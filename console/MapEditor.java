package console;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objects.TileMap;
import objects.Tile;
import util.Tileizer;

public class MapEditor extends JPanel {
	private JPanel selection, creation;
	private Tile[] mytiles, newtiles;
	public int s_width = 10, c_width = 25, c_height = 25;
	private int paint_bucket = TileMap.DEFAULT_ICON;
	private TileMap tmap;

	public MapEditor() {
		init();
	}

	public void init() {
		this.setBackground(Color.gray.darker());
		// this.setLayout(new GridLayout(1, 2, 2, 2));
		this.setSize(new Dimension((c_width+s_width)*(Tileizer.WIDTH+1), c_height*(Tileizer.WIDTH+1)-1));

		selection = new JPanel();
		creation = new JPanel();

		selection.setBackground(Color.BLACK);
		selection.setLayout(new GridLayout(c_height, s_width, 1, 1));
		selection.setSize(s_width*(Tileizer.WIDTH+1)-1, c_height*(Tileizer.WIDTH+1)-1);

		creation.setBackground(Color.black);
		creation.setLayout(new GridLayout(c_height, c_width, 1, 1));
		creation.setSize(c_width*(Tileizer.WIDTH+1)-1, c_height*(Tileizer.WIDTH+1)-1);
		creation.setMaximumSize(new Dimension(c_width*(Tileizer.WIDTH+1)-1, c_height*(Tileizer.WIDTH+1)-1));

		this.add(selection);
		this.add(creation);

		MELabelListener1 l1 = new MELabelListener1(this);
		MELabelListener2 l2 = new MELabelListener2(this);

		// Initilize Pallet
		TileMap.populate_tiles();
		mytiles = new Tile[s_width*c_height];
		for (int i = 0; i<c_height; ++i) {
			for (int j = 0; j<s_width; ++j) {
				if (i*s_width+j>=TileMap.tiles.size()) {
					Tile temp = new Tile(j, i, i*s_width+j, -1);
					temp.setSize(Tileizer.WIDTH, Tileizer.WIDTH);
					selection.add(temp);
					mytiles[i*s_width+j] = temp;
					temp.setVisible(true);
					temp.addMouseListener(l1);
				} else {
					Tile temp = new Tile(TileMap.icons.get(i*s_width+j), j, i, i*s_width+j, i*s_width+j);
					temp.setSize(Tileizer.WIDTH, Tileizer.WIDTH);
					selection.add(temp);
					mytiles[i*s_width+j] = temp;
					temp.setVisible(true);
					temp.addMouseListener(l1);
				}
			}
		}

		tmap = new TileMap(c_width, c_height);

		// Initilize new map
		newtiles = new Tile[c_height*c_width];
		for (int i = 0; i<c_height; ++i) {
			for (int j = 0; j<c_width; ++j) {
				Tile temp = new Tile(TileMap.icons.get(tmap.mapdata[i][j]), j, i, i*c_width+j, tmap.mapdata[i][j]);
				temp.setSize(Tileizer.WIDTH, Tileizer.WIDTH);
				creation.add(temp);
				newtiles[i*c_width+j] = temp;
				temp.setVisible(true);
				temp.addMouseListener(l2);
			}
		}
	}

	public void save(File file) {
		// TODO
	}

	public void load(File file) {
		// TODO
	}

	// BROKEN
	public void clear_all() {
		super.removeAll();
		init();
		repaint();
	}

	public void selected(Object o) {
		int i = mytiles.length-1;
		while (i>=0) {
			if (mytiles[i]==o) {
				System.out.println("Current selection changed to #"+i);
				paint_bucket = i;
				return;
			}
			--i;
		}
		System.out.println("ERROR: Selected Icon not found!!!");
	}

	public void apply_to(Object o) {
		Tile t = (Tile) o;
		t.setIcon(TileMap.icons.get(paint_bucket));
		tmap.mapdata[t.y][t.x] = paint_bucket;
		t.id = paint_bucket;
		repaint();
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Map Editor");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MapEditor m = new MapEditor();
		f.add(m);
		f.setJMenuBar(new MEBar(m));
		f.pack();
		f.setVisible(true);
	}

}
