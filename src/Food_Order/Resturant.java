package Food_Order;
import java.util.*;
public class Resturant implements Display{
    public String resturantName;
    public String resturantAddress;
    public  String contactInfo;
    public float resturantAvgRate;
    ArrayList <Dishes>items= new ArrayList() ;
    ArrayList<Review> reviews=new ArrayList<>();
    public Resturant(){}

    public Resturant(String resturantName, String resturantAddress, String contactInfo , float resturantAvgRate ) {
        this.resturantName = resturantName;
        this.resturantAddress = resturantAddress;
        this.contactInfo = contactInfo;
        this.resturantAvgRate=resturantAvgRate;

    }
    @Override
    public void displayInfo(){
        System.out.println("\n\t\t\t\t\t\t\t\t\t  Name : " + this.resturantName + "\n\t\t\t\t\t\t\t\t\t  Rate : " + this.resturantAvgRate + "\n\t\t\t\t\t\t\t\t\t  contactInfo : " + this.contactInfo +"\n\n\n \t\t\t\t\t\t\t*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }

}