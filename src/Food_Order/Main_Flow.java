package Food_Order;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
public  class Main_Flow {

    Scanner input =new Scanner(System.in);
    ArrayList <Dishes> searchDishes=new ArrayList(5);
    ArrayList <User> users=new ArrayList(5);
    ArrayList <Admin> admins=new ArrayList(5);
    ArrayList <Resturant> resturants=new ArrayList(5);
    ArrayList <Report> reports=new ArrayList(5);
    ArrayList <Owners> owners=new ArrayList(5);
    int indexOfAdmin;
    int an = 0;
    int counterOfSearchedDishes =1;



    public Main_Flow() throws IOException, ParseException {

       readFromFile(resturants,admins,users,reports,owners);
        Cart.main=this;
        Payment.main=this;

        firstPage();

    }
    public void firstPage () throws IOException {
        System.out.println("                                                                      ---------");
        System.out.println("                                                                     |\u001B[3m\u001B[1m\u001B[34m Welcome\u001B[0m |");
        System.out.println("                                                                      ---------");
        System.out.println("1-login");
        System.out.println("2-Sign Up");

        String ans =Validations.inputString();

        if(ans.trim().equals("1")){
            logIn();
        }
        else if(ans.trim().equals("2")){
            signUp();
        }
        else {
            System.out.println("\u001B[31mInvalid Choice\u001B[0m");
            firstPage();
        }

    }

    //----------------------------------------------
    public void logIn() throws IOException {
        System.out.println("Enter Username");
        String userName=Validations.inputString();
        System.out.println("Enter Password");
        String password=Validations.inputString();

        if(checkUser(userName,password)>=0){
            System.out.println("                                                                \u001B[32mLogin Successfully :) \u001B[0m");
            homePageUser(users.get(checkUser(userName,password)));
        }
        else if (checkAdmin(userName,password)>=0){
            System.out.println("                                                                \u001B[32mLogin Successfully :) \u001B[0m");
            homePageAdmin(admins.get(checkAdmin(userName,password)));
        }
        else if(checkOwner(userName,password)>=0){
            System.out.println("                                                                \u001B[32mLogin Successfully :) \u001B[0m");
            homePageOwner(owners.get(checkOwner(userName,password)));
        }
        else {
            String ans;
            System.out.println("\u001B[31mInvalid Account\u001B[0m");
            do{

                System.out.println("1- Try Again \n2- Back First Page");

                ans=Validations.inputString();

                switch (ans.trim()) {
                    case "1":
                        logIn();
                        break;
                    case "2":
                        firstPage();
                        break;
                    default:
                        System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                        break;
                }
            }while(!ans.trim().equals("1")&& ! ans.trim().equals("2"));

        }

    }
    //---------------------------------------------------------------------------
    public  int checkUser(String userName,String Password){
        int indexOfUSer=0;
        for(User i :users){

            if(i.name.equals(userName)&&i.password.equals(Password)){
                return indexOfUSer;
            }
            indexOfUSer++;

        }
        return -1;
    }
    //----------------------------------------------------------------------------------
    public int  checkAdmin(String adminName,String Password){
        indexOfAdmin=0;
        for(Admin i :admins){
            if(i.name.equals(adminName)&&i.password.equals(Password)){
                return indexOfAdmin;
            }
            indexOfAdmin++;
        }
        return -1;
    }
    //---------------------------------------------------------------------
    public int  checkOwner(String ownerName,String Password){
        int indexOfOwner=0;
        for(Owners i :owners){
            if(i.name.equals(ownerName)&&i.password.equals(Password)){
                return indexOfOwner ;
            }
            indexOfOwner++;
        }
        return -1;
    }

