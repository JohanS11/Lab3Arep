package edu.eci.arep.lab3.Challenge2.Persistence;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.eci.arep.lab3.Challenge2.Model.Restaurant;
import org.bson.Document;

import java.util.ArrayList;

public class DBConnection {

    public MongoClient mongoClient;
    public MongoClientURI uri;

    public DBConnection() {
        uri = new MongoClientURI(
                "mongodb+srv://chan1100:chan123@cluster0.djvny.mongodb.net/ArepDB?retryWrites=true&w=majority");
        mongoClient = new MongoClient(uri);
    }

    public ArrayList<Restaurant> retrieveData() {

        MongoDatabase db = mongoClient.getDatabase("ArepDB");
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        MongoCollection<Document> collection = db.getCollection("restaurants");
        //System.out.println("COLLECTION "+collection.getNamespace());
        FindIterable fit = collection.find();
        ArrayList<Document> docs = new ArrayList<Document>();
        fit.into(docs);

        for (Document document:docs) {
            String name = document.get("name").toString();
            String cuisine = document.get("cuisine").toString();
            String borough = document.get("borough").toString();
            int restaurant_id = (int) document.get("restaurant_id");

            restaurants.add(new Restaurant(restaurant_id,name,borough,cuisine));
        }
        return restaurants;

    }

    public void AddRestaurant(Restaurant restaurant){
        MongoDatabase db = mongoClient.getDatabase("ArepDB");
        MongoCollection<Document> collection = db.getCollection("restaurants");
        Document document = new Document();
        document.put("borough", restaurant.getBorough());
        document.put("cuisine", restaurant.getCuisine());
        document.put("name", restaurant.getName());
        document.put("restaurant_id", restaurant.getRestaurant_id());
        collection.insertOne(document);

    }



}
