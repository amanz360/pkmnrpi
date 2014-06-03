package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ImageLibrary {
	public static ImageIcon[] icons, front_sprites, back_sprites, small_sprites;
	public static BufferedImage[] image_sheets;
	public static final String[] image_sheet_names = { "src/tileset.png", "src/front_sprites.png", "src/back_sprites.png" };
	public static final int[] pixel_width = { 16, 56, 56 };
	public static final ImageIcon blank = new ImageIcon("src/blank.png");
	public static final int DEFAULT_ICON = 0;

	public static void init() {
		// Initilize the image sheet array
		image_sheets = new BufferedImage[image_sheet_names.length];
		// Load each image sheet from the list of names
		ArrayList<ArrayList<BufferedImage>> lst = new ArrayList<ArrayList<BufferedImage>>();
		for (int i = 0; i < image_sheet_names.length; ++i) {
			// Load the image
			Image im = (new ImageIcon(image_sheet_names[i])).getImage();
			int w = im.getWidth(null), h = im.getHeight(null);
			// Create the new buffered image
			image_sheets[i] = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			// Draw the image on to the buffered image
			image_sheets[i].getGraphics().drawImage(im, 0, 0, w, h, 0, 0, w, h, null);
			// Now the sheets are cut up into the icons
			lst.add(Tileizer.cutter(image_sheets[i], w, h, pixel_width[i], pixel_width[i], Integer.MAX_VALUE));
		}

		// Create icons, the array of image icon
		icons = new ImageIcon[195]; // There are currently 195 background tiles.
									// expect more
		icons[0] = blank;
		int count = 1;
		int[] good_tiles = { 133, 31, 34, 37, 64, 3, 13, 23, 1, 2, 4, 5, 6, 7, 8, 9, 0, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 24, 25, 26, 27, 28, 29, 30, 32, 33, 35, 36,
				38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
				80, 81, 82, 83, 84, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116,
				117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 134, 135, 136, 137, 138, 139, 140, 141, 142, 144, 145, 146, 147, 148, 149, 150,
				151, 152, 154, 155, 156, 157, 158, 159, 160, 161, 162, 164, 165, 166, 167, 168, 169, 170, 171, 172, 174, 175, 176, 177, 178, 179, 180, 181, 182, 184, 185, 186,
				190, 191, 192, 194, 195, 196, 200, 201, 202, 204, 205, 206 };
		for (int i : good_tiles)
			icons[count++ ] = new ImageIcon(lst.get(0).get(i));

		// Create front sprites, an array of image icons
		front_sprites = new ImageIcon[250]; // One for each pokemon
		for (int i = 0; i < front_sprites.length; ++i)
			front_sprites[i] = new ImageIcon(lst.get(1).get(i));
		// Create back sprites, an array of image icons
		back_sprites = new ImageIcon[250]; // One for each pokemon
		for (int i = 0; i < 201; ++i)
			back_sprites[i] = new ImageIcon(lst.get(2).get(i));
		for (int i = 228; i < 277; ++i)
			back_sprites[i - 27] = new ImageIcon(lst.get(2).get(i));
		// Create small sprites, an array of image icons
	}
}
