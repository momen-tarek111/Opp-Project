package Food_Order;
import java.util.*;
public class Order implements Display {
    ArrayList <Dishes> dish =new ArrayList(5);
    public String address;
    public float deliveryTime;
    public Payment paymentInfo=new Payment();
    public double orderPrice;
    public boolean statuesOfOrder;

    public Order(){}

    public Order(  String address, float deliveryTime, Payment paymentInfo, double orderPrice, boolean statuesOfOrder) {
        this.address = address;
        this.deliveryTime = deliveryTime;
        this.paymentInfo = paymentInfo;
        this.orderPrice = orderPrice;
        this.statuesOfOrder = statuesOfOrder;
    }
    public Order(  String address, float deliveryTime, Payment paymentInfo, double orderPrice, boolean statuesOfOrder,ArrayList<Dishes>dish) {
        this.address = address;
        this.deliveryTime = deliveryTime;
        this.paymentInfo = paymentInfo;
        this.orderPrice = orderPrice;
        this.statuesOfOrder = statuesOfOrder;
        this.dish=dish;
    }


    @Override
    public void displayInfo(){
        System.out.println("\u001B[36mOrder information:\u001B[0m");
        System.out.println(
                "Address delivery : " + this.address + "\nDelivery Time : " + this.deliveryTime);
                       for(Dishes i:dish){
                           System.out.println("\u001B[33mDish name : \u001B[0m"+i.dishName+"\nResturant Name : "+i.resturantName+"\nQuantity : "+i.quantity);
                           System.out.println("----------------------------------------");
                        }

                       System.out.println("\nTotal price : " + this.orderPrice);


        if(this.statuesOfOrder ){
            System.out.println("\u001B[32mPayment Done\u001B[0m");
            System.out.println("\u001B[36mPayment information\u001B[0m ");
            this.paymentInfo.displayInfo();
            System.out.println("                       ~~~~~~~~~~~~~~~~~");

        }
        else {
            System.out.println("\u001B[35mNo payment has been made\u001B[0m");
        }
    }
}