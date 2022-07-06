package org.sksl.skslmongo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class ErpConfig {

    @Bean
    public MongoClient mongoClient() {

        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

//        For MongoDB Local
//        final MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

//        For MongoDB Cloud Atlas
        final ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://root:pass@sksl.uc2o2.mongodb.net/?retryWrites=true&w=majority");
        final MongoClientSettings settings =
                MongoClientSettings.builder()
                        .applyConnectionString(connectionString)
                        .serverApi(
                                ServerApi.builder()
                                        .version(ServerApiVersion.V1)
                                        .build())
                        .codecRegistry(codecRegistry)
                        .build();
        return MongoClients.create(settings);
    }

    @Bean
    public MongoDatabase mongoDatabase() {
        return mongoClient().getDatabase("erpdb");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "erpdb");
    }
}
