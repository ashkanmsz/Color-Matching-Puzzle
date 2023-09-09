package ir.ac.guilan.ashkan;

import javax.swing.Icon;
/**
 * 
 * in this class we make our player with its propties
 *
 */

public class Player {
	
	private static String name;
	private static int line;
	private static int column;
	private static int poke;
	private static int color;
	private static Icon icn;

	public Player() {

	}
	public Player(String name, int line, int column, int poke, int color,Icon icn) {
		this.name = name;
		this.line = line;
		this.column = column;
		this.poke = poke;
		this.color = color;
		this.icn=icn;
	}
	public int getLine() {
		return Player.line;
	}
	public String getName() {
		return Player.name;
	}

	public int getColumn() {
		return Player.column;
	}

	public int getPoke() {
		return Player.poke;
	}

	public int getColor() {
		return Player.color;
	}	
}
