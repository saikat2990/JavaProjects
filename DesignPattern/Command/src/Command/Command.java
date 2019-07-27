package Command;

import java.awt.Graphics;

public interface Command {

	public void execute(Graphics g);
	public void undo(Graphics g);
}
