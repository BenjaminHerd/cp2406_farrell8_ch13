//// Program reads in a file of phone numbers without area codes
//// inserts "(312) " in front of each phone number
//// and produces an output file with the new complete phone numbers
import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
public class FixDebugThirteen2
{
   public static void main(String[] args)
   {
       //Paths for files
       //fileOut: DebugDataNew3 is being created from this
      Path fileIn =
              Paths.get("D:\\My Documents\\University\\BIT\\2017\\SP2\\CP2406\\Workshops\\Week 9\\cp2406_farrell8_ch13\\DebuggingExercises\\DebugData3.txt");
      Path fileOut =
              Paths.get("D:\\My Documents\\University\\BIT\\2017\\SP2\\CP2406\\Workshops\\Week 9\\cp2406_farrell8_ch13\\DebuggingExercises\\DebugData3New.txt");
      String areaCode = "(312) ";
      String phone;

      //For initialisation of the message stream
      InputStream input = null;
      OutputStream output = null;

      //try block for catching input/output errors
      try
      {
         input = Files.newInputStream(fileIn);

         //new buffered reader object to read the files
         BufferedReader reader = new BufferedReader
            (new InputStreamReader(input));
         output = Files.newOutputStream(fileOut);
         phone = reader.readLine();

         //As the reader object is reading DebugData3, while there is not a blank space in text file,
          // write bytes to fileOut (DebugDataNew3)
         while(phone != null)
         {
            phone = areaCode + phone + System.getProperty("line.separator");
            byte[] phoneBytes = phone.getBytes();
            output.write(phoneBytes);
            phone = reader.readLine();
         }
         //Remember to close both input and output files
         input.close();
         output.close();
       }
       catch (IOException e)
       {
          System.out.println(e);
       }
   }
}

