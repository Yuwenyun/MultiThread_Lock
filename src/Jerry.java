
public class Jerry implements Runnable{

	private Counter counter;
	public Jerry(Counter counter)
	{
		this.counter = counter;
	}
	
	@Override
	public void run()
	{
		//thread jerry run first, by calling addCount1()
		//thread jerry get the lock of counter
		this.counter.addCount1();
	}
}
