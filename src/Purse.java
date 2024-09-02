import java.util.HashMap;

public class Purse (double amt){
    HashMap<Denomination, Integer> cash = new HashMap<Denomination,Integer>();



    public void add(Denomination money_type, int num) {
        cash.put(money_type, num);
    }
    public double remove(Denomination money_type, int num) {
        cash.remove(money_type);
        double value = amt - num;
        return value;
    }

    public double getValue() {
        return amt;
    }

    public String toString() {
        String(amt);
    }

}