package com.performance.tune.mongoconnection;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Service
public class MongoClientConnection {

    private final Map<String, MongoDatabase> clientsMap = new HashMap<>();

    public MongoClient createMongoClient(String uri) {
        // Create a new client and connect to the server
        return MongoClients.create(uri);
    }

    public MongoDatabase getMongoDatabase(String uri,String database){
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        MongoDatabase client = clientsMap.get(uri.concat(database));
        if(Objects.isNull(client)){
            clientsMap.put(uri.concat(database),createMongoClient(uri).getDatabase(database));
        }
        return clientsMap.get(uri.concat(database));
    }
}
