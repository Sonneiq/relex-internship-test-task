package ru.relex.internship.relexinternshiptesttask.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.relex.internship.relexinternshiptesttask.models.Person;
import ru.relex.internship.relexinternshiptesttask.services.PersonServiceImpl;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private final PersonServiceImpl personService;

    @PostMapping ("/create")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person createdPerson = personService.createPerson(person);
        return new ResponseEntity(createdPerson, HttpStatus.OK);
    }
}
