package TeacherRegistration;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import TeacherModule.TeacherModule;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherRegistration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtFullName;
	private JTextField txtPhone;
	private JTextField txtSpecialization;
	private JTextField txtSubject;
	public TeacherRegistration() {
		super("School management system - Teacher's registration");
		setForeground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(759, 505);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		// Back label
		JLabel lblBack = new JLabel("Back");
		lblBack.setForeground(new Color(0, 0, 102));
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblBack.setBounds(19, 6, 70, 38);
		getContentPane().add(lblBack);
		
		Font originalFont = lblBack.getFont();
		Font newFont = originalFont.deriveFont(Font.PLAIN |Font.BOLD);
		
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TeacherModule().setVisible(true);
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
		
		JLabel lblTeacherRegistration = new JLabel("Teacher's registration");
		lblTeacherRegistration.setForeground(new Color(51, 153, 204));
		lblTeacherRegistration.setFont(new Font("Traditional Arabic", Font.BOLD, 42));
		lblTeacherRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherRegistration.setBounds(189, 18, 418, 60);
		getContentPane().add(lblTeacherRegistration);
		
		JLabel lblID = new JLabel("ID :");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblID.setBounds(165, 107, 91, 28);
		getContentPane().add(lblID);
		
		JLabel lblFullName = new JLabel("Full Name :");
		lblFullName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFullName.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblFullName.setBounds(142, 161, 114, 28);
		getContentPane().add(lblFullName);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPhone.setBounds(142, 218, 114, 28);
		getContentPane().add(lblPhone);
		
		JLabel lblSpecailization = new JLabel("Specialization :");
		lblSpecailization.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpecailization.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblSpecailization.setBounds(106, 273, 150, 28);
		getContentPane().add(lblSpecailization);
		
		JLabel lblSubjectAssigned = new JLabel("Subject Assigned :");
		lblSubjectAssigned.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubjectAssigned.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblSubjectAssigned.setBounds(90, 328, 169, 28);
		getContentPane().add(lblSubjectAssigned);
		
		txtID = new JTextField();
		txtID.setBounds(288, 110, 228, 28);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtFullName = new JTextField();
		txtFullName.setColumns(10);
		txtFullName.setBounds(288, 164, 228, 28);
		getContentPane().add(txtFullName);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(288, 221, 228, 28);
		getContentPane().add(txtPhone);
		
		txtSpecialization = new JTextField();
		txtSpecialization.setColumns(10);
		txtSpecialization.setBounds(288, 276, 228, 28);
		getContentPane().add(txtSpecialization);
		
		txtSubject = new JTextField();
		txtSubject.setColumns(10);
		txtSubject.setBounds(288, 331, 228, 28);
		getContentPane().add(txtSubject);
		
		JButton btnAddTeacher = new JButton("ADD TEACHER");
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// load mysql driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// create the connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagementsystem","root","root");
					// create the insert query of sql
					String query = "INSERT INTO teacher_registration (ID_teacher,Full_name,Phone,Specialization,Subject_assigned) VALUES (?,?,?,?,?)";                                                                                                                     
					// insert the values into the query
					
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, txtID.getText());
					ps.setString(2, txtFullName.getText());
					ps.setString(3, txtPhone.getText());
					ps.setString(4, txtSpecialization.getText());
					ps.setString(5, txtSubject.getText());
					
					ps.executeUpdate();

					JOptionPane.showMessageDialog(TeacherRegistration.this, "Data is stored seccessefully");
					con.close();
					txtID.setText("");
					txtFullName.setText("");
					txtPhone.setText("");
					txtSubject.setText("");
					txtSpecialization.setText("");

				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Error while establishing connection");

				}
			}
			
		});
		btnAddTeacher.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnAddTeacher.setBounds(378, 387, 138, 38);
		getContentPane().add(btnAddTeacher);
	}
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherRegistration frame = new TeacherRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
