import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.json.JSONObject;
import org.json.JSONArray;

public class RestaurantItemtoJSON { 
  
  public static void addNewRestaurantText() { 
    final Scanner theScanner = new Scanner(System.in);
    
    System.out.println("Enter restaurant name: ");
    final String restaurantName = theScanner.nextLine();
    
    try { 
      final File theFile = new File(restaurantName + ".txt");
      
      final JSONObject restaurant = new JSONObject();
      final JSONArray restaurantItems = new JSONArray();
      
      boolean toContinue = true;
      
      while(toContinue) { 
        System.out.println("Enter item name: ");
        final String itemName = theScanner.nextLine();
        
        if(itemName.equals("end")) { 
          toContinue = false;
          break;
        }
        
        System.out.println("Item cost: ");
        final double itemCost = 
          Double.parseDouble(theScanner.nextLine().replace("$", "").replace("+", ""));
        
        System.out.println("Item description: ");
        final String itemDescription = theScanner.nextLine();
        
        final JSONObject restaurantItem = new JSONObject();
        restaurantItem.put("name", itemName);
        restaurantItem.put("price", String.valueOf(itemCost));
        restaurantItem.put("description", itemDescription);
        
        restaurantItems.put(restaurantItem);
        
      }
      
    }
    catch(Exception e) { 
      e.printStackTrace();
    }
  }
  
  public static void main(String[] ryan) { 
    addNewRestaurantText();
  }
  
}