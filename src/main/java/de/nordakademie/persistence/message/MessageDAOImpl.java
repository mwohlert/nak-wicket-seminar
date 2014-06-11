package de.nordakademie.persistence.message;

import static java.util.Arrays.asList;

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
        return asList(new Message("helloWorld.title"));
    }
}
