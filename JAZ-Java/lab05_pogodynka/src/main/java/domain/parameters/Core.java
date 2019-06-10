package domain.parameters;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Core {
    private double temp;
    private double pressure;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
