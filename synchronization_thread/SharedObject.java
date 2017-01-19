package synchronization_thread;

import java.util.ArrayList;

public class SharedObject {
	
	ArrayList<String> list = new ArrayList<String>();
	
	public SharedObject(){
		list.add("1번 홍길동");
		list.add("2번 이순신");
		list.add("3번 강감찬");
		list.add("4번 영석이");
	}
	
	public void printList(){
		for(String t:list){
			System.out.println(t);
		}
	}
	
}
