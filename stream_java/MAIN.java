package stream_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MAIN {

	public static void main(String[] args) {
		
		// 키보드로부터 한 라인을 입력받을꺼에요!!
		// 입력받은 내용을 그대로 화면에 표준출력으로 내보낼 거에요!!
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String input = br.readLine(); // 한 줄이 입력될 때까지 blocking 상태가 됨. (blocking method).
			
			System.out.println("홍길동 > "+input);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
