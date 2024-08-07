package br.com.lucasnather.courses.infra.controller;

import br.com.lucasnather.courses.application.usecases.FindManyCourses;
import br.com.lucasnather.courses.domain.Courses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class FindManyCoursesController {

    private final FindManyCourses  findManyCourses;

    public  FindManyCoursesController(FindManyCourses findManyCourses) {
        this.findManyCourses = findManyCourses;
    }

    @GetMapping
    public List<Courses> get() {
        return this.findManyCourses.listCourses();
    }
}
