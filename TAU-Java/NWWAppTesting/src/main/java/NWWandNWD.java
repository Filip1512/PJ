public class NWWandNWD {

    public int nwd(int x, int y) {
        while (x != y) {
            if (x > y)
                x -= y;
            else
                y -= x;
        }
        return x;
    }

    public int nww(int x, int y) {
        return (x * y) / nwd(x, y);
    }

    public int calc(int x, int y, String operator){
        int result = 0;

        switch(operator) {
            case "+": {
                result = x + y;
                break;
            }
            case "-": {
                result = x - y;
                break;
            }
            case "*": {
                result = x * y;
                break;
            }
            case "/": {
                result = x / y;
                break;
            }
            default: {
                result = 0;
                System.out.println("Podano zly znak. Wybierz +, -, * lub / !");
            }
        }

        return result;
    }

}