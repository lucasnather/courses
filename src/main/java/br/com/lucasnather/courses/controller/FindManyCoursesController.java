package br.com.lucasnather.courses.controller;

import br.com.lucasnather.courses.entities.CoursesEntity;
import br.com.lucasnather.courses.services.FindManyCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class FindManyCoursesController {

    @Autowired
    private FindManyCoursesService findManyCoursesService;

    @GetMapping
    public ResponseEntity<List<CoursesEntity>> get() {
        var courses = this.findManyCoursesService.handle();

        return  ResponseEntity.status(HttpStatus.OK).body(courses);
    }
}
