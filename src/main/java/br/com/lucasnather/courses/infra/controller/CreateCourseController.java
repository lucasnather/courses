package br.com.lucasnather.courses.infra.controller;

import br.com.lucasnather.courses.application.usecases.CreateCourses;
import br.com.lucasnather.courses.domain.Courses;
import br.com.lucasnather.courses.infra.controller.dto.CreateCourseDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CreateCourseController {


    private CreateCourses createCourses;

    public  CreateCourseController(CreateCourses createCourses) {
        this.createCourses = createCourses;
    }

    @PostMapping
    public CreateCourseDto post(@RequestBody CreateCourseDto createCourseDto ) {
        Courses coursesEntity = new Courses(createCourseDto.name(), createCourseDto.category(), createCourseDto.isActive());

        this.createCourses.create(coursesEntity);

        return new CreateCourseDto(createCourseDto.name(), createCourseDto.category(), createCourseDto.isActive());
    }
}
