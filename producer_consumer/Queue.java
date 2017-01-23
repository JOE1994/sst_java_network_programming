package producer_consumer;

// 이 interface를 구현한 클래스의 instance가 공용객체가 됩니다. 
// 공용객체가 가져야 하는 method의 선언이 나와요!!
public interface Queue {
	
	public abstract void put(int item); // producer에 의해서 사용되는 메소드.
	int pop();							// consumer에 의해서 사용되는 메소드.
	
}
