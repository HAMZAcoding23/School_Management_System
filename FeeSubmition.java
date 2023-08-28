package FeeSubmition;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Welcome.Welcome;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FeeSubmition extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textID;
	private JTextField textName;
	private JTextField textAnnuelFee;
	private JTextField textLibraryFee;
	private JTextField textInsuranceFee;
	private double ann;
	private double lib;
	private double ins;

	
	public FeeSubmition() {
		super("School management system - Fee Submition");
		setForeground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(783, 539);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		JLabel lblFeeSubmition = new JLabel("Student Fee Submission");
		lblFeeSubmition.setForeground(new Color(70, 130, 180));
		lblFeeSubmition.setFont(new Font("Traditional Arabic", Font.BOLD, 37));
		lblFeeSubmition.setBounds(39, 46, 397, 42);
		getContentPane().add(lblFeeSubmition);
		
		// Back label
		JLabel lblBack = new JLabel("Back");
		lblBack.setForeground(new Color(0, 0, 102));
		lblBack.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblBack.setBounds(6, 4, 57, 38);
		getContentPane().add(lblBack);
		
		Font originalFont = lblBack.getFont();
		Font newFont = originalFont.deriveFont(Font.PLAIN |Font.BOLD);
		
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Welcome().setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBack.setFont(newFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBack.setFont(originalFont);
			}
		});
		
		JLabel lblID = new JLabel("ID :");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblID.setBounds(38, 138, 136, 32);
		getContentPane().add(lblID);
		
		JLabel lblName = new JLabel("Full Name :");
		lblName.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblName.setBounds(70, 197, 118, 32);
		getContentPane().add(lblName);
		
		JLabel lblAnnuelFee = new JLabel("Annual Fee :");
		lblAnnuelFee.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnnuelFee.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblAnnuelFee.setBounds(60, 259, 118, 32);
		getContentPane().add(lblAnnuelFee);
		
		JLabel lblLibraryFee = new JLabel("Library Fee :");
		lblLibraryFee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLibraryFee.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblLibraryFee.setBounds(37, 318, 136, 32);
		getContentPane().add(lblLibraryFee);
		
		JLabel lblInsuranceFee = new JLabel("Insurance Fee :");
		lblInsuranceFee.setHorizontalAlignment(SwingConstants.LEFT);
		lblInsuranceFee.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblInsuranceFee.setBounds(31, 378, 161, 32);
		getContentPane().add(lblInsuranceFee);
		
		textID = new JTextField();
		textID.setBounds(204, 143, 190, 28);
		getContentPane().add(textID);
		textID.setColumns(10);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(204, 202, 190, 28);
		getContentPane().add(textName);
		
		textAnnuelFee = new JTextField();
		textAnnuelFee.setColumns(10);
		textAnnuelFee.setBounds(204, 263, 190, 28);
		getContentPane().add(textAnnuelFee);
		
		textLibraryFee = new JTextField();
		textLibraryFee.setColumns(10);
		textLibraryFee.setBounds(204, 323, 190, 28);
		getContentPane().add(textLibraryFee);
		
		textInsuranceFee = new JTextField();
		textInsuranceFee.setColumns(10);
		textInsuranceFee.setBounds(204, 383, 190, 28);
		getContentPane().add(textInsuranceFee);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBounds(460, 6, 303, 490);
		getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("PAY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// load mysql driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// create the connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagementsystem","root","root");
					// create the insert query of sql
					String query = "INSERT INTO fee_submission (ID_student,Full_name,Annual_fee,Library_fee,Insurance_fee,Payment_status,rest) VALUES (?,?,?,?,?,?,?)";
					// insert the values into the query
					ann = Double.parseDouble(textAnnuelFee.getText());
					lib = Double.parseDouble(textLibraryFee.getText());
					ins = Double.parseDouble(textInsuranceFee.getText());
					
					double rest = -800 + (ann+lib+ins);
					String status;
					if(rest == 0)
						status = "paid";
					else
						status = "unpaid";
	
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,textID.getText());
					ps.setString(2,textName.getText());
					ps.setDouble(3, ann);
					ps.setDouble(4, lib);
					ps.setDouble(5, ins);
					ps.setString(6,status);
					ps.setDouble(7, rest);
					ps.executeUpdate();
				
					JOptionPane.showMessageDialog(FeeSubmition.this,"The data is stored successfully");
					
					
					//Report  
					textArea.setText("      * Student Fee Submission *\n_____________________________\n\n" +
					" ID : " + textID.getText() + "\n" + 
					" Full Name : " + textName.getText() + "\n\n" +
					" Annual Fee : " + textAnnuelFee.getText() + " DH\n" +
					" Library Fee : " + textLibraryFee.getText() + " DH\n" +
					" Insurance Fee : " + textInsuranceFee.getText() + " DH\n_____________________________\n\n"+
					" Rest : " + rest + " DH\n" +
					" Status : " + status + "\n" 
					); 
					
					con.close();
					
					textID.setText("");
					textName.setText("");
					textAnnuelFee.setText("");
					textLibraryFee.setText("");
					textInsuranceFee.setText("");
					
					
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Erreur while establishing connection");
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.setBounds(310, 423, 84, 32);
		getContentPane().add(btnNewButton);
	}


	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeeSubmition frame = new FeeSubmition();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 }
}
