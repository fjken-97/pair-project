import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {
	
	/*
	 * 测试-m异常处理
	 */
	@Test
	void test1() {
		String infile = new String();
		int weight;
		int member;
		int number;
		
		String args[]={"-i","test.txt","-w","1","-o","output.txt","-n","1","-m","1"}; 
		commandline cml= new commandline(args);
		
		infile = cml.infile;
		weight = Integer.parseInt(cml.weight);
		member = Integer.parseInt(cml.member);
		number = Integer.parseInt(cml.number);
		
		System.out.println(infile);
		System.out.println(weight);
		System.out.println(member);
		System.out.println(number);

	}

	/*
	 * 测试-n异常处理
	 */
	@Test
	void test2() {
		String infile = new String();
		int weight;
		int member;
		int number;
		
		String args[]={"-i","test.txt","-w","1","-o","output.txt","-n","150","-m","2"}; 
		commandline cml= new commandline(args);
		
		infile = cml.infile;
		weight = Integer.parseInt(cml.weight);
		member = Integer.parseInt(cml.member);
		number = Integer.parseInt(cml.number);
		
		System.out.println(infile);
		System.out.println(weight);
		System.out.println(member);
		System.out.println(number);
	}
	
	/*
	 * 空字符传入测试
	 */
	@Test
	void test3() {
		String infile = new String();
		int weight;
		int member;
		int number;
		
		String args[]={""}; 
		commandline cml= new commandline(args);
		
		infile = cml.infile;
		weight = Integer.parseInt(cml.weight);
		member = Integer.parseInt(cml.member);
		number = Integer.parseInt(cml.number);
		
		System.out.println(infile);
		System.out.println(weight);
		System.out.println(member);
		System.out.println(number);
	}
	
	/*
	 *正常文本测试
	 */
	@Test
	void test4() {
		String infile = new String();
		int weight;
		int member;
		int number;
		
		String args[]={"-i","test.txt","-w","1","-o","output.txt","-n","10","-m","2"}; 
		commandline cml= new commandline(args);
		
		infile = cml.infile;
		weight = Integer.parseInt(cml.weight);
		member = Integer.parseInt(cml.member);
		number = Integer.parseInt(cml.number);
		
		System.out.println("Begin.............................................");
		Infile in = new Infile();
		in.readfile(infile, weight, member, number);

		assertEquals(133,in.characters);
		assertEquals(4,in.lines);
		assertEquals(14,in.words);
		
		System.out.println("End.............................................");
	}
}
