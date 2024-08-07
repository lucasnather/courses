package br.com.lucasnather.courses.config;

import br.com.lucasnather.courses.application.gateways.CoursesRepository;
import br.com.lucasnather.courses.application.usecases.*;
import br.com.lucasnather.courses.infra.gateways.CoursesMapper;
import br.com.lucasnather.courses.infra.gateways.CoursesRepositoryJpa;
import br.com.lucasnather.courses.infra.persistence.CoursesInterfaceJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseConfig {

    @Bean
    CreateCourses createCourses(CoursesRepository coursesRepository) {
        return  new CreateCourses(coursesRepository);
    }

    @Bean
    FindManyCourses findManyCourses(CoursesRepository coursesRepository) {
        return  new FindManyCourses(coursesRepository);
    }

    @Bean
    DeleteCoursesById deleteCoursesById(CoursesRepository coursesRepository) {
        return  new DeleteCoursesById(coursesRepository);
    }

    @Bean
    UpdateCoursesActiveById updateCoursesActiveById(CoursesRepository coursesRepository) {
        return  new UpdateCoursesActiveById(coursesRepository);
    }

    @Bean
    UpdateCoursesById updateCoursesById(CoursesRepository coursesRepository) {
        return  new UpdateCoursesById(coursesRepository);
    }

    @Bean
    CoursesRepositoryJpa coursesRepositoryJpa( CoursesInterfaceJpa coursesInterfaceJpa, CoursesMapper coursesMapper) {
        return  new CoursesRepositoryJpa(coursesInterfaceJpa, coursesMapper);
    }

    @Bean
    CoursesMapper coursesMapper() {
        return  new CoursesMapper();
    }
}
