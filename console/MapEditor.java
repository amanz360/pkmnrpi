package console;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import objects.TileMap;
import util.Tileizer;

public class MapEditor extends JPanel{
	private JPanel selection, creation;
	private JLabel[] mytiles, newtiles;
	
	public MapEditor() {
		this.setBackground(Color.red);
		this.setLayout(new GridLayout(1, 2, 2, 2));
		
		selection = new JPanel();
		creation = new JPanel();
		
		selection.setBackground(Color.BLACK);
		selection.setLayout(new GridLayout(25, 10, 1, 1));
		
		creation.setBackground(Color.black);
		creation.setLayout(new GridLayout(25, 25, 1, 1));
		
		this.add(selection);
		this.add(creation);
		
		TileMap.populate_tiles();
		mytiles = new JLabel[250];
		for(int i = 0; i < 250; ++i) {
			if(i >= TileMap.tiles.size()) {
				JLabel temp = new JLabel();
				temp.setSize(Tileizer.WIDTH, Tileizer.WIDTH);
				selection.add(temp);
				mytiles[i] = temp;
				temp.setVisible(true);
			} else {
				JLabel temp = new JLabel(TileMap.icons.get(i));
				temp.setSize(Tileizer.WIDTH, Tileizer.WIDTH);
				selection.add(temp);
				mytiles[i] = temp;
				temp.setVisible(true);
			}
		}
		
		// Initilize new map
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Map Editor");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		f.setVisible(true);
		MapEditor m = new MapEditor();
		f.add(m);
		f.pack();
	}

}
