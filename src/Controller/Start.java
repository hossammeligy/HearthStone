package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import View.StartView;

public class Start implements ActionListener {
	private StartView view;
	public Start(){
		view = new StartView();
		JButton b = new JButton();
		b.setText("START");
		view.getPanel().add(b);
		b.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		arg0.getSource();
		new Heroes();
		view.dispose();
	}
	public static void main(String[] args) {
		new Start();
	}

}
