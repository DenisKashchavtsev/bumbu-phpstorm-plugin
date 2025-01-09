package pro.dkart.bumbu.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementPresentation;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.util.ProcessingContext;
import com.jetbrains.php.PhpIndex;
import com.jetbrains.php.completion.insert.PhpInsertHandlerUtil;
import com.jetbrains.php.lang.psi.elements.*;
import org.jetbrains.annotations.NotNull;
import pro.dkart.bumbu.completion.attribute.AttributeHandler;

import java.util.Collection;
import java.util.List;


public class BumbuCompletionContributor extends CompletionContributor {

    BumbuCompletionContributor() {
        System.out.println("BumbuCompletionContributor initialized");

        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters completionParameters, @NotNull ProcessingContext processingContext, @NotNull CompletionResultSet completionResultSet) {

                PsiElement psiElement = completionParameters.getOriginalPosition();
                PsiElement parent;
                PsiElement prevSibling = completionParameters.getPosition().getPrevSibling();

                if (prevSibling != null) {
                    parent = prevSibling.getParent();
                } else {
                    assert psiElement != null;
                    parent = psiElement.getParent();
                }


                if (parent instanceof FieldReference fieldReference) {
                    PhpExpression classReference = fieldReference.getClassReference();
                    if (classReference != null) {
                        Project project = completionParameters.getPosition().getProject();
                        PhpIndex phpIndex = PhpIndex.getInstance(project);

                        Collection<PhpClass> phpClasses = phpIndex.getClassesByFQN(classReference.getType().toString());

                        for (PhpClass phpClass : phpClasses) {

                            List<Method> newMethods = new AttributeHandler().handle(phpClass);
                            System.out.println("newMethods: " + newMethods);

                            for (Method method : newMethods) {
                                System.out.println("method: " + method.getName());

                                if (phpClass.findMethodByName(method.getName()) == null) {

                                    completionResultSet.addElement(new MyLookupElement("", method.getName(), method, phpClass.getName(), false));
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    private class MyLookupElement extends com.intellij.codeInsight.lookup.LookupElement {
        private final String key;
        private final String lookupElement;

        private final PhpNamedElement phpNamedElement;
        private final String typeText;
        private final @NotNull boolean exists;

        public MyLookupElement(@NotNull String key, @NotNull String lookupElement, @NotNull PhpNamedElement phpNamedElement, @NotNull String typeText, boolean exists) {
            this.key = key;
            this.lookupElement = lookupElement;
            this.phpNamedElement = phpNamedElement;
            this.typeText = typeText;
            this.exists = exists;
        }

        @Override
        public void renderElement(@NotNull LookupElementPresentation presentation) {
            super.renderElement(presentation);

            if (this.exists) {
                presentation.setTypeText(typeText, AllIcons.Nodes.Method);
                presentation.setTypeGrayed(true);
            } else {
                presentation.setTypeText(typeText, AllIcons.Nodes.Method);
            }

            presentation.setIcon(phpNamedElement.getIcon());
            presentation.setTypeIconRightAligned(true);
        }

        @Override
        public @NotNull String getLookupString() {
            return lookupElement + "('" + getKey() + "')";
        }

        @Override
        public void handleInsert(@NotNull InsertionContext context) {
            new MyInsertHandler().handleInsert(context, this);
        }

        public String getKey() {
            return key;
        }

        public PhpNamedElement getPhpNamedElement() {
            return phpNamedElement;
        }
    }


    private class MyInsertHandler implements InsertHandler<com.intellij.codeInsight.lookup.LookupElement> {
        @Override
        public void handleInsert(@NotNull InsertionContext context, @NotNull com.intellij.codeInsight.lookup.LookupElement item) {
            context.getDocument().deleteString(context.getStartOffset(), context.getTailOffset());
            context.commitDocument();

            if (!(item instanceof MyLookupElement lookupElement)) {
                return;
            }

            String content = lookupElement.getLookupString();

            Project project = context.getProject();
            PsiDocumentManager.getInstance(project).doPostponedOperationsAndUnblockDocument(context.getDocument());

            int caretModel = context.getEditor().getCaretModel().getOffset();

            PhpInsertHandlerUtil.insertStringAtCaret(context.getEditor(), content);
            CodeStyleManager.getInstance(project).reformatText(context.getFile(), caretModel, caretModel + content.length());
        }
    }
}

