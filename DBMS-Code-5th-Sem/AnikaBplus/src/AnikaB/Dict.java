package AnikaB;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Dict {

	private JFrame frame;
	private JTextField input;
	//Font banglaFont=new Font("Arial Unicode MS", Font.BOLD,15);
	/**
	 * Launch the application.
	 */
	static Block rootblock= new Block();
	Dict(Block block){
		rootblock=block;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dict window = new Dict();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/*ZoneId zoneId = ZoneId.of("Europe/Paris"); 
		Clock clock=Clock.system(zoneId);
		Instant instant = clock.instant(); 
		ZonedDateTime time = instant.atZone(clock.getZone()); 
		System.out.println(time.toString());*/
		
	}
	

	//System.outprintln(time.toString());

	/*public void Traverse(Block curBlock, String val, int curBlockPosition){
	    int i;
	    for( i=0; i<curBlock.tNodes; i++){
	        if(val.compareTo(curBlock.stri[i])<0 && curBlock.childBlock[i]!=null){
	            Traverse(curBlock.childBlock[i],val, ++curBlockPosition);
	            return;
	        }
	        else if(val.compareTo(curBlock.stri[i])==0){
	        	//System.out.println("value found at level "+curBlockPosition);
	        	//JOptionPane.showMessageDialog(null, input.getText()+" found at level : " + curBlockPosition);
	        	
	        	JLabel label = new JLabel(input.getText()+" found at level : "+ curBlockPosition);
				label.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(null,label,"Message",JOptionPane.PLAIN_MESSAGE);
	            return;
	        }

	        /*else if(curBlock.childBlock[i]==NULL){

	        }*/
	   /* }
	    if(curBlock.childBlock[i]!=null){
	         Traverse(curBlock.childBlock[i],val, ++curBlockPosition);
	    }
	    else{
	        //System.out.println("Not found :(");
	    	//JOptionPane.showMessageDialog(null, input.getText()+" Not found :(");
	    	JLabel label = new JLabel(input.getText()+" Not found :(");
			label.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
			JOptionPane.showMessageDialog(null,label,"Message",JOptionPane.PLAIN_MESSAGE);
	    }
	    return;
	}*/

	boolean search(Block curBlock, String str)
	{
		boolean key = false;

		int i;

		for(i = 0 ; i<curBlock.tNodes; i++)
		{
			if(curBlock.stri[i] == str)
			{
				if(curBlock.childBlock[i+1] == null)
				{
					key = true;
					return key;
				}
				else
					key = search(curBlock.childBlock[i+1], str);
			}
			else if(((curBlock.stri[i].compareTo(str)) >0 ) && (curBlock.childBlock[i] != null))
				key = search(curBlock.childBlock[i],str);
			if(key)
				break;
			//cout << curBlock.stri[i] << endl;
		}

		if(!key && (curBlock.childBlock[i] != null))
			key = search(curBlock.childBlock[i],str);

		return key;
	}

	/**
	 * Create the application.
	 */
	public Dict() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		input = new JTextField();
		input.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		String in = input.getText();
		System.out.println(in);
		
		input.setBounds(34, 46, 168, 54);
		frame.getContentPane().add(input);
		
		input.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				long startTime = System.currentTimeMillis();

				search(rootblock,input.getText());	

				long endTime = System.currentTimeMillis();

				System.out.println("That took " + (endTime - startTime) + " milliseconds");
				/*long startTime = System.nanoTime();
				//methodToTime();
				Traverse(rootblock,input.getText(),0);	
				long endTime = System.nanoTime();

				long duration = (endTime - startTime); 
			System.out.println(duration);*/
			
			//JOptionPane.showMessageDialog(null, input.getText()+" found");
			
			/*JLabel label = new JLabel(input.getText()+" found");
			label.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
			JOptionPane.showMessageDialog(null,label,"Message",JOptionPane.PLAIN_MESSAGE);
			*/	
			}
		});

		btnSearch.setBounds(247, 61, 97, 25);
		frame.getContentPane().add(btnSearch);
	}
}

