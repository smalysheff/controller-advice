package ru.smal.repository;

import ru.smal.model.entity.Book;

import java.util.List;

public interface BookRepository extends BaseRepository<Book, Long> {

    @Override
    Book findOne(Long id);

    @Override
    List<Book> findAll();

    @Override
    Long save(Book entity);

    @Override
    Long delete(Long id);
}
