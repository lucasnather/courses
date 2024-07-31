package br.com.lucasnather.courses.controller;

import br.com.lucasnather.courses.entities.CoursesEntity;
import br.com.lucasnather.courses.services.UpdateCoursesByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class UpdateCoursesByIdController {

    @Autowired
    private UpdateCoursesByIdService updateCoursesByIdService;

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable("id") String id, @RequestBody CoursesEntity courses) {

        UUID stringIdToUuid = UUID.fromString(id);
        CoursesEntity coursesEntity = new CoursesEntity();

        coursesEntity.setName(courses.getName());
        coursesEntity.setCategory(courses.getCategory());
        coursesEntity.setIsActive(courses.getIsActive());
        coursesEntity.setUpdatedAt(LocalDateTime.now());

        try {
            var updateCourses = this.updateCoursesByIdService.handle(stringIdToUuid, coursesEntity);

            return  ResponseEntity.status(HttpStatus.ACCEPTED).body(updateCourses);
        } catch (RuntimeException e) {
            return  ResponseEntity.status(HttpStatus.ACCEPTED).body(Arrays.asList(e.getMessage()));
        }
    }
}
