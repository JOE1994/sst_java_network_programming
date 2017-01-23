package producer_consumer;

public class Consumer implements Runnable {

	// 인터페이스 타입으로 잡아서 객체를 가져옴.
	private Queue queue; 
	private String name;
	
	public Consumer(String name) {
		queue = Queue_impl.getInstance(); // static method 호출.
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(name + " Consumer 동작 시작");
		while(!Thread.currentThread().isInterrupted()){
			System.out.println(name+" : "+queue.pop());
		}
	}
}
