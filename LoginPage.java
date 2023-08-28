package LoginPage;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Welcome.Welcome;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField UserNameText;
	private JPasswordField passwordField;
	private JTextField EnterCodetext;

	public LoginPage() {
		super("School management system - Login page");
		setForeground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(803, 560);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		JLabel SchoolManagementSystem = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		SchoolManagementSystem.setVerticalAlignment(SwingConstants.TOP);
		SchoolManagementSystem.setForeground(new Color(0, 51, 153));
		SchoolManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		SchoolManagementSystem.setFont(new Font("Gabriola", Font.BOLD, 42));
		SchoolManagementSystem.setBounds(141, 42, 498, 63);
		getContentPane().add(SchoolManagementSystem);
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		lblNewLabel.setBounds(246, 106, 289, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel UserNameLabel = new JLabel("Username : ");
		UserNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserNameLabel.setBounds(165, 168, 118, 36);
		getContentPane().add(UserNameLabel);
		
		UserNameText = new JTextField();
		UserNameText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		UserNameText.setBounds(287, 172, 262, 31);
		getContentPane().add(UserNameText);
		UserNameText.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password :");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordLabel.setBounds(165, 241, 106, 36);
		getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(287, 247, 266, 31);
		getContentPane().add(passwordField);
		
		//btnSubmit
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setVerticalAlignment(SwingConstants.TOP);
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String us = UserNameText.getText();
				String pass = passwordField.getText();
				try {
					// load mysql driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// create the connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagementsystem","root","root");
					// create a state of connection
					Statement st = con.createStatement();
					//créer une requete de sélection
					ResultSet res = st.executeQuery("select * from user_login");
					String user;
					String password;
					int test = 0;
					
					while(res.next()) 
					{
						user = res.getString("username");
						password = res.getString("password");
						if(us.equals(user) && pass.equals(password)) {
							new Welcome().setVisible(true);
							dispose();
							test = 1;
							break;
						}
					}
					
					if(test==0)
					{
						JOptionPane.showMessageDialog(LoginPage.this, "Username or password is incorrect");
					}
					
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error while establishing connection");
				}
			}
		});
		
		btnSubmit.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		btnSubmit.setBounds(466, 290, 87, 31);
		getContentPane().add(btnSubmit);
		
		JLabel ForgotPasswordLabel = new JLabel("Forgot password ?");
		ForgotPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ForgotPasswordLabel.setBounds(165, 332, 163, 36);
		getContentPane().add(ForgotPasswordLabel);
		
		JLabel EnterCodeLabel = new JLabel("Enter secret code :");
		EnterCodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EnterCodeLabel.setBounds(165, 394, 178, 36);
		getContentPane().add(EnterCodeLabel);
		
		EnterCodetext = new JTextField();
		EnterCodetext.setBounds(336, 399, 130, 32);
		getContentPane().add(EnterCodetext);
		EnterCodetext.setColumns(10);
		//btnSubmitCode
		JButton btnSubmitCode = new JButton("Submit");
		btnSubmitCode.setVerticalAlignment(SwingConstants.TOP);
		btnSubmitCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = EnterCodetext.getText();
				if(code.equals("enim-1972@scolarite.ma"))
				{
					new Welcome().setVisible(true);
				}
			}
		});
		btnSubmitCode.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		btnSubmitCode.setBounds(466, 399, 87, 31);
		getContentPane().add(btnSubmitCode);
		
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("C:\\Users\\koks msin\\Downloads\\open-book_171322 (1).png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(42, 16, 87, 72);
		getContentPane().add(lblNewLabel_1);

	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
