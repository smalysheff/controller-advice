package ru.smal.repository;

import java.util.List;

public interface BaseRepository<E, ID> {

    E findOne(ID id);
    List<E> findAll();
    ID save(E entity);
    ID delete(ID id);
}
