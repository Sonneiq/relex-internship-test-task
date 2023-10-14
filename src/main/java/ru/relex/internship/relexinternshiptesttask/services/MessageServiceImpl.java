package ru.relex.internship.relexinternshiptesttask.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.relex.internship.relexinternshiptesttask.models.Message;
import ru.relex.internship.relexinternshiptesttask.models.Person;
import ru.relex.internship.relexinternshiptesttask.repositories.MessageRepository;
import ru.relex.internship.relexinternshiptesttask.repositories.PersonRepository;
import ru.relex.internship.relexinternshiptesttask.services.interfaces.MessageService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final PersonRepository personRepository;

    @Override
    public List<Message> getMessages(String sender, String recipient) {
        Optional<Person> recipientOptional = personRepository.findByNickname(recipient);
        if(recipientOptional.isEmpty()) {
            throw new RuntimeException("Recipient: " + recipient + " not found");
        }
        return messageRepository.getMessageDialog(sender, recipient);
    }
    @Override
    public Message writeMessage(Message message) throws RuntimeException {
        String recipientNickname = message.getRecipient();
        Optional<Person> recipientOptional = personRepository.findByNickname(recipientNickname);
        if(recipientOptional.isEmpty()) {
            throw new RuntimeException("Recipient: " + recipientNickname + " not found");
        }
        return messageRepository.save(message);
    }
}
