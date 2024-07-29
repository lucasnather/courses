package br.com.lucasnather.courses.services;

import br.com.lucasnather.courses.entities.CoursesEntity;
import br.com.lucasnather.courses.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCoursesServices {

    @Autowired
    private CoursesRepository coursesRepository;

    public CoursesEntity handle(CoursesEntity coursesEntity) {
        CoursesEntity course = this.coursesRepository.save(coursesEntity);

        return  course;
    }
}
