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

    @PostMapping ("/registration")
    public ResponseEntity<Person> register(@RequestBody Person person) {
        Person result = personService.registerPerson(person);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    //Для тестирования авторизованных Get запросов
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
