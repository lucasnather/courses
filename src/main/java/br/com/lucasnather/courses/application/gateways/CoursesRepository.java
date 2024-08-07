package br.com.lucasnather.courses.application.gateways;

import br.com.lucasnather.courses.domain.Courses;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoursesRepository {
    Courses create(Courses courses);
    List<Courses> findMany();
    Courses updateIsActiveById(UUID id, Courses courses);
    Courses updateById(UUID id, Courses courses);
    Optional<Courses> findById(UUID id);
    void deleteById(UUID id);
}
