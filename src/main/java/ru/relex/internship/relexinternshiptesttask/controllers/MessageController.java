package ru.relex.internship.relexinternshiptesttask.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.relex.internship.relexinternshiptesttask.models.Message;
import ru.relex.internship.relexinternshiptesttask.security.PersonDetails;
import ru.relex.internship.relexinternshiptesttask.services.MessageServiceImpl;
import ru.relex.internship.relexinternshiptesttask.services.PersonServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageController {
    private final PersonServiceImpl personService;
    private final MessageServiceImpl messageService;

    @GetMapping("/get/{recipient}")
    public ResponseEntity<List<Message>> getMessages(@AuthenticationPrincipal PersonDetails authenticatedPerson,
                                                     @PathVariable String recipient) {
        if(personService.isPersonExists(recipient)) {
            List<Message> messages = messageService.getMessages(authenticatedPerson.getUsername(), recipient);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/send/{recipient}")
    public ResponseEntity<Message> sendMessage(@AuthenticationPrincipal PersonDetails authenticatedPerson,
                                               @PathVariable String recipient, @RequestBody String text) {
        if(personService.isPersonExists(recipient)) {
            Message messageToSend = Message.builder()
                    .sender(authenticatedPerson.getUsername())
                    .recipient(recipient)
                    .text(text)
                    .build();
            Message writtenMessage = messageService.writeMessage(messageToSend);
            return new ResponseEntity<>(writtenMessage, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
