package Food_Order;
import java.util.*;

public class Dishes implements Display{
    public String resturantName;
    public String dishName;
    public float price;
    public float dishAvgRate;
    public String discribtion;
    public int quantity=1;
    public boolean availability;
    ArrayList<Review>  reviewes=new ArrayList<>();
    public Dishes(){}
    public Dishes(String resturantName,String dishName , float price ,float dishAvgRate, String discribtion, boolean availability){
        this.resturantName=resturantName;
        this.dishName= dishName;
        this.price= price;
        this.dishAvgRate=dishAvgRate;
        this.discribtion=discribtion;
        this.availability=availability;
    }
    public Dishes(String dishName , float price ,float dishAvgRate, String discribtion, boolean availability){
        this.dishName= dishName;
        this.price= price;
        this.dishAvgRate=dishAvgRate;
        this.discribtion=discribtion;
        this.availability=availability;
    }
    @Override
    public void displayInfo(){
        System.out.println("Dish name : "+this.dishName+"\nPrice : " + this.price + "\nDiscribtion: " + this.discribtion+"\nRate : "+ this.dishAvgRate);
        if (this.availability){
            System.out.println("Availabe\u001B[32m :) \u001B[0m ");
        }
        else {
            System.out.println("Not availabe\u001B[31m :( \u001B[0m  ");
        }

    }
    public void displayInfo(String nameDish){
        boolean color=true;
        System.out.print("Dish name : ");
        for (int i=0;i<this.dishName.length();i++){
            for (int j=0;j<nameDish.length();j++){
                if (this.dishName.toLowerCase().charAt(i)==nameDish.toLowerCase().charAt(j)){
                    System.out.print("\u001B[44m"+this.dishName.charAt(i)+"\u001B[0m");
                    color=false;
                    break;
                }
            }
            if (color){
                System.out.print(this.dishName.charAt(i));
            }
            color=true;
        }

        System.out.println("\nPrice : " + this.price + "\nDiscribtion: " + this.discribtion+"\nRate : "+ this.dishAvgRate);
        if (this.availability){
            System.out.println("Availabe\u001B[32m :) \u001B[0m \n\n");
        }
        else {
            System.out.println("Not availabe\u001B[31m :( \u001B[0m \n\n ");
        }

    }


}