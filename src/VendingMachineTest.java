import java.util.Scanner;

/**
 * Class: CIS35A Java Programming
 * Instructor: Victor Yu
 * Description: Write a program that simulates a vending machine.
 * Vending machine sells 3 types of food:
 * 1. Chips - $1.25
 * 2. Cookies $0.85
 * 3. Candies $0.95
 * <p>
 * Due: 2/9/2017, 8:00 PM PST
 * I pledge by honor that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Sign here: Tsao-Hsiang (Robert) Tu
 */

public class VendingMachineTest {
    // Initialize different coins
    static int quarter = 25;
    static int dime = 10;
    static int nickel = 5;

    /**
     * Main method
     */
    public static void main(String[] args) {
        // Initialize quantity of each vending machine items
        int chipsQty = 1;
        int cookiesQty = 1;
        int candiesQty = 1;
        // Initialize price of each vending machine item
        int chipsPrice = 125;
        int cookiesPrice = 85;
        int candiesPrice = 95;
        // Create Scanner object to read user inputs
        Scanner reader = new Scanner(System.in);
        // Prints vending machine title
        while (true) {
            if (chipsQty > 0 || cookiesQty > 0 || candiesQty > 0) {
                System.out.println("");
                System.out.println("-----------------------------");
                System.out.println("Welcome to My Vending Machine");
                System.out.println("-----------------------------");
                // Asks the user to put in their coins
                System.out.println("Please put your money in: ");
                // Asks for number of quarters and saves as variable
                System.out.println("How many quarters?");
                int numOfQuarters = reader.nextInt();
                // Asks for number of dimes and saves as variable
                System.out.println("How many dimes?");
                int numOfDimes = reader.nextInt();
                // Asks for number of nickels and saves as variable
                System.out.println("How many nickels?");
                int numOfNickels = reader.nextInt();
                // Calculates total amount by multiplying user's input with assigned currency value, then adding them for total value
                int money = (quarter * numOfQuarters) + (dime * numOfDimes) + (nickel * numOfNickels);
                // Printing
                System.out.println("");
                System.out.println("-----------------------------");
                System.out.println("     PROCESSING MONEY        ");
                System.out.println("-----------------------------");
                // Display the number of coins the user put and how much total money is in the machine
                System.out.println("You put in " + numOfQuarters + " quarters, " + numOfDimes + " dimes, and " + numOfNickels + " nickels.");
                // Formats display to show decimals for money
                System.out.printf("Current amount in machine: $%.2f\n", money / 100.0);
                // Prints vending machine menu
                System.out.println("-----------------------------");
                System.out.println("[#] | Food    | Qty  | Price");
                System.out.println("-----------------------------");
                System.out.printf("[1] | Chips   |  %d   | $%4.2f\n", chipsQty, chipsPrice / 100.0);
                System.out.println("-----------------------------");
                System.out.printf("[2] | Cookies |  %d   | $%4.2f\n", cookiesQty, cookiesPrice / 100.0);
                System.out.println("-----------------------------");
                System.out.printf("[3] | Candies |  %d   | $%4.2f\n", candiesQty, candiesPrice / 100.0);
                System.out.println("-----------------------------");
                System.out.println("Please make your selection: ");
                System.out.println("Type \"1\" for Chips, \"2\" for Cookies, \"3\" for Candies, \"0\" to quit.");
                // Asks for user selection and reads input
                int selection = reader.nextInt();
                // If user enters "1" and chips are in stock then they can buy chips
                if (selection == 1 && chipsQty > 0) {
                    System.out.println("You selected Chips");
                    // Calculates if user put enough money to purchase
                    money = money - chipsPrice;
                    // If they did not put enough money, item will not sell
                    if (money < 0) {
                        // Returns the user's money
                        money = money + chipsPrice;
                        System.out.println("-----------------------------");
                        System.out.println("ERROR: You did not put enough money");
                        System.out.println("-----------------------------");
                        System.out.printf("Returning your money: $%.2f\n", money / 100.0);
                        calculateChange(money);
                        // If user put enough money then they can purchase the item
                    } else {
                        System.out.printf("Change: $%.2f\n", money / 100.0);
                        // Calls calculateChange method to determine change
                        calculateChange(money);
                        // Subtracts 1 from total stock
                        chipsQty--;
                    }
                    // If user selects "2" and cookies are in stock then they can buy cookies
                } else if (selection == 2 && cookiesQty > 0) {
                    System.out.println("You selected Cookies");
                    // Calculates if user put enough money to purchase
                    money = money - cookiesPrice;
                    // If they did not put enough money, item will not sell
                    if (money < 0) {
                        // Returns the user's money
                        money = money + cookiesPrice;
                        System.out.println("-----------------------------");
                        System.out.println("ERROR: You did not put enough money");
                        System.out.println("-----------------------------");
                        System.out.printf("Returning your money: $%.2f\n", money / 100.0);
                        calculateChange(money);
                        // If user put enough money then they can purchase the item
                    } else {
                        System.out.printf("change: %.2f\n", money / 100.0);
                        // Calls calculateChange method to determine change
                        calculateChange(money);
                        // Subtracts 1 from total stock
                        cookiesQty--;
                    }
                    // If user selects "3" then they will buy candies
                } else if (selection == 3 && candiesQty > 0) {
                    System.out.println("You selected Candies");
                    money = money - candiesPrice;
                    if (money < 0) {
                        // Returns the user's money
                        money = money + candiesPrice;
                        System.out.println("-----------------------------");
                        System.out.println("ERROR: You did not put enough money");
                        System.out.println("-----------------------------");
                        System.out.printf("Returning your money: $%.2f\n", money / 100.0);
                        calculateChange(money);
                        // If user put enough money then they can purchase the item
                    } else {
                        System.out.printf("change: %.2f\n", money / 100.0);
                        // Calls calculateChange method to determine change
                        calculateChange(money);
                        // Subtracts 1 from total stock
                        candiesQty--;
                    }
                } else if (selection == 0) {
                    System.out.println("-----------------------------");
                    System.out.println("Exiting Vending Machine      ");
                    System.out.println("-----------------------------");
                    System.out.printf("Returning your money: $%.2f\n", money / 100.0);
                    calculateChange(money);
                    break;
                }
                // If user enters anything else then it will prompt invalid and return the money
                else {
                    System.out.println("-----------------------------");
                    System.out.println("ERROR: Invalid selection or out of stock");
                    System.out.println("-----------------------------");
                    System.out.printf("Returning your money: $%.2f\n", money / 100.0);
                    calculateChange(money);
                }
                // Once all items are sold out then it will quit
            } else {
                System.out.println("Sorry. All items are sold out!");
                break;
            }
        }
    }

    /* Method for calculating how many coins to return*/
    public static void calculateChange(double money) {
        //
        double change = Math.round(money * 100.0) / 100.0;
        // Calculate number of quarters
        // Divide
        int numQuarters = (int) (change / quarter);
        System.out.println("Quarters:" + numQuarters);
        // Set money as remainder after counting quarters
        change = change % quarter;
        // Calculate number of dimes
        int numDime = (int) (change / dime);
        System.out.println("Dimes: " + numDime);
        // Set money as remainder after counting dimes
        change = change % dime;
        // Calculate number of nickels
        int numNickel = (int) (change / nickel);
        System.out.println("Nickels: " + numNickel);
        // Set money as remainder after nickels
        change = change % nickel;
    }

    // Test Cases (Repeat for all foods)
    // Buyer selects a food that is available, and inserts the exact amount as the price
    // Buyer selects a food that is in stock, and inserts less money than the price
    // Buyer selects a food that is in stock, and inserts more money than the price
    // Buyer selects a food that is sold out
    // Buyer selects a food that does not exist


}
