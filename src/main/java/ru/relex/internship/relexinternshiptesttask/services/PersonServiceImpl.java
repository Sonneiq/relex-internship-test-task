package ru.relex.internship.relexinternshiptesttask.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.internship.relexinternshiptesttask.models.Person;
import ru.relex.internship.relexinternshiptesttask.repositories.PersonRepository;
import ru.relex.internship.relexinternshiptesttask.services.interfaces.PersonService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Person register(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public Person update(Person authenticatedPerson, Person updatedPerson) throws RuntimeException {
        Optional<Person> personToUpdateOptional = personRepository.findByNickname(authenticatedPerson.getNickname());

        if(personToUpdateOptional.isEmpty()) {
            throw new RuntimeException(
                    "User: " + authenticatedPerson.getNickname() + " not found");
        }
        if(isPersonExists(updatedPerson.getNickname())) {
            throw new RuntimeException(
                    "User with nickname: " + updatedPerson.getNickname() + " already exists");
        }

        Person personToUpdate = personToUpdateOptional.get();

        personToUpdate.setEmail(updatedPerson.getEmail());
        personToUpdate.setNickname(updatedPerson.getNickname());
        personToUpdate.setName(updatedPerson.getName());
        personToUpdate.setSurname(updatedPerson.getSurname());

        return personRepository.save(personToUpdate);
    }

    @Override
    @Transactional
    public Person updatePassword(Person authenticatedPerson, String newPassword) throws RuntimeException {
        Optional<Person> personToUpdatePass = personRepository.findByNickname(authenticatedPerson.getNickname());
        if(personToUpdatePass.isEmpty()) {
            throw new RuntimeException(
                    "User: " + authenticatedPerson.getNickname() + " not found");
        }
        personToUpdatePass.get().setPassword(passwordEncoder.encode(newPassword));
        return personRepository.save(personToUpdatePass.get());
    }

    @Override
    public void delete(Person authenticatedPerson) throws RuntimeException {
        Optional<Person> personToDelete = personRepository.findByNickname(authenticatedPerson.getNickname());
        if(personToDelete.isEmpty()) {
            throw new RuntimeException(
                    "User: " + authenticatedPerson.getNickname() + " not found");
        }
        personRepository.delete(personToDelete.get());
    }

    private boolean isPersonExists(String nickname) {
        Optional<Person> personOptional = personRepository.findByNickname(nickname);
        return personOptional.isPresent();
    }
}
