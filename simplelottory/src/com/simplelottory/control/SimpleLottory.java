package com.simplelottory.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.simplelottory.control.LottoryManager.LottoryType;
import com.simplelottory.model.Lottory;
import com.simplelottory.model.Pool;

/*
 * main class
 */
public class SimpleLottory {

	public static LottoryManager manager = new LottoryManager();

	public static void main(String s[]) {
		init();
		manager.shuffleAll();
		manager.draw(LottoryType.BigLotto);
		System.out.println(manager.getLottory(LottoryType.BigLotto).getDrewNumbers(0));
		System.out.println(manager.getLottory(LottoryType.BigLotto).getDrewNumbers(1));
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String read;
		try {
			while((read=br.readLine())!=null) {
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void init() {
		Lottory bigLotto = new Lottory(new BigLottoDraw(), new Pool(7, 6), new Pool(1));
		Lottory lotto539 = new Lottory(new Pool(39, 5));
		Lottory superlotto = new Lottory(new Pool(38, 6), new Pool(8, 1));
		manager.addLottory(LottoryType.BigLotto, bigLotto);
		manager.addLottory(LottoryType.Lotto539, lotto539);
		manager.addLottory(LottoryType.SuperLotto, superlotto);
	}
}
