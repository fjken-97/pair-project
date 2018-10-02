import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Infile {

	public void readfile(String path,int w,int m,int n) {
		
		int w_title,w_content;
		
		try {
			FileInputStream file = new FileInputStream(path);	//构造文件流
			InputStreamReader reader = new InputStreamReader(file);		//文件流读取
			BufferedReader buffReader = new BufferedReader(reader);	
			w_title = w*10+(w-1)*(-1);
			w_content = 1;
			System.out.println(w_title);
			System.out.println(w_content);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
