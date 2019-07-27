package CompositePattern;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Graphics.*;
import java.awt.color.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class OrientalMainDraw  extends JFrame{
	
	int x1,y1,x2,y2;
	String condition;
	public OrientalMainDraw() {
		
		setTitle("Final");
		setSize(1500,1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	public void paint(Graphics g) {
	
		
		
		HutBuilder orientalHut = new OrientalHut(g,900,200,100,200);
		orientalHut.draw();
		
		//OccidentalHut occidentalHut = new OccidentalHut(g,800,200,100,200);
		//occidentalHut.draw();
		
		Flora orientalTree =new  OrientalTree(g);
		//OccidentalTree occidentalTree = new OccidentalTree(g);
		Founa orientalFouna = new OrientalFouna(g);
		
		Pond pond = new OrientalPond(g,800,600);
		pond.draw();
		int val = pond.getWater();
		
		CheckVolume cor = new CheckVolume(val, "OrientalPond");
		condition  = cor.getCondition();
		
		ArrayList<Observer> arrayList = new ArrayList<Observer>();
		arrayList.add(new OrientalObserver());
		arrayList.add(new OccidentalObserver());
		
		for(Observer ob : arrayList) {
			ob.Update(condition);
		}
		
		Strategy s = new Software();
		if(s.getAccess()) {
			MediatorImplement mediatorImplement = new MediatorImplement();
//			OrientalEnvirnment m = new OrientalEnvirnment();
			mediatorImplement.conditionSet("Oriental", condition);
			System.out.println(mediatorImplement.conditionGet("Occidental"));
		}else {
			
			System.out.println("You are a normal user");
		}

		
		CommandforMarraige marraige = new Marraige();
		Scanner scanner = new Scanner( System.in );
		
		
		while(true) {
			
			String person1 = scanner.nextLine();
			String person2 = scanner.nextLine();
			marraige.doMarraige(person1, person2);
			
			if(marraige.checkCouple(person1, person2)) {
				break;
			}else {
				marraige.pressUndo(person1, person2);
				System.out.println("wrong couple match please enter again");
			}
		}
		
		
		
		

	}
	
	public String getCondition() {
		return condition;
	}
	public void setVariable(int x1,int y1,int x2,int y2) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
	}
	
}
