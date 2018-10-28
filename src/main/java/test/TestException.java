package test;

public class TestException {
	
	public static void main(String[] args) {
		try {
			f1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void f1() throws Exception {
		try {
			f2();
		} catch (Exception e) {
			e.initCause(new RuntimeException("init"));
			throw new Exception("first", e);
		}
	}

	private static void f2() throws Exception {

		String a = null;
		try {
			a.equals("");
		} catch (Exception e) {
			throw new Exception("first", e);
		}
	}
}
