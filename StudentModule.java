package StudentModule;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import SearchDeleteStudent.SearchDeleteStudent;
import StudentRegistration.StudentRegistration;
import UpdateStudent.UpdateStudent;
import Welcome.Welcome;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentModule extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public StudentModule() {
		super("School management system - Student Module");
		setForeground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(704, 498);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		JLabel lblStudentModule = new JLabel("Student's Module");
		lblStudentModule.setForeground(new Color(165, 42, 42));
		lblStudentModule.setFont(new Font("Traditional Arabic", Font.BOLD, 43));
		lblStudentModule.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentModule.setBounds(130, 21, 421, 59);
		getContentPane().add(lblStudentModule);
		
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setForeground(new Color(0, 0, 102));
		lblBack.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblBack.setBounds(19, 6, 70, 38);
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

		
		JButton btnStudentRegistration = new JButton("STUDENT'S REGISTRATION");
		btnStudentRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentRegistration().setVisible(true);
				dispose();
			}
		});
		btnStudentRegistration.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnStudentRegistration.setBounds(176, 117, 321, 59);
		getContentPane().add(btnStudentRegistration);
		
		JButton btnUpdateStudent = new JButton("UPDATE STUDENT'S RCORDS");
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateStudent().setVisible(true);
				dispose();
			}
		});
		btnUpdateStudent.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnUpdateStudent.setBounds(176, 231, 321, 59);
		getContentPane().add(btnUpdateStudent);
		
		JButton btnSearchDeleteStudent = new JButton("SEARCH & DELETE STUDENT");
		btnSearchDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchDeleteStudent().setVisible(true);
				dispose();
			}
		});
		btnSearchDeleteStudent.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnSearchDeleteStudent.setBounds(176, 348, 321, 59);
		getContentPane().add(btnSearchDeleteStudent);
	}

	
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentModule frame = new StudentModule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
