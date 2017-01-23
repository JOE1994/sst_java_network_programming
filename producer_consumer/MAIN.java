package producer_consumer;

public class MAIN {

	public static void main(String[] args) {
		
		Thread c1 = new Thread(new Consumer("consumer1"));
		Thread c2 = new Thread(new Consumer("consumer2"));
		Thread c3 = new Thread(new Consumer("consumer3"));
		
		Thread producer = new Thread(new Producer());
		c1.start();
		c2.start();
		c3.start();
		producer.start();
		
		try {
			Thread.sleep(2000);
			producer.interrupt();
			Thread.sleep(2000);
			c1.interrupt();
			c2.interrupt();
			c3.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	}
	
}
