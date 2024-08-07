package br.com.lucasnather.courses.application.usecases;

import br.com.lucasnather.courses.application.gateways.CoursesRepository;
import br.com.lucasnather.courses.domain.Courses;

import java.util.List;

public class FindManyCourses {

    private final CoursesRepository coursesRepository;

    public  FindManyCourses(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public List<Courses> listCourses() {
        return  this.coursesRepository.findMany();
    }
}
