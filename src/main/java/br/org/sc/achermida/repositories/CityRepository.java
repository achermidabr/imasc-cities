package br.org.sc.achermida.repositories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.org.sc.achermida.entidades.City;
import br.org.sc.achermida.enums.StatesEnum;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class CityRepository implements PanacheMongoRepository<City>{
    public List<City> findByState(StatesEnum state){
        return list("estado", Sort.by("municDescricao"), state.name());
    }

    public City findByIbge(Integer code) {
        return find("codIbge", code).singleResult();
    }
}

