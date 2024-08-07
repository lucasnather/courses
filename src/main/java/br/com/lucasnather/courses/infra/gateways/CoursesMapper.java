package br.com.lucasnather.courses.infra.gateways;

import br.com.lucasnather.courses.domain.Courses;
import br.com.lucasnather.courses.infra.persistence.CoursesEntity;

public class CoursesMapper {

    public CoursesEntity toEntity(Courses courses) {
        return  new CoursesEntity( courses.getId(), courses.getName(), courses.getCategory(), courses.getActive(), courses.getCreatedAt());
    }

    public  Courses toDomain(CoursesEntity coursesEntity) {
        return  new Courses( coursesEntity.getId(), coursesEntity.getName(), coursesEntity.getCategory(), coursesEntity.getIsActive(), coursesEntity.getCreatedAt(), coursesEntity.getUpdatedAt());
    }
}
