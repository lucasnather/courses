package br.com.lucasnather.courses.services;

import br.com.lucasnather.courses.entities.CoursesEntity;
import br.com.lucasnather.courses.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateCoursesByIdService {

    @Autowired
    private CoursesRepository coursesRepository;

    public CoursesEntity handle(UUID id, CoursesEntity coursesEntity){
        Optional<CoursesEntity> courses = this.coursesRepository.findById(id);

        if(courses.isEmpty()) {
            throw new RuntimeException("Course Not Found");
        }

        coursesEntity.setId(courses.get().getId());
        coursesEntity.setCreatedAt(courses.get().getCreatedAt());

        if(coursesEntity.getName() == null) {
            coursesEntity.setName(courses.get().getName());

        }

        if(coursesEntity.getCategory() == null) {
            coursesEntity.setCategory(courses.get().getCategory());
        }

        if(coursesEntity.getIsActive() == null) {
            coursesEntity.setIsActive(courses.get().getIsActive());
        }


        CoursesEntity updateCourse = this.coursesRepository.save(coursesEntity);

        return updateCourse;
    }
}
