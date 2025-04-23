package pro.dkart.bumbu.annotator;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.ui.JBColor;

import java.awt.*;

public class CustomHighlightingColors {
    public static final TextAttributesKey CUSTOM_METHOD =
            TextAttributesKey.createTextAttributesKey(
                    "CUSTOM_METHOD",
                    new TextAttributes(JBColor.RED, null, null, EffectType.BOLD_DOTTED_LINE, Font.BOLD)
            );
}
