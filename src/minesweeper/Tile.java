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
    
    public Tile(boolean bomb, int name)
    {
        this.setFocusable(false);
        this.bomb = bomb;
        if (bomb)
        {
            this.setText("bomb");
        }
    }
    
    public boolean getBomb()
    {
        return bomb;
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
