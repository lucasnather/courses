package br.com.lucasnather.courses.services;

import br.com.lucasnather.courses.entities.CoursesEntity;
import br.com.lucasnather.courses.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateCourseIsActiveByIdService {

    @Autowired
    private CoursesRepository coursesRepository;

    public CoursesEntity handle(UUID id ){
        Optional<CoursesEntity> courses = this.coursesRepository.findById(id);

        if(courses.isEmpty()) {
            throw new RuntimeException("Course Not Found");
        }

        CoursesEntity coursesEntity = new CoursesEntity();

        coursesEntity.setIsActive(true);
        coursesEntity.setUpdatedAt(LocalDateTime.now());
        coursesEntity.setId(courses.get().getId());
        coursesEntity.setName(courses.get().getName());
        coursesEntity.setCategory(courses.get().getCategory());
        coursesEntity.setCreatedAt(courses.get().getCreatedAt());
        CoursesEntity updateCourse = this.coursesRepository.save(coursesEntity);

        return updateCourse;
    }
}
