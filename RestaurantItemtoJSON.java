import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.json.JSONObject;
import org.json.JSONArray;

public class RestaurantItemtoJSON { 
  
  /** Creates a new textfile with the restaurant's name
    * Adds each of the restaurant's items as a JSONObject in a JSONArray to a JSONObject
    * Writes the JSONObject to the textfile as a String  */
  public static void addNewRestaurantText() { 
    
    final Scanner theScanner = new Scanner(System.in);
    
    System.out.println("Enter restaurant name: ");
    final String restaurantName = theScanner.nextLine();
    
    try { 
      
      //Overall JSONObject to represent a restaurant
      final JSONObject restaurant = new JSONObject();
      
      //To hold each of the restaurant's items
      final JSONArray menu = new JSONArray();
      
      //To continue adding items to the menu
      boolean toContinue = true;
      
      while(toContinue) { 
        
        //Get the item name
        System.out.println("Enter item name: ");
        final String itemName = theScanner.nextLine();
        
        //If the name is end, stop adding items
        if(itemName.equals("end")) { 
          toContinue = false;
          break;
        }
        
        //Item cost
        System.out.println("Item cost: ");
        final double itemCost = 
          Double.parseDouble(theScanner.nextLine().replace("$", "").replace("+", ""));
        
        //Item description
        System.out.println("Item description: ");
        final String itemDescription = theScanner.nextLine();
        
        //Create a JSONObject for each restaurant item with the following fields
        final JSONObject restaurantItem = new JSONObject();
        restaurantItem.put("name", itemName);
        restaurantItem.put("price", String.valueOf(itemCost));
        restaurantItem.put("description", itemDescription);
        
        //Add each restaurant item to the Menu
        menu.put(restaurantItem);
      }
      
      //Add the menu (array) to the restaurant JSONObject
      restaurant.put("menu", menu);
      
      //Creates the textfile with the restaurant's name
      final File theFile = new File(restaurantName + ".txt");
      
      //Writes the JSONObject as a string to the file
      BufferedWriter output = new BufferedWriter(new FileWriter(theFile));
      output.write(restaurant.toString());
      output.close();
    }
    catch(Exception e) { 
      e.printStackTrace();
    }
  }
  
  public static void main(String[] ryan) { 
    //For adding a new restaurant and all of its items to a text file
    addNewRestaurantText();
  }
}