package ru.smal.model.entity;


public abstract class AbstractBaseEntity implements Entity<Long> {

    private Long id;

    public AbstractBaseEntity(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }
}
