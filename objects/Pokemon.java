package objects;

public class Pokemon {
	// TYPES
	public static final int FIRE = 0, WATER = 1, GRASS = 2, GROUND = 3, ROCK = 4, DARK = 5, GHOST = 6, STEEL = 7, ELECTRIC = 8, FLYING = 9, DRAGON = 10, ICE = 11, PSYCHIC = 12,
			POISON = 13, FIGHTING = 14, NORMAL = 15;
	public String name;
	public boolean male = true;
	public int type, height, weight;
	public int max_health, attack, defense, agility, special, current_health, level;
	public int IV_atk, IV_def, IV_agi, IV_spec, IV_HP;
	public int base_HP, base_atk, base_def, base_agi, base_spec;

	public void generate_stats(int lvl) {

	}
	
	
	//formula for stats =    (IV + Base) x Level
	//                  =    -------------------  + 5
	//                  =            50
	//note: HP is slightly different
	public void update_stats(){
		this.attack = ((IV_atk + base_atk) * level)/50 + 5;
		this.defense = ((IV_def + base_def) * level)/50 + 5;
		this.agility = ((IV_agi + base_agi) * level)/50 + 5;
		this.special= ((IV_spec + base_spec) * level)/50 + 5;
		
		this.max_health = ((IV_HP + base_HP + 50) * level)/50 + 10;
	}
}
