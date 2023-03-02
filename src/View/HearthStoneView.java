package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class HearthStoneView extends JFrame {
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTextArea text1;
	private JTextArea text2;
	private JPanel curPanel;
	private JPanel oppPanel;
	private JPanel choices;
	public JPanel getCurPanel() {
		return curPanel;
	}
	public void setCurPanel(JPanel curPanel) {
		this.curPanel = curPanel;
	}
	public JPanel getOppPanel() {
		return oppPanel;
	}
	public void setOppPanel(JPanel oppPanel) {
		this.oppPanel = oppPanel;
	}
	public HearthStoneView(){
		
		super();
this.setSize(1000,800);
this.setDefaultCloseOperation(EXIT_ON_CLOSE);
panel1=new JPanel();
panel2=new JPanel();

curPanel =new JPanel();

oppPanel =new JPanel();
panel3=new JPanel();


text1= new JTextArea();
text2= new JTextArea();
choices=new JPanel();

		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	public JTextArea getText1() {
		return text1;
	}
	public JTextArea getText2() {
		return text2;
	}
	public void setText1(JTextArea text1) {
		this.text1 = text1;
	}
	public void setText2(JTextArea text2) {
		this.text2 = text2;
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
	public JPanel getPanel3() {
		return panel3;
	}
	public void setPanel3(JPanel panel3) {
		this.panel3 = panel3;
	}
	public static void main(String[] args) {
		new HearthStoneView();
	}
	public void addpanels(){

		
		panel1.setPreferredSize(new Dimension(getWidth(),200));
		panel1.setLayout(new GridLayout(1,10));
		this.add(panel1,BorderLayout.NORTH);
		
		choices.setPreferredSize(new Dimension(200,200));
		choices.setLayout(new GridLayout(0,1));
		this.add(choices,BorderLayout.EAST);
	
		
		panel2.setPreferredSize(new Dimension(getWidth(),200));
		panel2.setLayout(new GridLayout(1,10));
		this.add(panel2,BorderLayout.SOUTH);
	
		panel3.setPreferredSize(new Dimension(getWidth(),600));
		panel3.setLayout(new GridLayout(2,1));
		this.add(panel3,BorderLayout.CENTER);
	
		oppPanel.setLayout(new GridLayout(1,7));
	   
		curPanel.setLayout(new GridLayout(1,7));
		panel3.add(oppPanel);
		panel3.add(curPanel);
	
		text1.setPreferredSize(new Dimension(100,100));
		text1.setEditable(false);
		panel2.add(text1,BorderLayout.EAST);
	
		text2.setPreferredSize(new Dimension(100,100));
		text2.setEditable(false);
		panel1.add(text2,BorderLayout.WEST);
	
	
	}
	public JPanel getChoices() {
		return choices;
	}
}
