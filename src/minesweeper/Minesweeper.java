/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minesweeper;

import javax.swing.SwingUtilities;

/**
 *
 * @author loreb
 */
public class Minesweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameFrame frame = new GameFrame("Minesweeper");
        Board board = new Board(5, 5, 3);
        frame.add(board);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    
}
