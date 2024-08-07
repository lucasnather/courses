package br.com.lucasnather.courses.application.usecases;

import br.com.lucasnather.courses.application.gateways.CoursesRepository;
import br.com.lucasnather.courses.domain.Courses;

public class CreateCourses {

    private final CoursesRepository coursesRepository;

    public CreateCourses(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public  Courses create(Courses courses) {

        courses.setCreatedAt();

        return  this.coursesRepository.create(courses);
    }
}
