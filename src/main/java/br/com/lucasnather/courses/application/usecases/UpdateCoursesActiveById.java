package br.com.lucasnather.courses.application.usecases;

import br.com.lucasnather.courses.application.gateways.CoursesRepository;
import br.com.lucasnather.courses.domain.Courses;

import java.util.UUID;

public class UpdateCoursesActiveById {

    private final CoursesRepository coursesRepository;

    public  UpdateCoursesActiveById(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public Courses updateCourses(UUID id) {
        Courses findCourses = this.coursesRepository.findById(id).get();

        findCourses.setActive(true);
        findCourses.setUpdatedAt();
        findCourses.setId(id);

        return  this.coursesRepository.updateIsActiveById(id, findCourses);
    }
}
