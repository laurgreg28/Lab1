import java.util.Scanner;
class Register {
    Denomination hundredDollar;
    Denomination fiftyDollar;
    Denomination twentyDollar;
    Denomination tenDollar;
    Denomination fiveDollar;
    Denomination oneDollar;
    Denomination quarter;
    Denomination dime;
    Denomination nickel;
    Denomination penny;

    public Register() {
        hundredDollar = new Denomination("Hundred-Dollar Note", 100.00, "bill");
        fiftyDollar = new Denomination("Fifty-Dollar Note", 50.00, "bill");
        twentyDollar = new Denomination("Twenty-Dollar Note", 20.00, "bill");
        tenDollar = new Denomination("Ten-Dollar Note", 10.00, "bill");
        fiveDollar = new Denomination("Five-Dollar Note", 5.00, "bill");
        oneDollar = new Denomination("One-Dollar Note", 1.00, "bill");
        quarter = new Denomination("Quarter", 0.25, "coin");
        dime = new Denomination("Dime", 0.10, "coin");
        nickel = new Denomination("Nickel", 0.05, "coin");
        penny = new Denomination("Penny", 0.01, "coin");
    }
    public static void main(String[] args) {
        Register register = new Register();

        System.out.println("How much money do you have? ");
        Scanner scan = new Scanner(System.in);
        double amt = scan.nextDouble();
        Purse p = register.makeChange(amt);
        System.out.println(p.toString());
        System.out.println("Total: " + p.getValue());
    }

    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        while (amt > 0.0001) {
            if (amt >= hundredDollar.amt()) {
                purse.add(hundredDollar, 1);
                amt -= hundredDollar.amt();
            } else if (amt >= fiftyDollar.amt()) {
                purse.add(fiftyDollar, 1);
                amt -= fiftyDollar.amt();
            } else if (amt >= twentyDollar.amt()) {
                purse.add(twentyDollar, 1);
                amt -= twentyDollar.amt();
            } else if (amt >= tenDollar.amt()) {
                purse.add(tenDollar, 1);
                amt -= tenDollar.amt();
            } else if (amt >= fiveDollar.amt()) {
                purse.add(fiveDollar, 1);
                amt -= fiveDollar.amt();
            } else if (amt >= oneDollar.amt()) {
                purse.add(oneDollar, 1);
                amt -= oneDollar.amt();
            }
            else if (amt >= quarter.amt()) {
                purse.add(quarter, 1);
                amt -= quarter.amt();
            }
            else if (amt >= dime.amt()) {
                purse.add(dime, 1);
                amt -= dime.amt();
            }
            else if (amt >= nickel.amt()) {
                purse.add(nickel, 1);
                amt -= nickel.amt();
            }
            else {
                purse.add(penny, 1);
                amt -= penny.amt();
            }



        }
        return purse;
    }


}

