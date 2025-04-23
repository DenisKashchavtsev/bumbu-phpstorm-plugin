package pro.dkart.bumbu.completion.dto;

import com.jetbrains.php.lang.psi.elements.PhpAttribute;

import java.util.ArrayList;
import java.util.List;

public class ClassPropertyDTO {
    public String name;
    public List<String> attributes;
    public List<PhpAttribute> psiAttributes;

    public ClassPropertyDTO(String name) {
        this.name = name;
        this.attributes = new ArrayList<>();
        this.psiAttributes = new ArrayList<>();
    }

    public ClassPropertyDTO(String name, List<String> attributes) {
        this.name = name;
        this.attributes = attributes;
        this.psiAttributes = new ArrayList<>();
    }
}
