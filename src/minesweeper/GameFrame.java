/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minesweeper;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
        Score score = new Score(0);
        Board board = new Board(5, 8, 3);
        Info info = new Info();
        this.setLayout(new BorderLayout());
        this.add(board, BorderLayout.CENTER);
        this.add(score, BorderLayout.SOUTH);
        this.add(info, BorderLayout.NORTH);
        SwingUtilities.updateComponentTreeUI(this);
    }
   
}
