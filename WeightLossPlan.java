//Name: Wenhuan/Selina Tan
//Date: 05/24/2020

/*Desceiption: This is a program to calculate how long it will take these 4 users to loss some weight with the recommended diet.
                A random number is used to choose their weight loss goals and the random number is limited to 20kg since it is 
                recommended to lose too much weight in real life. */

/* pseudocode:
   1. Create a User class to define user's information
      a. list 5 fields(usersName, usersGender, usersAge, usersHeight, usersWeight)
      b. create a set value method and a get value method for each field
      c. create a method to calculate Basal Metabol Rate
      d. create a method to see how much calories are needed to keep the user's current weight
      e. create a method to calculate when the user will reach his/her weight goal
      f. create a Non-default constructor and override a default constructor
      g. override the toString() method to return a brief introduction for the users
      
   2. Create the  main class
      a. import statements
      b. the main routine
      c. four reference variables, user1, user2, user3, user4
      d. invoke toString() method and print the information of each user to the screen
      e. invoke mybasalMetabolRate() method and print the results on the screen
      f. ask the reader to guess each user's activity level and invoke getCurrentCaloriesNeed() method
      g. open and read data from the file Diet.txt and assign the calories number from the file to an Array
      h. invoke averageDailyCaloriesInput method
      i. use to random number to get the weight goal and invoke daysToGo method
      j.create a method to calculate averageDailyCaloriesInput */

