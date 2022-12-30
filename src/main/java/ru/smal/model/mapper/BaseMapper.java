package ru.smal.model.mapper;

import java.util.List;

public interface BaseMapper<R, E> {

    R mapToDto(E entity);

    E mapToEntity(R request);

    List<R> mapListToDto(List<E> entities);

    List<E> mapListToEntity(List<R> requests);
}
