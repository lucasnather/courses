package br.com.lucasnather.courses.controller;

import br.com.lucasnather.courses.entities.CoursesEntity;
import br.com.lucasnather.courses.services.UpdateCourseIsActiveByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class UpdateCoursesIsActiveByIdController {

    @Autowired
    private UpdateCourseIsActiveByIdService updateCourseIsActiveByIdService;

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> patch(@PathVariable("id") String id) {

        UUID stringIdToUuid = UUID.fromString(id);

        try {
            var courses = this.updateCourseIsActiveByIdService.handle(stringIdToUuid);

            return  ResponseEntity.status(HttpStatus.ACCEPTED).body(courses);
        } catch (RuntimeException e) {
            return  ResponseEntity.status(HttpStatus.ACCEPTED).body(Arrays.asList(e.getMessage()));
        }
    }

}
