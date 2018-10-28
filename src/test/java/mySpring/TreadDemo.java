package mySpring;

import java.util.concurrent.atomic.AtomicInteger;

public class TreadDemo {
	
	public AtomicInteger i = new AtomicInteger();
	public static int NUM = 60;
	
	public static void main(String[] args) {
		TreadDemo treadDemo = new TreadDemo();
		Tread1 treadDemo1 = new Tread1(treadDemo);
		Tread2 treadDemo2 = new Tread2(treadDemo);
		new java.lang.Thread(treadDemo1).start();
		new java.lang.Thread(treadDemo2).start();
	}
	
	static class Tread1 implements Runnable {
		private TreadDemo treadDemo;
		private int num = 0;
		
		public Tread1(TreadDemo treadDemo) {
			this.treadDemo = treadDemo;
		}

		@Override
		public void run() {
			sys();
		}

		private void sys() {
			while (true) {
				if (treadDemo.i.get() == TreadDemo.NUM) {
					break;
				} else if (treadDemo.i.get() % 2 == 0) {
					System.out.println((char)('a' + num));
					num++;
					treadDemo.i.getAndIncrement();
				}
			}
		}
		
	}
	
	static class Tread2 implements Runnable {

		private TreadDemo treadDemo;
		private int num = 0;
		
		public Tread2(TreadDemo treadDemo) {
			this.treadDemo = treadDemo;
		}
		
		@Override
		public void run() {
			sys();
		}

		private void sys() {
			while (true) {
				if (treadDemo.i.get() == TreadDemo.NUM) {
					break;
				} else if (treadDemo.i.get() % 2 == 1) {
					System.out.println(1 + num);
					num++;
					treadDemo.i.getAndIncrement();
				}
			}
		}
		
	}
}
