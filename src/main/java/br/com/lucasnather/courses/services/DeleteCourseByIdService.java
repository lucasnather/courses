package br.com.lucasnather.courses.services;

import br.com.lucasnather.courses.entities.CoursesEntity;
import br.com.lucasnather.courses.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeleteCourseByIdService {

    @Autowired
    private CoursesRepository coursesRepository;

    public void handle(UUID id) {
        Optional<CoursesEntity> findCourse = this.coursesRepository.findById(id);

        if(!findCourse.isPresent()) {
            throw new RuntimeException("Course not founb");
        }

        this.coursesRepository.deleteById(id);
    }
}
