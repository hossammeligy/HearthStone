package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exceptions.FullHandException;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import View.HeroesView;
public class Heroes implements ActionListener {
	private HeroesView view;
	ArrayList<JButton>Buttoncur = new ArrayList<JButton>() ;
	ArrayList<JButton>Buttonopp = new ArrayList<JButton>() ;
	ArrayList<Hero>Heroes = new ArrayList<Hero>();
	int s = 0;
	private static HearthStone h;
	public Heroes(){
		view = new HeroesView();
		ArrayList<String>Names = new ArrayList<String>();
		Names.add("Hunter");
		Names.add("Mage");
		Names.add("Paladin");
		Names.add("Priest");
		Names.add("Warlock");
		for(int i=0;i<5;i++){
			JButton b = new JButton();
			b.setText(Names.get(i));
			view.getPanel1().add(b);
			b.addActionListener(this);
			Buttoncur.add(b);
		}
		for(int i=0;i<5;i++){
			JButton b = new JButton();
			b.setText(Names.get(i));
			view.getPanel2().add(b);
			b.addActionListener(this);
			Buttonopp.add(b);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JButton b = (JButton) arg0.getSource();
		if(b.getActionCommand().equals("Hunter")){
			try {
				Heroes.add(new Hunter());
				s++;
			} catch (IOException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			} catch (CloneNotSupportedException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			}
		}
		if(b.getActionCommand().equals("Mage")){
			try {
				Heroes.add(new Mage());
				s++;
			} catch (IOException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			} catch (CloneNotSupportedException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			}
		}
		if(b.getActionCommand().equals("Paladin")){
			try {
				Heroes.add(new Paladin());
				s++;
			} catch (IOException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			} catch (CloneNotSupportedException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			}
		}
		if(b.getActionCommand().equals("Priest")){
			try {
				Heroes.add(new Priest());
				s++;
			} catch (IOException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			} catch (CloneNotSupportedException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			}
		}
		if(b.getActionCommand().equals("Warlock")){
			try {
				Heroes.add(new Warlock());
				s++;
			} catch (IOException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			} catch (CloneNotSupportedException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			}
		}
		if(s==2){
			try {
			 h=	new HearthStone(Heroes.get(0), Heroes.get(1));
			 view.dispose();
			} catch (FullHandException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			} catch (CloneNotSupportedException e) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			}	
		}
		
		
	}
	public static HearthStone getH() {
		return h;
	}
	

}
