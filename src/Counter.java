
public class Counter {

	private int count;
	
	//every time synchronized method is called, thread will
	//gain the lock of the object
	public synchronized void addCount1()
	{
		System.out.println(Thread.currentThread().getName() + "[B][1]:" + count);
		try 
		{
			//calling sleep() won't give up the lock current thread hold,
			//but calling wait() will give away the lock and other thread who
			//get the lock will step in the method
			Thread.sleep(5000);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		count++;
		System.out.println(Thread.currentThread().getName() + "[A][1]:" + count);
		
		//involving another synchronized method in synchronized method will not
		//release the lock, instead it adds the counter in the lock by 1.
		//lock will be released when the counter in the lock reach 0
		addCount2();
	}
	
	public synchronized void addCount2()
	{
		System.out.println(Thread.currentThread().getName() + "[B][2]:" + count);
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		count++;
		System.out.println(Thread.currentThread().getName() + "[A][2]:" + count);
	}
	
	public synchronized void addCount3()
	{
		System.out.println(Thread.currentThread().getName() + "[B][3]:" + count);
		count++;
		System.out.println(Thread.currentThread().getName() + "[A][3]:" + count);
	}
}
