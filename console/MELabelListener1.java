package console;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MELabelListener1 implements MouseListener{
	private MapEditor editor;
	
	public MELabelListener1(MapEditor e) {
		editor = e;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		editor.selected(e.getSource());
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
