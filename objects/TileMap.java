package objects;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import util.Tileizer;

public class TileMap {
	public static ArrayList<BufferedImage> tiles;
	public static ArrayList<ImageIcon> icons;
	public static final ImageIcon blank = new ImageIcon("src/blank.png");
	public static final int DEFAULT_ICON = 0;

	public int[][] mapdata;

	public TileMap() {
		mapdata = new int[25][25];
		clear_map();
	}

	public TileMap(int x, int y) {
		mapdata = new int[y][x];
		clear_map();
	}

	public TileMap(int[][] map) {
		mapdata = map;
	}

	public void clear_map() {
		for (int i = 0; i<mapdata.length; ++i)
			for (int k = 0; k<mapdata[0].length; ++k)
				mapdata[i][k] = DEFAULT_ICON;
	}

	public void save(File file) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(mapdata.length+":"+mapdata[0].length);
			for (int i = 0; i<mapdata.length; ++i) {
				for (int j = 0; j<mapdata[0].length; ++j) {
					out.write(":"+mapdata[i][j]);
				}
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(File file) {
		String str = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();

			while (line!=null) {
				str += line;
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] ary = str.split(":");
		int a = Integer.parseInt(ary[0]);
		int b = Integer.parseInt(ary[1]);
		mapdata = new int[a][b];
		for (int i = 0; i<a; ++i) {
			for (int j = 0; j<b; ++j) {
				mapdata[i][j] = Integer.parseInt(ary[2+i*b+j]);
			}
		}
	}

	public void buffer_bottom_rows(int n) {
		assert n>0;
		int[][] temp = new int[mapdata.length+n][mapdata[0].length];
		for (int i = 0; i<temp.length; ++i)
			for (int k = 0; k<temp[0].length; ++k)
				temp[i][k] = DEFAULT_ICON;
		for (int i = 0; i<mapdata.length; ++i)
			for (int k = 0; k<mapdata[0].length; ++k)
				temp[i][k] = mapdata[i][k];
		mapdata = temp;
	}

	public void buffer_top_rows(int n) {
		assert n>0;
		int[][] temp = new int[mapdata.length+n][mapdata[0].length];
		for (int i = 0; i<temp.length; ++i)
			for (int k = 0; k<temp[0].length; ++k)
				temp[i][k] = DEFAULT_ICON;
		for (int i = 0; i<mapdata.length; ++i)
			for (int k = 0; k<mapdata[0].length; ++k)
				temp[n+i][k] = mapdata[i][k];
		mapdata = temp;
	}

	public void buffer_right_cols(int n) {
		assert n>0;
		int[][] temp = new int[mapdata.length][mapdata[0].length+n];
		for (int i = 0; i<temp.length; ++i)
			for (int k = 0; k<temp[0].length; ++k)
				temp[i][k] = DEFAULT_ICON;
		for (int i = 0; i<mapdata.length; ++i)
			for (int k = 0; k<mapdata[0].length; ++k)
				temp[i][k] = mapdata[i][k];
		mapdata = temp;
	}

	public void buffer_left_cols(int n) {
		assert n>0;
		int[][] temp = new int[mapdata.length][mapdata[0].length+n];
		for (int i = 0; i<temp.length; ++i)
			for (int k = 0; k<temp[0].length; ++k)
				temp[i][k] = DEFAULT_ICON;
		for (int i = 0; i<mapdata.length; ++i)
			for (int k = 0; k<mapdata[0].length; ++k)
				temp[i][k+n] = mapdata[i][k];
		mapdata = temp;
	}

	public static void populate_tiles() {
		tiles = Tileizer.tile_maker("src/tileset.png", 200);
		icons = new ArrayList<ImageIcon>();
		icons.add(blank);
		for (BufferedImage im : tiles) {
			//icons.add(new ImageIcon(im.getScaledInstance(Tileizer.WIDTH, Tileizer.WIDTH, BufferedImage.SCALE_SMOOTH)));
			icons.add(new ImageIcon(im));
		}
	}

}
