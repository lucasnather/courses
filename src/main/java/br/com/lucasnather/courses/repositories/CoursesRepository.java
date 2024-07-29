package br.com.lucasnather.courses.repositories;

import br.com.lucasnather.courses.entities.CoursesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoursesRepository extends JpaRepository<CoursesEntity, UUID> {
}
