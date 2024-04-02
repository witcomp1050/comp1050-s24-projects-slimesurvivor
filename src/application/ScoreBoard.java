package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ScoreBoard {
	File file;
	Scanner fileReader;
	String line = "";
	public ScoreBoard(String filePath){
		this.file = new File(filePath);
		try {
			this.fileReader = new Scanner(this.file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readScoreBoard();

	}
	public ScoreBoard() {
		this.file = new File("ScoreBoard.txt");
		try {
			this.fileReader = new Scanner(this.file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readScoreBoard();
	}
	private String readScoreBoard() {
		while(this.fileReader.hasNextLine()) {
			line+=this.fileReader.nextLine();
			line+="\n";
		}
		return this.line;
	}
	public String getScoreBoard() {
		return line;
	}
	public boolean addScore(String score) {
		ArrayList<String> topScores = new ArrayList<String>(Arrays.asList(this.line.split("\n")));
		int scoreNum = scoreToNum(score);
		int[] topTimes = new int[10];
		for(int i=0;i<topScores.size();i++) {
			topTimes[i] = scoreToNum(topScores.get(i));
		}
		for(int i=0;i<topTimes.length;i++) {
			System.out.println(scoreNum);
			System.out.println(topTimes[i]);
			if(topTimes[i] < scoreNum) {
				System.out.println("NEW HIGHSCORE");
				topScores.add(i, score);
				topScores.remove(10);
				this.line = String.join("\n",topScores);
				try {
					PrintWriter fileWriter = new PrintWriter("ScoreBoard.txt");
					fileWriter.print(this.line);
					fileWriter.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(i==0) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	private int scoreToNum(String score) {
		score = score.replace(":", "");
		return Integer.parseInt(score);
	}
}
