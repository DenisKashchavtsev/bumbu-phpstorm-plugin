package pro.dkart.bumbu.Inspection;

import com.intellij.codeInspection.*;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.jetbrains.php.lang.inspections.PhpInspection;
import com.jetbrains.php.lang.psi.PhpPsiElementFactory;
import com.jetbrains.php.lang.psi.elements.*;
import com.jetbrains.php.lang.psi.elements.impl.MethodReferenceImpl;
import com.jetbrains.php.lang.psi.visitors.PhpElementVisitor;
import org.jetbrains.annotations.NotNull;
import pro.dkart.bumbu.annotator.CustomHighlightingColors;

public class CustomLocalInspectionTool extends PhpInspection {

    public PsiNamedElement getProblemElement(@NotNull PsiElement psiElement) {


        System.out.println("getProblemElement"+psiElement.getContainingFile());
        return psiElement.getContainingFile();
    }

    @Override
    public @NotNull PsiElementVisitor buildVisitor(
            final @NotNull ProblemsHolder problemsHolder,
            final boolean isOnTheFly
    ) {
        return new PhpElementVisitor() {
            @Override
            public void visitPhpMethodReference(MethodReference reference) {
                if ("getModel".equals(reference.getName())) {
                    problemsHolder.registerProblemForReference(
                            reference,
                            ProblemHighlightType.INFORMATION,
                            "Бумбу метод берется с кешей"
                    );
                }
            }
        };
    }
}
