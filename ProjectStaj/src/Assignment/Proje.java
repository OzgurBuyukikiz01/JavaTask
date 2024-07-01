package Assignment;
import java.util.Scanner;

public class Proje {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);	

        System.out.println("Welcome to the Calculator!");
        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (x)");
        System.out.println("4. Division (/)");
        System.out.println("5. Square Root (√)");
        System.out.println("6. Power (^)");
        
     
        
        int operation = scan.nextInt(); 
        int numberOfInputs = 0;
        
      
       
        if (operation == 5) {	
        	
            numberOfInputs = 1;
        } else if (operation == 6) {
            numberOfInputs = 2;
        } else {
            System.out.println("How many numbers do you want to enter?");
            
            
            
            numberOfInputs = scan.nextInt();
        }
        
        
        double[] numbers = new double[numberOfInputs]; 
        
       
        
        for (int i = 0; i < numberOfInputs; i++) {
        	
       
        	
            System.out.println("Enter number " + (i + 1) + ":");
         
            
            numbers[i] = scan.nextDouble();
        }

        double result = 0;

        switch (operation) {	
            case 1:
                result = add(numbers);	
                break;					
            case 2:
                result = subtract(numbers);
                break;
            case 3:
                result = multiply(numbers);
                break;
            case 4:
                result = divide(numbers);
                break;
            case 5:
                result = Math.sqrt(numbers[0]);  
                break;								
            case 6:
                result = Math.pow(numbers[0], numbers[1]);
                break;
            default:
                System.out.println("Invalid operation selected.");
                return;
        }

        System.out.println("The result is: " + result);
    }

    public static double add(double[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {	
            sum += numbers[i];						
        }											
        return sum;									
    }

    public static double subtract(double[] numbers) {
        double result = numbers[0];		
        for (int i = 1; i < numbers.length; i++) {   
            result -= numbers[i];
        }
        return result;
    }

    public static double multiply(double[] numbers) {
        double result = 1;			
        for (int i = 0; i < numbers.length; i++) {
            result *= numbers[i]; 
        }
        return result;
    }

    public static double divide(double[] numbers) {
        double result = numbers[0]; 
        for (int i = 1; i < numbers.length; i++) {	
            if (numbers[i] == 0) {
                System.out.println("Error: Division by zero.");		
                return Double.NaN;
            }
            result /= numbers[i];
        }
        return result;
    }					
}
