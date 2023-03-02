package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HeroesView extends JFrame {
	private JPanel panel1;
	private JPanel panel2;
	public HeroesView(){
		this.setSize(700, 700);
		panel1=new JPanel();
		panel1.setPreferredSize(new Dimension(getWidth(),getHeight()/2));
		panel1.setLayout(new GridLayout(0,1));
		this.add(panel1,BorderLayout.NORTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel2=new JPanel();
		panel2.setPreferredSize(new Dimension(getWidth(),getHeight()/2));
		panel2.setLayout(new GridLayout(0,1));
		this.add(panel2,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	public JPanel getPanel1() {
		return panel1;
	}
	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}
	public JPanel getPanel2() {
		return panel2;
	}
	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}
	public static void main(String[] args) {
		new HeroesView();
	}
}
