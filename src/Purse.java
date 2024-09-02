import java.util.HashMap;

public class Purse {
    HashMap<Denomination, Integer> cash = new HashMap<Denomination,Integer>();



    public void add(Denomination money_type, int num) {
        if (!cash.containsKey(money_type)) {
            cash.put(money_type, num);
        }
        else {
            cash.put(money_type, cash.get(money_type) + num);
        }


    }
    //public double remove(Denomination money_type, int num) {
      //  cash.remove(money_type, num-1);
    //}

    //public double getValue() {
      //  return amt;
   // }

    public String toString() {
        String result = "Money in purse\n--------------------\n";
        for (HashMap.Entry<Denomination, Integer> entry : cash.entrySet()) {
            result += entry.getValue() + " " + entry.getKey().name() + "\n";
        }
        return result;

    }

}