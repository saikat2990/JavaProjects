package registration;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.BorderLayout;
import java.awt.Color;

public class Table {

	private JFrame frame;
	private JTable table;

	public Table() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 872, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		table = new JTable();
		
		DefaultTableModel model=new DefaultTableModel();
		Object[] columnItems= {"Acc.No","UserName","Email","Password","Gerder"};
		
	
		
		
		
		model.setColumnIdentifiers(columnItems);
		table.setModel(model);
		
		File file=new File("input.txt");
		
		
		//read data from table
		try {
			
			
			BufferedReader read = new BufferedReader(new FileReader(file));
			
			String s;
			while((s=read.readLine())!=null) {
		
				String[] str=s.split(",");
				
				
				model.addRow(str);
			
		
			}
		}catch(IOException e) {
			
			
		}
		
		
		

		
		
		table.setBounds(0,0,800,400);
		JTableHeader header=table.getTableHeader();
		header.setSize(400,200);
		header.setBackground(Color.blue);
		header.setFont(new Font("serif",Font.BOLD,20));
		
	
		
		
		
		 table.setAlignmentX(6);
		
		table.setRowHeight(30);
		
		table.setForeground(Color.black);
		
		
		table.setFont(new Font("serif",Font.BOLD,24));
		
		JScrollPane js=new JScrollPane(table);
		frame.getContentPane().add(js);
		
		frame.setVisible(true);
	}

}
