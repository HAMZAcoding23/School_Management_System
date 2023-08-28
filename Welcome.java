package Welcome;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import FeeSubmition.FeeSubmition;
import LoginPage.LoginPage;
import StudentModule.StudentModule;
import TeacherModule.TeacherModule;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	private static final long serialVersionUID = 1L;

	public Welcome() {
		super("School management system - Menu Page");
		setForeground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(704, 498);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		JLabel lblMenuPage = new JLabel("Menu Page");
		lblMenuPage.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMenuPage.setForeground(new Color(255, 0, 0));
		lblMenuPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPage.setFont(new Font("Traditional Arabic", Font.BOLD, 42));
		lblMenuPage.setBounds(173, 43, 316, 59);
		getContentPane().add(lblMenuPage);
		//btnStudent
		JButton btnStudent = new JButton("STUDENT'S MODULE");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentModule().setVisible(true);
				dispose();
			}
		});
		btnStudent.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnStudent.setBounds(211, 125, 241, 51);
		getContentPane().add(btnStudent);
		//btnTeacher
		JButton btnTeacher = new JButton("TEACHER'S MODULE");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherModule().setVisible(true);
				dispose();
			}
		});
		btnTeacher.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnTeacher.setBounds(211, 238, 241, 51);
		getContentPane().add(btnTeacher);
		//btnFeeSubmition
		JButton btnFeeSubmition = new JButton("FEE SUBMITION");
		btnFeeSubmition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FeeSubmition().setVisible(true);
				dispose();
			}
		});
		btnFeeSubmition.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnFeeSubmition.setBounds(211, 357, 241, 51);
		getContentPane().add(btnFeeSubmition);
		//Logout
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setForeground(new Color(0, 0, 102));
		lblLogout.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setBounds(-11, 6, 105, 39);
		getContentPane().add(lblLogout);
		
		Font originalFont = lblLogout.getFont(); // Store the original font
        Font newFont = originalFont.deriveFont(Font.PLAIN |Font.BOLD); // Create a new font
        
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new LoginPage().setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogout.setFont(newFont);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogout.setFont(originalFont);

			}
		});
	}
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Welcome().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
