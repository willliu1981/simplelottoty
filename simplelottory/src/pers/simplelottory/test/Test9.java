package pers.simplelottory.test;

public class Test9 {

	public static void main(String[] args) {
		TT t=new TT();
		t.a=22;
		
		TT t2=new TT();
		t2.a=t.a;
		t2.a=33;
		
		System.out.println(t.a);
	}
	
	public static class TT{
		Integer a;
	}

}
