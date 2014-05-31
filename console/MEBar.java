package console;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MEBar extends JMenuBar implements ActionListener{
	private MapEditor editor;
	private JMenuItem save, n, load;
	private JFileChooser filer;
	
	public MEBar(MapEditor e) {
		editor = e;
		filer = new JFileChooser();
		JMenu menu = new JMenu("File");
		add(menu);
		
		save = new JMenuItem("Save (Not Functional)");
		n = new JMenuItem("New (Broken)");
		load = new JMenuItem("Load (Not Functional)");
		
		menu.add(save);
		menu.add(n);
		menu.add(load);
		
		save.addActionListener(this);
		n.addActionListener(this);
		load.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == save) {
			if(filer.showOpenDialog(editor) == JFileChooser.APPROVE_OPTION) {
				editor.save(filer.getSelectedFile());
			}
		} else if(e.getSource() == n) {
			editor.clear_all();
		} else if(e.getSource() == load) {
			if(filer.showSaveDialog(editor) == JFileChooser.APPROVE_OPTION) {
				editor.load(filer.getSelectedFile());
			}
		}
	}

}
