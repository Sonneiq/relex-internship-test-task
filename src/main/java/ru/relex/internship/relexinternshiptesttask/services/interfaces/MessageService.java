package ru.relex.internship.relexinternshiptesttask.services.interfaces;

import ru.relex.internship.relexinternshiptesttask.models.Message;

import java.util.List;

public interface MessageService {
    Message writeMessage(Message message);
    List<Message> getMessages(String sender, String recipient);
}
