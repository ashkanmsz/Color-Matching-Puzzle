package ir.ac.guilan.ashkan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class LastRecords {

	private JPanel contentPane;
	private JFrame frmRecordList = new JFrame();
	private JButton btnBack;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new LastRecords();
	}

	/**
	 * Create the frame.
	 */
	public LastRecords() {
		frmRecordList.setTitle("record list\r\n");
		frmRecordList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecordList.setBounds(100, 100, 399, 792);
		frmRecordList.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmRecordList.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 166, 375, 491);
		contentPane.add(scrollPane_1);

		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setFont(new Font("Nirmala UI", Font.PLAIN, 23));
		textArea.setForeground(Color.YELLOW);
		textArea.setBackground(Color.BLACK);
		
	
		
		btnBack = new JButton("back");
		btnBack.setBackground(Color.YELLOW);
		btnBack.setFocusable(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRecordList.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBack.setBounds(10, 670, 115, 50);
		contentPane.add(btnBack);
		
		btnNewButton = new JButton("Remove\r\n");//this button over write the txt file 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PrintWriter writer = new PrintWriter("ashkan.txt", "UTF-8");
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				frmRecordList.setVisible(false);
				LastRecords.main(null);
				
			}
		});
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(240, 670, 122, 50);
		contentPane.add(btnNewButton);
		
		String dir;
		dir = System.getProperty("user.dir");
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(dir+"\\78.jpg"));
		label.setBounds(106, 0, 163, 171);
		contentPane.add(label);
		
		String st="";
		File file = new File(dir+"/ashkan.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(st!=null) {
				st = br.readLine();
				textArea.append(st);
				textArea.append("\n");
				}
		
			br.close();

		} catch (Exception e) {
			e.getMessage();

		}

		frmRecordList.setVisible(true);
	}
}
