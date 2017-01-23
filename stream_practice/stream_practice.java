package stream_practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class stream_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
		try {
			File f = new File("D:/hellotest.txt");
			if(!f.exists())	f.createNewFile();
			
			FileWriter wtr = new FileWriter(f);
			String str;
			while((str = rdr.readLine()) != null){
				wtr.write(str+System.getProperty("line.separator"));
			}
			wtr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
