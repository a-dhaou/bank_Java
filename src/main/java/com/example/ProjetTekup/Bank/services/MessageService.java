package com.example.ProjetTekup.Bank.services;

import java.util.List;
import com.example.ProjetTekup.Bank.models.Message;

public interface MessageService {
    Message sendMessage(Message message);
    List<Message> getMessagesByClientId(Long clientId);
    List<Message> getAllMessages();
}
