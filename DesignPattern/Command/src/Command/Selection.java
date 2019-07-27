package Command;

import java.awt.Graphics;

public class Selection {
	
	Command command;
	public Selection(Command command) {
		this.command=command;
	}
	
	public void press(Graphics g) {

		command.execute(g);
	}
	
	public void pressUndo(Graphics g) {
		command.undo(g);
	}
	
}
