package mySpring;

public class ExceptionDemo {
	
	void f() {
		throw new RuntimeException("ex");
	}
	
	void g() {
		try {
			f();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	void h () throws Exception {
		try {
			f();
		} catch (RuntimeException e) {
			e.printStackTrace();
			
			throw (Exception)e.fillInStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExceptionDemo exceptionDemo = new ExceptionDemo();
		try {
			exceptionDemo.g();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("========================");
		try {
			exceptionDemo.h();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
