package Food_Order;
import java.util.*;
import java.io.*;

public class Payment implements Display{
    public  static  Main_Flow main;
    public String paymentMethod;
    public String transactionID;
    public static int countTransactions = 0;
    public static char [] countTransactionID = {'A','A','A'};


    public Payment(){};
    public Payment( String paymentMethod , String transactionID){
        this.paymentMethod=paymentMethod;
        this.transactionID=transactionID;
    }

    public Payment(String paymentMethod){

        this.paymentMethod = paymentMethod;

        if (countTransactions > 9){
            countTransactions = 0;
            for(int i = 2 ; i >= 0 ; i--){
                if(countTransactionID[i] != 'Z'){
                    countTransactionID[i]+=1;
                    break;
                }
            }
            this.transactionID =(String.valueOf(countTransactionID) + String.valueOf(countTransactions));
        }
        else {
            this.transactionID =(String.valueOf(countTransactionID) + String.valueOf(countTransactions));
            countTransactions++;
        }


    }

    @Override
    public void displayInfo(){

        System.out.println("Payment Method : " + this.paymentMethod
                +"\nTransaction ID : "+this.transactionID+"\n\n");

    }

    public static void  confirmPayment(User user) throws IOException {
        ArrayList<Dishes> confirmedDishes=new ArrayList<>();
        System.out.println("Select payment method");
        System.out.println("1- Credit card ");
        System.out.println("2- Digital wallet ");
        System.out.println("3- GO to home page ");
        String ans = Validations.inputString();
        String address=" ";
        String choiceOfAddress;
        switch (ans.trim()){

            case "1":
                do{
                    System.out.println("1-The delivery address is the same my address\n2-Enter your new delivery address\n3-Go to payment method");
                    choiceOfAddress=Validations.inputString();
                    switch (choiceOfAddress){
                        case "1":
                            address=user.address;
                            break;
                        case "2":
                            System.out.println("Enter your delivery address");
                            address= Validations.inputString();
                            break;
                        case "3":
                            confirmPayment(user);
                            break;
                        default:
                            System.out.println("\u001B[31mInvalid choice\u001B[0m ");

                    }}while (!(choiceOfAddress.trim().equals("1")||choiceOfAddress.trim().equals("2")||choiceOfAddress.trim().equals("3")));
                System.out.println("Enter card number ");
                String numberOfCard = Validations.checkStringIsNumberOnly();
                System.out.println("Enter CVV ");
                String CVV = Validations.checkStringIsNumberOnly();
                System.out.println("Order will be ready in ?(minimum half an hour)");
                float deliveryTime;
                do{
                    String hours=Validations.inputString();
                    deliveryTime =Validations.checkFloatValidation(hours);
                    if(deliveryTime<.5)
                        System.out.println("\u001B[35mMinimum time is half an hour\nTry again\u001B[0m");
                }while(deliveryTime<.5);
                System.out.println("\u001B[32mPayment is done successfully\u001B[0m");
                user.carts.currentOrder.paymentInfo= new Payment("Credit card");
                System.out.println("Transaction ID : " + user.carts.currentOrder.paymentInfo.transactionID);
                for(int i=0;i<user.carts.currentOrder.dish.size();i++){
                    confirmedDishes.add(i,user.carts.currentOrder.dish.get(i));
                }
                user.orders.add( new Order(address,deliveryTime,user.carts.currentOrder.paymentInfo,user.carts.currentOrder.orderPrice,true,confirmedDishes));
                user.carts.currentOrder.dish.clear();
                main.homePageUser(user);
                break;
            case "2" :
                do{
                System.out.println("1-The delivery address is the same my address\n2-Enter your new delivery address");
                choiceOfAddress=Validations.inputString();
                switch (choiceOfAddress){
                    case "1":
                        address=user.address;
                        break;
                    case "2":
                        System.out.println("Enter your delivery address");
                        address= Validations.inputString();
                        break;
                    case "3":
                        confirmPayment(user);
                        break;
                    default:
                        System.out.println("\u001B[31mInvalid choice\u001B[0m ");

                }}while (!(choiceOfAddress.trim().equals("1")||choiceOfAddress.trim().equals("2")||choiceOfAddress.trim().equals("3")));
                System.out.println("Enter phone number ");
                String phoneNumber= Validations.checkStringIsNumberOnly();
                System.out.println("Order will be ready in ?(minimum half an hour)");

                do{
                    String hours=Validations.inputString();
                    deliveryTime =Validations.checkFloatValidation(hours);
                    if(deliveryTime<.5)
                        System.out.println("\u001B[35mMinimum time is half an hour\nTry again\u001B[0m");
                }while(deliveryTime<.5);
                System.out.println("\u001B[32mPayment is done successfully\u001B[0m");
                user.carts.currentOrder.paymentInfo= new Payment("Digital wallet");
                System.out.println("Transaction ID : " + user.carts.currentOrder.paymentInfo.transactionID);
                for(int i=0;i<user.carts.currentOrder.dish.size();i++){
                    confirmedDishes.add(i,user.carts.currentOrder.dish.get(i));
                }
                user.orders.add( new Order(address,deliveryTime,user.carts.currentOrder.paymentInfo,user.carts.currentOrder.orderPrice,true,confirmedDishes));
                user.carts.currentOrder.dish.clear();
                main.homePageUser(user);
                break;
            case "3":
                main.homePageUser(user);
                break;
            default:
                System.out.println("\u001B[31mInvalid choice \u001B[0m\n Try again");
                confirmPayment(user);
        }
    }

}
