package objects;

public class Move {
	public static final int PARALIZE = 0, BURN = 1, SLEEP = 2, CONFUSE = 3, POISON = 4, FREEZE = 5, HYPERBEAM = 6, SOLARBEAM = 7, WRAP = 8, FOCUS_PUNCH = 9, FLY = 10, DIG = 11,
			DOUBLE_SLAP = 12, FURRY_SWIPE = 13, BULLET_SEED = 15, ARM_THRUST = 16, COMET_PUNCH = 17, ROCK_BLAST = 18;
	public int type, damage, pp, lvl_req;
	public boolean physical;
	public String name;
	public double crit_chance, hit_chance;

}
