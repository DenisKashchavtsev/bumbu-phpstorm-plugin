package pro.dkart.bumbu.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.psi.PsiElement;
import com.intellij.ui.JBColor;
import com.jetbrains.php.lang.psi.elements.MethodReference;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class CustomMethodAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element instanceof MethodReference)) {
            return;
        }

        MethodReference methodReference = (MethodReference) element;
//        System.out.println("element" + element);

        if ("getModel".equals(methodReference.getName())) {
//            System.out.println(methodReference.getName());
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(CustomHighlightingColors.CUSTOM_METHOD)
                    .create();
        }
    }
}
