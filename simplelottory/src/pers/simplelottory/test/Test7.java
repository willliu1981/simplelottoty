package pers.simplelottory.test;

import java.util.HashMap;
import java.util.Map;

public class Test7 {

	public static void main(String[] args) {
		AA a1=new AA(1); 
		AA a2=new AA(2); 
		
		Map<AA,String> map=new HashMap<>();
		map.put(a1, "A1");
		map.put(a2, "A2");
		map.put(a2, "A2");
		
		
		System.out.println(map.get(a2));
		System.out.println(map.size());
		
		mm();
	}
	
	public static void mm() {
		throw new RuntimeException("aaa");
	}

	public static class AA{
		public int a;
		public AA(int a) {
			this.a=a;
		}
	}
}
