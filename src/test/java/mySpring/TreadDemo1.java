package mySpring;

import java.util.concurrent.atomic.AtomicInteger;

public class TreadDemo1 {
	public AtomicInteger i = new AtomicInteger();
	public static int NUM = 20;
	
	public static void main(String[] args) {
		TreadDemo1 t = new TreadDemo1();
		Tread1 treadDemo1 = new Tread1(t);
		Tread2 treadDemo2 = new Tread2(t);
		new java.lang.Thread(treadDemo1).start();
		new java.lang.Thread(treadDemo2).start();
	}
	
	static class Tread1 implements Runnable {
		private int num = 0;
		private volatile Object lock;
		
		public Tread1(Object lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sys();
		}

		private void sys() {
			while (true) {
				synchronized (lock) {
					if (num == TreadDemo1.NUM) {
						break;
					}
					System.out.print((char)('a' + num));
					num++;
					lock.notifyAll();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	static class Tread2 implements Runnable {

		private int num = 0;
		private volatile Object lock;
		
		public Tread2(Object lock) {
			this.lock = lock;
		}
		
		@Override
		public void run() {
			sys();
		}

		private void sys() {
			while (true) {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (num == TreadDemo1.NUM) {
						break;
					}
					System.out.print(1 + num);
					num++;
					lock.notifyAll();
				}
				
			}
		}
		
	}
}
