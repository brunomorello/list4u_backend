package br.com.l4u.shoppinglist.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private String dbUrl;
    private String dbName = "list4u";
    private String dbUser;
    private String dbPasswod;

    public DatabaseConfig() {
        this.dbUrl = getProperty("DB_URL");
        this.dbName = getProperty("DB_NAME");
        this.dbUser = getProperty("DB_USERNAME");
        this.dbPasswod = getProperty("DB_PASSWORD");

        StringBuilder sb = new StringBuilder();
        sb.append(this.dbUrl.replaceAll("USER", this.dbName))
                .append(this.dbUrl.replaceAll("PWD", this.dbPasswod));
        this.dbUrl = sb.toString();
    }

    private String getProperty(String value) {
        try(InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            if (System.getenv(value) != null) {
                return System.getenv(value);
            } else {
                return properties.getProperty(value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MongoDatabase mongoDb() {
        MongoClient mongoClient = MongoClients.create(dbUrl);
        return mongoClient.getDatabase(dbName);
    }
}
