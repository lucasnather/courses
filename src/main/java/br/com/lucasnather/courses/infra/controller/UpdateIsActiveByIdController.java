package br.com.lucasnather.courses.infra.controller;

import br.com.lucasnather.courses.application.usecases.CreateCourses;
import br.com.lucasnather.courses.application.usecases.UpdateCoursesActiveById;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class UpdateIsActiveByIdController {

    private UpdateCoursesActiveById updateCoursesActiveById;

    public  UpdateIsActiveByIdController(UpdateCoursesActiveById updateCoursesActiveById) {
        this.updateCoursesActiveById = updateCoursesActiveById;
    }

    @PatchMapping("/{id}/active")
    public Object patch(@PathVariable("id") String id) {

        UUID stringIdToUuid = UUID.fromString(id);

        try {
            return  this.updateCoursesActiveById.updateCourses(stringIdToUuid);

        } catch (RuntimeException e) {
            return  Arrays.asList(e.getMessage());
        }
    }
}
