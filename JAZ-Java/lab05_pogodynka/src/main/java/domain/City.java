package domain;


import domain.parameters.Core;
import domain.parameters.Weather;
import domain.parameters.Wind;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class City
{
    private Weather weather;
    private Core core;
    private Wind wind;
    private String name;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Core getCore() {
        return core;
    }

    public void setCore(Core core) {
        this.core = core;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}