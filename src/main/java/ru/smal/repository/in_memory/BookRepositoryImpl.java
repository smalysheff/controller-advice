package ru.smal.repository.in_memory;

import org.springframework.stereotype.Repository;
import ru.smal.model.entity.Book;
import ru.smal.repository.BookRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final AtomicLong counter = new AtomicLong();
    private final Map<Long, Book> bookMap = new ConcurrentHashMap<>();

    {
        save(new Book(null, "Spring in action", "O'Relly"));
        save(new Book(null, "Kafka in action", "JJ Geewex"));
    }

    @Override
    public Book findOne(Long id) {
        return bookMap.get(id);
    }

    @Override
    public List<Book> findAll() {
        return bookMap.values().stream().toList();
    }

    @Override
    public Long save(Book entity) {
        if (entity.isNew()) {
            entity.setId(counter.incrementAndGet());
            bookMap.put(entity.getId(), entity);
            return entity.getId();
        }
        bookMap.computeIfPresent(entity.getId(), (id, oldEntity) -> entity);
        return entity.getId();
    }

    @Override
    public Long delete(Long id) {
        Book remove = bookMap.remove(id);
        if (remove == null) {
            return null;
        }
        return remove.getId();
    }
}
