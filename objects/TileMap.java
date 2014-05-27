package objects;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import util.Tileizer;


public class TileMap {
	public static ArrayList<BufferedImage> tiles;
	public static ArrayList<ImageIcon> icons;
	
	public int[][] mapdata;
	
	public TileMap() {
		mapdata = new int[25][25];
		for(int i = 0; i < mapdata.length; ++i)
			for(int k = 0; k < mapdata[0].length; ++k);
	}
	
	public TileMap(int x, int y) {
		mapdata = new int[y][x];
	}
	
	public TileMap(int[][] map) {
		mapdata = map;
	}
	
	public void buffer_bottom_rows(int n) {
		assert n > 0;
		int[][] temp = new int[mapdata.length+n][mapdata[0].length];
		for(int i = 0; i < temp.length; ++i)
			for(int k = 0; k < temp[0].length; ++k)
				temp[i][k] = 0;
		for(int i = 0; i < mapdata.length; ++i)
			for(int k = 0; k < mapdata[0].length; ++k)
				temp[i][k] = mapdata[i][k];
		mapdata = temp;
	}
	
	public void buffer_top_rows(int n) {
		assert n > 0;
		int[][] temp = new int[mapdata.length+n][mapdata[0].length];
		for(int i = 0; i < temp.length; ++i)
			for(int k = 0; k < temp[0].length; ++k)
				temp[i][k] = 0;
		for(int i = 0; i < mapdata.length; ++i)
			for(int k = 0; k < mapdata[0].length; ++k)
				temp[n+i][k] = mapdata[i][k];
		mapdata = temp;
	}
	
	public void buffer_right_cols(int n) {
		assert n > 0;
		int[][] temp = new int[mapdata.length][mapdata[0].length+n];
		for(int i = 0; i < temp.length; ++i)
			for(int k = 0; k < temp[0].length; ++k)
				temp[i][k] = 0;
		for(int i = 0; i < mapdata.length; ++i)
			for(int k = 0; k < mapdata[0].length; ++k)
				temp[i][k] = mapdata[i][k];
		mapdata = temp;
	}
	
	public void buffer_left_cols(int n) {
		assert n > 0;
		int[][] temp = new int[mapdata.length][mapdata[0].length+n];
		for(int i = 0; i < temp.length; ++i)
			for(int k = 0; k < temp[0].length; ++k)
				temp[i][k] = 0;
		for(int i = 0; i < mapdata.length; ++i)
			for(int k = 0; k < mapdata[0].length; ++k)
				temp[i][k+n] = mapdata[i][k];
		mapdata = temp;
	}
	
	public static void populate_tiles() {
		tiles = Tileizer.tile_maker("src/tileset.png", 200);
		icons = new ArrayList<ImageIcon>();
		for(BufferedImage im : tiles) {
			icons.add(new ImageIcon(im));
		}
	}

}
