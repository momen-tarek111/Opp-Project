package Food_Order;
import java.util.*;
import java.text.SimpleDateFormat;

public class Report implements Display{
    public String  reportTitle ;
    public  String adminName;
    public String discription;
    public Date currentDate;
    public Report(String reportTitle , String adminName, String discription,Date currentDate){
        this.reportTitle=reportTitle;
        this.adminName=adminName;
        this.discription=discription;
        this.currentDate=currentDate;


    }
    @Override
    public void displayInfo(){
        System.out.println("Admin name : "+ this.adminName);
        System.out.println("Date : "+ new SimpleDateFormat("MM/dd/yyyy").format(currentDate));
        System.out.println("\u001B[36mReport title\u001B[0m : "+ this.reportTitle);
        System.out.println("Discription : "+ this.discription);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }


}