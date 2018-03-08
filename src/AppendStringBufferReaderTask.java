import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * This class use to read file by append string by using BufferReader
 * @author wasuthun wanaphongthipakorn
 *
 */
public class AppendStringBufferReaderTask implements Runnable{
	/**
	 * Attribute filename
	 */
	private String filename=null;
	/**
	 * Constructor
	 * @param filename
	 */
	public AppendStringBufferReaderTask(String filename) {
		this.filename=filename;
	}
	/**
	 * Read file by append string by use BufferReader 
	 * @param filename
	 * @return result of string in file
	 */
	public static String readFileToBufferedReader(String filename) {
		FileReader reader=null;
		String result = "";
		try {
			reader=new FileReader(filename);
			BufferedReader br=new BufferedReader(reader);
			  String line;
			 
			  while( (line = br.readLine()) != null )
			      result = result + line + '\n';
			  
			  if ( br != null ) br.close();
		}catch (FileNotFoundException e) {
			System.out.println("not found "+filename);
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	/**
	 * Run method
	 */
	@Override
	public void run() {
		readFileToBufferedReader(filename);	
	}
	/**
	 * Print a description
	 */
	@Override
	public String toString() {
		return "Readfile by AppendStringBufferReader ";
	}
	
}
