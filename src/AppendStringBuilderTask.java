import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * This class use to read file by append string by using StringBuilder 
 * @author wasuthun wanaphongthipakorn
 *
 */
public class AppendStringBuilderTask implements Runnable{
	/**
	 * Attribute filename
	 */
	private String filename=null;
	/**
	 * Constructor
	 * @param filename
	 */
	public AppendStringBuilderTask(String filename) {
		this.filename=filename;
	}
	/**
	 * Read file by append string by use StringBuilder 
	 * @param filename
	 * @return result of string in file
	 */
	public static String readFileToStringBuilder(String filename) {
		InputStream in=null;
		StringBuilder build=null;
		try {
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			build=new StringBuilder();
			int c;
			while(true) {
				c=reader.read();
				if(c<0) break;
				build.append((char)c);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("not found "+filename);
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if(in!=null)	try {
			in.close();
		}catch (IOException e) {
			
		}
		return build.toString();
		
	}
	/**
	 * Run method
	 */
	@Override
	public void run() {
		readFileToStringBuilder(filename);	
	}	
	/**
	 * Print a description
	 */
	@Override
	public String toString() {
		return "Readfile by AppendStringBuilder ";
	}
}
