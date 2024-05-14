package Food_Order;
import java.util.*;
public abstract class Person {
    public String  name;
    public String email;
    protected String password;
    protected  String address;


    public Person(){}
   public Person( String name ,String email, String password,String address)
    {
        this.name=name;
        this.email=email;
        this.password=password;
        this.address=address;

    }
    abstract public void displayInfo();
}