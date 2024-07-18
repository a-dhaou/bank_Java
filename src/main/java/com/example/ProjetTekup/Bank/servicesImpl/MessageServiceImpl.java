package com.example.ProjetTekup.Bank.servicesImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetTekup.Bank.models.Message;
import com.example.ProjetTekup.Bank.repositories.MessageRepository;
import com.example.ProjetTekup.Bank.services.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message sendMessage(Message message) {
        message.setDateEnvoi(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesByClientId(Long clientId) {
        return messageRepository.findByClientId(clientId);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
