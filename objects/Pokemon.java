package objects;

public class Pokemon {
	// TYPES
	public static final int FIRE = 0, WATER = 1, GRASS = 2, GROUND = 3, ROCK = 4, DARK = 5,
			GHOST = 6, STEEL = 7, ELECTRIC = 8, FLYING = 9, DRAGON = 10, ICE = 11, 
			PSYCHIC = 12, POISON = 13, FIGHTING = 14, NORMAL = 15;
	public String name;
	public boolean male = true;
	public int type, height, weight;
	public int max_health, attack, defense, speed, spec_attack, spec_defense, current_health, level;
	
	private void generate_stats(int lvl) {
		
	}
}
