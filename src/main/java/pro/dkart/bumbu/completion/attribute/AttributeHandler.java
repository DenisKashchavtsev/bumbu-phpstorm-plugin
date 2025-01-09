package pro.dkart.bumbu.completion.attribute;

import com.jetbrains.php.lang.psi.elements.Method;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import pro.dkart.bumbu.completion.dto.ClassPropertyDTO;
import pro.dkart.bumbu.completion.tool.extractor.ClassAttributeExtractor;

import java.util.ArrayList;
import java.util.List;

public class AttributeHandler {

    public List<Method> handle(PhpClass phpClass) {

        List<Method> methods = new ArrayList<>();
        List<ClassPropertyDTO> properties = new ClassAttributeExtractor().getPropertyAttributes(phpClass);

        for (ClassPropertyDTO property : properties) {
            for (String attribute : property.attributes) {
                System.out.println("attribute " + attribute);
                System.out.println("GetterAttribute.namespace " + GetterAttribute.namespace);
                if (GetterAttribute.namespace.equals(attribute)) {
                    System.out.println("adding " + GetterAttribute.namespace + " - for - " +property.name);
                    methods.add(new GetterAttribute().createMethodStub(phpClass, property.name));
                }
                if (SetterAttribute.namespace.equals(attribute)) {
                    System.out.println("adding " + SetterAttribute.namespace + " - for - " +property.name);
                    methods.add(new SetterAttribute().createMethodStub(phpClass, property.name));
                }
            }
        }

        return methods;
    }
}
