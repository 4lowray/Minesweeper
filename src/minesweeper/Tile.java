/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minesweeper;

import javax.swing.JButton;

/**
 *
 * @author loreb
 */
public class Tile extends JButton{
    
    private boolean bomb;
    private int near;
    
    public Tile(int name)
    {
        this.setFocusable(false);
    }
    
    public boolean getBomb()
    {
        return bomb;
    }
    
    public void placeBomb()
    {
        bomb = true;
    }

    public void setBombsNear(int i)
    {
        near = i;
        if (bomb == false)
        {
            this.setText(String.valueOf(near));
        }
    }
    
}
