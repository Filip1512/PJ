package services;

import domain.City;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
// API URL              http://api.openweathermap.org/data/2.5/weather
// API KEY (appid=)     e3513dedfc557c7cee1a824030a52aa2
public class CityService {
    public static final String URL = "http://api.openweathermap.org/data/2.5/weather";
    public static final String APIKEY = "e3513dedfc557c7cee1a824030a52aa2";


    public City getCity(String name){
        return ClientBuilder
                .newClient()
                .target(URL + "?q=" + name + "&APPID=" + APIKEY + "&units=metric")
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(City.class);
    }

}