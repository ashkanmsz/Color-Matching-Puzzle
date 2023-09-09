package ir.ac.guilan.ashkan;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Hello welcome to my program this program impliments a game that's name is
 * DOOZ!
 * 
 * @author ashkan
 * @version 1.1.3
 * @since 20/5/2018
 */
public class sabtenam {

	private JPanel contentPane;
	private JFrame frmReception = new JFrame();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new sabtenam();
	}

	/**
	 * Create the frame.
	 */
	public sabtenam() {
		frmReception.setTitle("reception");
		frmReception.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReception.setBounds(100, 100, 571, 397);
		frmReception.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmReception.setContentPane(contentPane);
		contentPane.setLayout(null);

		Player obj = new Player();// this is a object from player class
		/**
		 * in this section we make our fields and frame
		 */
		textField = new JTextField();
		textField.setBackground(Color.YELLOW);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField.setBounds(110, 46, 182, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.YELLOW);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_1.setBounds(109, 88, 69, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBackground(Color.YELLOW);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_2.setBounds(110, 126, 69, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBackground(Color.YELLOW);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_3.setBounds(109, 168, 69, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBackground(Color.YELLOW);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_4.setBounds(109, 207, 69, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblName = new JLabel("name");
		lblName.setForeground(Color.YELLOW);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblName.setBounds(44, 49, 69, 20);
		contentPane.add(lblName);
		
		String dir;
		dir = System.getProperty("user.dir");

		JLabel piclabel = new JLabel("");
		piclabel.setIcon(new ImageIcon(dir+"\\download.png"));
		piclabel.setBounds(281, 88, 215, 228);
		contentPane.add(piclabel);

		JLabel lblLine = new JLabel("Line");
		lblLine.setForeground(Color.YELLOW);
		lblLine.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLine.setBounds(44, 91, 69, 20);
		contentPane.add(lblLine);

		JLabel lblColumn = new JLabel("column");
		lblColumn.setForeground(Color.YELLOW);
		lblColumn.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblColumn.setBounds(44, 129, 69, 20);
		contentPane.add(lblColumn);

		JLabel lblPoke = new JLabel("Poke");
		lblPoke.setForeground(Color.YELLOW);
		lblPoke.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPoke.setBounds(44, 210, 69, 20);
		contentPane.add(lblPoke);

		JLabel lblColor = new JLabel("Color");
		lblColor.setForeground(Color.YELLOW);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblColor.setBounds(44, 171, 69, 20);
		contentPane.add(lblColor);

		JButton btnPhoto = new JButton("photo");
		btnPhoto.setBackground(Color.YELLOW);
		btnPhoto.setFocusable(false);
		btnPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				photo.main(null);
			}
		});
		btnPhoto.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnPhoto.setBounds(327, 45, 115, 29);
		contentPane.add(btnPhoto);
		/**
		 * if we select the save button
		 */
		JButton btnsave = new JButton("save");
		btnsave.setBackground(Color.YELLOW);
		btnsave.setFocusable(false);
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();// get the name
				int line = Integer.parseInt(textField_1.getText());// get line and convert it to integer
				int column = Integer.parseInt(textField_2.getText());// get column and convert it to integer
				int poke = Integer.parseInt(textField_4.getText());// get poke and convert it to integer
				int color = Integer.parseInt(textField_3.getText());// get the much of colors and convert it to integer
				Icon icn = photo.getIcon();// get the pic that was selected at photo gui
				Player player = new Player(name, line, column, poke, color, icn);// make our player object
				frmReception.setVisible(false);
				gui.main(null);
			}
		});
		btnsave.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnsave.setBounds(109, 271, 115, 40);
		contentPane.add(btnsave);

		frmReception.setVisible(true);
	}
}
