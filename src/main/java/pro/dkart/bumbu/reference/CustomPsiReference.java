package pro.dkart.bumbu.reference;


import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.Processor;
import com.jetbrains.php.codeInsight.PhpScope;
import com.jetbrains.php.codeInsight.controlFlow.PhpControlFlow;
import com.jetbrains.php.lang.documentation.phpdoc.psi.PhpDocComment;
import com.jetbrains.php.lang.documentation.phpdoc.psi.tags.PhpDocTag;
import com.jetbrains.php.lang.psi.elements.*;
import com.jetbrains.php.lang.psi.elements.impl.MethodImpl;
import com.jetbrains.php.lang.psi.resolve.types.PhpType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pro.dkart.bumbu.completion.stub.MethodStub;

import javax.swing.*;
import java.util.Collection;
import java.util.Set;

public class CustomPsiReference extends PsiReferenceBase<MethodReference> {

    protected TextRange myRangeInElement;

    private final PhpClass phpClass;
    private final String methodName;
    private PsiElement element;

    public CustomPsiReference(@NotNull MethodReference element, PhpClass phpClass, String methodName) {
        super(element, new TextRange(2, element.getTextLength()), true);
        this.element = element;
        this.phpClass = phpClass;
        this.methodName = methodName;
    }

    // ебаная проблема дето тут, этот метод не выполняется
    public @Nullable PsiElement resolve() {
        // Для примера, предполагаем, что phpClass это объект PhpClass
//        System.out.println("resolve");

        if (phpClass != null) {
            // Ищем свойство $model в классе phpClass
            Field modelField = phpClass.findFieldByName("model", false);

            if (modelField != null) {
                // Проверяем, есть ли аннотация #[Getter] у этого свойства

                if (modelField.getAttributes("Getter") != null) {
                    // Если аннотация #[Getter] найдена, возвращаем ссылку на это свойство
//                    System.out.println("Found Getter annotation for $model");
                    return modelField;
                }
            }
        }

        // Если свойство не найдено или нет аннотации, возвращаем null
        return null;
    }



    @Override
    public Object @NotNull [] getVariants() {
        System.out.println("getVariants");

        // Возвращает варианты для автодополнения, если это нужно.
        return new Object[0];
    }

//    @Override
//    public @Nullable PsiElement resolve() {
//        System.out.println("resolve");
//        return null;
//    }

    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        // Позволяет переименовать метод
        return super.handleElementRename(newElementName);
    }

    public String getMethodName() {
        System.out.println("getMethodName");
        return "getMethod";
    }

    public PhpClass getPhpClass() {
        System.out.println("getPhpClass");

        return this.phpClass;
    }
}