//Name: Wenhuan Tan
//Date: 05/24/2020


// Import the Random class
import java.util.Random;

//Create a class that defines an object type of User
public class User {
	
	//fields
   private String usersName;
   private String usersGender;
   private int usersAge;
   private double usersHeight;
   private double usersWeight;
	
   
   //get value of field of usersName
   public String getName() {
      return usersName;
   }
   
   //assign the field usersName to name 
   public void setName(String name) {
      usersName = name;
   }
   
	//get value of field usersGender
   public String getGender() {
      return usersGender;
   }
   
   //assign the field usersGender to gender
   public void setGender(String gender) {
      usersGender = gender;
   }
	
	//get value of field usersAge
   public int getAge() {
      return usersAge;
   }
   
   //assign the field usersAge to age
   public void setAge(int age) {
      usersAge = age;
   }
	
	//get value of field usersHeight
   public double getHeight() {
      return usersHeight;
   }
   
   //assign the field usersHeight to height
   public void setHeight(double height) {
      usersHeight = height;
   }
	
	//get value of field usersWeight
   public double getWeight() {
      return usersWeight;
   }
   
   //assign the field usersWeight to weight
   public void setWeight(double weight) {
      usersWeight = weight;
   }
	
	
//	public double mybasalMetabolRate(String gender, int age, double height, double weight) {
   public int mybasalMetabolRate() {
   	// use if, else-if, else statement calculate the BMR
      int basalMetabolRate = 0;
      if (usersGender.equals("M")) {
         basalMetabolRate = (int)(88.362 + (13.397 * usersWeight) + (4.799 * usersHeight) - (5.677 * usersAge));
      } else {
         basalMetabolRate = (int)(447.593 + (9.247 * usersWeight) + (3.098 * usersHeight) - (4.330 * usersAge));
      }
      return basalMetabolRate;
   }
	
	//create a method to calculate the currentCaloriesNeed to see how much calories are needed to keep the user's current weight
   public int getCurrentCaloriesNeed( String activity ) {
      int currentCaloriesNeed=0;
      
      //use a switch statement to calculate currentCaloriesNeed with 4 different activity levels 
      switch (activity) {
         case "low":
            currentCaloriesNeed = (int)(mybasalMetabolRate()*1.2);
            break;
         case "little":
            currentCaloriesNeed = (int)(mybasalMetabolRate()*1.375);
            break;
         case "medium":
            currentCaloriesNeed = (int)(mybasalMetabolRate()*1.55);
            break;
         case "high":
            currentCaloriesNeed = (int)(mybasalMetabolRate()*1.725);
            break;
      }
      return currentCaloriesNeed;
   }
   
	
	//create a method to calculate when the user will reach his/her weight goal
   public int daysToGo(int CaloriesNeed, int dailyCaloriesInput, int totalWeightLoss) {
      int  dailyCaloriesSavings = CaloriesNeed - dailyCaloriesInput;
      final int caloriesPerKgFat = 7778;
      int daysToGo = (int)(totalWeightLoss*caloriesPerKgFat/dailyCaloriesSavings);
      return daysToGo;
   }
    
    //create a Non-default constructor
   public User(String usersName,String usersGender,int usersAge,double usersHeight,double usersWeight) {
      this.usersName  = usersName;
      this.usersGender  = usersGender;
      this.usersAge = usersAge;
      this.usersHeight = usersHeight;
      this.usersWeight = usersWeight; 
   }
   //override a default constructor
   public User() {}

   //override the toString() method of the User class to return information of the users
   public String toString() {
      return "Name:" + usersName + ",Gender:" + usersGender + ", Age: " + usersAge
         	+ ",Height:" + usersHeight + "cm,Weight:"+usersWeight+";";
   }
}