    //-----------------------------------------------------------------------
    public void signUp() throws IOException {
        System.out.println("Enter Username");
        String name=input.nextLine();
        name =Validations.userNameValidation(name);
        System.out.println("Enter Email (gmail)");
        String email=Validations.inputString();
        email= Validations.emailValidation(email);
        System.out.println("Enter Password");
        String pass=Validations.inputString();
        pass=Validations.passwordValidation(pass);
        System.out.println("Enter Address");
        String address=Validations.inputString();


        for(User i :users){
            if(i.name.equals(name)||i.email.equals(email)){

                String ans;
                System.out.println("\u001B[35mThis Name or Email is already Exist\nPlease Try Again\u001B[0m");
                do{

                    System.out.println("1- Try Again \n2- Back First Page");

                    ans=Validations.inputString();

                    switch (ans.trim()) {
                        case "1":
                            signUp();
                            break;
                        case "2":
                            firstPage();
                            break;
                        default:
                            System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                            break;
                    }
                }while(!ans.trim().equals("1")&& ! ans.trim().equals("2"));

            }
        }
        for(Admin i :admins){
            if(i.name.equals(name)||i.email.equals(email)){
                String ans;
                System.out.println("\u001B[35mThis Name or Email is already Exist\nPlease Try Again\u001B[0m");
                do{

                    System.out.println("1- Try Again \n2- Back First Page");

                    ans=Validations.inputString();

                    switch (ans.trim()) {
                        case "1":
                            signUp();
                            break;
                        case "2":
                            firstPage();
                            break;
                        default:
                            System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                            break;
                    }
                }while(!ans.trim().equals("1")&& ! ans.trim().equals("2"));
            }
        }
        for(Owners i :owners){
            if(i.name.equals(name)||i.email.equals(email)){
                String ans;
                System.out.println("\u001B[35mThis Name or Email is already Exist\nPlease Try Again\u001B[0m");
                do{

                    System.out.println("1- Try Again \n2- Back First Page");

                    ans=Validations.inputString();

                    switch (ans.trim()) {
                        case "1":
                            signUp();
                            break;
                        case "2":
                            firstPage();
                            break;
                        default:
                            System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                            break;
                    }
                }while(!ans.trim().equals("1")&& ! ans.trim().equals("2"));
            }
        }

        System.out.println("\u001B[32mAccount is Created successfully\u001B[0m");
        users.add(new User(name,email,pass,address));
        firstPage();

    }
    //-------------------------------------------------------------------
    public  void homePageUser(User user) throws IOException {
        System.out.println("                                                                \u001B[32mWelcome "+ user.name +"\u001B[0m");
        int j=1;
        int numberOfResturant;
        for(Resturant i: resturants){
            System.out.println("\u001B[33mResturant "+ j++ +"\u001B[0m");
            i.displayInfo();
        }
        System.out.println("\n \n");
        System.out.println("1-Search by dish");
        System.out.println("2-Select Resturant ");
        System.out.println("3-Review and rate resturant ");
        System.out.println("4-Your Account ");
        System.out.println("5-Display Cart");
        System.out.println("6-Log Out ");
        String ans =Validations.inputString();

        switch(ans.trim()){

            case "1":
                String choice;
                int an=0;
                String nameOfDish;
                do{
                    choice="";
                    System.out.println("Enter the dish name you want to search");
                    nameOfDish=Validations.inputString();


                    searchDish(nameOfDish,user);
                    if(searchDishes.isEmpty()){
                        System.out.println("\u001B[35mNo dish founded by this name\u001B[0m");
                        do{
                            System.out.println("1-Search dish again\n2-Back to home page");
                            choice=Validations.inputString();
                            if(!(choice.trim().equals("1")||choice.trim().equals("2")))
                                System.out.println("Invalid choice");
                        }while(!(choice.trim().equals("1")||choice.trim().equals("2")));
                    }
                    if(choice.equals("2"))
                        homePageUser(user);
                }while(choice.trim().equals("1"));

                do {
                    String ch;
                    do{
                        System.out.println("1-Select searched dishes\n2-Back to home page");
                        ch=Validations.inputString();
                        switch(ch.trim()){
                            case "1":
                                searchDish(nameOfDish,user);
                                an=selectDish(user);
                                break;
                            case "2":
                                homePageUser(user);
                                break;
                            default:
                                System.out.println("\u001B[31mInvalid choice\u001B[0m");
                        }
                    }while(!(ch.equals("1")||ch.equals("2")));
                    if (an == 1) {

                        homePageUser(user);
                        searchDishes.clear();
                    } else if (an == 2) {

                        searchDishes.clear();
                        Cart.selectedOptionsCart(user);
                    }
                }while (an!=1&&an!=2);
                break;
            case "2" :
                an=0;
                do{

                    for(Resturant i: resturants){
                        System.out.println("\u001B[33mResturant "+ (resturants.indexOf(i)+1)+"\u001B[0m");
                        i.displayInfo();
                    }
                    do{
                        System.out.println("1-Select resturant\n2-Back to home page");
                        choice=Validations.inputString();

                        if(!(choice.trim().equals("1")||choice.trim().equals("2")))
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");
                    }while(!(choice.equals("1")||choice.equals("2")));
                    switch(choice.trim()){
                        case "1" :
                            for(Resturant i: resturants){
                                System.out.println("\u001B[33mResturant "+ (resturants.indexOf(i)+1)+"\u001B[0m");
                                i.displayInfo();
                            }
                            System.out.println("Select number of resturant");
                            numberOfResturant = Validations.inputFromStrToInt(resturants.size());
                            an=selectDish(numberOfResturant,user);

                            if(an==3){
                                Cart.selectedOptionsCart(user);
                            }
                        case "2":
                            homePageUser(user);
                            break;
                    }
                }while(an==2);
                break;
            case "3" :
                String answer;


                for (Resturant i : resturants) {
                    System.out.println("\u001B[33mResturant " + (resturants.indexOf(i) + 1)+"\u001B[0m");
                    i.displayInfo();
                }
                System.out.println("Select Number Of Resturant");

                numberOfResturant = Validations.inputFromStrToInt(resturants.size());
                do {
                    System.out.println("1-Add review by comment \n 2-Add rate by number 1 to 5 \n 3-If you want add both \n 4-Back to home  ");
                    answer = Validations.inputString();
                    switch (answer.trim()) {

                        case "1":
                            System.out.println("Write your comment ");
                            String comment = Validations.inputString();
                            resturants.get(numberOfResturant - 1).reviews.add(new Review(user.name, comment));
                            System.out.println("\u001B[32mDone\u001B[0m");
                            homePageUser(user);
                            break;
                        case "2":

                            float  rate;
                            String ra;
                            do{
                                System.out.println("Write your rate 1 to 5");
                                ra = Validations.inputString();
                                rate =Validations.checkFloatValidation(ra);
                                if(rate<=0||rate>5)
                                    System.out.println("\u001B[31mInvalid rate\u001B[0m");
                            }while(rate<=0||rate>5);
                            resturants.get(numberOfResturant - 1).reviews.add(new Review(user.name, rate));
                            resturants.get(numberOfResturant-1).resturantAvgRate=Review.calcRate();
                            System.out.println("\u001B[32mDone\u001B[0m");
                            homePageUser(user);
                            break;
                        case "3":
                            System.out.println("Write your comment ");
                            comment = Validations.inputString();

                            do{
                                System.out.println("Write your rate 1 to 5");
                                ra = Validations.inputString();
                                rate =Validations.checkFloatValidation(ra);
                                if(rate<=0||rate>5)
                                    System.out.println("\u001B[31mInvalid rate\u001B[0m");
                            }while(rate<=0||rate>5);
                            resturants.get(numberOfResturant - 1).reviews.add(new Review(user.name, comment, rate));
                            resturants.get(numberOfResturant-1).resturantAvgRate=Review.calcRate();
                            System.out.println("\u001B[32mDone\u001B[0m");
                            homePageUser(user);
                            break;
                        case "4":
                            homePageUser(user);
                            break;
                        default:
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");
                    }
                }while (!(answer.equals("1")||answer.equals("2")||answer.equals("3")||answer.equals("4")));
                break;
            case "4":
                user.displayInfo();
                String backTOHome;
                do{

                    System.out.println("If you want to go to home page press h ");
                    backTOHome=Validations.inputString();
                    if (backTOHome.trim().toLowerCase().equals("h")) {
                        homePageUser(user);
                    }
                    else
                        System.out.println("\u001B[31mInvalid choice\u001B[0m");
                }while(!(backTOHome.trim().equals("h")||backTOHome.trim().equals("H")));
                break;
            case "5":
                Cart.selectedOptionsCart(user);
                break;
            case "6":
                String x;
                do {
                    System.out.println("1-Log out \n2-Close program\n3-Back to home page");
                    x = Validations.inputString();
                }while (!(x.trim().equals("1")||x.trim().equals("2")||x.trim().equals("3")));
                switch (x){
                    case "1" :
                        firstPage();
                        break;
                    case "2" :
                        exitProgram();
                        break;
                    case "3":
                        homePageUser(user);
                        break;
                    default:
                        System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                        break;
                }
                break;
            default:
                System.out.println("\u001B[31mInvalid choice\u001B[0m \nTry again");
                homePageUser(user);
                break;

        }
    }
    //-------------------------------------------------
    public void homePageOwner(Owners owner) throws IOException {
        System.out.println("                                                                \u001B[32mWelcome "+owner.name+"\u001B[0m");
        System.out.println("Your resturant name : "+owner.getResturant().resturantName);
        for(Dishes i:owner.getResturant().items){
            System.out.println("\n\u001B[33mDish "+(owner.getResturant().items.indexOf(i)+1)+"\u001B[0m");
            i.displayInfo();
        }
        System.out.println("1-Add dish");
        System.out.println("2-Delete dish");
        System.out.println("3-Modify dish");
        System.out.println("4-Your account");
        System.out.println("5-Log out");
        String ans=input.next();
        int newAns = Integer.parseInt(ans.trim());
        switch(newAns){
            case 1:
                int numberDish;
                String c;
                do{
                    System.out.println("1-Are you sure to add new dish\n2-To go back to previous page");
                    c =Validations.inputString();
                    switch(c.trim()){
                        case "1":
                            Owners.addDish(owner.getResturant());
                            homePageOwner(owner);
                            break;
                        case "2":
                            homePageOwner(owner);
                            break;
                        default :
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");


                    }}while(!(c.equals("1")||c.equals("2")));
                break;
            case 2:
                do{

                    System.out.println("1-Sure to remove dish   \n2-To go back to previous page ");
                    c =Validations.inputString();
                    switch(c.trim()){
                        case"1":
                            for(Dishes i:owner.getResturant().items){
                                System.out.println("\n\u001B[33mDish "+(owner.getResturant().items.indexOf(i)+1)+"\u001B[0m");
                                i.displayInfo();
                            }
                            System.out.println("Select number of dish");
                            numberDish= Validations.inputFromStrToInt(owner.getResturant().items.size());
                            Owners.removeDish(numberDish,owner.getResturant());

                            homePageOwner(owner);
                            break;
                        case "2":
                            homePageOwner(owner);
                            break;
                        default :
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");

                    }
                }while(!(c.equals("1")||c.equals("2")));



                break;

            case 3:
                do{
                    System.out.println("1-To select dish  \n2-To go back to previous page ");
                    c =Validations.inputString();
                    switch(c.trim()){
                        case "1":
                            for(Dishes i:owner.getResturant().items){
                                System.out.println("\n\u001B[33mDish "+(owner.getResturant().items.indexOf(i)+1)+"\u001B[0m");
                                i.displayInfo();
                            }
                            System.out.println("Select number of dish");
                            numberDish= Validations.inputFromStrToInt(owner.getResturant().items.size());
                            if( Owners.updateDish(numberDish, owner.getResturant())){
                                homePageOwner(owner);
                            }
                            break;
                        case "2":
                            homePageOwner(owner);
                            break;
                        default:
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");

                            break;
                    }
                }while(!(c.equals("1")||c.equals("2")));
                break;
            case 4:
                owner.displayInfo();
                do{

                    System.out.println("If you want to go to home page press h ");
                    c=Validations.inputString();
                    if (c.trim().toLowerCase().equals("h")) {
                        homePageOwner(owner);
                    }
                    else
                        System.out.println("\u001B[31mInvalid choice\u001B[0m");
                }while(!(c.trim().equals("h")||c.trim().equals("H")));
                break;
            case 5:
                String x;
                do {
                    System.out.println("1-Log out \n2-Close program\n3-Back to home page ");
                    x = Validations.inputString();
                }while (!(x.trim().equals("1")||x.trim().equals("2")||x.trim().equals("3")));
                switch (x){
                    case "1" :
                        firstPage();
                        break;
                    case "2" :
                        exitProgram();break;
                    case "3" :
                        homePageOwner(owner);
                        break;
                    default:
                        System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                        break;
                }
                break;
            default:
                System.out.println("\u001B[31mInvalid choice\u001B[0m try again");
                homePageOwner(owner);
                break;

        }
    }
    //----------------------------------------------
    public void homePageAdmin(Admin admin) throws IOException {
        System.out.println("                                                                \u001B[32mWelcome "+admin.name+"\u001B[0m");
        int j=1;
        int numberOfResturant=0;
        for(Resturant i: resturants){
            System.out.println("\u001B[33mResturant "+ j++ +"\u001B[0m");
            i.displayInfo();
        }
        j=1;
        System.out.println("\n \n");
        System.out.println("1-Select resturant to show its dishes  ");
        System.out.println("2-Add resturant ");
        System.out.println("3-Remove resturant");
        System.out.println("4-Modify resturant");
        System.out.println("5-Add report");
        System.out.println("6-Show reports");
        System.out.println("7-Show users");
        System.out.println("8-Show orders");
        System.out.println("9-Your Account");
        System.out.println("10-Log out");
        String ans =Validations.inputString();
        switch(ans.trim()){
            case "1" :
                String c;
                for(Resturant i: resturants){
                    System.out.println("\u001B[33mResturant "+ j++ +"\u001B[0m");
                    i.displayInfo();
                }
                System.out.println("Select Number Of Resturant");
                numberOfResturant= Validations.inputFromStrToInt(resturants.size());

                displayDishes(numberOfResturant);
                break;
            case "2":
                do{
                    System.out.println("1-Are you sure to add new resturent\n2-To go back to previous page");
                    c =Validations.inputString();
                    switch(c.trim()){
                        case "1":
                            Admin.Add_Resturant(resturants,owners,admins,users);
                            homePageAdmin(admin);
                            break;
                        case "2":
                            homePageAdmin(admin);
                            break;
                        default :
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");


                    }}while(!(c.equals("1")||c.equals("2")));


                break;
            case "3":

                do{

                    System.out.println("1-To select resturant  \n2-To go back to previous page ");
                    c =Validations.inputString();
                    switch(c.trim()){
                        case"1":
                            for(Resturant i: resturants){
                                System.out.println("Resturant "+ j++ );
                                i.displayInfo();
                            }
                            System.out.println("Select number of resturant");
                            numberOfResturant= Validations.inputFromStrToInt(resturants.size());
                            Admin.Remove_Resturant(numberOfResturant,resturants);
                            System.out.println("\u001B[32mRemove successfully\u001B[0m");
                            homePageAdmin(admin);
                            break;
                        case "2":
                            homePageAdmin(admin);
                            break;
                        default :
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");

                    }
                }while(!(c.equals("1")||c.equals("2")));



                break;
            case "4":
                do{
                    System.out.println("1-To select resturant  \n2-To go back to previous page ");
                    c =Validations.inputString();
                    switch(c.trim()){
                        case "1":
                            for(Resturant i: resturants){
                                System.out.println("\u001B[33mResturant "+ j++ +"\u001B[0m");
                                i.displayInfo();
                            }
                            System.out.println("Select number of resturant");
                            numberOfResturant= Validations.inputFromStrToInt(resturants.size());
                            if (Admin.Update_Resturant(resturants.get(numberOfResturant-1))){
                                homePageAdmin(admin);
                            }
                            break;
                        case "2":
                            homePageAdmin(admin);
                            break;
                        default:
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");

                            break;
                    }
                }while(!(c.equals("1")||c.equals("2")));

                break;
            case "5":
                do{
                    System.out.println("1-Sure to add new report\n2-To go back to previous page");
                    c =Validations.inputString();
                    switch(c.trim()){
                        case "1":
                            admin.addReport(reports, admin.name);
                            homePageAdmin(admin);
                        case "2":
                            homePageAdmin(admin);
                        default :
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");


                    }}while(!(c.equals("1")||c.equals("2")));




                break;
            case "6":
                admin.displayReport(reports);
                do{


                    System.out.println("If you want to go to home page press h ");
                    c=Validations.inputString();
                    if (c.trim().equals("h")||c.trim().equals("H")) {
                        homePageAdmin(admin);
                    }
                    else
                        System.out.println("\u001B[31mInvalid choice\u001B[0m");
                }while(!(c.trim().equals("h")||c.trim().equals("H")));


                break;
            case "7":
                admin.showUsers(users);
                do{

                    System.out.println("If you want to go to home page press h ");
                    c=Validations.inputString();
                    if (c.trim().equals("h")||c.trim().equals("H")) {
                        homePageAdmin(admin);
                    }
                    else
                        System.out.println("\u001B[31mInvalid choice\u001B[0m");
                }while(!(c.trim().equals("h")||c.trim().equals("H")));

                break;
            case "8":
                admin.showOrders(users);
                do{

                    System.out.println("If you want to go to home page press h ");
                    c=Validations.inputString();
                    if (c.trim().equals("h")||c.trim().equals("H")) {
                        homePageAdmin(admin);
                    }
                    else
                        System.out.println("\u001B[31mInvalid choice\u001B[0m");
                }while(!(c.trim().equals("h")||c.trim().equals("H")));
                break;
            case "9":
                admin.displayInfo();
                do{

                    System.out.println("If you want to go to home page press h ");
                    c=Validations.inputString();
                    if (c.trim().equals("h")||c.trim().equals("H")) {
                        homePageAdmin(admin);
                    }
                    else
                        System.out.println("\u001B[31mInvalid choice\u001B[0m");
                }while(!(c.trim().equals("h")||c.trim().equals("H")));
                break;
            case "10":
                String x;
                do {
                    System.out.println("1-logout \n2-close program\n3-Back to home page");
                    x = Validations.inputString();
                }while (!(x.trim().equals("1")||x.trim().equals("2")||x.trim().equals("3")));
                switch (x){
                    case "1" :
                        firstPage();
                        break;
                    case "2" :
                        exitProgram();
                        break;
                    case "3":
                        homePageAdmin(admin);
                        break;
                    default:
                        System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                        break;
                }
                break;
            default:
                System.out.println("\u001B[31mInvalid choice\u001B[0m");
                homePageAdmin(admin);
                break;
        }
    }

