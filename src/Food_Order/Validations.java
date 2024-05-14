package Food_Order;
import java.util.*;
public class Validations {

    public static String inputString(){
        Scanner input =new Scanner(System.in);
        String ans =input.nextLine();
        if(ans.equals("")){
            ans =input.nextLine();
        }
        return ans;
    }
    public static String emailValidation( String email){
        Scanner  input=new Scanner(System.in);
        while(!(email.contains("@gmail.com")&&email.endsWith("com"))||(email.startsWith("@"))||email.contains(" ")){
            System.out.println("\u001B[31mInvalid Email try again\u001B[0m");
            email=inputString();
        }
        return email;
    }
    public static String passwordValidation( String pass){
        Scanner  input=new Scanner(System.in);
        while(pass.length()<4||pass.contains(" ")){
            System.out.println("\u001B[35mPassword must contain at least 4 characters with no spaces\u001B[0m");
            pass=inputString();
        }
        return pass;
    }
    public static String userNameValidation( String userName){
        Scanner  input=new Scanner(System.in);
        while(userName.length()<2){
            System.out.println("\u001B[35mUsername must contain at least 2 characters\u001B[0m");
            userName=inputString();
        }
        return userName;
    }
    public static int checkNumberValidation(String inputString) {
        Scanner input = new Scanner(System.in);
        int choice =0;
        boolean validInput = false;
        while (!validInput) {
            try {

                choice = Integer.parseInt(inputString);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid choice.\u001B[0m Please enter a valid integer.");
                inputString=Validations.inputString().trim();
            }
        }
        return choice;
    }
    public static String checkStringIsNumberOnly()
    {
        String Paymentinfo=inputString();

        try {
            Double intValue = Double.parseDouble(Paymentinfo);
            return Paymentinfo;
        } catch (NumberFormatException e) {
            System.out.println("Input Must be number and not contain spaces.\u001B[31mTry again\u001B[0m ");
        }
        checkStringIsNumberOnly();
        return " ";
    }

    public static float checkFloatValidation(String inputString) {
        Scanner input = new Scanner(System.in);
        float choice =0;
        boolean validInput = false;
        while (!validInput) {
            try {

                choice = Float.parseFloat(inputString);

                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid choice.\u001B[0m Please enter a valid number.");
                inputString=Validations.inputString().trim();
            }
        }
        return choice;

    }

    public static int inputFromStrToInt(int size){
        int newNum=0;
        String num= Validations.inputString();
        newNum= Validations.checkNumberValidation(num.trim());
        while(newNum>size||newNum<=0){
            System.out.println("\u001B[31mThis number not in list\u001B[0m Try again");
            newNum=inputFromStrToInt(size);
        }
        return newNum;
    }
    public static boolean priceValidation(float price){
        if(price<=0){
            System.out.println("\u001B[31mInvalid price\u001B[0m");
            return false;
        }
        return true;
    }

}
