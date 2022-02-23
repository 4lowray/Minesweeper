package minesweeper;

import javax.swing.JLabel;

public class Score extends JLabel{
	
	public static Score INSTANCE;
	private int score;
	
	public Score(int score)
	{
		INSTANCE = this;
		this.score = score;
		this.setText("Score: " + String.valueOf(this.score));
	}
	
	public void addScore(int score)
	{
		this.score += score;
		this.setText("Score: " + String.valueOf(this.score));
	}
	
	public void gameOver()
	{
		this.setText("GAME OVER. Final Score: " + String.valueOf(this.score));
	}
}
