package pers.simplelottory.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pers.simplelottory.control.LottoryManager;
import pers.simplelottory.control.LottoryManager.LottoryType;

public class SimpleLottoryCustiomer {
	
	public static LottoryManager master_manager = new LottoryManager();
	public static LottoryManager customer_manager = new LottoryManager();
	
	public static void main(String[] args) {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String read;
		System.out.println("App start...");
		try {
			while (true) {
				read = br.readLine();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	private static void init() {
		
	}

}
