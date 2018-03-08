import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * This class use to measue count time of each 3 task method
 * @author wasuthun wanaphongthipakorn
 *
 */
public class FileTasks {
	/**
	 * Read file by append string 
	 * @param filename
	 * @return result of string in file
	 */
	public static String readFileToString(String filename) {
		InputStream in = null;
		String data = "";
		try {
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while (true) {
				c = reader.read();
				if (c < 0)
					break;
				data = data + (char) c;
			}
		} catch (FileNotFoundException e) {
			System.out.println("not found " + filename);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if (in != null)
			try {
				in.close();
			} catch (IOException e) {

			}
		return data;
	}
	/**
	 * Read file by append string by use StringBuilder 
	 * @param filename
	 * @return result of string in file
	 */
	public static String readFileToStringBuilder(String filename) {
		InputStream in = null;
		StringBuilder build = null;
		try {
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			build = new StringBuilder();
			int c;
			while (true) {
				c = reader.read();
				if (c < 0)
					break;
				build.append((char) c);
			}

		} catch (FileNotFoundException e) {
			System.out.println("not found " + filename);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if (in != null)
			try {
				in.close();
			} catch (IOException e) {

			}
		return build.toString();

	}
	/**
	 * Read file by append string by use BufferReader 
	 * @param filename
	 * @return result of string in file
	 */
	public static String readFileToBufferedReader(String filename) {
		FileReader reader = null;
		String result = "";
		try {
			reader = new FileReader(filename);
			BufferedReader br = new BufferedReader(reader);
			String line;

			while ((line = br.readLine()) != null)
				result = result + line + '\n';

			if (br != null)
				br.close();
		} catch (FileNotFoundException e) {
			System.out.println("not found " + filename);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	/**
	 * Check 2 parameter is equal or not
	 * @param str1
	 * @param str2
	 * @return result of checking
	 */
	public static String difference(String str1, String str2) {
		if (str1 == null) {
			return str2;
		}
		if (str2 == null) {
			return str1;
		}
		int at = indexOfDifference(str1, str2);
		if (at == -1) {
			return "";
		}
		return str2.substring(at);
	}
	/**
	 * Check what different index in 2 parameter 
	 * @param str1
	 * @param str2
	 * @return result of checking
	 */
	public static int indexOfDifference(String str1, String str2) {
		if (str1 == str2) {
			return -1;
		}
		if (str1 == null || str2 == null) {
			return 0;
		}
		int i;
		for (i = 0; i < str1.length() && i < str2.length(); ++i) {
			if (str1.charAt(i) != str2.charAt(i)) {
				break;
			}
		}
		if (i < str2.length() || i < str1.length()) {
			return i;
		}
		return -1;
	}
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		Stopwatch sw = new Stopwatch();
		sw.start();
		String alice = readFileToString("/Users/johnpaul/eclipse-workspace/Stopwatch/src/Alice-in-Wonderland.txt");
		sw.stop();
		System.out.printf("Read %d chars in %.6f sec.\n", alice.length(), sw.getElapsed());
		sw.start();
		String alice2 = readFileToStringBuilder("/Users/johnpaul/eclipse-workspace/Stopwatch/src/Alice-in-Wonderland.txt");
		sw.stop();
		System.out.printf("Read %d chars in %.6f sec.\n", alice.length(), sw.getElapsed());
		sw.start();
		String alice3 = readFileToBufferedReader("/Users/johnpaul/eclipse-workspace/Stopwatch/src/Alice-in-Wonderland.txt");
		sw.stop();
		System.out.printf("Read %d chars in %.6f sec.\n", alice.length(), sw.getElapsed());
		System.out.println("diff " + difference(alice2, alice3));

	}
}
