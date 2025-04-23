package pro.dkart.bumbu.reference;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.ProcessingContext;
import com.intellij.util.Processor;
import com.intellij.util.containers.JBIterable;
import com.jetbrains.php.PhpIndex;
import com.jetbrains.php.lang.PhpLanguage;
import com.jetbrains.php.lang.documentation.phpdoc.psi.PhpDocComment;
import com.jetbrains.php.lang.psi.elements.*;
import com.jetbrains.php.lang.psi.elements.impl.VariableImpl;
import com.jetbrains.php.lang.psi.resolve.types.PhpType;
import com.jetbrains.php.lang.psi.stubs.PhpClassStub;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collection;
import java.util.HashSet;

public class BumbuReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        System.out.println("BumbuReferenceContributor initialized");
        registrar.registerReferenceProvider(
                PlatformPatterns.psiElement(PhpExpression.class)
                        .withParent(
                                PlatformPatterns.psiElement(ParameterList.class)
                                        .withParent(
                                                PlatformPatterns.psiElement(MethodReference.class)
                                        )
                        ), // Захватываем MethodReference
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {

                        if (element == null || context == null) {
                            return PsiReference.EMPTY_ARRAY;
                        }
                        if (element.getParent() instanceof ParameterList &&
                                element.getParent().getParent() instanceof MethodReference
                        ) {
                            if (element.getParent().getParent() instanceof MethodReference) {
                                MethodReference methodReference = (MethodReference) element.getParent().getParent();

                                // Получаем имя метода
                                String methodName = methodReference.getName();

                                if ("getModel".equals(methodName)) {

                                    PsiElement qualifier = methodReference.getClassReference();
                                    PsiElement variable = methodReference.getClassReference();

                                    if (qualifier instanceof PhpExpression phpExpression) {

                                        PhpClass phpClass = null;

                                        if (variable instanceof VariableImpl) {
                                            PhpType classType = ((VariableImpl) variable).getType();
                                            PhpIndex phpIndex = PhpIndex.getInstance(variable.getProject());

                                            for (String className : classType.getTypes()) {
                                                Collection<PhpClass> classes = phpIndex.getClassesByFQN(className);
                                                if (!classes.isEmpty()) {
                                                    phpClass = classes.iterator().next();
                                                    System.out.println("Found class: " + phpClass.getName());
                                                }
                                            }
                                        }

                                        if (phpClass == null) {
                                            return PsiReference.EMPTY_ARRAY;
                                        }

                                        return new PsiReference[]{new CustomPsiReference(methodReference, phpClass, methodName)};
                                    }
                                }
                            }
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                }
                ,
                PsiReferenceRegistrar.HIGHER_PRIORITY // Задаем приоритет LOW (можно использовать HIGH или MEDIUM)

        );

    }
}