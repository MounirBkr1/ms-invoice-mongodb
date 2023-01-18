package com.ensa.msinvoice.config;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
    public class mongoAtlassConfig extends AbstractMongoClientConfiguration {

        static final String uri="mongodb+srv://miirbri1:Mounir15429@ms-invoice.m6naiks.mongodb.net/?retryWrites=true&w=majority";
        static final String db="invoice_db";

        @Override
        public MongoClient mongoClient() {
            ConnectionString connectionString = new ConnectionString(uri);
            MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
            return MongoClients.create(settings);
        }

        @Override
        protected String getDatabaseName() {
            return db;
        }

        @Bean
        public MongoTemplate mongoTemplate() throws Exception {
            return new MongoTemplate(mongoClient(), getDatabaseName());
        }

    }