import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class gestionIO {
	
	
	/**
	 * read a plain text file and returns a list of strings
	 * each strings points to a line
	 * @param pathToSource
	 * @return the content of the file
	 */
	public static String [] read(String pathToSource){
		try
		  {
		      File f = new File (pathToSource);
		      FileReader fr = new FileReader (f);
		      BufferedReader br = new BufferedReader (fr);
		      String content = "";
		   
		      try
		      {
		          String line = br.readLine();
		          String [] lines;
		   
		          while (line != null)
		          {
		        	  content = content + line + "\n";
		              line = br.readLine();
		          }
		          lines = content.split("\n");//on renverra cette valeur
		          
		          
		   
		          br.close();
		          fr.close();
		          return lines;
		      }
		      catch (IOException exception)
		      {
		          System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		      }
		  }
		  catch (FileNotFoundException exception)
		  {
		      System.out.println ("Le fichier n'a pas été trouvé");
		  }
		return null;
	}
	
	/**
	 * write a text to a path
	 * @param pathToOutput
	 * @param output
	 */
	public static void write(String pathToOutput, String output){
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream(pathToOutput), "utf-8"))) {
	   writer.write(output);
	}catch(IOException e){};
		
	}
}
