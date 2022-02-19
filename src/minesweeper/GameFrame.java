/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minesweeper;

import javax.swing.JFrame;

/**
 *
 * @author loreb
 */
public class GameFrame extends JFrame{
    
    public GameFrame(String title)
    {
        this.setTitle(title);
        this.setSize(800, 800);
        this.setResizable(true);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
    
}
