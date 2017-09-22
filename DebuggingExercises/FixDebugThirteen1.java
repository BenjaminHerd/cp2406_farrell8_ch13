// Program describes two files
// tells you which one is newer and which one is larger
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;
public class FixDebugThirteen1
{
   public static void main(String[] args)
   {
      //Specify paths to get to file (Will be stored differently on each computer)
      Path file1 =
         Paths.get("D:\\My Documents\\University\\BIT\\2017\\SP2\\CP2406\\Workshops\\Week 9\\cp2406_farrell8_ch13\\DebuggingExercises\\DebugData1.txt");
      Path file2 =
              Paths.get("D:\\My Documents\\University\\BIT\\2017\\SP2\\CP2406\\Workshops\\Week 9\\cp2406_farrell8_ch13\\DebuggingExercises\\DebugData2.txt");

      //Try block to catch Input/Output error (as an example; if the path was not correct for either file variable)
      try
      {
         //Some attributes required a rename
         BasicFileAttributes attr1 =
            Files.readAttributes(file1, BasicFileAttributes.class);
         System.out.println("File: " + file1.getFileName());
         System.out.println("Creation time " + attr1.creationTime());
         System.out.println("Last modified time " + attr1.lastModifiedTime());
         System.out.println("Size " + attr1.size());
         BasicFileAttributes attr2 =
            Files.readAttributes(file2, BasicFileAttributes.class);
         System.out.println("\nFile: " + file2.getFileName());
         System.out.println("Creation time " + attr2.creationTime());
         System.out.println("Last modified time " + attr2.lastModifiedTime());
         System.out.println("Size " + attr2.size());

         //If else statement for comparison of times created and size (file 1 was not created earlier, and is not larger)
          //Remember, you're comparing two different files, i.e. attr1 > attr2
         if(attr1.creationTime().compareTo(attr2.creationTime()) > 0)
            System.out.println("\n" + file1.getFileName() + " was created earlier");
         else
            System.out.println("\n" + file1.getFileName() + " was not created earlier");
         if(attr1.size() > attr2.size())
            System.out.println(file1.getFileName() + " is larger ");
         else
            System.out.println(file1.getFileName() + " is not larger");
      }
      catch(IOException e)
      {
          System.out.println("IO Exception");
      }
   }
}
