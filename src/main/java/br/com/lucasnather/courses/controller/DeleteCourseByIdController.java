package br.com.lucasnather.courses.controller;

import br.com.lucasnather.courses.services.DeleteCourseByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class DeleteCourseByIdController {

    @Autowired
    private DeleteCourseByIdService deleteCourseByIdService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        UUID stringIdToUuid = UUID.fromString(id);

        try {
            this.deleteCourseByIdService.handle(stringIdToUuid);

            return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Curso deletado");
        } catch (RuntimeException e) {
            return  ResponseEntity.status(HttpStatus.ACCEPTED).body(e.getMessage());
        }
    }

}
