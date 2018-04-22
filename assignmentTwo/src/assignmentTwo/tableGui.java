package assignmentTwo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class tableGui extends JFrame implements MouseListener
{

	private JPanel contentPane;
	private JTextField query;
	private JTable table;
	boolean tablesExist = true;
	private JButton btnShowTables;
	private JButton btnSelect;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnInsert;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					tableGui frame = new tableGui();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public tableGui() throws Exception
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JDBC jdbc = new JDBC();
		if(tablesExist)
			try {
					jdbc.dropTables();
			}
		catch(SQLException e1) {
			
		}
		jdbc.buildTables();
		jdbc.populateTables();
		WindowListener exitListener = new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "Are You Sure to Close Application?", 
		             "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) 
		        {
		           try {
					jdbc.dropTables();
				} catch (SQLException e1) 
		           {
					e1.printStackTrace();
		           }
		           System.exit(0);
		        }
		    }
		    
		};
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(exitListener);
		
		
		

		btnShowTables = new JButton("Show Tables");
		btnShowTables.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					jdbc.showTables();
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShowTables.setBounds(10, 35, 108, 23);
		contentPane.add(btnShowTables);

		btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});
		btnSelect.setBounds(128, 35, 89, 23);
		contentPane.add(btnSelect);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				deleteGui delete= new deleteGui();
				delete.delete();
			}
		});
		btnDelete.setBounds(909, 35, 89, 23);
		contentPane.add(btnDelete);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				updateGui update = new updateGui();
				update.update();
			}
		});
		btnUpdate.setBounds(810, 35, 89, 23);
		contentPane.add(btnUpdate);

		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				insertGui insert = new insertGui();
				insert.insert();
			}
		});
		btnInsert.setBounds(711, 35, 89, 23);
		contentPane.add(btnInsert);

		JLabel lblEnterQueryTo = new JLabel("Enter query to see results below:");
		lblEnterQueryTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterQueryTo.setBounds(10, 87, 218, 14);
		contentPane.add(lblEnterQueryTo);

		query = new JTextField();
		query.setBounds(10, 112, 705, 20);
		contentPane.add(query);
		query.setColumns(10);

		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResults.setBounds(10, 144, 63, 23);
		contentPane.add(lblResults);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 179, 705, 383);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	@Override
	public void mouseClicked(MouseEvent event)
	{
		JButton selection = (JButton) event.getSource();
		String text = selection.getText();
		
		if(text.equals(btnShowTables.getText()))
		{
			System.out.println("Show Tables was pressed");
		}
		else if (text.equals(btnSelect.getText()))
		{
			System.out.println("Select was pressed");
		}
		else if (text.equals(btnDelete.getText()))
		{
			System.out.println("Delete was pressed");
		}
		else if (text.equals(btnUpdate.getText()))
		{
			System.out.println("Update was pressed");
		}
		else if (text.equals(btnInsert.getText()))
		{
			System.out.println("Insert was pressed");
		}
		else 
		{
			System.out.println("A button was not pressed");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
