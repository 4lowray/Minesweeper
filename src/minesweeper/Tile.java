/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static minesweeper.Minesweeper.LOG;

/**
 *
 * @author loreb
 */
public class Tile extends JButton implements ActionListener{
    
    private boolean bomb;
    private int near;
    private Board owner;
    private int name;
    private boolean revealed;
    
    public Tile(int name, Board board)
    {
        LOG.info("Tile " + name + " created");
        this.setFocusable(false);
        this.addActionListener(this);
        owner = board;
        this.name = name;
        this.revealed = false;
    }
    
    public boolean getBomb()
    {
        return bomb;
    }
    
    public int getNear()
    {
        return near;
    }
    
    public void placeBomb()
    {
        bomb = true;
    }

    public void setBombsNear(int i)
    {
        near = i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (revealed == false)
        {
            if (bomb)
            {
                this.setText("BOOM");
                revealed = true;
                owner.setOffBomb();
            }
            else
            {
                this.setText(String.valueOf(near));
                Score.INSTANCE.addScore(10);
                if (near == 0)
                {
                    owner.revealZeros(name);
                }
                revealed = true;
                owner.updateRemainingTiles();
            }
        }
    }
    
    public void reveal()
    {
        if (revealed == false)
        {
            this.setText(String.valueOf(near));
            revealed = true;
            Score.INSTANCE.addScore(10);
            if (near == 0)
            {
                owner.revealZeros(name);
            }
            owner.updateRemainingTiles();
        }
    }
    
    public void endGame()
    {
    	if ((bomb) && (revealed == false))
    	{
    		this.setText("bomb");
    	}
    	else if (!bomb)
    	{
    		this.setText(String.valueOf(near));
    	}
    }

	public boolean getRevealed() {
		// TODO Auto-generated method stub
		return revealed;
	}
    
}
