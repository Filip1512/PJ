package domain.parameters;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Wind
{
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