    public void displayDishes(int numberOfResturant) throws IOException {
        Owners owner = new Admin();
        for(Dishes i:resturants.get(numberOfResturant-1).items){
            System.out.println("\n\u001B[33mDish "+ (resturants.get(numberOfResturant-1).items.indexOf(i)+1)+"\u001B[0m");
            i.displayInfo();
        }
        System.out.println("1-Add dish");
        System.out.println("2-Remove dish");
        System.out.println("3-Modify dish");
        System.out.println("4-Go to previous page");
        String numOfDish=Validations.inputString();
        switch (numOfDish.trim()){
            case "1" :
                String c;
                do{
                    System.out.println("1-Sure to add new dish\n2-To go back to previous page");
                    c =Validations.inputString();
                    switch(c.trim()){
                        case "1":
                            owner.addDish(resturants.get(numberOfResturant-1));
                            displayDishes(numberOfResturant);
                            break;
                        case "2":
                            displayDishes(numberOfResturant);
                            break;
                        default :
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");


                    }}while(!(c.equals("1")||c.equals("2")));



                break;
            case "2" :
                do{
                    System.out.println("1-Sure to remove dish  \n2-To go back to previous page ");
                    c = Validations.inputString();
                    switch(c.trim()){
                        case "1":
                            for(Dishes i:resturants.get(numberOfResturant-1).items){
                                System.out.println("\n\u001B[33mDish "+ (resturants.get(numberOfResturant-1).items.indexOf(i)+1)+"\u001B[0m");
                                i.displayInfo();
                            }
                            System.out.println("Select number of dish that you want to remove");
                            int numberOfDish= Validations.inputFromStrToInt(resturants.get(numberOfResturant-1).items.size());
                            owner.removeDish(numberOfDish,resturants.get(numberOfResturant-1));
                            displayDishes(numberOfResturant);
                        case "2":
                            displayDishes(numberOfResturant);
                        default :
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");

                    }
                }while(!(c.equals("1")||c.equals("2")));
                break;
            case "3" :

                do{
                    System.out.println("1-Sure to update dish  \n2-To go back to previous page ");
                    c=Validations.inputString();
                    switch(c.trim()){
                        case "1":
                            for(Dishes i:resturants.get(numberOfResturant-1).items){
                                System.out.println("\n\u001B[33mDish "+ (resturants.get(numberOfResturant-1).items.indexOf(i)+1)+"\u001B[0m");
                                i.displayInfo();
                            }
                            System.out.println("Select number of dish that you want to update");
                            int numberOfDish=Validations.inputFromStrToInt(resturants.get(numberOfResturant-1).items.size());
                            if(owner.updateDish(numberOfDish,resturants.get(numberOfResturant-1))){
                                displayDishes( numberOfResturant);
                            }
                        case "2":
                            displayDishes(numberOfResturant);
                        default:
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");
                    }
                }while(!(c.equals("1")||c.equals("2")));
                break;
            case "4" :
                homePageAdmin(admins.get(indexOfAdmin));
                break;
            default:
                System.out.println("\u001B[31mInvalid Choice\u001B[0m");
                displayDishes(numberOfResturant);
        }
    }
    //----------------------------------------------------
    public void displayUserDish (int numberOfResturant) {
        for(Dishes i:resturants.get( numberOfResturant-1).items){
            System.out.println("\u001B[33mDish " +(resturants.get( numberOfResturant-1).items.indexOf(i)+1)+"\u001B[0m" );
            i.displayInfo();
        }
    }
    //---------------------------------------------------------------

