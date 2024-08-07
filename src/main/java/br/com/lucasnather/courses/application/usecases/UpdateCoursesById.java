package br.com.lucasnather.courses.application.usecases;

import br.com.lucasnather.courses.application.gateways.CoursesRepository;
import br.com.lucasnather.courses.domain.Courses;

import java.util.UUID;

public class UpdateCoursesById {

    private final CoursesRepository coursesRepository;

    public  UpdateCoursesById(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public Courses updateCourses(UUID id, Courses courses) {
        Courses findCourses = this.coursesRepository.findById(id).get();

        findCourses.setUpdatedAt();
        findCourses.setId(id);

        if(courses.getName() != null) {
            findCourses.setName(courses.getName());
        }

        if(courses.getCategory() != null) {
            findCourses.setCategory(courses.getCategory());
        }

        return  this.coursesRepository.updateById(id, findCourses);
    }
}
