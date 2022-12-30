package ru.smal.service;

import java.util.List;

public interface BaseService<R, ID> {

    R findOne(ID id);
    List<R> findAll();
    ID save(R request);
    ID update(ID id, R request);
    ID delete(ID id);
}
