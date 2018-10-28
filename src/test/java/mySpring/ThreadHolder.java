package mySpring;

public class ThreadHolder implements Runnable{

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		if (name.equals("t2")) {
			try {
				Thread.currentThread().sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<100;i++) {
			
			System.out.println(name + ":" + i);
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadHolder(),"t1");
		Thread t2 = new Thread(new ThreadHolder(),"t2");
		t1.start();
		t2.start();
		t1.join();//t1.join()是暂停main线程，先执行t1线程，执行完t1线程后再执行t2线程
		for (int i = 0; i < 100; i++) {
			System.out.println("======================================");
		}
		//t2.join();在此处意义不大
		t2.join();
	}
}
