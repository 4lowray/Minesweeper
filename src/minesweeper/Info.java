package minesweeper;

import javax.swing.JLabel;

public class Info extends JLabel{
	
	public static Info INSTANCE;
	
	public Info()
	{
		this.setText("Tiles Left: " + String.valueOf(Board.tilesRemaining));
		INSTANCE = this;
	}
	
	public void update()
	{
		this.setText("Tiles Left: " + String.valueOf(Board.tilesRemaining));
	}
}
