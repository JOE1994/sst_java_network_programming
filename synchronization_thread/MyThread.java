package synchronization_thread;

public class MyThread implements Runnable{

	SharedObject obj;
	public static final Object monitor = new Object(); // 여기서는 뜬금없는 empty object. 그냥 동기화 위한 모니터에요!
	
	public MyThread(SharedObject obj){
		this.obj = obj;
	}
	
	// 공유객체를 사용하는 business method를 작성해보아요~
	/*
	public void printObj(){
		obj.printList();
	}*/
	
	// eclipse의 콘솔 출력 자체도 스레드로 구현(eclipse자체가 스레드로 구현)되어 있어서 실제 스레드 실행 순서와 출력 순서가 종종 다를 때가 있다능!
	
	// synchronized 붙이면, 순차처리가 됨. 먼저 온 놈이 다 끝날 때까지 다른 애들은 대기!
	// synchronized만 붙여주면, 알아서 동기화를 해줌. 동기화 메소드가 됨!!!
	// 근데, 이 경우는 method 자체가 동기화 되어버려서 효율이 안 좋을 수가 있어요!
	// 메소드 전체를 동기화 하는 경우는, 메소드가 아주 짧지 않은 이상 쓰지 않는 것이 바람직해요!
	// 일정 부분만을 동기화시키기 위해 monitor를 써서 monitor block을 만든다!
	/*
	public synchronized void printObj(){
		obj.printList();
	}*/
	
	public void printObj() {
		//동기화 필요한 부분만 동기화 블록 처리. synchronized block!
		synchronized(monitor){ // 모니터!!
			obj.printList();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		printObj();
		
	}
	
}
