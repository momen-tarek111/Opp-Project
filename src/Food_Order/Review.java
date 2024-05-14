package Food_Order;
import java.util.*;
public class Review implements Display{
    public String userName;
    public String comment;
    public float rate;
    public static float totalRate=0;
    public static int countReviewers;
    public Review(String userName , String comment){
        this.userName=userName;
        this.comment=comment;
    }
    public Review(String userName , String comment , float rate){
        this.userName=userName;
        this.comment=comment;
        this.rate=rate;
        totalRate+=rate;
        countReviewers++;
    }
    public Review(String userName , float rate){
        this.userName=userName;
        this.rate=rate;
        totalRate+=rate;
        countReviewers++;
    }
    @Override
    public void displayInfo(){
        System.out.print("User name :");
        System.out.println(this.userName);
        System.out.println("Review : ");
        System.out.println(this.comment);
        System.out.println("~~~~~~~~~~~~~~~~~~~~");

    }
    public static float calcRate(){

        return totalRate/countReviewers;
    }

}