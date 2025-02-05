import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker{
    //Holds common weak passwords to compare against
    private static final String[] COMMON_PASSWORDS={
        "123456", "password", "123456789", "qwerty", "abc123", "letmein", "123123"
    };

    //function to check strength of the password
    public static String StrengthChecker(String password){
       
        if(password.length()<8){
            return "Week! Too short.";
        }
        boolean hasUpper=false, hasLower=false, hasNumbers=false, hasSpecial=false;
        
        // Check each character in the password
        for(char c : password.toCharArray()){
            if(Character.isUpperCase(c))
                hasUpper=true;
            if(Character.isLowerCase(c))
                hasLower=true;
            if(Character.isDigit(c))
                hasNumbers=true;
            if (Pattern.matches("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]", String.valueOf(c)))
                hasSpecial=true;
        }

        //set common pass values on weekpass variable to compare
        for(String weekpass : COMMON_PASSWORDS)
        {
            //ignores the case and compare password to weekpass
            if(password.equalsIgnoreCase(weekpass))
                return "Weak!(Common password)";
        }

        //determine the strength level
        if(hasLower && hasUpper && hasNumbers && hasSpecial )
            return "Strong!";
        if(hasLower && hasUpper && hasNumbers || hasLower && hasUpper && hasSpecial || hasLower && hasNumbers && hasSpecial)
            return "Average!";
        else
            return "Week!";
    }

    //main method
    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
       String password;
       boolean running = true;
       while(running)
       {
            System.out.println("1. To check the Strength of password\n2. Exit");
            int ch = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline

            switch (ch) {
                case 1:
                    System.out.println("Enter the password to check : ");
                    password = sc.nextLine();
                    String strength = StrengthChecker(password);
                    System.out.println("The strength of the password is "+ strength);
                    break;
                case 2:
                    System.out.println("Exiting...");

                    //setting the boolean variable to false to exit from while
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
                    break;
            }
        }
        sc.close();
    }
    
}