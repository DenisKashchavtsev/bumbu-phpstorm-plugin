package pro.dkart.bumbu.completion.dto;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClassPropertyDTO {
    public String name;
    public List<String> attributes;

    public ClassPropertyDTO(String name) {
        this.name = name;
        this.attributes = new ArrayList<>();
    }

    public ClassPropertyDTO(String name, List<String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }
}
