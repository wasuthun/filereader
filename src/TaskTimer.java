/**
 * This class use to call a Runnable subclass and count time
 * @author wasuthun wanaphongthipakorn
 *
 */
public class TaskTimer {
	/**
	 * count time each task
	 * @param run
	 */
	public void measureAndPrint(Runnable run) {
		Stopwatch sw=new Stopwatch();
		sw.start();
		run.run();
		sw.stop();
		System.out.printf("%s in %.6f sec.\n",run.toString(),sw.getElapsed());
	}
}
