package br.com.lucasnather.courses.controller;

import br.com.lucasnather.courses.entities.CoursesEntity;
import br.com.lucasnather.courses.services.CreateCoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CreateCourseController {

    @Autowired
    private CreateCoursesServices createCoursesServices;

    @PostMapping
    public ResponseEntity<CoursesEntity> create(@RequestBody CoursesEntity body ) {
       CoursesEntity coursesEntity = new CoursesEntity();
       coursesEntity.setName(body.getName());
       coursesEntity.setCategory(body.getCategory());
       coursesEntity.setIsActive(body.getIsActive());

       var courses = this.createCoursesServices.handle(coursesEntity);

       return  ResponseEntity.status(HttpStatus.CREATED).body(courses);
    }
}
