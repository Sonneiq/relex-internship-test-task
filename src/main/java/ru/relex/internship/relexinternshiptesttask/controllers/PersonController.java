package ru.relex.internship.relexinternshiptesttask.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.relex.internship.relexinternshiptesttask.models.Person;
import ru.relex.internship.relexinternshiptesttask.security.PersonDetails;
import ru.relex.internship.relexinternshiptesttask.services.PersonServiceImpl;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
@Log4j2
@Tag(name = "PersonController", description = "Контроллер для создания, удаления и редактирования пользователей")
public class PersonController {

    private final PersonServiceImpl personService;

    @PostMapping ("/registration")
    @Operation(description = "Регистрация нового пользователя")
    public ResponseEntity<Person> register(@RequestBody Person person) {
        Person result = personService.register(person);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/update/data")
    @Operation(description = "Обновление почты, никнейма, имени и фамилии пользователя")
    @SecurityRequirement(name = "basicAuth")
    public ResponseEntity<Person> update(@AuthenticationPrincipal PersonDetails authenticatedPerson,
                                         @RequestBody Person updatingPerson) {
        try {
            Person result = personService.update(authenticatedPerson.getPerson(), updatingPerson);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (RuntimeException exception) {
            log.warn(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/update/password/{newPassword}")
    @Operation(description = "Обновление пароля пользователя")
    @SecurityRequirement(name = "basicAuth")
    public ResponseEntity<Person> updatePassword(@AuthenticationPrincipal PersonDetails authenticatedPerson,
                                                 @PathVariable String newPassword) {
        try {
            Person result = personService.updatePassword(authenticatedPerson.getPerson(), newPassword);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (RuntimeException exception) {
            log.warn(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/delete")
    @Operation(description = "Удаление пользователя")
    @SecurityRequirement(name = "basicAuth")
    public ResponseEntity<Void> delete(@AuthenticationPrincipal PersonDetails authenticatedPerson) {
        try {
            personService.delete(authenticatedPerson.getPerson());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException exception) {
            log.warn(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
