package pro.dkart.bumbu.tool;

import com.intellij.psi.PsiFile;
import com.jetbrains.php.PhpIndex;
import com.jetbrains.php.lang.psi.elements.PhpAttribute;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import pro.dkart.bumbu.completion.attribute.GetterAttribute;
import pro.dkart.bumbu.completion.attribute.SetterAttribute;
import pro.dkart.bumbu.completion.dto.ClassPropertyDTO;
import pro.dkart.bumbu.tool.extractor.ClassAttributeExtractor;

import java.util.Collection;
import java.util.List;

public class BumbuTool {
    public PhpClass findPhpClass(String className, PsiFile file) {
        if (className == null || className.isEmpty()) {
            return null;
        }

        PhpIndex phpIndex = PhpIndex.getInstance(file.getProject());

        Collection<PhpClass> classes = phpIndex.getClassesByFQN(className);
        if (!classes.isEmpty()) {
            return classes.iterator().next();
        }

        return null;
    }

    public boolean isBumbuMethod(PhpClass phpClass, String methodName) {
        List<ClassPropertyDTO> fields = new ClassAttributeExtractor().getFieldsAttributes(phpClass);
        String fieldName = methodNameToFieldName(methodName);

        for (ClassPropertyDTO field : fields) {
            if (field.name.equals(fieldName)) {
                for (String attribute : field.attributes) {
                    System.out.println(attribute);

                    if ((methodName.startsWith("get") || methodName.startsWith("is")) && GetterAttribute.namespace.equals(attribute)) {
                        return true;
                    }

                    if ((methodName.startsWith("set")) && SetterAttribute.namespace.equals(attribute)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public PhpAttribute getBumbuAttibuteByMethod(PhpClass phpClass, String methodName) {
        List<ClassPropertyDTO> fields = new ClassAttributeExtractor().getFieldsAttributes(phpClass);
        String fieldName = methodNameToFieldName(methodName);

        for (ClassPropertyDTO field : fields) {
            if (field.name.equals(fieldName)) {
                for (PhpAttribute attribute : field.psiAttributes) {

                    if ((methodName.startsWith("get") || methodName.startsWith("is")) && GetterAttribute.namespace.equals(attribute.getFQN())) {
                        return attribute;
                    }

                    if ((methodName.startsWith("set")) && SetterAttribute.namespace.equals(attribute.getFQN())) {
                        return attribute;
                    }
                }
            }
        }

        return null;
    }


    private String methodNameToFieldName(String methodName) {
        if (methodName.startsWith("get") || methodName.startsWith("set")) {
            return Character.toLowerCase(methodName.charAt(3)) + methodName.substring(4);
        } else if (methodName.startsWith("is")) {
            return Character.toLowerCase(methodName.charAt(2)) + methodName.substring(3);
        }
        return methodName;
    }
}
