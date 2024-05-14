package Food_Order;
import java.util.*;
public class User extends Person {

    public static int counter=0;
    public Cart carts =new Cart();
    private final int user_id;
    ArrayList <Order> orders = new ArrayList(5);
    public User (String name ,String email, String password, String address){
        super( name ,email,  password, address );

        counter++;
        user_id=counter;
    }

    @Override
    public void displayInfo(){
        System.out.println("\n\n\u001B[36mUser information:\u001B[0m");
        System.out.println("User id : " + this.user_id +"\nUser Name : " + this.name  +"\nEmail : "+ this.email +
                "\nAddress : " + this.address +"\n\n\n" );
        if (!orders.isEmpty()){
            for(Order i : orders){
                i.displayInfo();
            }
        }
        else{
            System.out.println("\u001B[35mNo Orders Exist\u001B[0m");
        }
    }
    public int getUser_id()
    {
        return user_id;
    }
}