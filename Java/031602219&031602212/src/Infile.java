import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infile {

	public void readfile(String path,int w,int m,int n) {
		
		int w_title,w_content,lines,characters,words;
		String strline = new String();
		String t_str = new String();
		String c_str = new String();
		String title_regex = "Title: (.+)";
		String content_regex = "Abstract: (.+)";
		
		System.out.println("reading.....................");
		
		try {
			FileInputStream file = new FileInputStream(path);	//构造文件流
			InputStreamReader reader = new InputStreamReader(file);		//文件流读取
			BufferedReader buffReader = new BufferedReader(reader);	
			w_title = w*10+(w-1)*(-1); w_content = 1; 
			lines=0; characters=0; words=0;
			Pattern t_pat = Pattern.compile(title_regex);
			Pattern c_pat = Pattern.compile(content_regex);
			while((strline = buffReader.readLine())!=null){
				System.out.println(strline);
				Matcher t_mat = t_pat.matcher(strline);
				Matcher c_mat = c_pat.matcher(strline);
				if(t_mat.find()) {
					t_str=t_mat.group(1).toLowerCase();
					characters += t_str.length()+1;
					lines++;
				}
				if(c_mat.find()) {
					c_str=c_mat.group(1).toLowerCase();
					characters += c_str.length();
					lines++;
				}
			}
			buffReader.close();
			System.out.println("characters: " + characters);
			System.out.println("words: " + words);
			System.out.println("lines: " + lines);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
