package UpdateStudent;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import StudentModule.StudentModule;

public class UpdateStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtFullName;
	private JTextField txtId;
	private JTextField txtPhone;
	private JTextField txtFatherName;
	private JTextField txtFatherPhone;
	private JTextField txtAddress;
	private JTextField txtClass;
	private JTextField txtPreviousID;
	
	public UpdateStudent() {
		super("School management system - Update student's records");
		setForeground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(809, 571);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		JLabel lblUpdateStudentRecords = new JLabel("Update Student's Records");
		lblUpdateStudentRecords.setForeground(new Color(0, 0, 102));
		lblUpdateStudentRecords.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 37));
		lblUpdateStudentRecords.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateStudentRecords.setBounds(108, 6, 507, 58);
		getContentPane().add(lblUpdateStudentRecords);
		
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setForeground(new Color(0, 153, 153));
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
		lblID.setBounds(245, 152, 59, 29);
		getContentPane().add(lblID);
		
		JLabel lblName = new JLabel("Full Name :");
		lblName.setVerticalAlignment(SwingConstants.TOP);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblName.setBounds(185, 193, 111, 38);
		getContentPane().add(lblName);
		
		JLabel lblFatherName = new JLabel("Father's Name :");
		lblFatherName.setVerticalAlignment(SwingConstants.TOP);
		lblFatherName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFatherName.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblFatherName.setBounds(146, 293, 150, 38);
		getContentPane().add(lblFatherName);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setVerticalAlignment(SwingConstants.TOP);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblPhone.setBounds(220, 243, 76, 38);
		getContentPane().add(lblPhone);
		
		JLabel lblFatherPhone = new JLabel("Father's Phone :");
		lblFatherPhone.setVerticalAlignment(SwingConstants.TOP);
		lblFatherPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblFatherPhone.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblFatherPhone.setBounds(146, 343, 150, 38);
		getContentPane().add(lblFatherPhone);
		
		JLabel lblAdress = new JLabel("Address :");
		lblAdress.setVerticalAlignment(SwingConstants.TOP);
		lblAdress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdress.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblAdress.setBounds(175, 393, 150, 38);
		getContentPane().add(lblAdress);
		
		JLabel lblClass = new JLabel("Class :");
		lblClass.setVerticalAlignment(SwingConstants.TOP);
		lblClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblClass.setBounds(200, 450, 123, 38);
		getContentPane().add(lblClass);
		
		JLabel lblRollNumber = new JLabel("Roll Number :");
		lblRollNumber.setVerticalAlignment(SwingConstants.TOP);
		lblRollNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNumber.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblRollNumber.setBounds(465, 450, 150, 38);
		getContentPane().add(lblRollNumber);
		
		txtFullName = new JTextField();
		txtFullName.setBounds(304, 193, 254, 28);
		getContentPane().add(txtFullName);
		txtFullName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(304, 149, 254, 28);
		getContentPane().add(txtId);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(304, 240, 254, 28);
		getContentPane().add(txtPhone);
		
		txtFatherName = new JTextField();
		txtFatherName.setColumns(10);
		txtFatherName.setBounds(304, 290, 254, 28);
		getContentPane().add(txtFatherName);
		
		txtFatherPhone = new JTextField();
		txtFatherPhone.setColumns(10);
		txtFatherPhone.setBounds(304, 340, 254, 28);
		getContentPane().add(txtFatherPhone);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(304, 390, 254, 28);
		getContentPane().add(txtAddress);
		
		txtClass = new JTextField();
		txtClass.setBounds(306, 444, 147, 28);
		getContentPane().add(txtClass);
		txtClass.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("SansSerif", Font.PLAIN, 14));
		spinner.setModel(new SpinnerNumberModel(1, 1, 60, 1));
		spinner.setBounds(612, 444, 52, 28);
		getContentPane().add(spinner);
		
		JButton btnUpdateStudent = new JButton("UPDATE RECORDS");
		btnUpdateStudent.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// load mysql driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// create the connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagementsystem","root","root");
					// create the update query of sql
					String query = "UPDATE student_registration SET ID_student=? , Full_name=? , Phone=? , Father_name=? , Father_phone=? , Address=? , Class=? , Roll_number=? WHERE ID_student=?";                                                                                                                     
					
					// Update values 
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, txtId.getText());
					ps.setString(2, txtFullName.getText());
					ps.setString(3, txtPhone.getText());
					ps.setString(4, txtFatherName.getText());
					ps.setString(5, txtFatherPhone.getText());
					ps.setString(6, txtAddress.getText());
					ps.setString(7, txtClass.getText());
					ps.setInt(8,(Integer) spinner.getValue());
					ps.setString(9, txtPreviousID.getText());

					
					ps.executeUpdate();

					JOptionPane.showMessageDialog(UpdateStudent.this, "Data has been updated seccessefully");
					con.close();

				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Error while establishing connection");

				}
			}
		});
		btnUpdateStudent.setBounds(242, 487, 241, 38);
		getContentPane().add(btnUpdateStudent);
		
		JLabel lblPreviousID = new JLabel("The previous ID :");
		lblPreviousID.setFont(new Font("Sylfaen", Font.ITALIC, 21));
		lblPreviousID.setBounds(136, 76, 165, 38);
		getContentPane().add(lblPreviousID);
		
		txtPreviousID = new JTextField();
		txtPreviousID.setColumns(10);
		txtPreviousID.setBounds(308, 78, 254, 28);
		getContentPane().add(txtPreviousID);
		
		JLabel lblNewRecords = new JLabel("New records :");
		lblNewRecords.setFont(new Font("Sylfaen", Font.ITALIC, 21));
		lblNewRecords.setBounds(136, 118, 155, 28);
		getContentPane().add(lblNewRecords);
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent frame = new UpdateStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