import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class WeightLossPlan {

	// the main routine
   public static void main(String[] args) throws IOException {
   
   	// introduce the program
      System.out.println("This is a program to calculate how long it will take these 4 users to reach their weight goal with the recommended diet");
   
   	// four reference variables, user1, user2, user3, user4
      User user1 = new User("Tina", "F", 23, 168.0, 72.5);
      User user2 = new User("Yuko", "F", 34, 162.0, 64.8);
      User user3 = new User("Tom", "M", 38, 175.0, 104.6);
      User user4 = new User("David", "M", 29, 183.0, 97.4);
   
   
   	// invoke toString() method to print out each user's information on the screen
      System.out.println("user1:" + user1.toString());
      System.out.println("user2:" + user2.toString());
      System.out.println("user3:" + user3.toString());
      System.out.println("user4:" + user4.toString());
   
   	// invoke mybasalMetabolRate() method and print the results on the screen
      System.out.println(user1.getName() + "'s " + "Basal Metabol Rate is " + user1.mybasalMetabolRate());
      System.out.println(user2.getName() + "'s " + "Basal Metabol Rate is " + user2.mybasalMetabolRate());
      System.out.println(user3.getName() + "'s " + "Basal Metabol Rate is " + user3.mybasalMetabolRate());
      System.out.println(user4.getName() + "'s " + "Basal Metabol Rate is " + user4.mybasalMetabolRate());
   
   	// ask the reader to guess each user's activity level and invoke
   	// getCurrentCaloriesNeed method
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Please guess " + user1.getName() + "'s activity level(low/little/medium/high): ");
      String activityLevel1 = keyboard.nextLine();
      System.out.println("Then " + user1.getName() + " need " + user1.getCurrentCaloriesNeed(activityLevel1)
         	           + " calories per day to keep current weight");
   
      System.out.print("Please guess " + user2.getName() + "'s activity level(low/little/medium/high): ");
      String activityLevel2 = keyboard.nextLine();
      System.out.println("Then " + user2.getName() + " need " + user2.getCurrentCaloriesNeed(activityLevel2)
         	           + " calories per day to keep current weight");
            
      System.out.print("Please guess " + user3.getName() + "'s activity level(low/little/medium/high): ");
      String activityLevel3 = keyboard.nextLine();
      System.out.println("Then " + user3.getName() + " need " + user3.getCurrentCaloriesNeed(activityLevel3)
         	           + " calories per day to keep current weight");
            
      System.out.print("Please guess " + user4.getName() + "'s activity level(low/little/medium/high): ");
      String activityLevel4 = keyboard.nextLine();
      System.out.println("Then " + user4.getName() + " need " + user4.getCurrentCaloriesNeed(activityLevel4)
         	           + " calories per day to keep current weight");
   	
   
   	//open and read data from the file Diet.txt
      System.out.println("Next we are going to take a look at our weekly diet plan:");
      System.out.println("------------------------------------------------------------------------------");
      File myDietPlans = new File("Diet.txt");
      Scanner inputFile = new Scanner(myDietPlans);
   
      //read calories of each meal from the file and put into an array 
      int i = 0;
      int k = 0;
      double[][] caloriesPerMeal = new double[7][3];
      while (inputFile.hasNext()) {
         String food = inputFile.nextLine();
         System.out.println(food);
         String nums = inputFile.nextLine();
         int num = Integer.valueOf(nums);
      
         if (i == 0) {
            caloriesPerMeal[k][i] = num;
            i = i + 1;
         }
         if (i == 1) {
            caloriesPerMeal[k][i] = num;
            i = i + 1;
         }
         if (i == 2) {
            caloriesPerMeal[k][i] = num;
            i = 1;
         }
      }
   
      // invoke averageDailyCaloriesInput method
      averageDailyCaloriesInput(caloriesPerMeal);
      
      System.out.println("------------------------------------------------------------------------------");
      
      //use to random number to get the weight goal and invoke daysToGo method
      Random randomNumbers = new Random();
      int weightLoss1 = randomNumbers.nextInt(20);
      int weightLoss2 = randomNumbers.nextInt(20);
      int weightLoss3 = randomNumbers.nextInt(20);
      int weightLoss4 = randomNumbers.nextInt(20);
   
      int user1_daysTogo = user1.getCurrentCaloriesNeed(activityLevel1);
      int user1_average  =  averageDailyCaloriesInput(caloriesPerMeal);
      int user2_daysTogo = user2.getCurrentCaloriesNeed(activityLevel2);
      int user2_average  =  averageDailyCaloriesInput(caloriesPerMeal);
      int user3_daysTogo = user3.getCurrentCaloriesNeed(activityLevel3);
      int user3_average  =  averageDailyCaloriesInput(caloriesPerMeal);
      int user4_daysTogo = user4.getCurrentCaloriesNeed(activityLevel4);
      int user4_average  =  averageDailyCaloriesInput(caloriesPerMeal);
       
      System.out.println("if " + user1.getName() + " follows the diet plan, she will loss " + weightLoss1 + "kg in " 
                           + user1.daysToGo(user1_daysTogo,user1_average,weightLoss1) + " days");
       
      System.out.println("if " + user2.getName() + " follows the diet plan, she will loss " + weightLoss2 + "kg in " 
                           + user1.daysToGo(user2_daysTogo,user2_average,weightLoss2) + " days");
                           
      System.out.println("if " + user3.getName() + " follows the diet plan, he will loss " + weightLoss3 + "kg in " 
                           + user1.daysToGo(user3_daysTogo,user3_average,weightLoss3) + " days");
                           
      System.out.println("if " + user4.getName() + " follows the diet plan, he will loss " + weightLoss4 + "kg in " 
                           + user1.daysToGo(user4_daysTogo,user4_average,weightLoss4) + " days");                   
                           
   }

	// create a method to calculate averageDailyCaloriesInput
   public static int averageDailyCaloriesInput(double[][] calories) {
      double total = 0;
      int averageDailyCaloriesInput = 0;
      for (int row = 0; row < calories.length; row++) {
         for (int col = 0; col < calories[row].length; col++) {
            total += calories[row][col];
            averageDailyCaloriesInput = (int)(total / 7);
         }
      }
      return averageDailyCaloriesInput;
   }
}

//If the player input something other than low/little/medium/high, 
//then the result will be negative, which does not match the reality, 
//so the code will break.
