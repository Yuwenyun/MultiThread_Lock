
public class Jack implements Runnable{

	private Counter counter;
	public Jack(Counter counter)
	{
		this.counter = counter;
	}
	
	@Override
	public void run()
	{
		//since thread jerry get the lock of counter first,
		//now thread jack has to wait till the lock is released
		//even when jack and jerry call different methods.
		this.counter.addCount3();
	}
}
