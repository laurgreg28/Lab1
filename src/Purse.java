//Returns the purse containing the fewest bills and coins
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Purse {
    //Map of denomination and its count in order
    LinkedHashMap<Denomination, Integer> cash = new LinkedHashMap<Denomination,Integer>();

    //Adds number of the denomination
    public void add(Denomination money_type, int num) {
        //If there isn't a value for the key just add 1
        if (!cash.containsKey(money_type)) {
            cash.put(money_type, num);
        }
        //Else add 1 to the current value
        else {
            cash.put(money_type, cash.get(money_type) + num);
        }


    }
    //Diminishes money in purse and returns amount removed
    public double remove(Denomination money_type, int num) {
        //Current count of denomination
        int current_count = cash.get(money_type);

        //Checks if there is enough to remove
        if (current_count < num) {
            System.out.println("Not enough " + money_type.name() + " to remove.");
            return 0;
        }
        //removes amount and updates the map
        double removed_amt = money_type.amt()*num;
        cash.put(money_type,current_count-num);
        return removed_amt;
    }

    //Returns amount of money in the Purse
    public double getValue() {
      //Multiplies amount of denomination by its count
        double total = 0;
        for (Denomination money : cash.keySet()) {
            total += cash.get(money) * money.amt();
        }
        return total;
    }

    // Returns string representation of the Purse's contents
    public String toString() {
        String result = "";
        //Checks for empty purse
        if (cash.isEmpty())
            return "Empty purse";
        //Iterate through map
        for (HashMap.Entry<Denomination, Integer> entry : cash.entrySet()) {
            result += (entry.getValue()) + (" ") + (entry.getKey().name()) + ("\n");
        }
        return result;

    }

}