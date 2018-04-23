package assignmentTwo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertGui extends State
{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnInsert;
	private Gui gui;

	/**
	 * Create the application.
	 */
	public InsertGui(Gui gui)
	{
		this.gui = gui;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize()
	{
		getContentPane().setLayout(null);
		JLabel lblInsertingInto = new JLabel("Inserting into <table name>");
		lblInsertingInto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInsertingInto.setBounds(10, 25, 192, 20);
		getContentPane().add(lblInsertingInto);
		
		textField = new JTextField();
		textField.setBounds(10, 145, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 145, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(202, 145, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(298, 145, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(394, 145, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(490, 145, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInsert.setBounds(607, 144, 89, 23);
		getContentPane().add(btnInsert);
	}

	@Override
	public void handle()
	{
		gui.setState(gui.getState("table"));
	}

}
