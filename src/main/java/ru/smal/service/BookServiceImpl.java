package ru.smal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smal.exception.NoSuchElementFoundExeption;
import ru.smal.exception.ValidationException;
import ru.smal.model.dto.BookDto;
import ru.smal.model.entity.Book;
import ru.smal.model.mapper.BookMapper;
import ru.smal.repository.BookRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookMapper mapper;


    @Override
    public BookDto findOne(Long id) {
        Book found = repository.findOne(id);
        checkNotFound(found, id);
        return mapper.mapToDto(found);
    }

    @Override
    public List<BookDto> findAll() {
        return mapper.mapListToDto(repository.findAll());
    }

    @Override
    public Long save(BookDto request) {
        if (Objects.nonNull(request.id())) {
            String message = String.format("For save id: %s must be empty", request.id());
            throw new ValidationException(message);
        }

        return repository.save(mapper.mapToEntity(request));
    }

    @Override
    public Long update(Long id, BookDto request) {
        Book found = repository.findOne(id);
        checkNotFound(found, id);
        Book book = mapper.mapToEntity(request);
        book.setId(id);
        return repository.save(book);
    }

    @Override
    public Long delete(Long id) {
        Book found = repository.findOne(id);
        checkNotFound(found, id);
        return repository.delete(id);
    }

    private void checkNotFound(Book entity, Long id) {
        if (Objects.isNull(entity)) {
            String message = String.format("Entity with id: %s not found", id);
            throw new NoSuchElementFoundExeption(message);
        }
    }
}
