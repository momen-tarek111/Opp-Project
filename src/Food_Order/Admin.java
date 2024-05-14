package Food_Order;
import java.util.*;
public class Admin extends Owners {

    public String report;
    public Admin(){}
    public Admin(String name ,String email, String password,String address)
    {
        super( name ,email,  password, address);

    }

    public static void Add_Resturant(ArrayList<Resturant> resturant,ArrayList<Owners> owners,ArrayList<Admin> admins,ArrayList<User> users){

        Scanner input = new Scanner(System.in) ;
        Resturant R = new Resturant();
        System.out.println("Enter name of resturant :");
        R.resturantName=input.nextLine();
        System.out.println("Enter address of resturant :");
        R.resturantAddress=input.nextLine();
        System.out.println("Enter contactInfo of resturant :");
        R.contactInfo=input.nextLine();
        Owners owner=new Owners();
        boolean accountExist;
        do{
            accountExist=false;
            System.out.println("Enter user name of owner :");
            owner.name=input.nextLine();
            owner.name= Validations.userNameValidation(owner.name);
            System.out.println("Enter password of owner :");
            owner.password=input.nextLine();
            owner.password= Validations.passwordValidation(owner.password);
            System.out.println("Enter email of owner :");
            owner.email=input.nextLine();
            owner.email= Validations.emailValidation(owner.email);
            System.out.println("Enter address of owner :");
            owner.address=input.nextLine();
            for(User i :users){
                if(i.name.equals(owner.name)||i.email.equals(owner.email)){
                    System.out.println("\u001B[35mThis Name or Email is already Exist\nPlease Try Again\u001B[0m");
                    accountExist=true;
                }
            }
            for(Admin i :admins){
                if(i.name.equals(owner.name)||i.email.equals(owner.email)){
                    System.out.println("\u001B[35mThis Name or Email is already Exist\nPlease Try Again\u001B[0m");
                    accountExist=true;
                }
            }
            for(Owners i :owners){
                if(i.name.equals(owner.name)||i.email.equals(owner.email)){
                    System.out.println("\u001B[35mThis Name or Email is already Exist\nPlease Try Again\u001B[0m");
                    accountExist=true;
                }
            }
        }while(accountExist==true);
        resturant.add(R);
        owner.setResturant(R);
        owners.add(owner);
        System.out.println("\u001B[32mResturant is added successfully\u001B[0m");

    }
    public static void Remove_Resturant(int numberOfResturant,ArrayList<Resturant> resturant){
        resturant.remove(numberOfResturant-1);
    }

    public static boolean Update_Resturant(Resturant resturant){
        System.out.println("1-Update name");
        System.out.println("2-Update address");
        System.out.println("3-Update contactInfo");
        System.out.println("4-Go to previous page");
        Scanner input = new Scanner(System.in);
        String Option = input.nextLine();
        switch (Option.trim()) {
            case "1":
                System.out.println("Old name is : " +resturant.resturantName);
                System.out.println("Enter new name ");
                resturant.resturantName =  input.nextLine();
                System.out.println("\u001B[32mName is Updated\u001B[0m");
                break;
            case "2":
                System.out.println("Old address is : " + resturant.resturantAddress);
                System.out.println("Enter new address ");
                resturant.resturantAddress=input.nextLine();
                System.out.println("\u001B[32mAddress is Updated\u001B[0m");
                break;
            case "3":
                System.out.println("Old contactInfo is : " +resturant.contactInfo);
                System.out.println("Enter new contactInfo");
                resturant.contactInfo=input.nextLine();
                System.out.println("\u001B[32mContactInfo is Updated\u001B[0m");
                break;
            case "4":
                return true;
            default:
                System.out.println("\u001B[31mInvalid choice\u001B[0m");
                Update_Resturant(resturant);
                break;
        }
        String bool;
        do{
            System.out.println("DO you want to  Update any thing else ? (y/n)");
            bool = input.nextLine();
            if (bool.trim().toLowerCase().equals("y")) {
                return Update_Resturant(resturant);
            }
            else if (bool.trim().toLowerCase().equals("n")){
                return true;
            }
            else{
                System.out.println("\u001B[31mInvalid choice\u001B[0m");
            }
        }while(!(bool.trim().toLowerCase().equals("y")||bool.trim().toLowerCase().equals("n")));


        return false;
    }

    public void addReport(ArrayList<Report> reports , String adminName){
        Scanner input =new Scanner(System.in);
        System.out.println("Enter title of Report ");
        String title =input.nextLine();
        System.out.println("Enter discription of Report ");
        String discription =input.nextLine();
        reports.add(new Report(title,adminName,discription,new Date()));
        System.out.println("\u001B[32mReport is added successfully\u001B[0m");

    }
    public void displayReport(ArrayList<Report> reports){
        if(reports.isEmpty()){
            System.out.println("\n\u001B[35mNo reports exist\u001B[0m\n");
        }
        else{
            for (Report i: reports) {
                i.displayInfo();
            }
        }

    }
    public void showUsers(ArrayList<User> users){
        if(users.isEmpty()){
            System.out.println("\n\u001B[35mNo users exist\u001B[0m\n");
        }
        else{
            for(User i:users){
                i.displayInfo();
            }
        }
    }
    public void showOrders(ArrayList<User> users){
        boolean existOrders=false;
        for(User i:users){
            for(Order j:i.orders){
                existOrders=true;
                j.displayInfo();
            }
        }
        if(!existOrders){
            System.out.println("\n\u001B[35mNo orders exist\u001B[0m\n");
        }

    }


}