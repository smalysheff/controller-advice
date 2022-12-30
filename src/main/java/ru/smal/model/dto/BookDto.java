package ru.smal.model.dto;

import lombok.Builder;

@Builder
public record BookDto(Long id, String name, String publish) {
}
