package br.org.sc.achermida.entidades;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="regional")
public class Regional {
    public String _id;
    public String description;
    public String resume;
    public String abbreviation;
    // public Address address;
    // public List<Contact> contacts;
}
