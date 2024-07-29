package br.com.lucasnather.courses.services;

import br.com.lucasnather.courses.entities.CoursesEntity;
import br.com.lucasnather.courses.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindManyCoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    public List<CoursesEntity> handle() {
        return  this.coursesRepository.findAll();
    }
}
