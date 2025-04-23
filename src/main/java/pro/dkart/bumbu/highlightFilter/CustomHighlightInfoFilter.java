package pro.dkart.bumbu.highlightFilter;

import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.daemon.impl.HighlightInfoFilter;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pro.dkart.bumbu.tool.BumbuTool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomHighlightInfoFilter implements HighlightInfoFilter {
    @Override
    public boolean accept(@NotNull HighlightInfo highlightInfo, @Nullable PsiFile file) {
        if (highlightInfo.getDescription() != null) {
            if (highlightInfo.getDescription().matches("Method '(get|set|is)[A-Z][a-zA-Z0-9]*' not found in .*")) {

                if (null == file) {
                    return true;
                }

                PsiElement highlightedElement = file.findElementAt(highlightInfo.getStartOffset());
                if (null == highlightedElement) {
                    return true;
                }

                if (highlightedElement != null) {

                    String className = extractFullClassName(highlightInfo.getDescription());

                    PhpClass phpClass = new BumbuTool().findPhpClass(className, file);
                    if (phpClass != null) {

                        String methodName = extractMethodName(highlightInfo.getDescription());
                        if (methodName != null) {
                            if (new BumbuTool().isBumbuMethod(phpClass, methodName)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    private String extractFullClassName(String errorMessage) {
        if (errorMessage == null) {
            return null;
        }

        Pattern pattern = Pattern.compile("not found in ([\\w\\.\\\\]+)");
        Matcher matcher = pattern.matcher(errorMessage);

        return matcher.find() ? matcher.group(1) : null;
    }

    private String extractMethodName(String errorText) {
        Pattern pattern = Pattern.compile("Method '(get|set|is)([A-Z][a-zA-Z0-9]*)' not found");
        Matcher matcher = pattern.matcher(errorText);
        return matcher.find() ? matcher.group(1) + matcher.group(2) : null;
    }
}
