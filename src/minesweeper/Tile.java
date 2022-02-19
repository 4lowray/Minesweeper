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
    
    public Tile(int name)
    {
        LOG.info("Tile " + name + " created");
        this.setFocusable(false);
        this.addActionListener(this);
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
