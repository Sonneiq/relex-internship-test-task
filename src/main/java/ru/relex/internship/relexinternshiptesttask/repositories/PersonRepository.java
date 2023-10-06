package ru.relex.internship.relexinternshiptesttask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.relex.internship.relexinternshiptesttask.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
