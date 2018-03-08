/**
 * Main class
 * @author wasuthun wanaphongthipakorn
 *
 */
public class Main {
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		String file = "/Users/johnpaul/eclipse-workspace/Stopwatch/src/Alice-in-Wonderland.txt";
		AppendStringBufferReaderTask task1 = new AppendStringBufferReaderTask(file);
		AppendStringTask task2 = new AppendStringTask(file);
		AppendStringBuilderTask task3 = new AppendStringBuilderTask(file);
		TaskTimer tasktimer= new TaskTimer();
		tasktimer.measureAndPrint(task2);
		tasktimer.measureAndPrint(task3);
		tasktimer.measureAndPrint(task1);
	}
}
