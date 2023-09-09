package ir.ac.guilan.ashkan;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Record {

	private JPanel contentPane;
	private JFrame frmYourRecord = new JFrame();
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Record();
	}

	/**
	 * Create the frame.
	 */
	public Record() {		

	}

	public Record(int a) {
		
		frmYourRecord.setTitle("your record");
		frmYourRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYourRecord.setBounds(100, 100, 450, 300);
		frmYourRecord.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmYourRecord.setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(114, 83, 299, 36);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText("your record is : " + a);
		
		JButton btnNewGame = new JButton("ok");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmYourRecord.setVisible(false);
				
			}
		});
		btnNewGame.setFocusable(false);
		btnNewGame.setBackground(Color.YELLOW);
		btnNewGame.setForeground(Color.BLACK);
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewGame.setBounds(69, 172, 129, 36);
		contentPane.add(btnNewGame);

		JButton btnRecords = new JButton("Records");
		btnRecords.setFocusable(false);
		btnRecords.setBackground(Color.YELLOW);
		btnRecords.setForeground(Color.BLACK);
		btnRecords.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnRecords.setBounds(233, 172, 135, 36);
		contentPane.add(btnRecords);
		btnRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmYourRecord.setVisible(false);
				LastRecords.main(null);
			}
		});
		
		
		
		frmYourRecord.setVisible(true);
	}
}
