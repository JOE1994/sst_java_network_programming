package producer_consumer;

public class Producer implements Runnable {
	private Queue queue;
	public Producer(){
		queue = Queue_impl.getInstance();	
		
	}
	public void run() {
		System.out.println("Producer 동작 시작");
		int i=0;
		while(!Thread.currentThread().isInterrupted()){
			queue.put(i++);
		}
	}	
}
