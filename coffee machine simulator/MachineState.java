package machine;

import java.util.Scanner;

public class MachineState {
    int neededWaterForACup;
    int neededMilkForACup;
    int neededBeansForACup;
    int requestedCoffee;
    int howMuchWaterHas=400;
    int howMuchMilkHas=540;
    int howMuchBeansHas=120;
    int howMuchCupHas=9;
    int money=550;

    int amountOfCanMake;



    public void showMachineState(){
        System.out.printf("The coffee machine has:\n" +
                        "%d ml of water\n" +
                        "%d ml of milk\n" +
                        "%d g of coffee beans\n" +
                        "%d disposable cups\n" +
                        "$%d of money\n",

                howMuchWaterHas,howMuchMilkHas,howMuchBeansHas,howMuchCupHas,money);
    }
    private static void response(int amountOfCanMake,int requestedCoffee) {
        if(requestedCoffee> amountOfCanMake){
            System.out.printf("No, I can make only %d cup(s) of coffee", amountOfCanMake);
        } else if (requestedCoffee== amountOfCanMake) {
            System.out.println("Yes, I can make that amount of coffee");

        }
        else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", amountOfCanMake -requestedCoffee);
        }
    }
     public boolean   checkIngredients(Coffee coffee){
        if(howMuchWaterHas<coffee.waterNeeded){
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (howMuchMilkHas<coffee.milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (howMuchBeansHas<coffee.coffeeBeansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (howMuchCupHas==0) {
            System.out.println("Sorry, not enough disposal cups!");
            return false;
        }
        else{
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }
    public  void fillState( ) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        howMuchWaterHas+= scan.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        howMuchMilkHas+= scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        howMuchBeansHas+= scan.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        howMuchCupHas+= scan.nextInt();

    }

    private void changeIngredients(Coffee coffee){
        this.howMuchWaterHas -= coffee.waterNeeded;
        this.howMuchMilkHas -= coffee.milkNeeded;
        this.howMuchBeansHas -= coffee.coffeeBeansNeeded;
        this.howMuchCupHas -= 1;
        this.money += coffee.price;
    }
    public  void buyState() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeNumber= scan.nextLine();
        if(coffeeNumber.equals("1")){
            if(checkIngredients(Coffee.ESPRESSO)){
                changeIngredients(Coffee.ESPRESSO);
            }


        } else if (coffeeNumber.equals("2")) {
            if(checkIngredients(Coffee.LATTE)){
                changeIngredients(Coffee.LATTE);
            }

        }
        else if(coffeeNumber.equals("3")){
            if(checkIngredients(Coffee.CAPPUCCINO)){
                changeIngredients(Coffee.CAPPUCCINO);
            }
        }
        else{
            return;
        }
    }
    private enum Coffee {

        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);

        int waterNeeded;
        int milkNeeded;
        int coffeeBeansNeeded;
        int price;

        Coffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int price) {
            this.waterNeeded = waterNeeded;
            this.milkNeeded = milkNeeded;
            this.coffeeBeansNeeded = coffeeBeansNeeded;
            this.price = price;
        }
    }

}
