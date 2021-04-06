/**
 * Ryan Wagner
 * 1-26-2021
 * Java Formatting Output
 */
import java.util.Scanner;
public class AnnualWeatherV2
{
    private static String city = "Miami";
    private static String state = "FL";
    private static double[] temperature = {68.1, 69.1, 72.4, 75.7, 79.6, 82.4, 83.7, 83.6, 82.4, 78.8, 74.4, 69.9};
    private static double[] precipitation = {1.9, 2.1, 2.6, 3.4, 5.5, 8.5, 5.8, 8.6, 8.4, 6.2, 3.4, 2.2};
    
    //Second Input of Data
    /*private static String city = "Key West";
    private static String state = "FL";
    private static double[] temperature = {70.3, 70.8, 73.8, 77.0, 80.7, 83.4, 84.5, 84.4, 83.4, 80.2, 76.3, 72.0};
    private static double [] precipitation = {2.2, 1.5, 1.9, 2.1, 3.5, 4.6, 3.3, 5.4, 5.5, 4.3, 2.6, 2.1};
    */ 
 
    private static String[] month = {"Jan", "Feb" , "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static String tempLabel = "F";
    private static String precipLabel = "in."; 
    
    public AnnualWeatherV2(){
        
    }
    
    // method to calculate the average of temperature
    public static double getAverageTemp(){
        double avgTemp = 0;
        for(int i = 0; i < temperature.length; i++){
            avgTemp += temperature[i];
        }
        
        avgTemp = (avgTemp / 12);
        
        return (double)Math.round(avgTemp * 10) / 10;
    }
    
    // method to calculate total precipitation array
    public static double getTotalPrecip(){
        double totalPrecip = 0;
        for(int i = 0; i < precipitation.length; i++){
            totalPrecip += precipitation[i];
        }
        
        return (double)Math.round(totalPrecip * 10) / 10;
    }
    
    
    public static void printResults(){// method to print results (formatting output will be done in 6.02)
    
        //Output: display table of weather data including average and total
        System.out.println();
        System.out.printf("%23s%n", "Weather Data");
        System.out.printf("%16s", "Location: ");
        System.out.println(city + ", " + state);
        System.out.println(" Month     Temperature (" +  tempLabel + ")     Precipitation (" + precipLabel + ")");
        System.out.printf("%s%n", "***************************************************");
        for( int index = 0; index < temperature.length; index++){
            System.out.println(" " + month[index] + "            " + temperature[index] + "                 " + precipitation[index]);
        }
        System.out.printf("%s%n", "****************************************************");
        System.out.println("       Average: " + getAverageTemp() + "         Annual: " + getTotalPrecip());
        
    }    

    // method to calculate temperature in Celsius (current index of temperature array passed as a parameter) - to be completed in 6.02
    /**
     * Enter a number for the month 1 - 12 you are trying to find the temperature in celsius for
     */
    public static double convertTemp(int MonthNum){
        double celsTemp = 0;
        
        try{
        celsTemp = (temperature[MonthNum - 1] - 32) * (5.0/9);
        }
        catch(Exception e){
            System.out.println("The number typed wasn't 1 - 12 for the couresponding month");
            return 0;
        }
        
        
        return (double)Math.round(celsTemp * 10) / 10;
    }
    
    // method to calculate precipitation in centimeters (current index of precipitation array passed as a parameter) - to be completed in 6.02
    public static double getPrecipInCM(int MonthNum){
        double precipInCM = 0;
        try{
        precipInCM = (precipitation[MonthNum - 1] * 2.54);
        }
        catch(Exception e){
            System.out.println("The number typed wasn't 1 - 12 for the couresponding month");
            return 0;
        }
    
        return (double)Math.round(precipInCM * 10) / 10;
    }
    
    // method for input and convertions in main method
    public static void scale(boolean fahrenhiet, boolean inches){
        if(!fahrenhiet){
            for(int i = 0; i < temperature.length; i++){
                temperature[i] = (double)Math.round((temperature[i] - 32) * (5.0/9) * 10) / 10;
            }
            tempLabel = "C";
        }
        if(!inches){
            for(int i = 0; i < precipitation.length; i++){
                precipitation[i] = (double)Math.round((precipitation[i] * 2.54)* 10) / 10;
            }
            precipLabel = "cm";
        }
    }
    
    /**
     * First, enter true for Fahrenhiet or false for Celcius. Then, enter true for inches or false for cm.
     */
    public static void main (boolean fahrenhiet, boolean inches)
    {
        //Declare and initialize variables
        //Scanner in = new Scanner(System.in);  //will be used in 6.02
        /*
        city = "";
        state = "";
        String [] month = {};
        double [] temperature{};     //complete initialization of temperatures array
        double [] precipitation ={};     //complete initialization of precipitation array
        tempLabel ="";    //initialize to F
        precipLabel = ""; //initialize to in
        */
        
        //input to decide F/C and in/cm - to be completed in 6.02
        //conditions & method call to convert temp, if needed - to be completed in 6.02
        //conditions & method call to convert prec, if needed - to be completed in 6.02 
        scale(fahrenhiet, inches); //All 3 previous comments in one method
        
        //method call to calculate the average temperature
        getAverageTemp();
        //method call to calculate the total precipitation
        getTotalPrecip();
        //method call to print results (hint: Need parameters for month, temperature, precipitation arrays, data labels and the average temperature, total precipitation variables)
        printResults();
    }//end main
}//end class
