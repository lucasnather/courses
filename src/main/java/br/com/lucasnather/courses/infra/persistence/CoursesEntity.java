package br.com.lucasnather.courses.infra.persistence;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoursesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public CoursesEntity( UUID id, String name, String category, Boolean isActive, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

}

