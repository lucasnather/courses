package br.com.lucasnather.courses.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Courses {

    private UUID id;

    private String name;

    private String category;

    private Boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Courses( UUID id, String name, String category, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Courses(String name, String category, Boolean isActive) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
        this.isActive = isActive;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
    }

    public Courses(String name, String category) {
        this.id = getId();
        this.name = name;
        this.category = category;
        this.isActive = getActive();
        this.createdAt = getCreatedAt();
        this.updatedAt = LocalDateTime.now();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public UUID setId(UUID id) {
        return  this.id = id;
    }
}