    //----------------------------------------------------------------
    public void searchDish(String nameDish,User user){
        counterOfSearchedDishes=1;
        for (Resturant i:resturants) {
            for (Dishes j: i.items) {
                if (j.dishName.toLowerCase().contains(nameDish.toLowerCase()) ) {
                    searchDishes.add(j);
                    System.out.println("\u001B[33m"+counterOfSearchedDishes+"-Resturant name is "+ i.resturantName+"\u001B[0m");
                    j.displayInfo(nameDish);
                    counterOfSearchedDishes++;
                }
            }
        }


    }
    //------------------------------------------------------------
    public int selectDish(int numberOfResturant,User user) throws IOException {

        System.out.println("1-show reviews this resturant \n2-select dish \n3-back to home page");
        String chioce=Validations.inputString();

        switch (chioce.trim()){
            case "1" :
                String backToPreviousChoice;
                if(resturants.get(numberOfResturant-1).reviews.isEmpty())
                    System.out.println("\n\u001B[35mNo reviews exist\u001B[0m");
                for (Review review:resturants.get(numberOfResturant-1).reviews){
                    review.displayInfo();
                }
                do{
                    System.out.println("If you want to back to previous page press b");
                    backToPreviousChoice=Validations.inputString();
                    if(!backToPreviousChoice.toLowerCase().trim().equals("b")){
                        System.out.println("\u001B[31mInvalid choice\u001B[0m");
                    }
                }while(!backToPreviousChoice.toLowerCase().trim().equals("b"));
                selectDish(numberOfResturant,user);
                break;
            case "2":
                String choose;
                do {
                    String MyChoice;
                    do{
                        displayUserDish(numberOfResturant);
                        System.out.println("1-Choose a dish \n2-back to previous page");
                        MyChoice = Validations.inputString();
                        if(MyChoice.trim().equals("2")){
                            selectDish(numberOfResturant,user);
                        }
                        if(!(MyChoice.trim().equals("1")||MyChoice.trim().equals("2")))
                            System.out.println("\u001B[31mInvalid choice\u001B[0m");
                    }while(!(MyChoice.trim().equals("1")));

                    System.out.println("Select number of dish");
                    int numberOfDish= Validations.inputFromStrToInt(resturants.get(numberOfResturant-1).items.size());

                    do {

                        do{
                            System.out.println("1-Add to cart \n2-Add review and rate \n3-Show review \n4-Back to previous page");
                            choose = Validations.inputString();
                            if(!(choose.trim().equals("1")||choose.trim().equals("2")||choose.trim().equals("3")||choose.trim().equals("4"))){
                                System.out.println("\u001B[31mInvalid choice\u001B[0m");
                            }
                        }while(!(choose.trim().equals("1")||choose.trim().equals("2")||choose.trim().equals("3")||choose.trim().equals("4")));

                        switch (choose.trim()) {
                            case "1":
                                if(!resturants.get(numberOfResturant-1).items.get(numberOfDish-1).availability){
                                    System.out.println("\u001B[35mThis dish not available now\u001B[0m");
                                    choose=" "; //return to start of (do while )
                                    break;
                                }

                                boolean foundDish = false;
                                for (int i = 0; i < user.carts.currentOrder.dish.size(); i++) {
                                    if (user.carts.currentOrder.dish.get(i).dishName.equals(resturants.get(numberOfResturant - 1).items.get(numberOfDish - 1).dishName)) {
                                        foundDish = true;
                                        user.carts.currentOrder.dish.get(i).quantity++;
                                        break;
                                    }
                                }
                                if (foundDish == false) {
                                    user.carts.currentOrder.dish.add(resturants.get(numberOfResturant - 1).items.get(numberOfDish - 1));

                                }
                                System.out.println("1-Select another dish \n2-Back to Menu of Resturnts \n3-Go to cart");

                                an = Validations.inputFromStrToInt(3);
                                break;
                            case "2":
                                String numberOfChoice;
                                do {
                                    System.out.println("1-Add review by comment \n2-Add rate by number 1 to 5 \n3-If you want add both \n4-Back to previous page");
                                    numberOfChoice = Validations.inputString();
                                    switch (numberOfChoice.trim()) {
                                        case "1":
                                            System.out.println("Write your comment ");
                                            String comment = Validations.inputString();
                                            resturants.get(numberOfResturant - 1).items.get(numberOfDish - 1).reviewes.add(new Review(user.name, comment));
                                            System.out.println("\u001B[32mDone\u001B[0m");
                                            selectDish(numberOfResturant, user);
                                            break;
                                        case "2":
                                            float rate = 0;
                                            do {
                                                System.out.println("Write your rate 1 to 5");
                                                String ra = Validations.inputString();

                                                rate = Validations.checkFloatValidation(ra);
                                                if (rate <= 0 || rate > 5)
                                                    System.out.println("\u001B[31mInvalid rate\u001B[0m");
                                            } while (rate <= 0 || rate > 5);
                                            resturants.get(numberOfResturant - 1).items.get(numberOfDish - 1).reviewes.add(new Review(user.name, rate));
                                            resturants.get(numberOfResturant - 1).items.get(numberOfDish - 1).dishAvgRate = Review.calcRate();
                                            System.out.println("\u001B[32mDone\u001B[0m");
                                            selectDish(numberOfResturant, user);
                                            break;
                                        case "3":
                                            System.out.println("Write your comment ");
                                            comment = Validations.inputString();

                                            do {
                                                System.out.println("Write your rate 1 to 5");
                                                String ra = Validations.inputString();
                                                rate = Validations.checkFloatValidation(ra);
                                                if (rate <= 0 || rate > 5)
                                                    System.out.println("\u001B[31mInvalid rate\u001B[0m");
                                            } while (rate <= 0 || rate > 5);
                                            resturants.get(numberOfResturant - 1).items.get(numberOfDish - 1).reviewes.add(new Review(user.name, comment, rate));
                                            resturants.get(numberOfResturant - 1).items.get(numberOfDish - 1).dishAvgRate = Review.calcRate();
                                            System.out.println("\u001B[32mDone\u001B[0m");
                                            selectDish(numberOfResturant, user);
                                            break;
                                        case "4":
                                            choose = " ";
                                            break;
                                        default:
                                            System.out.println("\u001B[31mInvalid choice\u001B[0m try again");
                                    }
                                } while (!(numberOfChoice.trim().equals("1") || numberOfChoice.trim().equals("2") || numberOfChoice.trim().equals("3") || numberOfChoice.trim().equals("4")));

                                break;

                            case "3":
                                if(resturants.get(numberOfResturant-1).items.get(numberOfDish-1).reviewes.isEmpty()){
                                    System.out.println("\n\u001B[35mNo reviewes exist\u001B[0m\n");
                                }
                                for (Review review :resturants.get(numberOfResturant-1).items.get(numberOfDish-1).reviewes) {
                                    review.displayInfo();
                                }
                                do {
                                    System.out.println("1-Go to previous page \n2-Go to home page");
                                    numberOfChoice= Validations.inputString();
                                    if (numberOfChoice.trim().equals("1")){
                                        choose=" ";
                                    }
                                    else if(numberOfChoice.trim().equals("2")){
                                        homePageUser(user);
                                    }
                                    else{
                                        System.out.println("\u001B[31mInvalid choice\u001B[0m");
                                    }}while (!(numberOfChoice.trim().equals("1")||numberOfChoice.trim().equals("2")));
                                break;
                            case "4":
                                an=1;
                                break;
                            default:
                                System.out.println("\u001B[31mInvalid choice\u001B[0m");
                                break;

                        }

                    }while (!(choose.equals("1")||choose.equals("2")||choose.equals("3")||choose.equals("4")));

                }while(an==1);
                return an;
            case "3":
                homePageUser(user);
                break;
            default:
                System.out.println("\u001B[31mInvalid choice \u001B[0m");
                selectDish( numberOfResturant, user);
        }
        return an;
    }

