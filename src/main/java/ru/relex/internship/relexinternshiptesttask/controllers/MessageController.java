package ru.relex.internship.relexinternshiptesttask.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.relex.internship.relexinternshiptesttask.models.Message;
import ru.relex.internship.relexinternshiptesttask.security.PersonDetails;
import ru.relex.internship.relexinternshiptesttask.services.MessageServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
@Log4j2
public class MessageController {

    private final MessageServiceImpl messageService;

    @GetMapping("/get/{recipient}")
    public ResponseEntity<List<Message>> getMessages(@AuthenticationPrincipal PersonDetails authenticatedPerson,
                                                     @PathVariable String recipient) {
        try {
            List<Message> messages = messageService.getMessages(authenticatedPerson.getUsername(), recipient);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch (RuntimeException exception) {
            log.warn(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/send/{recipient}")
    public ResponseEntity<Message> sendMessage(@AuthenticationPrincipal PersonDetails authenticatedPerson,
                                               @PathVariable String recipient, @RequestBody String text) {
        try {
            Message messageToSend = Message.builder()
                    .sender(authenticatedPerson.getUsername())
                    .recipient(recipient)
                    .text(text)
                    .build();
            Message writtenMessage = messageService.writeMessage(messageToSend);
            return new ResponseEntity<>(writtenMessage, HttpStatus.CREATED);
        } catch (RuntimeException exception) {
            log.warn(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
