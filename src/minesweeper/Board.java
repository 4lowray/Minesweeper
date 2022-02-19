/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minesweeper;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author loreb
 */
public class Board extends JComponent{
    private ArrayList<Tile> tiles = new ArrayList();
    private int hor;
    private int ver;
    
    public Board(int hor, int ver)
    {
        this.hor = hor;
        this.ver = ver;
        this.setLayout(new GridLayout(ver, hor));
        for (int i = 0; i < (hor * ver); i++)
        {
            Random bool = new Random();
            tiles.add(new Tile(bool.nextBoolean(), i));
            //tiles.add(new JButton(String.valueOf(i)));
            tiles.get(i).setVisible(true);
            this.add(tiles.get(i));
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
            int xtile = tile - (ver * ytile);
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
    
}