    //-------------------------------------------------------------
    public int selectDish(User user){
        boolean foundDish=false;
        int numberOfResturant=0;
        System.out.println("Select number of dish that you want to add to cart ");
        int numOfDish= Validations.inputFromStrToInt(searchDishes.size());

        exit:for (Resturant i:resturants) {
            for (Dishes j: i.items) {
                if(j.dishName.equals(searchDishes.get(numOfDish-1).dishName)){
                    numberOfResturant=resturants.indexOf(i);
                    numOfDish=i.items.indexOf(j);
                    break exit;
                }
            }
        }
        if(!resturants.get(numberOfResturant).items.get(numOfDish).availability){
            System.out.println("\u001B[35mThis dish not available now\u001B[0m");

            return 3;
        }
        for(int i=0;i< user.carts.currentOrder.dish.size();i++){
            if(user.carts.currentOrder.dish.get(i).dishName.equals(resturants.get(numberOfResturant).items.get(numOfDish).dishName))
            {
                foundDish=true;
                user.carts.currentOrder.dish.get(i).quantity++;
                break;
            }
        }
        if(foundDish==false){
            user.carts.currentOrder.dish.add(resturants.get(numberOfResturant).items.get(numOfDish));

        }
        System.out.println("1-home page  \n2-Go to cart");

        int an= Validations.inputFromStrToInt(2);
        return an;
    }
    //------------------------------------------------------------
    public static void readFromFile(ArrayList<Resturant> resturants, ArrayList<Admin> admins, ArrayList<User> users, ArrayList<Report> reports, ArrayList<Owners> owners) throws
            IOException, ParseException {
        BufferedReader readerResturants = new BufferedReader(new FileReader("resturants.txt"));
        BufferedReader readerAdmins = new BufferedReader(new FileReader("admins.txt"));
        BufferedReader readerUsers = new BufferedReader(new FileReader("users.txt"));
        BufferedReader readerReports = new BufferedReader(new FileReader("reports.txt"));
        BufferedReader readerOwners = new BufferedReader(new FileReader("owners.txt"));
        BufferedReader readerOrders = new BufferedReader(new FileReader("orders.txt"));
        BufferedReader readereviewDishes = new BufferedReader(new FileReader("reviewsDishes.txt"));
        BufferedReader readereviewRes = new BufferedReader(new FileReader("reviewsRes.txt"));
        BufferedReader readerTID = new BufferedReader(new FileReader("transactionID.txt"));
        String line;
        int resindex = -1;
        int userindex = -1;
        char[] partsOfTID = new char[4];
        int TID;
//-------------------------------------------------------------------------------------------------------------------
        while ((line = readerTID.readLine()) != null) {
            partsOfTID[0] = line.charAt(0);
            partsOfTID[1] = line.charAt(1);
            partsOfTID[2] = line.charAt(2);
            TID = Character.getNumericValue(line.charAt(3)); // Convert char to int
            Payment.countTransactionID[0] = partsOfTID[0];
            Payment.countTransactionID[1] = partsOfTID[1];
            Payment.countTransactionID[2] = partsOfTID[2];
            Payment.countTransactions = TID;
        }
//-------------------------------------------------------------------------------------------------------------------
        while ((line = readerResturants.readLine()) != null) {
            String[] parts = line.split("~:~");
            int dishindex = 0;
            int i = 4;
            if (parts.length >= 4) {
                String resturantName = parts[0];
                float resrate = Float.parseFloat(parts[1]);
                String resturantAddress = parts[2];
                String contactInfo = parts[3];
                Resturant resturant = new Resturant(resturantName, resturantAddress, contactInfo, resrate);
                resturants.add(resturant);
                resindex++;
                while (i < parts.length) {
                    String resname = parts[i];
                    i++;
                    String dishname = parts[i];
                    i++;
                    float dishprice = Float.parseFloat(parts[i]);
                    i++;
                    float dishAvgRate = Float.parseFloat(parts[i]);
                    i++;
                    String discribtion = parts[i];
                    i++;
                    boolean availability = Boolean.parseBoolean(parts[i]);
                    i++;
                    resturants.get(resindex).items.add(dishindex, new Dishes(resname, dishname, dishprice, dishAvgRate, discribtion, availability));
                    dishindex++;
                }
            }
        }
 //-------------------------------------------------------------------------------------------------------------------


        while ((line = readerAdmins.readLine()) != null) {
            String[] parts = line.split("~:~");

            if (parts.length >= 4) {
                String name = parts[0];
                String email = parts[1];
                String password = parts[2];
                String address = parts[3];
                Admin admin = new Admin(name, email, password, address);
                admins.add(admin);
            }
        }

//-------------------------------------------------------------------------------------------------------------------

        while ((line = readerUsers.readLine()) != null) {
            String[] parts = line.split("~:~");

            int dishindex = 0;
            int i = 4;
            if (parts.length >= 4) {
                String name = parts[0];
                String email = parts[1];
                String password = parts[2];
                String address = parts[3];
                User user = new User(name, email, password, address);
                users.add(user);
                userindex++;
                while (i + 1 < parts.length) {
                    String dishname = parts[i];
                    i++;
                    float dishprice = Float.parseFloat(parts[i]);
                    i++;
                    String discribtion = parts[i];
                    i++;
                    float dishAvgRate = Float.parseFloat(parts[i]);
                    i++;
                    boolean availability = Boolean.parseBoolean(parts[i]);
                    i++;
                    users.get(userindex).carts.currentOrder.dish.add(dishindex, new Dishes(dishname, dishprice, dishAvgRate, discribtion, availability));
                    dishindex++;
                }
            }

        }

//----------------------------------------------------------------------------------------------------------------------


        while ((line = readerOrders.readLine()) != null) {
            int i = 1;
            String[] parts = line.split("~:~");
            int id = Integer.parseInt(parts[0]);
            for (User user : users) {
                if (id == user.getUser_id()) {
                    if (parts.length >= 7) {
                        while (i  < parts.length) {
                            String address = parts[i];
                            i++;
                            float deliveryTime = Float.parseFloat(parts[i]);
                            i++;
                            String paymentMethod = parts[i];
                            i++;
                            String transactionID = parts[i];
                            i++;
                            double orderPrice = Double.parseDouble(parts[i]);
                            i++;
                            boolean statuesOfOrder = Boolean.parseBoolean(parts[i]);
                            i++;
                            Payment pay = new Payment(paymentMethod, transactionID);
                            Order order = new Order(address, deliveryTime, pay, orderPrice, statuesOfOrder);
                            while (i + 1 < parts.length) {
                                String resname=parts[i];
                                i++;
                                String dishname = parts[i];
                                i++;
                                for(Resturant res :resturants){
                                    for(Dishes dish:res.items){
                                        if((dish.resturantName.equals(resname))&&(dish.dishName.equals(dishname))){
                                            order.dish.add(dish);
                                            break;
                                        }
                                    }
                                }
                                if (i < parts.length && parts[i].equals("&&")) {
                                    i++;
                                    break;
                                }

                            }
                            user.orders.add(order);

                        }
                    }
                }
            }
        }
//---------------------------------------------------------------------------------------------------------------------

        while ((line = readerReports.readLine()) != null) {
            String[] parts = line.split("~:~");

            if (parts.length >= 4) {
                String reportTitle = parts[0];
                String adminName = parts[1];
                String discription = parts[2];
                String date=parts[3];
                DateFormat currentDate=new SimpleDateFormat("MM/dd/yyyy");
                Report report = new Report(reportTitle, adminName, discription,currentDate.parse(date));
                reports.add(report);
            }
        }
//-------------------------------------------------------------------------------------------------------------------


        while ((line = readerOwners.readLine()) != null) {
            String[] parts = line.split("~:~");
            if (parts.length >= 5) {
                String name = parts[0];
                String email = parts[1];
                String password = parts[2];
                String address = parts[3];
                String resturantName = parts[4];
                for(Resturant res :resturants){
                    if(res.resturantName.equals(resturantName)){
                        Owners owner = new Owners(name, email, password, address, res);
                        owners.add(owner);
                        break;
                    }
                }
            }
        }

//-------------------------------------------------------------------------------------------------------------------

        while ((line = readereviewDishes.readLine()) != null) {
            String[] parts = line.split("~:~");
            int i=2;
            if (parts.length >= 2) {
                String resname = parts[0];
                String dishname = parts[1];
                while (i< parts.length){
                    String username=parts[i];
                    i++;
                    String comment=parts[i];
                    i++;
                    for(Resturant res :resturants) {
                        for (Dishes dish : res.items) {
                            if ((res.resturantName.equals(resname) && (dish.dishName).equals(dishname))) {
                                Review rev = new Review(username, comment);
                                dish.reviewes.add(rev);
                                break;
                            }
                        }
                    }
                }
            }
        }

//-------------------------------------------------------------------------------------------------------------------

        while ((line = readereviewRes.readLine()) != null) {
            String[] parts = line.split("~:~");

            for (Resturant resturant : resturants) {
                int i = 1;
                if (resturant.resturantName.equals(parts[0])) {
                    while (i < parts.length) {
                        String username = parts[i];
                        i++;
                        String comment = parts[i];
                        i++;
                        Review review=new Review(username,comment);
                        resturant.reviews.add(review);
                    }
                }
            }

        }



        readerAdmins.close();
        readerResturants.close();
        readerUsers.close();
        readerReports.close();
        readerOwners.close();
        readerOrders.close();
        readereviewDishes.close();
        readereviewRes.close();
        readerTID.close();
   }
   //---------------------------------------------------------------
    public void writeToFile(ArrayList<Resturant> resturants, ArrayList<Admin> admins, ArrayList<User> users, ArrayList<Report> reports, ArrayList<Owners> owners) throws
            IOException {
        BufferedWriter writerResturants = new BufferedWriter(new FileWriter("resturants.txt"));
        BufferedWriter writerUsers = new BufferedWriter(new FileWriter("users.txt"));
        BufferedWriter writerReports = new BufferedWriter(new FileWriter("reports.txt"));
        BufferedWriter writerOwners = new BufferedWriter(new FileWriter("owners.txt"));
        BufferedWriter writerAdmins = new BufferedWriter(new FileWriter("admins.txt"));
        BufferedWriter writerOrders = new BufferedWriter(new FileWriter("orders.txt"));
        BufferedWriter writerDishReview = new BufferedWriter(new FileWriter("reviewsDishes.txt"));
        BufferedWriter writerResReview = new BufferedWriter(new FileWriter("reviewsRes.txt"));
        BufferedWriter writerTID = new BufferedWriter(new FileWriter("transactionID.txt"));

        for (Resturant resturant : resturants) {
            writerResturants.write(resturant.resturantName + "~:~");
            writerResturants.write(resturant.resturantAvgRate + "~:~");
            writerResturants.write(resturant.resturantAddress + "~:~");
            writerResturants.write(resturant.contactInfo + "~:~");
            int dishindex = 0;
            for (Dishes dish : resturant.items) {
                writerResturants.write(resturant.items.get(dishindex).resturantName + "~:~");
                writerResturants.write(resturant.items.get(dishindex).dishName + "~:~");
                writerResturants.write(resturant.items.get(dishindex).price + "~:~");
                writerResturants.write(resturant.items.get(dishindex).dishAvgRate + "~:~");
                writerResturants.write(resturant.items.get(dishindex).discribtion + "~:~");
                writerResturants.write(resturant.items.get(dishindex).availability + "~:~");
                if (!dish.reviewes.isEmpty()) {
                    writerDishReview.write(resturant.resturantName + "~:~");
                    writerDishReview.write(dish.dishName + "~:~");
                    for (Review review : dish.reviewes) {
                        writerDishReview.write(review.userName + "~:~");
                        writerDishReview.write(review.comment + "~:~");
                    }
                    writerDishReview.newLine();
                }
                dishindex++;
            }
            if(!resturant.reviews.isEmpty()){
                writerResReview.write(resturant.resturantName+"~:~");
                for (Review review : resturant.reviews) {
                    writerResReview.write(review.userName + "~:~");
                    writerResReview.write(review.comment + "~:~");
                }
                writerResReview.newLine();
            }
            writerResturants.newLine();
        }
//------------------------------------------------------------------------------------------------
        for (User user : users) {
            writerUsers.write(user.name + "~:~");
            writerUsers.write(user.email + "~:~");
            writerUsers.write(user.password + "~:~");
            writerUsers.write(user.address + "~:~");
            if (!user.carts.currentOrder.dish.isEmpty()) {
                int dishindex = 0;
                for (Dishes dish : user.carts.currentOrder.dish) {
                    writerUsers.write(user.carts.currentOrder.dish.get(dishindex).dishName + "~:~");
                    writerUsers.write(user.carts.currentOrder.dish.get(dishindex).price + "~:~");
                    writerUsers.write(user.carts.currentOrder.dish.get(dishindex).discribtion + "~:~");
                    writerUsers.write(user.carts.currentOrder.dish.get(dishindex).dishAvgRate + "~:~");
                    writerUsers.write(user.carts.currentOrder.dish.get(dishindex).availability + "~:~");
                    dishindex++;
                }
            }
            if (!user.orders.isEmpty()) {
                writerOrders.write(user.getUser_id() + "~:~");
                for (Order order : user.orders) {
                    writerOrders.write(order.address + "~:~");
                    writerOrders.write(order.deliveryTime + "~:~");
                    writerOrders.write(order.paymentInfo.paymentMethod + "~:~");
                    writerOrders.write(order.paymentInfo.transactionID + "~:~");
                    writerOrders.write(order.orderPrice + "~:~");
                    writerOrders.write(order.statuesOfOrder + "~:~");
                    if (!order.dish.isEmpty()) {
                        for (Dishes dish : order.dish) {
                            writerOrders.write(dish.resturantName+"~:~");
                            writerOrders.write(dish.dishName + "~:~");
                        }
                        writerOrders.write("&&" + "~:~");
                    }
                }


                writerOrders.newLine();
            }

            writerUsers.newLine();
        }
//------------------------------------------------------------------------------------------------------------

        for (Report report : reports) {
            writerReports.write(report.reportTitle + "~:~");
            writerReports.write(report.adminName + "~:~");
            writerReports.write(report.discription+"~:~");
            writerReports.write(new SimpleDateFormat("MM/dd/yyyy").format(report.currentDate)+"~:~");
            writerReports.newLine();
        }
//------------------------------------------------------------------------------------------------------------
        for (Owners owner : owners) {
            writerOwners.write(owner.name + "~:~");
            writerOwners.write(owner.email + "~:~");
            writerOwners.write(owner.password + "~:~");
            writerOwners.write(owner.address + "~:~");
            writerOwners.write(owner.getResturant().resturantName+"~:~");
            writerOwners.newLine();
        }
//--------------------------------------------------------------------------------------------------------------
        for (Admin admin : admins) {
            writerAdmins.write(admin.name + "~:~");
            writerAdmins.write(admin.email + "~:~");
            writerAdmins.write(admin.password + "~:~");
            writerAdmins.write(admin.address);
            writerAdmins.newLine();
        }
//--------------------------------------------------------------------------------------------------------------
        writerTID.write(Payment.countTransactionID);
        writerTID.write(String.valueOf(Payment.countTransactions));



        writerResturants.close();
        writerAdmins.close();
        writerUsers.close();
        writerReports.close();
        writerOwners.close();
        writerOrders.close();
        writerDishReview.close();
        writerResReview.close();
        writerTID.close();
   }
   //----------------------------------------------------------------
    public void exitProgram () throws IOException {
        writeToFile(resturants, admins, users, reports, owners);
        System.exit(0);
    }

}