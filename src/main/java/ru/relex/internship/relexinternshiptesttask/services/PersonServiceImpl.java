package ru.relex.internship.relexinternshiptesttask.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.relex.internship.relexinternshiptesttask.models.Person;
import ru.relex.internship.relexinternshiptesttask.repositories.PersonRepository;
import ru.relex.internship.relexinternshiptesttask.services.interfaces.PersonService;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
}
