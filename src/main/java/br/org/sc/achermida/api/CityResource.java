package br.org.sc.achermida.api;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.jboss.logging.Logger;

import br.org.sc.achermida.entidades.City;
import br.org.sc.achermida.enums.StatesEnum;
import br.org.sc.achermida.service.CityService;

@GraphQLApi
public class CityResource {

    @Inject
    private CityService rService;
    
    private static final Logger LOG = Logger.getLogger(CityService.class);

    @Query("cities") 
    @Description("Return all cities in Brazil")
    public List<City> allCities() {
        LOG.debug("All cities");
        return rService.allCities();
    }

    @Query("citiesByState") 
    @Description("Return all cities in the given State")
    public List<City> citiesByState(StatesEnum state) {
        return rService.citiesByState(state);
    }

    @Query("cityByIbge") 
    @Description("Return the city by the IBGE unique code")
    public City citiesByIbge(Integer code) {
        return rService.cityByIbge(code);
    }
    
}