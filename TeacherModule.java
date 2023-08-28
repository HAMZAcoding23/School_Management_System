package TeacherModule;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import DeleteTeacher.DeleteTeacher;
import TeacherRegistration.TeacherRegistration;
import UpdateTeacher.UpdateTeacher;
import Welcome.Welcome;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherModule extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public TeacherModule() {
		super("School management system - Teacher Module");
		setForeground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(704, 498);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		JLabel lblTeacherModule = new JLabel("Teacher's Module");
		lblTeacherModule.setForeground(new Color(0, 102, 204));
		lblTeacherModule.setFont(new Font("Traditional Arabic", Font.BOLD, 42));
		lblTeacherModule.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherModule.setBounds(123, 22, 421, 59);
		getContentPane().add(lblTeacherModule);
		//LabelBack
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Welcome().setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBack.setFont(lblBack.getFont().deriveFont(Font.BOLD));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBack.setFont(lblBack.getFont().deriveFont(Font.PLAIN));
			}
		});
		lblBack.setForeground(new Color(0, 0, 102));
		lblBack.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblBack.setBounds(19, 6, 70, 38);
		getContentPane().add(lblBack);
		
		JButton btnTeacherRegistration = new JButton("TEACHER'S REGISTRATION");
		btnTeacherRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherRegistration().setVisible(true);
				dispose();
			}
		});
		btnTeacherRegistration.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnTeacherRegistration.setBounds(178, 126, 321, 59);
		getContentPane().add(btnTeacherRegistration);
		
		JButton btnUpdateTeacher = new JButton("UPDATE TEACHER'S RCORDS");
		btnUpdateTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateTeacher().setVisible(true);
				dispose();
			}
		});
		btnUpdateTeacher.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnUpdateTeacher.setBounds(178, 240, 321, 59);
		getContentPane().add(btnUpdateTeacher);
		
		JButton btnTeacherDeparture = new JButton("TEACHER'S DEPARTURE");
		btnTeacherDeparture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteTeacher().setVisible(true);
				dispose();
			}
		});
		btnTeacherDeparture.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnTeacherDeparture.setBounds(178, 357, 321, 59);
		getContentPane().add(btnTeacherDeparture);
	}


	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherModule frame = new TeacherModule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}
