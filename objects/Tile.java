package objects;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Tile extends JLabel {
	public int x, y, idx, id;

	public Tile() {super();}

	public Tile(String s) {super(s);}

	public Tile(Icon i) {super(i);}

	public Tile(String s, int i) {super(s, i);}

	public Tile(Icon icon, int i) {super(icon, i);}

	public Tile(String s, Icon icon, int i) {super(s, icon, i);}
	
	public Tile(Icon icon, int x, int y, int idx, int id) {
		super(icon);
		this.x = x;
		this.y = y;
		this.idx = idx;
		this.id = id;
	}
	
	public Tile(int x, int y, int idx, int id) {
		super();
		this.x = x;
		this.y = y;
		this.idx = idx;
		this.id = id;
	}
}
