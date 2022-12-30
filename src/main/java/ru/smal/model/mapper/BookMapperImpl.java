package ru.smal.model.mapper;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.smal.model.dto.BookDto;
import ru.smal.model.entity.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public BookDto mapToDto(Book entity) {
        if (Objects.isNull(entity)) {
            return null;
        }

        return BookDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .publish(entity.getPublish())
                .build();
    }

    @Override
    public Book mapToEntity(BookDto request) {
        if (Objects.isNull(request)) {
            return null;
        }

        Book book = new Book();
        book.setId(request.id());
        book.setName(request.name());
        book.setPublish(request.publish());

        return book;
    }

    @Override
    public List<BookDto> mapListToDto(List<Book> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }

        List<BookDto> bookDtoList = new ArrayList<>();

        for (Book entity : entities) {
            bookDtoList.add(mapToDto(entity));
        }

        return bookDtoList;
    }

    @Override
    public List<Book> mapListToEntity(List<BookDto> requests) {
        if (CollectionUtils.isEmpty(requests)) {
            return Collections.emptyList();
        }

        List<Book> books = new ArrayList<>();

        for (BookDto dto : requests) {
            books.add(mapToEntity(dto));
        }

        return books;
    }
}
