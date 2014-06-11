package de.nordakademie.business.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.nordakademie.business.message.Message;
import de.nordakademie.business.message.MessageDAO;
import de.nordakademie.business.message.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO messageDAO;

    @Override
    public List<Message> findAll() {
        return messageDAO.findAll();
    }
}
