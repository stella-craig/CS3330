import java.util.Scanner;
import java.util.ArrayList;

//1. Design a class called Calculator.
public class Calculator
{
    //2. The class should have two private double variables: numarr[] and result.
    //Variable initialization:
    private double numarr[];
    private double result;

    //3. The default constructor should initialize the variables to 0.
    //Default contstructor:
    public Calculator()
    {
        numarr = new double[]{0};   //set numarr to 0
        result = 0;                 //set result to 0
    }

    //4. Overload the contstructor to initalize numarr[] with a user-defined number array as a parameter.
    //Overloaded constructor:
    public Calculator(double array[])
    {
        try{
            numarr = array; //Initialize numarr[] too the user-defined array
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        result = 0;     //The result initialization should always be 0.
    }

    //5. Write the appropriate 'set' and 'get' methods which are public.
    //Set functions:
    public void setNumarr(double array[])
    {
        try{
            this.numarr=array;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void setResult(double num)
    {
        try{
            this.result=num;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    //Get functions:
    public double[] getNumarr()
    {
        return numarr;
    }

    public double getResult()
    {
        return result;
    }

    //Math functions:
    //6. The add() method will add all the numbers in numarr[] and store the value in variable.
    public double add()
    {
        //setResult(0);
        result = 0;
        for(int i = 0; i < numarr.length; i++)
        {
            //setResult(getResult() + numarr[i]);
            result = result + numarr[i];
        }
        //return getResult();
        return result;
    }

    //6. The subtract() method will subtract all the other elements from the first element.
    public double subtract()
    {
        //setResult(numarr[0]);
        result = numarr[0];
        for(int i = 1; i < numarr.length; i++)
        {
            //setResult(getResult() + numarr[i]);
            result = result - numarr[i];
        }
        //return getResult();
        return result;
    }

    //6. The multiply() method will multiply all the elements.
    public double multiply()
    {
        //setResult(1);
        result = 1;
        for(int i = 0; i < numarr.length; i++)
        {
            //setResult(getResult() * numarr[i]);
            result = result * numarr[i];
        }
        //return getResult();
        return result;
    }

    //6. The divide() method will divide the first element with the rest of the elements.
    public double divide()
    {
        //setResult(numarr[0]);
        result = numarr[0];
        for(int i = 1; i < numarr.length; i++)
        {
            //setResult(getResult() / numarr[i]);
            result = result / numarr[i];
        }
        //return getResult();
        return result;
    }

    //Extra methods:
    //This method takes a string, where it will print the string and ask the user for a y or n.
    //If y, return 1. If n, return 0.
    public static int enterYorN(String string, Scanner input)
    {
        //Scanner input = new Scanner(System.in); //Scanner to take input from user
        int continuationLoop = 0;
        while (continuationLoop == 0)   //Loop in case user inputs neither y nor n.
            {
                char continuer = 'x';
                System.out.println(string + " Enter y if yes, n if no.");   //Prompt user.
                
                if(input.hasNext()){
                    
                    char butt = input.next().charAt(0);    //Take what user inputed.
                    continuer = butt;
                }
                

                if (continuer == 'n')   //If user inputs n
                {
                    continuationLoop = 1;   //Do not loop
                    //input.close();
                    return 0;           //Return 0
                }
                else if (continuer == 'y')  //If user inputs y
                {
                    continuationLoop = 1;   //Do not loop
                    //input.close();
                    return 1;   //Return 1
                }
                else    //If user puts in anything else
                {
                    System.out.println("Try again.");   //Tell user to try again
                    continuationLoop = 0;   //Loop and reprompt user
                }
            }
        //input.close();
        return -1;  //Return -1 if everything fails.
    }

    //This method returns the array the user fills
    //9. Allow the user to input the numbers using the keyboard. After two numbers are input, ask the user if more than two numbers are there to be input.
    private static double[] userArrayInput(Scanner num)
    {
        ArrayList<Double> array = new ArrayList<Double>();  //Create an arraylist for its dynamic memory
        //Scanner num = new Scanner(System.in);   //Scanner to take input from the user
        System.out.println("Enter 1st number of your array:");  //Prompt user for first number
        array.add(num.nextDouble());    //Add what the user inputs to the arraylist

        int temp = 1;
        while(temp == 1)    //While they want to add another element to the array
        {
            System.out.println("Enter the next number of your array:"); //Prompts user for next number
            if(num.hasNextDouble())
            {
                array.add(num.nextDouble());    //Add what the user inputs to the arraylist
            }
            else{
                //array.add(num.nextLine());
            }
            temp = enterYorN("Do you want to add another element to your array?", num);  //If no, leave while loop
        }

        double[] arr = new double[array.size()];    //Create a new double array

        for(int i = 0; i < array.size(); i++)   //Fill the array with what was in the arraylist so they are the same
        {
            arr[i] = array.get(i);
        }

        //num.close();
        return arr; //Return the double array with the user's inputted data
    }

    //This method prompts the user for which math function they would like to user on their data, and then prints out the result they asked for.
    //This method takes in a Calculator and returns nothing.
    //9. After all the numbers are entered, take the operator (+, -, *, /) as an input from the keyboard as a character.
    //9. Perform the operation and display the result.
    private static void mathematics(Calculator calc, Scanner input)
    {
        //Scanner input = new Scanner(System.in); //Scanner to take input from user
        int continuationLoop = 1;
        while (continuationLoop == 1)   //Loop as long as user wants to do another equation or misinputs.
            {
                char function = 'x';
                //Prompt user on which math function they would like to do:
                System.out.println("Would you like to add, subtract, multiply, or divide? Enter +, -, *, or / to continue.");
                if(input.hasNext())
                {
                    char buttface = input.next().charAt(0); //Take in whatever the user inputs
                    function = buttface;
                }

                if (function == '+')    //If user wants to add all the elements in the array
                {
                    System.out.println("Addition: " + calc.add());  //Print the sum of all the elements in their array
                    continuationLoop = enterYorN("Would you like to do another equation?", input); //Prompt a loop
                }
                else if (function == '-')   //If user wants to subtract all elements from the first one
                {
                    System.out.println("Subtraction: " + calc.subtract());  //Print the difference
                    continuationLoop = enterYorN("Would you like to do another equation?", input); //Prompt a loop
                }
                else if (function == '*')   //If the user wants to multiply all the elements in the array
                {
                    System.out.println("Multiply: " + calc.multiply()); //Print the product of all the elements in their array
                    continuationLoop = enterYorN("Would you like to do another equation?", input); //Prompt a loop
                }
                else if (function == '/')   //If the user wants to divide the first element by the rest of the elements in their array
                {
                    System.out.println("Divide: " + calc.divide()); //Print the quotient
                    continuationLoop = enterYorN("Would you like to do another equation?", input); //Prompt a loop
                }
                else    //If the user doesn't input any of the options 
                {   
                    System.out.println("Try again.");
                    continuationLoop = 1;   //Loop
                }
            }
        //input.close();
    }

    //Main function:
    public static void main(String[] args)
    {
        //The following comments were a test of the math functions:
        // double array[] = {20, 30, 40};
        // Calculator calc = new Calculator(array);
        
        // System.out.println("Addition: " + calc.add());
        // System.out.println("Subtraction: " + calc.subtract());
        // System.out.println("Multiply: " + calc.multiply());
        // System.out.println("Divide: " + calc.divide());

        Scanner input = new Scanner(System.in); //Scanner to take input from user

        int continuation = 1;
        while(continuation == 1)    //Loop until the user no longer wants to continue
        {
            //9. Create an instance of the Calculator class called 'calc'.
            Calculator calc = new Calculator(); //Create a new Calculator object
            //9. Allow the user to input the numbers using the keyboard.
            double[] tempArr = userArrayInput(input);    //Create a double array based on what the user inputs as its elements
            calc.setNumarr(tempArr);    //Set the numarr[] of the Calculator class to the new array the user created

            //9. After all the numbers are entered, take the operator (+, -, *, /) as an input from the keyboard as a character.
            //9. Perform the operation and display the result.
            mathematics(calc, input);  //Ask user which functions they want to do with their data and do it

            //9. Prompt the user with a continuation option (y/n). Loop if 'y', terminate if 'n'.
            continuation = enterYorN("Would you like to continue with another set?", input);   //Prompt the user if they would like to continue
        }
        input.close();
    }
}