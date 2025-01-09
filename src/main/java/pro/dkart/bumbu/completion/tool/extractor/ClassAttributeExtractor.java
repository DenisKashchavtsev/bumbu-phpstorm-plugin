package pro.dkart.bumbu.completion.tool.extractor;

import com.jetbrains.php.lang.psi.elements.Field;
import com.jetbrains.php.lang.psi.elements.PhpAttribute;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import pro.dkart.bumbu.completion.dto.ClassPropertyDTO;

import java.util.ArrayList;
import java.util.List;

public class ClassAttributeExtractor {

    public List<ClassPropertyDTO> getPropertyAttributes(PhpClass phpClass) {

        List<ClassPropertyDTO> properties = new ArrayList<>();

        for (Field field : phpClass.getFields()) {
            ClassPropertyDTO property = new ClassPropertyDTO(field.getName());

            for (PhpAttribute attribute : field.getAttributes()) {
                property.attributes.add(attribute.getFQN());
            }

            properties.add(property);
        }

        return properties;
    }
}
