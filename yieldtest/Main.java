package yieldtest;

public class Main {

	public static void main(String[] args) {
		// 2개의 스레드를 파생시켜요!!
		// 이렇게 만든 스레드를 실행시켜요!!
		MyYieldThread my1 = new MyYieldThread();
		MyYieldThread my2 = new MyYieldThread();
		
		Thread t1 = new Thread(my1);
		Thread t2 = new Thread(my2);
		
		t1.start();
		t2.start();
		
		
		
		System.out.println("main() 종료");
	}

}
