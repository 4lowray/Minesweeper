/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minesweeper;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;
import static minesweeper.Minesweeper.LOG;

/**
 *
 * @author loreb
 */
public class Board extends JComponent{
    private ArrayList<Tile> tiles = new ArrayList();
    private int hor;
    private int ver;
    private int bombs;
    
    public Board(int hor, int ver, int bombs)
    {
        this.hor = hor;
        this.ver = ver;
        this.setLayout(new GridLayout(ver, hor));
        for (int i = 0; i < (hor * ver); i++)
        {
            tiles.add(new Tile(i, this));
            //tiles.add(new JButton(String.valueOf(i)));
            tiles.get(i).setVisible(true);
            this.add(tiles.get(i));
            
        }
        for (int i = 0; i < bombs; i++)
        {
            Random rng = new Random();
            tiles.get(rng.nextInt(hor * ver)-1).placeBomb();
        }
        for (int i = 0; i < (hor * ver); i++)
        {
            if (tiles.get(i).getBomb() == false)
            {
                tiles.get(i).setBombsNear(bombsNear(i));
            }
        }
        this.setVisible(true);
    }
    
    public int bombsNear(int tile)
    {
        int bombs = 0;
        for (int i = 0; i < 8; i++)
        {
            int ytile = tile / hor;
            int xtile = tile - (hor * ytile);
            //System.out.println("Tile " + tile + " calculation number " + i + " ytile: " + ytile + " x tile: " + xtile);
            LOG.info("Tile " + tile + " calculation number " + i + " ytile: " + ytile + " x tile: " + xtile);
            switch (i)
            {
                case 0:
                    ytile += 1;
                    break;
                case 1:
                    ytile -= 1;
                    break;
                case 2:
                    xtile += 1;
                    break;
                case 3:
                    xtile -= 1;
                    break;
                case 4: 
                    ytile += 1;
                    xtile += 1;
                    break;
                case 5:
                    ytile -= 1;
                    xtile += 1;
                    break;
                case 6:
                    ytile += 1;
                    xtile -= 1;
                    break;
                case 7:
                    ytile -= 1;
                    xtile -= 1;
                    break;
            }
            if ((ytile >= 0) && (ytile < ver) && (xtile >= 0) && (xtile < hor))
            {
                if (tiles.get(ytile*hor+xtile).getBomb())
                {
                    bombs++;
                }
            }
        }
        return bombs;
    }
    
    public int getVer()
    {
        return ver;
    }
    
    public Tile getTile(int i)
    {
        return tiles.get(i);    
    }
    
    public int getMaxSize()
    {
        return hor * ver;
    }
    
    public void revealZeros(int tile)
    {
        for (int i = 0; i < 8; i++)
        {
            int ytile = tile / hor;
            int xtile = tile - (hor * ytile);
            //System.out.println("Tile " + tile + " calculation number " + i + " ytile: " + ytile + " x tile: " + xtile);
            LOG.info("Tile " + tile + " calculation number " + i + " ytile: " + ytile + " x tile: " + xtile);
            switch (i)
            {
                case 0:
                    ytile += 1;
                    break;
                case 1:
                    ytile -= 1;
                    break;
                case 2:
                    xtile += 1;
                    break;
                case 3:
                    xtile -= 1;
                    break;
                case 4: 
                    ytile += 1;
                    xtile += 1;
                    break;
                case 5:
                    ytile -= 1;
                    xtile += 1;
                    break;
                case 6:
                    ytile += 1;
                    xtile -= 1;
                    break;
                case 7:
                    ytile -= 1;
                    xtile -= 1;
                    break;
            }
            if ((ytile >= 0) && (ytile < ver) && (xtile >= 0) && (xtile < hor))
            {
                if (tiles.get(ytile*hor+xtile).getBomb() == false)
                {
                    tiles.get(ytile*hor+xtile).reveal();
                }
            }
        }
    }
    
}
