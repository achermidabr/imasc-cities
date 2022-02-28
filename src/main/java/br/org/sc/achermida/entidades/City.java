package br.org.sc.achermida.entidades;

import br.org.sc.achermida.enums.StatesEnum;
import io.quarkus.mongodb.panache.common.MongoEntity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.bson.types.ObjectId;

@MongoEntity(collection = "cities")
public class City {

  public String _id; // used by MongoDB for the _id field

  @NotNull
  @Size(max = 250)
  public String name;

  @NotNull
  public Integer codIbge;

  public Integer codTOM;
  public Integer municipalizationLevel;

  @NotNull
  public StatesEnum state;

  // public Regional regional;

  public MilitaryPoliceBattalion police;
  public HydrographicBasin basin;
}
