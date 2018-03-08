/**
 * This class use to count time
 * @author wasuthun wanaphongthipakorn
 *
 */
public class Stopwatch {
	/**
	 * Constant of nanoseconds
	 */
	private static final double NANOSECONDS = 1.0E-9;
	/**
	 * Attribute startTime
	 */
	private long startTime;
	/**
	 * Attribute endTime
	 */
	private long endTime;
	/**
	 * Attribute run;
	 */
	private boolean run = false;
	/**
	 * Start count time
	 */
	public void start() {
		if (run)
			return;
		startTime = System.nanoTime();
		run = true;
	}
	/**
	 * End count time
	 */
	public void stop() {
		if (!run)
			return;
		endTime = System.nanoTime();
		run = false;
	}
	/**
	 * Check this Stopwatch is running or not
	 * @return
	 */
	public boolean isRunning() {
		return run;

	}
	/**
	 * Calculate elapsed time
	 * @return out put elapsed time
	 */
	public double getElapsed() {
		if (isRunning())
			return (System.nanoTime() - startTime) * NANOSECONDS;
		return (endTime - startTime) * NANOSECONDS;
	}
}
