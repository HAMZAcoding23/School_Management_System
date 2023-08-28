package UpdateTeacher;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import TeacherModule.TeacherModule;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateTeacher extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtPreviousID;
	private JTextField txtID;
	private JTextField txtFullName;
	private JTextField txtPhone;
	private JTextField txtSpecialization;
	private JTextField txtSubject;
	public UpdateTeacher() {
		super("School management system - Update teacher's records");
		setForeground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(787, 536);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		// Back label
		JLabel lblBack = new JLabel("Back");
		lblBack.setForeground(new Color(0, 0, 102));
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblBack.setBounds(19, 6, 70, 38);
		getContentPane().add(lblBack);
		
		JLabel lblNewLabel = new JLabel("Update Teacher's Records");
		lblNewLabel.setForeground(new Color(102, 51, 102));
		lblNewLabel.setFont(new Font("Traditional Arabic", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(147, 20, 496, 49);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPreviousID = new JLabel("The previous ID :");
		lblPreviousID.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblPreviousID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreviousID.setBounds(102, 81, 169, 30);
		getContentPane().add(lblPreviousID);
		
		txtPreviousID = new JTextField();
		txtPreviousID.setBounds(296, 85, 220, 28);
		getContentPane().add(txtPreviousID);
		txtPreviousID.setColumns(10);
		
		JLabel lblNewRecords = new JLabel("New records :");
		lblNewRecords.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewRecords.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblNewRecords.setBounds(112, 129, 152, 30);
		getContentPane().add(lblNewRecords);
		
		JLabel lblD = new JLabel("ID :");
		lblD.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblD.setHorizontalAlignment(SwingConstants.RIGHT);
		lblD.setBounds(161, 174, 110, 28);
		getContentPane().add(lblD);
		
		JLabel lblFullName = new JLabel("Full Name :");
		lblFullName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFullName.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblFullName.setBounds(147, 226, 124, 28);
		getContentPane().add(lblFullName);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPhone.setBounds(147, 284, 124, 28);
		getContentPane().add(lblPhone);
		
		JLabel lblSpecialization = new JLabel("Specialization :");
		lblSpecialization.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpecialization.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblSpecialization.setBounds(102, 335, 169, 28);
		getContentPane().add(lblSpecialization);
		
		JLabel lblSubjectAssigned = new JLabel("Subject Assigned :");
		lblSubjectAssigned.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubjectAssigned.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblSubjectAssigned.setBounds(105, 388, 169, 28);
		getContentPane().add(lblSubjectAssigned);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(296, 177, 220, 28);
		getContentPane().add(txtID);
		
		txtFullName = new JTextField();
		txtFullName.setColumns(10);
		txtFullName.setBounds(296, 229, 220, 28);
		getContentPane().add(txtFullName);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(296, 287, 220, 28);
		getContentPane().add(txtPhone);
		
		txtSpecialization = new JTextField();
		txtSpecialization.setColumns(10);
		txtSpecialization.setBounds(296, 338, 220, 28);
		getContentPane().add(txtSpecialization);
		
		txtSubject = new JTextField();
		txtSubject.setColumns(10);
		txtSubject.setBounds(296, 391, 220, 28);
		getContentPane().add(txtSubject);
		
		JButton btnNewButton = new JButton("UPDATE RECORDS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// load mysql driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// create the connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagementsystem","root","root");
					// create the update query of sql
					String query = "UPDATE teacher_registration SET ID_teacher=? , Full_name=? , Phone=? , Specialization=? , Subject_assigned=? WHERE ID_teacher=?";                                                                                                                     
					
					// Update values 
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, txtID.getText());
					ps.setString(2, txtFullName.getText());
					ps.setString(3, txtPhone.getText());
					ps.setString(4, txtSpecialization.getText());
					ps.setString(5, txtSubject.getText());
					ps.setString(9, txtPreviousID.getText());

					
					ps.executeUpdate();

					JOptionPane.showMessageDialog(UpdateTeacher.this, "Data has been updated seccessefully");
					con.close();

				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Error while establishing connection");

				}
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.setBounds(340, 442, 176, 38);
		getContentPane().add(btnNewButton);
		
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
		
	}
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateTeacher frame = new UpdateTeacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}




}
