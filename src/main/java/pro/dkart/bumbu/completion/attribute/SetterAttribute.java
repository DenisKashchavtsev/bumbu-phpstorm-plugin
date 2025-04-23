package pro.dkart.bumbu.completion.attribute;

import com.jetbrains.php.lang.psi.elements.Method;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import pro.dkart.bumbu.completion.stub.MethodStub;
import pro.dkart.bumbu.tool.StringTool;

public class SetterAttribute implements pro.dkart.bumbu.attibute.SetterAttribute {

    Method createMethodStub(PhpClass phpClass, String name) {
        Method methodStub = new MethodStub().createMethod(phpClass, "set" + StringTool.capitalizeFirstLetter(name));

        return methodStub;
    }
}
