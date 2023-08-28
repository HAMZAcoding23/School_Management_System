package SearchDeleteStudent;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import StudentModule.StudentModule;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchDeleteStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtSearch;
	
	public SearchDeleteStudent() {
		super("School management system - Search and Delete Student");
		setForeground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(829, 478);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search & Delete Student");
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setBounds(195, 23, 399, 47);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		getContentPane().add(lblNewLabel);
		//Back Label 
		JLabel lblBack = new JLabel("Back");
		lblBack.setForeground(new Color(0, 0, 102));
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblBack.setBounds(19, 6, 70, 38);
		getContentPane().add(lblBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 201, 803, 234);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Full name", "Phone", "Father's name", "Father's phone", "Address", "Class", "Roll number"
			}
		) {
			
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class
			};
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		//btn SEARCH
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					// load mysql driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// create the connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagementsystem","root","root");
					// create a state of connection
					Statement st = con.createStatement();
					// create a query of select
					String query = "select * from student_registration ";
					
					ResultSet res = st.executeQuery(query);
					int test =0; 
					
					while(res.next())
					{
						if(res.getString(2).equals(txtSearch.getText())) {
							
							DefaultTableModel T = (DefaultTableModel) table.getModel();
							Object obj [] = {res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getInt(9)};
							T.addRow(obj);
							test=1;
						}
						
					}
					
					if (test==0)
						JOptionPane.showMessageDialog(SearchDeleteStudent.this, "This ID doesn't exist");
					
					con.close();
					txtSearch.setText("");

				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Error while establishing connection");

				}
			}
		});
		btnSearch.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnSearch.setBounds(444, 116, 101, 30);
		getContentPane().add(btnSearch);
		
		JLabel lblEnterID = new JLabel("Enter the student's ID :");
		lblEnterID.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEnterID.setBounds(19, 109, 217, 38);
		getContentPane().add(lblEnterID);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(239, 117, 183, 28);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblDelete = new JLabel("To delete student :");
		lblDelete.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDelete.setBounds(19, 159, 174, 30);
		getContentPane().add(lblDelete);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// load mysql driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// create the connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagementsystem","root","root");
					// create a query of delete 
					Statement st = con.createStatement();
					// create a query of select
					String query = "select * from student_registration ";
					
					ResultSet res = st.executeQuery(query);
					int x = 0;
					while(res.next())
					{
						if(res.getString(2).equals(txtSearch.getText())) {
							String query1 = "delete from student_registration where ID_student = ?";
							PreparedStatement ps = con.prepareStatement(query1);
							ps.setString(1,txtSearch.getText());
							ps.executeUpdate();
							x=1;
							JOptionPane.showMessageDialog(SearchDeleteStudent.this, "The data has been deleted successfully");
							break;
						}
					}
					if(x == 0)
						JOptionPane.showMessageDialog(SearchDeleteStudent.this, "This ID doesn't exist");
					con.close();
					txtSearch.setText("");
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Error while establishing connection");

				}
				
			}
		});
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnDelete.setBounds(195, 163, 89, 28);
		getContentPane().add(btnDelete);
		table.getColumnModel().getColumn(3).setPreferredWidth(74);
		table.getColumnModel().getColumn(4).setPreferredWidth(73);
		table.getColumnModel().getColumn(5).setPreferredWidth(64);
		table.getColumnModel().getColumn(6).setPreferredWidth(56);
		table.getColumnModel().getColumn(7).setPreferredWidth(82);
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
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDeleteStudent frame = new SearchDeleteStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
