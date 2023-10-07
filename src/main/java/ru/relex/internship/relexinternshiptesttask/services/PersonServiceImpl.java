package ru.relex.internship.relexinternshiptesttask.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.internship.relexinternshiptesttask.models.Person;
import ru.relex.internship.relexinternshiptesttask.repositories.PersonRepository;
import ru.relex.internship.relexinternshiptesttask.services.interfaces.PersonService;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    @Transactional
    public Person registerPerson(Person person) {
        return personRepository.save(person);
    }
}
