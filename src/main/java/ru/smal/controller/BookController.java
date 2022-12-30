package ru.smal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.smal.model.dto.BookDto;
import ru.smal.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/{id}")
    public BookDto findOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @GetMapping
    public List<BookDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Long save(@RequestBody BookDto request) {
        return service.save(request);
    }

    @PatchMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody BookDto request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
