package de.nordakademie.persistence.message;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.nordakademie.business.message.Message;
import de.nordakademie.business.message.MessageDAO;
import de.nordakademie.persistence.common.MongodbFactory;

@Repository
public class MessageDAOImpl implements MessageDAO {

    @Autowired
    private MongodbFactory mongodb;

    @Override
    public List<Message> findAll() {
        return Collections.singletonList(new Message("helloWorld.title"));
    }
}
