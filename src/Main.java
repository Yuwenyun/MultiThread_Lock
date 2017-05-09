
public class Main {

	public static void main(String[] args)
	{
		//share resource, maintains a lock
		Counter counter = new Counter();
		
		Jack jack = new Jack(counter);
		Jerry jerry = new Jerry(counter);
		
		Thread thread1 = new Thread(jack, "jack");
		thread1.setPriority(Thread.NORM_PRIORITY);
		
		Thread thread2 = new Thread(jerry, "jerry");
		//make sure thread2 start first
		thread2.setPriority(Thread.MAX_PRIORITY);
		
		thread1.start();
		thread2.start();
	}
}
