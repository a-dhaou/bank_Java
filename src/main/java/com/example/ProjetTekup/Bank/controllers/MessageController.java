package com.example.ProjetTekup.Bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ProjetTekup.Bank.models.Message;
import com.example.ProjetTekup.Bank.services.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Message sentMessage = messageService.sendMessage(message);
        return ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Message>> getMessagesByClientId(@PathVariable Long clientId) {
        List<Message> messages = messageService.getMessagesByClientId(clientId);
        return ResponseEntity.ok(messages);
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }
}
