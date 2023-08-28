package StudentRegistration;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import StudentModule.StudentModule;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class StudentRegistration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtFullName;
	private JTextField txtId;
	private JTextField txtPhone;
	private JTextField txtFatherName;
	private JTextField txtFatherPhone;
	private JTextField txtAddress;
	private JTextField txtClass;
	
	public StudentRegistration() {
		super("School management system - Student's Registration");
		setForeground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(803, 560);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		JLabel lblStudentRegistration = new JLabel("Student's Registration");
		lblStudentRegistration.setForeground(new Color(51, 51, 204));
		lblStudentRegistration.setFont(new Font("Traditional Arabic", Font.BOLD, 42));
		lblStudentRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentRegistration.setBounds(101, 6, 507, 58);
		getContentPane().add(lblStudentRegistration);
		
		
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
				new StudentModule().setVisible(true);
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
		lblID.setVerticalAlignment(SwingConstants.TOP);
		lblID.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(165, 93, 59, 29);
		getContentPane().add(lblID);
		
		JLabel lblName = new JLabel("Full Name :");
		lblName.setVerticalAlignment(SwingConstants.TOP);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblName.setBounds(105, 134, 111, 38);
		getContentPane().add(lblName);
		
		JLabel lblFatherName = new JLabel("Father's Name :");
		lblFatherName.setVerticalAlignment(SwingConstants.TOP);
		lblFatherName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFatherName.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblFatherName.setBounds(66, 234, 150, 38);
		getContentPane().add(lblFatherName);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setVerticalAlignment(SwingConstants.TOP);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblPhone.setBounds(140, 184, 76, 38);
		getContentPane().add(lblPhone);
		
		JLabel lblFatherPhone = new JLabel("Father's Phone :");
		lblFatherPhone.setVerticalAlignment(SwingConstants.TOP);
		lblFatherPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblFatherPhone.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblFatherPhone.setBounds(66, 284, 150, 38);
		getContentPane().add(lblFatherPhone);
		
		JLabel lblAdress = new JLabel("Address :");
		lblAdress.setVerticalAlignment(SwingConstants.TOP);
		lblAdress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdress.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblAdress.setBounds(95, 334, 150, 38);
		getContentPane().add(lblAdress);
		
		JLabel lblClass = new JLabel("Class :");
		lblClass.setVerticalAlignment(SwingConstants.TOP);
		lblClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblClass.setBounds(120, 391, 123, 38);
		getContentPane().add(lblClass);
		
		JLabel lblRollNumber = new JLabel("Roll Number :");
		lblRollNumber.setVerticalAlignment(SwingConstants.TOP);
		lblRollNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNumber.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblRollNumber.setBounds(385, 391, 150, 38);
		getContentPane().add(lblRollNumber);
		
		txtFullName = new JTextField();
		txtFullName.setBounds(224, 134, 254, 28);
		getContentPane().add(txtFullName);
		txtFullName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(224, 90, 254, 28);
		getContentPane().add(txtId);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(224, 181, 254, 28);
		getContentPane().add(txtPhone);
		
		txtFatherName = new JTextField();
		txtFatherName.setColumns(10);
		txtFatherName.setBounds(224, 231, 254, 28);
		getContentPane().add(txtFatherName);
		
		txtFatherPhone = new JTextField();
		txtFatherPhone.setColumns(10);
		txtFatherPhone.setBounds(224, 281, 254, 28);
		getContentPane().add(txtFatherPhone);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(224, 331, 254, 28);
		getContentPane().add(txtAddress);
		
		txtClass = new JTextField();
		txtClass.setBounds(226, 385, 147, 28);
		getContentPane().add(txtClass);
		txtClass.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("SansSerif", Font.PLAIN, 14));
		spinner.setModel(new SpinnerNumberModel(1, 1, 60, 1));
		spinner.setBounds(532, 385, 52, 28);
		getContentPane().add(spinner);
		
		JButton btnAddStudent = new JButton("ADD STUDENT");
		btnAddStudent.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// load mysql driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// create the connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagementsystem","root","root");
					// create the insert query of sql
					String query = "INSERT INTO student_registration (ID_student,Full_name,Phone,Father_name,Father_phone,Address,Class,Roll_number) VALUES (?,?,?,?,?,?,?,?)";                                                                                                                     
					// insert the values into the query
					
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, txtId.getText());
					ps.setString(2, txtFullName.getText());
					ps.setString(3, txtPhone.getText());
					ps.setString(4, txtFatherName.getText());
					ps.setString(5, txtFatherPhone.getText());
					ps.setString(6, txtAddress.getText());
					ps.setString(7, txtClass.getText());
					ps.setInt(8,(Integer) spinner.getValue());
					
					ps.executeUpdate();

					JOptionPane.showMessageDialog(StudentRegistration.this, "Data is stored seccessefully");
					con.close();
					txtId.setText("");
					txtFullName.setText("");
					txtClass.setText("");
					txtPhone.setText("");
					txtFatherPhone.setText("");
					txtFatherName.setText("");
					txtAddress.setText("");
					spinner.setValue(1);

				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Error while establishing connection");

				}
			}
		});
		btnAddStudent.setBounds(277, 440, 174, 49);
		getContentPane().add(btnAddStudent);
		
	}


	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegistration frame = new StudentRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
