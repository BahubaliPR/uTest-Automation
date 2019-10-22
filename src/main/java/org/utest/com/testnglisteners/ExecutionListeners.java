package org.utest.com.testnglisteners;

/*
 * Bahubali P R
 */
import org.testng.IExecutionListener;

public class ExecutionListeners implements IExecutionListener {

	private long start = System.currentTimeMillis();

	public void onExecutionStart() {
		System.out.println("Execution started : " + start);
	}

	public void onExecutionFinish() {
		System.out.println("Execution Finished : " + (System.currentTimeMillis() - start) + "Milli Seconds");
	}
}
