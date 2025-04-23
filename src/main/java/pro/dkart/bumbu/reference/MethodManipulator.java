package pro.dkart.bumbu.reference;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import com.jetbrains.php.PhpIndex;
import com.jetbrains.php.lang.psi.elements.MethodReference;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class MethodManipulator extends AbstractElementManipulator<MethodReference> {

    @Override
    public @Nullable MethodReference handleContentChange(@NotNull MethodReference element, @NotNull TextRange range, String newContent) throws IncorrectOperationException {
        System.out.println("MethodManipulator-element: " + element);
        System.out.println("MethodManipulator-range: " + range);
        System.out.println("MethodManipulator-newContent: " + newContent);
        return element;
    }

    @Override
    public @NotNull TextRange getRangeInElement(@NotNull MethodReference element) {
        return new TextRange(0, element.getTextLength());
    }


    /**
     * Проверяет, можно ли разрешить метод в классе
     */
    public static boolean isMethodResolvable(@NotNull MethodReference methodReference) {
        String methodName = methodReference.getName();
        if (methodName == null) {
            return false;
        }

        System.out.println("Checking method resolvability: " + methodName);

        PhpIndex phpIndex = PhpIndex.getInstance(methodReference.getProject());
        Collection<PhpClass> classes = phpIndex.getClassesByFQN("\\App\\Entity\\Car");

        for (PhpClass phpClass : classes) {
            if (phpClass.findMethodByName(methodName) != null) {
                System.out.println("Method found: " + methodName);
                return true;
            }
        }

        System.out.println("Method NOT found: " + methodName);
        return false;
    }
}
