package pro.dkart.bumbu.tool.extractor;

import com.jetbrains.php.lang.psi.elements.Field;
import com.jetbrains.php.lang.psi.elements.PhpAttribute;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import pro.dkart.bumbu.completion.dto.ClassPropertyDTO;

import java.util.ArrayList;
import java.util.List;

public class ClassAttributeExtractor {

    public List<ClassPropertyDTO> getFieldsAttributes(PhpClass phpClass) {

        List<ClassPropertyDTO> properties = new ArrayList<>();

        for (Field field : phpClass.getFields()) {
            ClassPropertyDTO property = new ClassPropertyDTO(field.getName());

            for (PhpAttribute attribute : field.getAttributes()) {
                property.attributes.add(attribute.getFQN());
                property.psiAttributes.add(attribute);
            }

            properties.add(property);
        }

        return properties;
    }

    public List<ClassPropertyDTO> getPropertyAttributesByFieldName(PhpClass phpClass, String fieldName) {

        List<ClassPropertyDTO> properties = new ArrayList<>();

        for (Field field : phpClass.getFields()) {
            if (field.getName().equals(fieldName)) {
                ClassPropertyDTO property = new ClassPropertyDTO(field.getName());

                for (PhpAttribute attribute : field.getAttributes()) {
                    property.attributes.add(attribute.getFQN());
                }

                properties.add(property);
            }
        }

        return properties;
    }
}
