package producer_consumer;

import java.util.LinkedList;

// singleton -> 딱 인스턴스 하나만 만들 수 있는 클래스 선언?
// 			 -> 프로그래밍 패턴으로 딱하나만 만들 수 있도록 설정하는 방법. 
// 굉장히 많이 사용되는 singleton pattern. 많이 쓰이지만, 사실 쓰는지도 모르고 쓰는 경우가 꽤 많음?
// 생성자를 외부에서 호출할 수 있도록 해놓으면 개수제한을 못한다!!
// 따라서 singleton pattern에서는 외부에서 생성자를 호출할 수 없도록 제한해요!!

// 이 공용 객체 역시 하나만 만들면 되기 때문에, singleton pattern으로 코드 작성.

public class Queue_impl implements Queue{

	//private static Queue_impl queue = null; // 이렇게 해놓고 private 생성자 호출하도록 해도 singleton아닐 수 있다.(스레드들이 접근 시에 두 개 이상의 객체 생성 가능!)
	// static으로 변수를 잡아놓으면, 인스턴스 만들지 않아도 사용할 수 있음. 클래스 선언이 JVM에 올라갈 때 이미 생기는 변수!!
	
	private static Queue_impl queue = new Queue_impl();
	private LinkedList<Integer> list = new LinkedList<Integer>(); 
	private static Object monitor = new Object();
	
	// 이와 같이 하면 객체가 두 번 이상 만들어질 수가 있기 때문에(스레드들이 접근하는 경우, thread들을 time-slicing하여 실행시), singleton pattern이라고 볼 수가 없다!!!
	/*
	public static Queue_impl getInstance() {
		if(queue==null){
			queue = new Queue_impl();
		}
		return queue;
	}*/
	public static Queue_impl getInstance(){
		return queue;
	}
	
	// default 생성자를 private으로 설정해 놓음으로써 클래스 외부에서 생성자를 호출 못하도록 제한한다!!
	private Queue_impl(){
		
	}
	
	@Override
	public void put(int item) {
		synchronized(monitor){
			list.addLast(item);
			monitor.notify(); // monitor.wait()로 대기상태 돌입한 애들한테 신호를 보내서 깨워줌!	
		}
	}

	@Override
	public int pop() {
		// 공유 자원이 linkedlist에서 맨 앞에 있는 숫자 하나를 뽑아서 리턴시키는 일을 할 거에요.
		int result = 0;
		synchronized(monitor){
			// 2가지 경우
			if(list.isEmpty()){
				// 현재 linkedlist가 비어있는 경우.
				// item이 들어올 때까지 대기타야 함!!
				try {
					monitor.wait(); // monitor를 놓으면서 block 상태가 됨. 대기타고 있다가 특정 메소드가 호출되어 신호를 받으면 다시 block 상태에서 깨어나 monitor에 접근을 시도한다!!
									// wait(), notify() 메소드 이용!!!!
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else{ // 현재 linkedlist 안에 item이 있는 경우.
				result = list.removeFirst();
			}
		}
		return result;
	}
}
