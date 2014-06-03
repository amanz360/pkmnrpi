package objects;

public class Flag {
	public static final int ITEM_FLAG = 0, DOOR_FLAG = 1, NPC_FLAG = 2, VIEW_FLAG = 3;
	private TileMap map;
	public Person lnk;
	public int x, y, flag;

	public Flag(TileMap m) {
		map = m;
	}

	public Flag(TileMap m, int x, int y, int f) {
		map = m;
		this.x = x;
		this.y = y;
		flag = f;
	}

	public Flag(Flag f) {
		map = f.map;
		flag = f.flag;
		x = f.x;
		y = f.y;
	}

	public Flag(TileMap m, String str) {
		map = m;
		String[] ary = str.split(":");
		flag = Integer.parseInt(ary[0]);
		x = Integer.parseInt(ary[1]);
		y = Integer.parseInt(ary[2]);
		if (ary.length > 3)
			;// TODO link to person
	}

	/**
	 * IMPORTANT! SAVE FORMAT
	 * 
	 * [flag]:[x]:[y]:[name]
	 * 
	 */

	@Override
	public String toString() {
		String str = flag + ":" + x + ":" + y;
		if (lnk != null)
			str += ":" + lnk.name;
		return str;
	}

	public boolean isAt(int x, int y) {
		return this.x == x && this.y == y;
	}
}
