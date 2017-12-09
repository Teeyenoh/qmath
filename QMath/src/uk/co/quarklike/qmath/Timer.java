package uk.co.quarklike.qmath;

public class Timer implements Runnable {
	private Thread thread;
	private long startTime;

	private static final long ONE_MINUTE = 1000 * 60 * 1;

	public void start() {
		thread = new Thread(this);
		thread.start();
		startTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		while (true) {
			if (System.currentTimeMillis() >= startTime + ONE_MINUTE) {
				System.out.println("Out of time!");
				System.exit(0);
			}
		}
	}
}
