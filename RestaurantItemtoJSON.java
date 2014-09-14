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
      
    }
    catch(Exception e) { 
      e.printStackTrace();
    }
  }
  
  public static void main(String[] ryan) { 
    addNewRestaurantText();
  }
  
}