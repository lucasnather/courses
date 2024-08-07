package br.com.lucasnather.courses.infra.controller.dto;

public record CreateCourseDto(String name, String category, Boolean isActive) {
}
