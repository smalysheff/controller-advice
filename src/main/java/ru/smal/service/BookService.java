package ru.smal.service;

import ru.smal.model.dto.BookDto;

import java.util.List;

public interface BookService extends BaseService<BookDto, Long> {

    @Override
    BookDto findOne(Long id);

    @Override
    List<BookDto> findAll();

    @Override
    Long save(BookDto request);

    @Override
    Long update(Long id, BookDto request);

    @Override
    Long delete(Long id);
}
