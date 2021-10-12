package br.org.sc.achermida.entidades;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="cities")
public class City {
    public String _id; // used by MongoDB for the _id field
    public String state;
    public String name;
    public Integer codIbge;
    public Integer codTOM;
    public Integer municipalizationLevel;

    public Regional regional;
    public MilitaryPoliceBattalion police;
    public HydrographicBasin basin;
}