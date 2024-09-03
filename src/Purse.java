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
    public double remove(Denomination money_type, int num) {
        int current_count = cash.get(money_type);
        double removed_amt = money_type.amt()*num;
        cash.put(money_type,current_count-num);
        return removed_amt;
    }

    public double getValue() {
      //multiply the number of money times the money value
        double total = 0;
        for (Denomination money : cash.keySet()) {
            total += cash.get(money) * money.amt();
        }
        return total;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Money in purse\n--------------------\n");
        if (cash.isEmpty())
            return "Empty purse";
        for (HashMap.Entry<Denomination, Integer> entry : cash.entrySet()) {
            result.append(entry.getValue()).append(" ").append(entry.getKey().name()).append("\n");
        }
        return result.toString();

    }

}