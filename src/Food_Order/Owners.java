package Food_Order;
import java.util.*;
public class Owners extends Person{
    private Resturant resturant =new Resturant();
    public Owners(){}


    public Owners(String name ,String email, String password,String address,Resturant resturant)
    {
        super( name ,email,  password, address);
        this.resturant=resturant;
    }
    public Owners(String name ,String email, String password,String address)
    {
        super( name ,email,  password, address);
    }
    public static void addDish(Resturant resturant){
        Scanner input = new Scanner(System.in) ;
        Dishes D = new Dishes();
        System.out.println("Enter name of dish :");
        D.dishName=input.nextLine();
        System.out.println("Enter Discribtion of dish :");
        D.discribtion=input.nextLine();
        do{

            System.out.println("Enter Price of dish :");
            String price=Validations.inputString();
            D.price= Validations.checkFloatValidation(price);
        }while(!Validations.priceValidation( D.price));

        int newAvailability;
        do{
            System.out.println("Enter 1 to available or 0 to not available :");
            String availability=Validations.inputString();
            newAvailability=Validations.checkNumberValidation(availability);

            if(newAvailability==1){
                D.availability=true;
            }
            else if(newAvailability==0) {
                D.availability=false;
            }
            else {
                System.out.println("\u001B[31mInvalid choice\u001B[0m");
            }
        }while(!(newAvailability==1||newAvailability==0));

        resturant.items.add(D);
        System.out.println("\u001B[32mDish is added successfully\u001B[0m");
    }
    public  static void removeDish(int numberOfDish,Resturant resturant){
        resturant.items.remove(numberOfDish-1);
        System.out.println("\u001B[32mRemove successfully\u001B[0m");
    }
    public  static boolean  updateDish(int numberOfDish,Resturant resturant) {
        System.out.println("1-Update name");
        System.out.println("2-Update price");
        System.out.println("3-Update discribtion");
        System.out.println("4-Update availability");
        System.out.println("5-Go to previous page");
        Scanner input = new Scanner(System.in);
        String Option = input.nextLine();
        switch (Option.trim()) {
            case "1":
                System.out.println("Old name is : " + resturant.items.get(numberOfDish - 1).dishName);
                System.out.println("Enter new name ");
                String newName = input.nextLine();
                resturant.items.get(numberOfDish - 1).dishName = newName;
                System.out.println("\u001B[32mName is Updated\u001B[0m");
                break;
            case "2":
                System.out.println("Old price is : " + resturant.items.get(numberOfDish - 1).price);
                float newprice;
                do{

                    System.out.println("Enter new price :");
                    String price=Validations.inputString();
                    newprice= Validations.checkFloatValidation(price);
                }while(!Validations.priceValidation( newprice));
                resturant.items.get(numberOfDish - 1).price=newprice;
                System.out.println("\u001B[32mPrice is Updated\u001B[0m");
                break;
            case "3":
                System.out.println("Old discribtion is : " + resturant.items.get(numberOfDish - 1).discribtion);
                System.out.println("Enter new discribtion ");
                String newDiscribtion = input.nextLine();
                resturant.items.get(numberOfDish - 1).dishName = newDiscribtion;
                System.out.println("\u001B[32mDiscribtion is Updated\u001B[0m");
                break;
            case "4":
                System.out.println("Old availability is : ");
                if (resturant.items.get(numberOfDish - 1).availability) {
                    System.out.println("Available");
                } else {
                    System.out.println("Not available");
                }
                int newAvailability;
                do{
                    System.out.println("Enter 1 to available or 0 to not available :");
                    String availability=Validations.inputString();
                    newAvailability=Validations.checkNumberValidation(availability);

                    if(newAvailability==1){
                        resturant.items.get(numberOfDish - 1).availability = true;
                    }
                    else if(newAvailability==0) {
                        resturant.items.get(numberOfDish - 1).availability = false;
                    }
                    else {
                        System.out.println("\u001B[31mInvalid choice\u001B[0m");
                    }
                }while(!(newAvailability==1||newAvailability==0));


                break;
            case "5":
                return true;
            default:
                System.out.println("\u001B[31mInvalid choice\u001B[0m");
                updateDish(numberOfDish, resturant);
                break;
        }
        String bool;
        do{
            System.out.println("DO you want to  Update any thing else ? (y/n)");
            bool = Validations.inputString();
            if (bool.trim().toLowerCase().equals("y")) {
                return updateDish(numberOfDish, resturant);
            }
            else if(bool.trim().toLowerCase().equals("n")){
                return true;
            }
            else
                System.out.println("\u001B[31mInvalid choice\u001B[0m");


        }while(!(bool.trim().toLowerCase().equals("y")||bool.trim().toLowerCase().equals("n")));
        return false;
    }


    @Override
    public void displayInfo(){

        System.out.println("User Name : " + this.name  +"\nEmail : "+ this.email +
                "\nAddress : " + this.address );

    }

    public Resturant getResturant() {
        return resturant;
    }

    public void setResturant(Resturant resturant) {
        this.resturant = resturant;
    }

}