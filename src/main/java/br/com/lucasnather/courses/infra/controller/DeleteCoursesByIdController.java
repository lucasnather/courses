package br.com.lucasnather.courses.infra.controller;

import br.com.lucasnather.courses.application.usecases.DeleteCoursesById;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class DeleteCoursesByIdController {

    private final DeleteCoursesById deleteCoursesById;

    public  DeleteCoursesByIdController(DeleteCoursesById deleteCoursesById) {
        this.deleteCoursesById = deleteCoursesById;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        UUID stringIdToUuid = UUID.fromString(id);

        try {
            this.deleteCoursesById.deleteCourses(stringIdToUuid);

            return  "Curso deletado";
        } catch (RuntimeException e) {
            return  e.getMessage();
        }
    }
}
