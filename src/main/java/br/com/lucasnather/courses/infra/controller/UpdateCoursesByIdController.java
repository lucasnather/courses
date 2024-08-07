package br.com.lucasnather.courses.infra.controller;

import br.com.lucasnather.courses.application.usecases.UpdateCoursesById;
import br.com.lucasnather.courses.domain.Courses;
import br.com.lucasnather.courses.infra.controller.dto.UpdatedCourseDto;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class UpdateCoursesByIdController {

    private UpdateCoursesById updateCoursesById;

    public UpdateCoursesByIdController(UpdateCoursesById updateCoursesById) {
        this.updateCoursesById = updateCoursesById;
    }

    @PutMapping("/{id}")
    public Object put(@PathVariable("id") String id, @RequestBody UpdatedCourseDto updatedCourseDto) {

        Courses courses = new Courses(updatedCourseDto.name(), updatedCourseDto.category());
        UUID stringIdToUuid = UUID.fromString(id);

        try {
            return  this.updateCoursesById.updateCourses(stringIdToUuid, courses);

        } catch (RuntimeException e) {
            return  Arrays.asList(e.getMessage());
        }
    }
}
