package Food_Order;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Cart implements Display {
    public  static  Main_Flow main;
    private double totalPrice =0;
    Order currentOrder = new Order();

    public Double calcTotalPrice() {
        totalPrice=0;
        for(Dishes i :currentOrder.dish){
            totalPrice+=i.price*i.quantity;
        }
        currentOrder.orderPrice=totalPrice;
        return totalPrice;
    }

    @Override
    public void displayInfo() {
        int counterOfdishesInCurrentOrder=1;
        if (!currentOrder.dish.isEmpty()) {
            for (Dishes i : currentOrder.dish) {
                System.out.print("\u001B[33m"+counterOfdishesInCurrentOrder+"-Dish name\u001B[0m\n");
                i.displayInfo();
                System.out.println("Quantity : " +  i.quantity+"\n\n");
                counterOfdishesInCurrentOrder++;
            }
            System.out.println("\nTotal Price : " + calcTotalPrice()+"\n");
        } else {
            System.out.println("\u001B[35mNo orders exist\u001B[0m");
        }

    }
    public static int optionsOfCart(User user){
        user.carts.displayInfo();
        System.out.println("1-Confirm Pay");
        System.out.println("2-Modify quantity");
        System.out.println("3-Remove dish");
        System.out.println("4-Back to home page");
        int ans= Validations.inputFromStrToInt(4);
        return ans;
    }
    public static void selectedOptionsCart(User user) throws IOException {

        int option;
        String Back;
        do{
            if(user.carts.currentOrder.dish.isEmpty()){
                System.out.println("\u001B[35mNo orders exist\u001B[0m");
                do {
                    System.out.println("If you want to go to home page press h ");
                    Back = Validations.inputString();
                    if (Back.trim().toLowerCase().equals("h")) {
                        main.homePageUser(user);
                    } else
                        System.out.println("\u001B[31mInvalid choice\u001B[0m");
                }while (!Back.trim().toLowerCase().equals("h"));
            }
            option=optionsOfCart(user);

            switch(option){
                case 1:
                    Payment.confirmPayment(user);
                    break;
                case 2:

                    System.out.println("Select number of dish that you want to modify its quantitiy");
                    int newNumOfQuantityDish = Validations.inputFromStrToInt(user.carts.currentOrder.dish.size());
                    System.out.println("Enter the new quantity");

                    int newNumOfQuantity = Validations.inputFromStrToInt(100000);
                    user.carts.currentOrder.dish.get(newNumOfQuantityDish-1).quantity=newNumOfQuantity;
                    break;
                case 3:
                    user.carts.displayInfo();
                    System.out.println("Select number of dish that you want to remove");
                    int newNumOfRemovedDish = Validations.inputFromStrToInt(user.carts.currentOrder.dish.size());
                    user.carts.currentOrder.dish.remove(newNumOfRemovedDish-1);
                    break;
                case  4:
                    main.homePageUser(user);
                    break;
                default :
                    System.out.println("\u001B[31mInvalid Choice\u001B[0m");
            }

        }while(option!=1&&option!=4);
    }
}