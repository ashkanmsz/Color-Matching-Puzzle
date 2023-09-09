package ir.ac.guilan.ashkan;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * 
 * this is the main section of our program that play in it
 *
 */
public class gui {

	private JPanel contentPane;
	private JFrame frmGameTable = new JFrame();
	private JLabel time;
	public int secounds;
	// this array list keeps the much of choosen buttons that are neighbour
	public static ArrayList<Integer> counter = new ArrayList<Integer>();
	// this array list keeps much of removed buttons
	public static ArrayList<Integer> kills = new ArrayList<Integer>();
	// this array list keeps much of selected buttons
	public static ArrayList<Integer> selects = new ArrayList<Integer>();
	// this array list keeps much of colors that user detemine that
	public static ArrayList<Color> colorList = new ArrayList<Color>();
	/**
	 * this section is for timer of game
	 */
	TimerTask task = new TimerTask() {

		public void run() {
			secounds++;
			time.setText(String.valueOf(secounds));
		}
	};
	Timer t = new Timer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new gui();
	}

	/**
	 * Create the frame.
	 */
	public gui() {

		frmGameTable.setTitle("game table\r\n");
		frmGameTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameTable.setBounds(100, 100, 1096, 754);
		frmGameTable.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmGameTable.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(308, 0, 771, 707);
		frmGameTable.getContentPane().add(panel);

		Random r = new Random();// we need the random class for choosing the colors
		Player obj = new Player();// this is object of player class
		Oprations op = new Oprations();// this object of opration class
		/**
		 * get the information to make the table
		 */
		int Line = obj.getLine();
		int Column = obj.getColumn();
		int rang = obj.getColor();
		int poke = obj.getPoke();
		String name = obj.getName();

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(photo.getIcon());
		lblNewLabel.setBounds(15, 0, 278, 241);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Poke\r\n");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(50, 332, 80, 23);
		contentPane.add(lblNewLabel_2);

		JLabel pokeMount = new JLabel();
		pokeMount.setForeground(Color.YELLOW);
		pokeMount.setFont(new Font("Tahoma", Font.PLAIN, 19));
		pokeMount.setBounds(145, 333, 69, 20);
		contentPane.add(pokeMount);

		JLabel lblSelects = new JLabel("selects");
		lblSelects.setForeground(Color.YELLOW);
		lblSelects.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSelects.setBounds(50, 371, 69, 20);
		contentPane.add(lblSelects);

		JLabel selectMount = new JLabel();
		selectMount.setForeground(Color.YELLOW);
		selectMount.setFont(new Font("Tahoma", Font.PLAIN, 19));
		selectMount.setBounds(145, 371, 69, 20);
		contentPane.add(selectMount);
		selectMount.setText("0");

		time = new JLabel();
		time.setForeground(Color.YELLOW);
		time.setFont(new Font("Tahoma", Font.PLAIN, 50));
		time.setBounds(70, 601, 143, 81);
		contentPane.add(time);
		t.schedule(task, 1000, 1000);

		JLabel lblKills = new JLabel("kills");
		lblKills.setForeground(Color.YELLOW);
		lblKills.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblKills.setBounds(50, 407, 69, 20);
		contentPane.add(lblKills);

		JLabel killsMount = new JLabel();
		killsMount.setForeground(Color.YELLOW);
		killsMount.setFont(new Font("Tahoma", Font.PLAIN, 19));
		killsMount.setBounds(145, 407, 69, 20);
		contentPane.add(killsMount);
		killsMount.setText("0");

		JLabel namelbl = new JLabel();
		namelbl.setForeground(Color.YELLOW);
		namelbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		namelbl.setBounds(70, 251, 149, 65);
		contentPane.add(namelbl);
		namelbl.setText(name);

		JButton btnNewGame = new JButton("new game");// this button return us to first page and clear all information
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				photo.setIcon();
				counter.clear();
				selects.clear();
				kills.clear();
				colorList.clear();
				frmGameTable.setVisible(false);
				sabtenam.main(null);

			}
		});
		btnNewGame.setBackground(Color.YELLOW);
		btnNewGame.setFocusable(false);
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewGame.setBounds(71, 487, 143, 41);
		contentPane.add(btnNewGame);

		JButton btnRecords = new JButton("records");// this button send us to record page
		btnRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LastRecords.main(null);
			}
		});
		btnRecords.setBackground(Color.YELLOW);
		btnRecords.setFocusable(false);
		btnRecords.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnRecords.setBounds(71, 544, 143, 41);
		contentPane.add(btnRecords);

		JButton buttons[][] = new JButton[Line][Column];// this is a 2D array for makin the table
		/**
		 * this is a array of colors that we select any much of colors that we want to
		 * make table from it
		 */
		Color colors[] = { new Color(255, 0, 0), new Color(0, 255, 0), new Color(0, 0, 255), new Color(255, 255, 0),
				new Color(0, 255, 255), new Color(255, 0, 255), new Color(192, 192, 192), new Color(139, 0, 0),
				new Color(255, 165, 0), new Color(25, 25, 112), new Color(139, 0, 139), new Color(245, 245, 220),
				new Color(0, 139, 139), new Color(188, 143, 143), new Color(245, 222, 179), new Color(230, 230, 250),
				new Color(0, 191, 255), new Color(127, 255, 212), new Color(107, 142, 35), new Color(255,20,147) };

		boolean arr[][] = new boolean[Line][Column];// this is a boolean array for preventing of counting repetitive
													// colors
		/**
		 * in below loop we choose random colors from colors array and pour it in array
		 * list with out repetitive colors
		 */
		for (int i = 0; i < rang; i++) {
			int R = (int) (Math.random() * colors.length);
			colorList.add(colors[R]);
			for (int x = 0; x < i; x++)
				if (colorList.get(x).equals(colorList.get(i))) {
					colorList.remove(i);
					i--;
				}
		}

		pokeMount.setText(String.valueOf(poke));// we get the pokes and show it in this label
		panel.setLayout(new GridLayout(Line, Column, 0, 0));// match our panel with lines and columns

		for (int i = 0; i < Line; i++)
			for (int j = 0; j < Column; j++) {
				JButton btnOk = new JButton(i + ":" + j);// we coding our buttons with their lines and columns
				btnOk.setFocusable(false);
				btnOk.setFont(new Font("Tahoma", Font.PLAIN, 19));
				int rc = r.nextInt(rang);
				btnOk.setBackground(colorList.get(rc));// setting the colors
				buttons[i][j] = btnOk;

				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/**
						 * with that coding here we can easily send the i & j to function
						 */
						JButton MB = (JButton) e.getSource();
						String tmp[] = MB.getText().split(":");

						int x = Integer.parseInt(tmp[0]);
						int y = Integer.parseInt(tmp[1]);
						int rcd;

						counter.clear();// in each level that we use our function we should clear the number of
										// neighbours in this array list
						// in each level that we use our function we should make whole of this array
						// false
						for (int i = 0; i < Line; i++)
							for (int j = 0; j < Column; j++)
								arr[i][j] = false;

						op.select(buttons, arr, x, y);// this is our function
						/**
						 * after using function we should set the color of removed buttons white
						 */
						for (int i = 0; i < Line; i++)
							for (int j = 0; j < Column; j++)
								if (arr[i][j] == true && op.counterTotal() > 3)
									buttons[i][j].setBackground(Color.WHITE);

						// if we have removed case we should increase the value of kills and selects
						// array list
						if (op.counterTotal() > 3) {
							kills.add(op.counterTotal());
							selects.add(1);
						}

						killsMount.setText(String.valueOf(op.killsTotal()));// we set the much of kills array list
						selectMount.setText(String.valueOf(op.selectTotals()));// we set the much of select array list
						int scl = Integer.parseInt(selectMount.getText());// we get the much of select array list

						op.firstGravity(Line, Column, buttons);// execute the first gravity
						op.secoundGravity(Line, Column, buttons);// execute the secound gravity

						for (int i = 0; i < Line; i++)// after removing we set visibility of them false
							for (int j = 0; j < Column; j++)
								if (buttons[i][j].getBackground() == Color.WHITE)
									buttons[i][j].setVisible(false);
						/**
						 * in this section app determine that be finish or continue
						 */
						if (scl <= poke && op.win(buttons, Line, Column)) {// if there was in button in the table
							int h = Integer.parseInt(killsMount.getText());
							int c = Integer.parseInt(selectMount.getText());
							rcd = op.record(Line, Column, h, c, time.getText());// we should count the record in each
																				// level
							Record object = new Record(rcd);// send it to record constructor and show it
							Record.main(null);
						} else if (scl > poke) {// if the select amount is bigger than pokes
							int h = Integer.parseInt(killsMount.getText()) - kills.get(kills.size() - 1);
							int c = Integer.parseInt(selectMount.getText()) - 1;
							rcd = op.record(Line, Column, h, c, time.getText());// we should count the record in each
																				// level
							Record object = new Record(rcd);// send it to record constructor and show it
							Record.main(null);
						} else if (scl <= poke && op.lose(buttons, arr, Line, Column)) {// if there wasn't any neighbour
							int h = Integer.parseInt(killsMount.getText());
							int c = Integer.parseInt(selectMount.getText());
							rcd = op.record(Line, Column, h, c, time.getText());// we should count the record in each
							// level
							Record object = new Record(rcd);// send it to record constructor and show it
							Record.main(null);
						}
					}
				});

				panel.add(buttons[i][j]);
			}

		frmGameTable.setVisible(true);
	}

}
