package ru.relex.internship.relexinternshiptesttask.services.interfaces;

import ru.relex.internship.relexinternshiptesttask.models.Person;

public interface PersonService {
    Person register(Person person);
    Person update(Person authenticatedPerson, Person updatingPerson);
    Person updatePassword(Person authenticatedPerson, String newPassword);
    void delete(Person authenticatedPerson);
}
