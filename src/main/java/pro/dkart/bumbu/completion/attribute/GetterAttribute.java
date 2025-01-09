package pro.dkart.bumbu.completion.attribute;

import com.jetbrains.php.lang.psi.elements.Method;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import pro.dkart.bumbu.completion.stub.MethodStub;
import pro.dkart.bumbu.completion.tool.StringTool;

public class GetterAttribute {

    public static final String namespace = "\\DKart\\Bumbu\\Attribute\\Getter";

    Method createMethodStub(PhpClass phpClass, String name) {
        Method methodStub = new MethodStub().createMethod(phpClass);
        methodStub.setName("get" + StringTool.capitalizeFirstLetter(name));

        return methodStub;
    }
}
