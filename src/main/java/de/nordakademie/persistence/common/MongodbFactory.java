package de.nordakademie.persistence.common;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Required;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongodbFactory implements FactoryBean<MongoDatabase> {

    private MongoClient mongoClient;
    private String databaseName;

    @Override
    public MongoDatabase getObject() {
        return mongoClient.getDatabase(databaseName);
    }

    @Override
    public Class<MongoDatabase> getObjectType() {
        return MongoDatabase.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Required
    public void setMongoClient(final MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Required
    public void setDatabaseName(final String databaseName) {
        this.databaseName = databaseName;
    }
}
