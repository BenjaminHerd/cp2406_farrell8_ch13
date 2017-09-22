// Reads file of entrees and prices
// prompts user for a cutoff price
// and displays entrees that cost no more than the cutoff
import java.nio.file.*;
import java.io.*;
import static java.nio.file.AccessMode.*;
import java.util.Scanner;
public class FixDebugThirteen4
{
   public static void main(String[] args)
   {
      Path file =
              Paths.get("D:\\My Documents\\University\\BIT\\2017\\SP2\\CP2406\\Workshops\\Week 9\\cp2406_farrell8_ch13\\DebuggingExercises\\DebugData4.txt");

      //Need scanner for user input
      Scanner keyBoard = new Scanner(System.in);
      String[] array = new String[2];
      String string = "";
      String delimiter = ",";
      double searchPrice;
      boolean wasFound = false;

      try
      {
         InputStream input = new BufferedInputStream(Files.newInputStream(file));
         BufferedReader reader = new BufferedReader(new InputStreamReader(input));
         System.out.println();

         System.out.print("Enter maximum price to search for >> ");
         searchPrice = keyBoard.nextDouble();
         System.out.println("\nEntrees no more than $" + searchPrice + "\n");
         string = reader.readLine();
         while(string != null)
         {
            array = string.split(delimiter);
            if(searchPrice >= Double.parseDouble(array[1]))
            {
               wasFound = false;
               System.out.println(array[0] + "  $" + array[1]);
            }
            string = reader.readLine();
         }
         if(!wasFound)
           System.out.println("No more entrees found under $" + searchPrice);
         reader.close();
      }
      catch(Exception e)
      {
        System.out.println("Message: " + e);
      }
   }
}
