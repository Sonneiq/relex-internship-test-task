package ru.relex.internship.relexinternshiptesttask.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.relex.internship.relexinternshiptesttask.models.Message;
import ru.relex.internship.relexinternshiptesttask.repositories.MessageRepository;
import ru.relex.internship.relexinternshiptesttask.services.interfaces.MessageService;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Message writeMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessages(String sender, String recipient) {
        return messageRepository.getMessageDialog(sender, recipient);
    }
}
