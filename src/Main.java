

import java.util.ArrayList;
import java.util.Scanner;
class Register {
    Denomination hundredDollar;
    Denomination fiftyDollar;
    Denomination twentyDollar;
    Denomination tenDollar;
    Denomination fiveDollar;
    Denomination oneDollar;

    public Register() {
        hundredDollar = new Denomination("Hundred-Dollar Note", 100.00, "bill");
        fiftyDollar = new Denomination("Fifty-Dollar Note", 50.00, "bill");
        twentyDollar = new Denomination("Twenty-Dollar Note", 20.00, "bill");
        tenDollar = new Denomination("Ten-Dollar Note", 10.00, "bill");
        fiveDollar = new Denomination("Five-Dollar Note", 5.00, "bill");
        oneDollar = new Denomination("One-Dollar Note", 1.00, "bill");
    }
    public static void main(String[] args) {
        Register register = new Register();
        System.out.println(register.hundredDollar);

        System.out.println("How much money do you have? ");
        Scanner scan = new Scanner(System.in);
        double amt = scan.nextDouble();
        register.makeChange(amt);
    }

    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        int count = 0;
        while (amt > 0.0001) {
            if (amt >= hundredDollar.amt()) {
                purse.add(hundredDollar, count += 1);
                amt -= hundredDollar.amt();
            } else if (amt < hundredDollar.amt() && amt >= fiftyDollar.amt()) {
                purse.add(fiftyDollar, count += 1);
                amt -= fiftyDollar.amt();
            } else if (amt < fiftyDollar.amt() && amt >= twentyDollar.amt()) {
                purse.add(twentyDollar, count += 1);
                amt -= twentyDollar.amt();
            } else if (amt < twentyDollar.amt() && amt >= tenDollar.amt()) {
                purse.add(tenDollar, count += 1);
                amt -= tenDollar.amt();
            } else if (amt < tenDollar.amt() && amt >= fiveDollar.amt()) {
                purse.add(fiveDollar, count += 1);
                amt -= fiveDollar.amt();
            } else if (amt < fiveDollar.amt() && amt >= oneDollar.amt()) {
                purse.add(oneDollar, count += 1);
                amt -= oneDollar.amt();
            }
        }
        return purse;
    }


}

