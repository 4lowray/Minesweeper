/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minesweeper;

import javax.swing.SwingUtilities;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 *
 * @author loreb
 */
public class Minesweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        FileHandler handler = new FileHandler("log.log", true);
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        LOG.addHandler(handler);
        
        LOG.info("=============================================================Start Program=============================================================");
        GameFrame frame = new GameFrame("Minesweeper");
        Board board = new Board(5, 8, 3);
        frame.add(board);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public static final Logger LOG = Logger.getLogger(Minesweeper.class.getName());
    
}
