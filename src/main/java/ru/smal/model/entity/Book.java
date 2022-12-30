package ru.smal.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book extends AbstractBaseEntity{

    private String name;
    private String publish;

    public Book() {
        super(null);
    }

    public Book(String name, String publish) {
        super(null);
        this.name = name;
        this.publish = publish;
    }

    public Book(Long id, String name, String publish) {
        super(id);
        this.name = name;
        this.publish = publish;
    }
}
