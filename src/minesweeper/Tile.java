/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author loreb
 */
public class Tile extends JButton implements ActionListener{
    
    private boolean bomb;
    private int near;
    
    public Tile(int name)
    {
        this.setFocusable(false);
        this.addActionListener(this);
        this.setText("X");
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (bomb)
        {
            this.setText("BOOM");
        }
        else
        {
            this.setText(String.valueOf(near));
        }
    }
    
}
