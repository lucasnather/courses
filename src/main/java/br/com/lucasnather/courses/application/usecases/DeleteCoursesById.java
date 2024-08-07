package br.com.lucasnather.courses.application.usecases;

import br.com.lucasnather.courses.application.gateways.CoursesRepository;
import br.com.lucasnather.courses.domain.Courses;

import java.util.Optional;
import java.util.UUID;

public class DeleteCoursesById {

    private final CoursesRepository coursesRepositorys;

    public  DeleteCoursesById(CoursesRepository coursesRepository) {
        this.coursesRepositorys = coursesRepository;
    }

    public void deleteCourses(UUID id) {
        Optional<Courses> findCourses = this.coursesRepositorys.findById(id);

        if(findCourses.isEmpty()) {
            throw new RuntimeException("Course not found");
        }

        this.coursesRepositorys.deleteById(id);
    }
}
