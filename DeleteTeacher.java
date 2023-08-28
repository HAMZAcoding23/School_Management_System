package DeleteTeacher;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import TeacherModule.TeacherModule;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteTeacher extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JTextField textID;

	public DeleteTeacher() {
		super("School management system - Teacher's registration");
		setTitle("School management system - Teacher's departure");
		setForeground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(668, 387);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		JLabel lblTeacherDeparture = new JLabel("Teacher's Departure");
		lblTeacherDeparture.setForeground(new Color(70, 130, 180));
		lblTeacherDeparture.setFont(new Font("Traditional Arabic", Font.BOLD, 40));
		lblTeacherDeparture.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherDeparture.setBounds(114, 34, 401, 65);
		getContentPane().add(lblTeacherDeparture);
		
		JLabel lblTeacherID = new JLabel("Enter the ID to dismiss the teacher :");
		lblTeacherID.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblTeacherID.setBounds(59, 161, 357, 44);
		getContentPane().add(lblTeacherID);
		
		textID = new JTextField();
		textID.setBounds(244, 217, 190, 34);
		getContentPane().add(textID);
		textID.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					// load mysql driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// create the connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagementsystem","root","root");
					// create a state of connection
					Statement st = con.createStatement();
					ResultSet res = st.executeQuery("SELECT * FROM teacher_registration");
					int test = 0;
					while(res.next())
					{
						if (res.getString(2).equals(textID.getText())) {// you have to be carefull with equals 
							String query = "DELETE FROM teacher_registration WHERE ID_teacher = ?";
							PreparedStatement ps = con.prepareStatement(query);
							ps.setString(1,textID.getText());
							ps.executeUpdate();
							JOptionPane.showMessageDialog(DeleteTeacher.this, "The data has been removed successfully");
							test = 1;
							break;
						}
					}
					if(test == 0)
						JOptionPane.showMessageDialog(DeleteTeacher.this, "This ID doesn't exist");


					con.close();
					textID.setText("");
					
				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erreur while establishing connection");
					
				}
	
			}
			
		});
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnDelete.setBounds(464, 214, 107, 39);
		getContentPane().add(btnDelete);
		
		// Back label
		JLabel lblBack = new JLabel("Back");
		lblBack.setForeground(new Color(0, 0, 102));
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblBack.setBounds(18, 24, 70, 38);
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
		
	}
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteTeacher frame = new DeleteTeacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
