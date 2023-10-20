package com.performance.tune.service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.performance.tune.mongoconnection.MongoClientConnection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class HomeService {

    @Autowired
    MongoClientConnection mongoClientConnection;

    public void hello(String hello) {
        MongoDatabase database = mongoClientConnection.getMongoDatabase("mongodb://127.0.0.1:27017","hello");
        MongoCollection<Document> collection = database.getCollection("hello");
        collection.insertOne(new Document(Instant.now().toString(),hello));
    }

    public void optionalHello(Optional<String> hello) {
        MongoDatabase database = mongoClientConnection.getMongoDatabase("mongodb://127.0.0.1:27017","hello_optional");
        MongoCollection<Document> collection = database.getCollection("hello_optional");
        collection.insertOne(new Document(Instant.now().toString(),hello.get()));
    }

    public List<Document> getHello() {
        MongoDatabase database = mongoClientConnection.getMongoDatabase("mongodb://127.0.0.1:27017","hello");
        MongoCollection<Document> collection = database.getCollection("hello");
        FindIterable<Document> iterable = collection.find().limit(100);
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }
}
