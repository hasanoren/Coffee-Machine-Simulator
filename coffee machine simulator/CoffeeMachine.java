package machine;

import java.util.Scanner;

import static java.lang.String.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MachineState machineState = new MachineState();
        Customer customer = new Customer();



       while(true){
           System.out.println("Write action (buy, fill, take,remaining,exit): ");
           customer.customerAction=scan.nextLine();

           switch (customer.customerAction){
               case "buy":
                   machineState.buyState();
                   break;

               case "fill":
                   machineState.fillState();

                   break;
               case "take":

                   System.out.printf("I gave you $%d",machineState.money);
                   machineState.money=0;

                   break;
               case "remaining":
                   machineState.showMachineState();
                   break;

               case "exit":
                   return;
           }
       }





        




    }






}
