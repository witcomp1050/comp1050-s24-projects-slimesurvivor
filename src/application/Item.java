package application;

public class Item extends Sprite {
	private String name;
	private String description;
	private int damage;
	private String rarity;

	Item(String name, String description, int damage, String rarity) {
		this.name = name;
		this.description = description;
		this.damage = damage;
		this.rarity = rarity;
	}

	public String getname() {
		return name;
	}

	public String getdescription() {
		return description;
	}

	public int getvalue() {
		return damage;
	}

	public String getrarity() {
		return rarity;
	}

	public void setValue(int value) {
		this.damage = value;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public void setname(String name) {
		this.name = name;
	}

	public void setrarity(String rarity) {
		this.rarity = rarity;
	}
// used to display item info
	
	public String toString() {
		return "name" + name + "rarity" + rarity + "description" + description + " damage" + damage;
	}
	
//method can be used for when the item is used
	public void Attack() {
		System.out.println("Attacking with" + name + "for" + damage + "damage.");
	}
}
