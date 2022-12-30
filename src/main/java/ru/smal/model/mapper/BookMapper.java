package ru.smal.model.mapper;

import ru.smal.model.dto.BookDto;
import ru.smal.model.entity.Book;

import java.util.List;

public interface BookMapper extends BaseMapper<BookDto, Book> {
    @Override
    BookDto mapToDto(Book entity);

    @Override
    Book mapToEntity(BookDto request);

    @Override
    List<BookDto> mapListToDto(List<Book> entities);

    @Override
    List<Book> mapListToEntity(List<BookDto> requests);
}
