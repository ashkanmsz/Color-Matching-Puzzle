package ir.ac.guilan.ashkan;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;

/**
 * 
 * in this class we run the functions
 *
 */
public class Oprations {

	public Oprations() {

	}

	/**
	 * 
	 * this function check that if 2 buttons are same color or not
	 * 
	 * @param a
	 * @param i
	 * @param j
	 * @param i2
	 * @param j2
	 * 
	 */
	public boolean Check(JButton a[][], int i, int j, int i2, int j2) {
		try {
			if (a[i][j].getBackground().equals(a[i2][j2].getBackground()))
				return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	/**
	 * this is our main recursive function that determine wheter buttons are
	 * neighbours or not
	 * 
	 * @param buttons
	 * @param arr
	 * @param i
	 * @param j
	 */
	public void select(JButton buttons[][], boolean arr[][], int i, int j) {
		try {
			if (Check(buttons, i, j, i, j + 1) && arr[i][j + 1] == false) {
				// in each if that it's condition is true we make the same place of that button
				// in boolean array true
				arr[i][j + 1] = true;
				gui.counter.add(1);// in each if that it's condition is true we increase the value of array list
				select(buttons, arr, i, j + 1);// now we run the function in new button
			}

			if (Check(buttons, i, j, i - 1, j + 1) && arr[i - 1][j + 1] == false) {
				arr[i - 1][j + 1] = true;
				gui.counter.add(1);
				select(buttons, arr, i - 1, j + 1);
			}

			if (Check(buttons, i, j, i + 1, j + 1) && arr[i + 1][j + 1] == false) {
				arr[i + 1][j + 1] = true;
				gui.counter.add(1);
				select(buttons, arr, i + 1, j + 1);
			}

			if (Check(buttons, i, j, i + 1, j) && arr[i + 1][j] == false) {
				arr[i + 1][j] = true;
				gui.counter.add(1);
				select(buttons, arr, i + 1, j);
			}

			if (Check(buttons, i, j, i + 1, j - 1) && arr[i + 1][j - 1] == false) {
				arr[i + 1][j - 1] = true;
				gui.counter.add(1);
				select(buttons, arr, i + 1, j - 1);
			}

			if (Check(buttons, i, j, i, j - 1) && arr[i][j - 1] == false) {
				arr[i][j - 1] = true;
				gui.counter.add(1);
				select(buttons, arr, i, j - 1);
			}

			if (Check(buttons, i, j, i - 1, j - 1) && arr[i - 1][j - 1] == false) {
				arr[i - 1][j - 1] = true;
				gui.counter.add(1);
				select(buttons, arr, i - 1, j - 1);
			}

			if (Check(buttons, i, j, i - 1, j) && arr[i - 1][j] == false) {
				arr[i - 1][j] = true;
				gui.counter.add(1);
				select(buttons, arr, i - 1, j);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * in this function we add the members of counter array list
	 */
	public int counterTotal() {
		int a = 0;
		for (int i = 0; i < gui.counter.size(); i++)
			a += gui.counter.get(i);
		return a;
	}

	/**
	 * in this function we add the members of kills array list
	 */
	public int killsTotal() {
		int a = 0;
		for (int i = 0; i < gui.kills.size(); i++)
			a += gui.kills.get(i);

		return a;
	}

	/**
	 * in this function we add the members of kills array list
	 */
	public int selectTotals() {
		int a = 0;
		for (int i = 0; i < gui.selects.size(); i++)
			a += gui.selects.get(i);

		return a;
	}

	public void firstGravity(int Line, int Column, JButton buttons[][]) {
		for (int i = 0; i < Line; i++)
			for (int j = 0; j < Column; j++)

				if (buttons[i][j].getBackground() == Color.WHITE) {// first we search for white buttos
					// in this loop we set the color of each button from its upward button in one
					// column
					for (int x = i; x > 0; x--)
						buttons[x][j].setBackground(buttons[x - 1][j].getBackground());
					buttons[0][j].setBackground(Color.WHITE);// the buttons of first line should be white
				}
	}

	public void secoundGravity(int Line, int Column, JButton buttons[][]) {
		for (int i = 0; i < Line; i++)
			for (int j = 0; j < Column; j++)
				if (buttons[i][j].getBackground() == Color.WHITE)// first we search for white buttos
					// in this loop we set the color of each button from its rigth button in one
					// line
					for (int y = j; y < Column; y++)
						if (buttons[i][y].getBackground() != Color.WHITE) {
							buttons[i][j].setBackground(buttons[i][y].getBackground());
							buttons[i][y].setBackground(Color.WHITE);
							break;
						}

	}

	/**
	 * this function indicate that all buttons are remove or not
	 * 
	 * @param buttons
	 * @param Line
	 * @param Column
	 */
	public boolean win(JButton buttons[][], int Line, int Column) {
		for (int i = 0; i < Line; i++)
			for (int j = 0; j < Column; j++)
				if (buttons[i][j].getBackground() != Color.WHITE)
					return false;
		return true;
	}
	/**
	 * this function count the record and write it in txt file
	 * @param Line
	 * @param Column
	 * @param h
	 * @param c
	 * @param time
	 * 
	 */
	public int record(int Line, int Column, int h, int c, String time) {

		Player obj = new Player();
		int t = Integer.parseInt(time);
		int a = Line * Column;
		double makhraj = c * Math.ceil(Math.pow(t, 1.0 / 3));
		double soorat = a * h;
		int result = (int) (soorat / makhraj);
		String s = obj.getName();
		try {
			FileWriter fw = new FileWriter("ashkan.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.println(s + "******************" + result);
			out.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}
	/**
	 * this function determine that we have remainder button with no neighbour or not
	 * @param buttons
	 * @param arr
	 * @param Line
	 * @param Column
	 */
	public boolean lose(JButton buttons[][], boolean arr[][], int Line, int Column) {

		for (int i = 0; i < Line; i++)
			for (int j = 0; j < Column; j++)

				if (buttons[i][j].getBackground() != Color.WHITE) {

					gui.counter.clear();
					for (int i2 = 0; i2 < Line; i2++)
						for (int j2 = 0; j2 < Column; j2++)
							arr[i2][j2] = false;

					select(buttons, arr, i, j);

					for (int x = 0; x < Line; x++)
						for (int y = 0; y < Column; y++) {
							if (arr[x][y] == true && counterTotal() > 3)
								return false;//if we have neighbour return false
						}
				}

		return true;

	}

}
