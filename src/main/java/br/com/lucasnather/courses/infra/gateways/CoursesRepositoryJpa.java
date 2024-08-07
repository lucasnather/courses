package br.com.lucasnather.courses.infra.gateways;


import br.com.lucasnather.courses.application.gateways.CoursesRepository;
import br.com.lucasnather.courses.domain.Courses;
import br.com.lucasnather.courses.infra.persistence.CoursesEntity;
import br.com.lucasnather.courses.infra.persistence.CoursesInterfaceJpa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


public class CoursesRepositoryJpa implements CoursesRepository {

    private final CoursesInterfaceJpa coursesInterfaceJpa;
    private final CoursesMapper coursesMapper;

    public  CoursesRepositoryJpa(CoursesInterfaceJpa coursesInterfaceJpa, CoursesMapper coursesMapper) {
        this.coursesInterfaceJpa = coursesInterfaceJpa;
        this.coursesMapper = coursesMapper;
    }


    @Override
    public Courses create(Courses courses) {
        CoursesEntity coursesEntity = this.coursesMapper.toEntity(courses);

        this.coursesInterfaceJpa.save(coursesEntity);
        return this.coursesMapper.toDomain(coursesEntity);
    }

    @Override
    public List<Courses> findMany() {
        return this.coursesInterfaceJpa.findAll().stream()
                .map(this.coursesMapper::toDomain)
                .collect(Collectors.toList());

    }

    @Override
    public Courses updateIsActiveById(UUID id, Courses courses) {
        CoursesEntity coursesEntity = this.coursesMapper.toEntity(courses);
        this.coursesInterfaceJpa.save(coursesEntity);

        return  this.coursesMapper.toDomain(coursesEntity);

    }

    @Override
    public Courses updateById(UUID id, Courses courses) {
        CoursesEntity coursesEntity = this.coursesMapper.toEntity(courses);
        this.coursesInterfaceJpa.save(coursesEntity);

        return  this.coursesMapper.toDomain(coursesEntity);
    }

    @Override
    public Optional<Courses> findById(UUID id) {
        CoursesEntity coursesEntity = this.coursesInterfaceJpa.findById(id).get();

        return Optional.ofNullable(this.coursesMapper.toDomain(coursesEntity));

    }

    @Override
    public void deleteById(UUID id) {
        this.coursesInterfaceJpa.deleteById(id);
    }
}
