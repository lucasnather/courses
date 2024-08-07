package br.com.lucasnather.courses.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoursesInterfaceJpa extends JpaRepository<CoursesEntity, UUID> {
}
