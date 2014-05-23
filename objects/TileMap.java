package objects;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import util.Tileizer;


public class TileMap {
	public static ArrayList<BufferedImage> tiles;
	
	public int[][] mapdata;
	
	public TileMap(int[][] map) {
		mapdata = map;
	}
	
	public static void populate_tiles() {
		tiles = Tileizer.tile_maker("src/tileset.png", 200);
	}

}
