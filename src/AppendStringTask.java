import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * This class use to read file by append string 
 * @author wasuthun wanaphongthipakorn
 *
 */
public class AppendStringTask implements Runnable{
	/**
	 * Attribute filename
	 */
	private String filename=null;
	/**
	 * Constructor
	 * @param filename
	 */
	public AppendStringTask(String filename) {
		this.filename=filename;
	}
	/**
	 * Read file by append string 
	 * @param filename
	 * @return result of string in file
	 */
	public static String readFileToString(String filename) {
		InputStream in=null;
		String data="";
		try
		{
		in = new FileInputStream(filename);
		InputStreamReader reader = new InputStreamReader(in);
		int c;
		while(true) {
			c=reader.read();
			if(c<0) break;
			data =data+(char)c;
		}
		}
		catch (FileNotFoundException e) {
			System.out.println("not found "+filename);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if(in!=null)	try {
			in.close();
		}catch (IOException e) {
			
		}
		return data;
	}
	/**
	 * Run method
	 */
	@Override
	public void run() {
		readFileToString(filename);
	}
	/**
	 * Print a description
	 */
	@Override
	public String toString() {
		return "Readfile by AppendString ";
	}
	
}
