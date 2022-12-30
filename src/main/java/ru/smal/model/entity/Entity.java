package ru.smal.model.entity;

public interface Entity<ID> {

    ID getId();

    boolean isNew();
}
