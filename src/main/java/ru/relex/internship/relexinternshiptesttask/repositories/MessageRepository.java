package ru.relex.internship.relexinternshiptesttask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.relex.internship.relexinternshiptesttask.models.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query("FROM Message WHERE sender = :sender AND recipient = :recipient " +
            "OR sender = :recipient AND recipient = :sender ORDER BY id")
    List<Message> getMessageDialog(@Param("sender") String sender, @Param("recipient") String recipient);
}
