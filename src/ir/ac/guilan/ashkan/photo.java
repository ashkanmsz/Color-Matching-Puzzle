package ir.ac.guilan.ashkan;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;

/**
 * in this gui we choose our favorite photo
 */
public class photo {

	private JPanel contentPane;
	private JFrame frmPhoto = new JFrame();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	// if we won't choose our favorite photo this photo will be your default picture
	private static Icon icn = new ImageIcon("C:\\Users\\ashka\\eclipse-workspace\\Project5\\download.png");
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton btnBrowse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new photo();
	}

	/**
	 * Create the frame.
	 */
	public photo() {
		frmPhoto.setTitle("photo");
		frmPhoto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhoto.setBounds(100, 100, 662, 902);
		frmPhoto.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmPhoto.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 649, 743);
		contentPane.add(panel);
		
		String dir;
		dir = System.getProperty("user.dir");

		btnNewButton = new JButton();
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(dir+"\\images\\face-11.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				icn = btnNewButton.getIcon();// get the icon and pour it in icn variable
				frmPhoto.setVisible(false);
			}
		});
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		panel.add(btnNewButton);

		btnNewButton_5 = new JButton();
		panel.add(btnNewButton_5);
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setIcon(new ImageIcon(dir+"\\images\\34.jpg"));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				icn = btnNewButton_5.getIcon();// get the icon and pour it in icn variable
				frmPhoto.setVisible(false);
			}
		});

		button = new JButton();
		button.setBackground(Color.GRAY);
		button.setIcon(new ImageIcon(dir+"\\images\\download.jfif"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				icn = button.getIcon();// get the icon and pour it in icn variable
				frmPhoto.setVisible(false);
			}
		});
		
				btnNewButton_1 = new JButton();
				btnNewButton_1.setBackground(Color.WHITE);
				btnNewButton_1.setIcon(new ImageIcon(dir+"\\images\\2.jpg"));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						icn = btnNewButton_1.getIcon();// get the icon and pour it in icn variable
						frmPhoto.setVisible(false);
					}
				});
				
						btnNewButton_4 = new JButton();
						btnNewButton_4.setIcon(new ImageIcon(dir+"\\images\\250px-Donald_Trump_official_portrait_(cropped).jpg"));
						btnNewButton_4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								icn = btnNewButton_4.getIcon();// get the icon and pour it in icn variable
								frmPhoto.setVisible(false);
							}
						});
						
								btnNewButton_3 = new JButton();
								btnNewButton_3.setIcon(new ImageIcon(dir+"\\images\\635907076024739362-Kim.0001.jpg"));
								btnNewButton_3.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										icn = btnNewButton_3.getIcon();// get the icon and pour it in icn variable
										frmPhoto.setVisible(false);
									}
								});
								
										btnNewButton_2 = new JButton();
										btnNewButton_2.setIcon(
												new ImageIcon(dir+"\\images\\east-clinic-v-shape-001.jpg"));
										btnNewButton_2.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												icn = btnNewButton_2.getIcon();// get the icon and pour it in icn variable
												frmPhoto.setVisible(false);
											}
										});
										panel.add(btnNewButton_2);
								panel.add(btnNewButton_3);
						panel.add(btnNewButton_4);
				panel.add(btnNewButton_1);
		panel.add(button);

		button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(dir+"\\images\\35.jpg"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				icn = button_2.getIcon();// get the icon and pour it in icn variable
				frmPhoto.setVisible(false);
			}
		});
		panel.add(button_2);
		
				button_1 = new JButton();
				panel.add(button_1);
				button_1.setBackground(Color.BLACK);
				button_1.setIcon(new ImageIcon(dir+"\\images\\6.jpg"));
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						icn = button_1.getIcon();// get the icon and pour it in icn variable
						frmPhoto.setVisible(false);
					}
				});
		
		btnBrowse = new JButton("browse");//this section is for choosing more photos
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser jf = new JFileChooser();
				jf.setFont(new Font("Simplified Arabic", Font.PLAIN, 21));
				int flag = jf.showOpenDialog(null);
				if (flag == JFileChooser.APPROVE_OPTION) {
					File file = jf.getSelectedFile();
					try {
						Image image;
						image = ImageIO.read(file);
						Image image1 = image.getScaledInstance(200, 300, image.SCALE_DEFAULT);
						icn=new ImageIcon(image1);
						frmPhoto.setVisible(false);
						
					} catch (Exception e) {
						e.getMessage();
					}
				}
				
				
				
			}
		});
		btnBrowse.setFocusable(false);
		btnBrowse.setBackground(Color.YELLOW);
		btnBrowse.setFont(new Font("Simplified Arabic", Font.PLAIN, 21));
		btnBrowse.setBounds(256, 759, 143, 51);
		contentPane.add(btnBrowse);

		
	frmPhoto.setVisible(true);
	}
	public static Icon getIcon() {
		return icn;
	}
	public static void setIcon() {
		icn = new ImageIcon("C:\\Users\\ashka\\eclipse-workspace\\Project5\\download.png");
	}

}
