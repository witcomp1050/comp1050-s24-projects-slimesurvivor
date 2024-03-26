package application;

public class Item extends Sprite {
	private String name;
	private String description;
	private int value;
	private String rarity;

	Item(String name, String description, int value, String rarity) {
		this.name = name;
		this.description = description;
		this.value = value;
		this.rarity = rarity;
	}

	public String getname() {
		return name;
	}

	public String getdescription() {
		return description;
	}

	public int getvalue() {
		return value;
	}

	public String getrarity() {
		return rarity;
	}

	public void setValue(int value) {
		this.value = value;
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

//method can be used for when the item is used
	public void use() {
	}
}
