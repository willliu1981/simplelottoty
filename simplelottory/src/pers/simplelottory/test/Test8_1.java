package pers.simplelottory.test;

import java.util.Scanner;

public class Test8_1 {

	public static void main(String[] args) {// Volleyball
		Scanner sc = new Scanner(System.in);

		while (true) {
			// 1.隊伍數量
			System.out.println("T:");
			int T = sc.nextInt();
			if (T == 0)
				break;

			// clear input stream ( nextInt後接nextLine會錯誤)
			sc.nextLine();

			// 2.隊伍名稱
			String teams[] = new String[T];
			for (int i = 0; i < T; i++) {
				System.out.println("Teams name:");
				teams[i] = sc.nextLine();
			}
			
			// 3.賽次
			System.out.println("G:");
			int G = sc.nextInt();

			// 分數
			int[][] team_record = new int[T][G]; // 此隊伍於此場比賽之分數
			for (int i = 0; i < T; i++)
				for (int j = 0; j < G; j++)
					team_record[i][j] = 0;// 初始化

			sc.nextLine();

			// 賽次
			for (int i = 0; i < G; i++) {
				// 解析輸入(Team1-Team2:25-19 25-20 25-23)
				System.out.println("Parse ...:");
				String[] game = sc.nextLine().split(":");
				// 隊伍
				String[] team_opp = game[0].split("-");
				int teamA_ID = teamID(team_opp[0], teams);
				int teamB_ID = teamID(team_opp[1], teams);
				// 分數
				String[] score = game[1].split(" ");

				// 比分
				int win = 0;
				for (int j = 0; j < score.length; j++) {
					String[] point = score[j].split("-");
					int teamA_p = Integer.parseInt(point[0]);
					int teamB_p = Integer.parseInt(point[1]);
					// 赢局-輸局
					if (teamA_p > teamB_p) {
						team_record[teamA_ID][1]++;
						team_record[teamB_ID][1]--;
						win++;
					} else if (teamA_p < teamB_p) {
						team_record[teamA_ID][1]--;
						team_record[teamB_ID][1]++;
						win--;
					}

					// 總得分
					team_record[teamA_ID][2] += teamA_p;
					team_record[teamB_ID][2] += teamB_p;
				}
				// 勝場
				if (win > 0)
					team_record[teamA_ID][0]++;
				else if (win < 0)
					team_record[teamB_ID][0]++;

			}

			// 以勝場排序
			String temp[] = new String[T];
			int[][] temp_r = new int[T][G];
			for (int i = 0; i < T - 1; i++) {
				for (int j = i + 1; j < T; j++) {
					if (team_record[i][0] < team_record[j][0]) {
						temp[i] = teams[i];
						teams[i] = teams[j];
						teams[j] = temp[i];

						temp_r[i] = team_record[i];
						team_record[i] = team_record[j];
						team_record[j] = temp_r[i];
					}
				}
			}
			// 輸出(20)隊伍名稱、(5)勝場、(5)贏局-輸局、(20)總得分
			for (int i = 0; i < T; i++) {
				System.out.printf("%-20s%5d%5d%10d\n", teams[i], team_record[i][0], team_record[i][1],
						team_record[i][2]);
			}
			System.out.print("");
		}
		sc.close();
	}

	// 隊伍名稱轉換為:CD
	static int teamID(String team, String[] lst) {
		for (int i = 0; i < lst.length; i++)
			if (team.equals(lst[i]))
				return i;
		return -1;
	}

}
