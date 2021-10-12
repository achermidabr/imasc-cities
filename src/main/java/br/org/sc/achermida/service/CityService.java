package br.org.sc.achermida.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.jboss.logging.Logger;

import br.org.sc.achermida.entidades.City;
import br.org.sc.achermida.enums.StatesEnum;
import br.org.sc.achermida.repositories.CityRepository;
import io.quarkus.cache.CacheResult;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class CityService {

    @Inject 
    private CityRepository repo;
    private static final Logger LOG = Logger.getLogger(CityService.class);

    @CacheResult(cacheName = "cities-cache")
    public List<City> allCities(){
        LOG.debug("returning all cities in database, this might take a while in first call");
        return repo.listAll(Sort.by("estado").and("municDescricao"));
    }

    public List<City> citiesByState(StatesEnum state){
        return repo.findByState(state);
    }

    public City cityByIbge(Integer code) {
        return repo.findByIbge(code);
    }
}
