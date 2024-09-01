import java.util.Scanner;

class Register {
    public static void main(String[] args) {
        System.out.println("How much money do you have? ");
        Scanner scan = new Scanner(System.in);
        double money = scan.nextDouble();
        makeChange(money);
    }

    public static void makeChange(double args) {

        System.out.println("\nMoney: $" + args);

        int quarters = 0, dimes = 0, nickles = 0, pennies = 0;
        while (args > 0.0001) {
            if (args >= 0.25) {
                quarters += 1;
                args -= 0.25;
            } else if (args < 0.25 && args >= 0.10) {
                dimes += 1;
                args -= 0.10;
            } else if (args < 0.10 && args >= 0.05) {
                nickles += 1;
                args -= 0.05;
            } else {
                pennies += 1;
                args -= 0.01;
            }
        }
        System.out.println("\nTotal Change \n---------------\nQuarters: " + quarters + "\nDimes: " + dimes + "\nNickles: " + nickles + "\nPennies: " + pennies);
    }


}

