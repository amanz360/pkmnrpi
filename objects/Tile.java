package objects;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Tile extends JLabel {
	public int x, y, idx;

	public Tile() {
		super();
	}

	public Tile(String s) {
		super(s);
	}

	public Tile(Icon i) {
		super(i);
	}

	public Tile(String s, int i) {
		super(s, i);
	}

	public Tile(Icon icon, int i) {
		super(icon, i);
	}

	public Tile(String s, Icon icon, int i) {
		super(s, icon, i);
	}

	public Tile(Icon icon, int x, int y, int idx) {
		super(icon);
		this.x = x;
		this.y = y;
		this.idx = idx;
	}

	public Tile(int x, int y, int idx) {
		super();
		this.x = x;
		this.y = y;
		this.idx = idx;
	}
}
