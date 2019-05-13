package domain.services;

public class RatingService {


    public double update(String ratesTab)
    {
        String[] rates = ratesTab.split("[ | ]");

        double sum = 0;
        int counter = 0;
        for (String num : rates)
        {
            sum = sum+Double.valueOf(num);
            counter++;
        }
        return sum/counter;
    }

}
