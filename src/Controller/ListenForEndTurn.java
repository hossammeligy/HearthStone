package Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exceptions.FullHandException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.Spell;
import View.HearthStoneView;

public class ListenForEndTurn implements ActionListener {

String x;
String y;
public void updatecurHeroStats() {
	y ="Name:"+" "+ HearthStone.getModel().getCurrentHero().getName() + "\n" + " " + "CurrentHp:"+" "+ HearthStone.getModel().getCurrentHero().getCurrentHP() + "\n" + " " +"CurrentManaCrystals:"+" "+ HearthStone.getModel().getCurrentHero().getCurrentManaCrystals()
	+"\n" + " " +"TotalManaCrystals:"+" "+ HearthStone.getModel().getCurrentHero().getTotalManaCrystals() + "\n" + " " + "Left in deck:"+" "+ HearthStone.getModel().getCurrentHero().getDeck().size();
	HearthStone.getView().getText1().setText(y);
}
public void updateoppHeroStats() {
	y ="Name:"+" "+ HearthStone.getModel().getOpponent().getName() + "\n" + " " +"CurrentHp:"+" "+ HearthStone.getModel().getOpponent().getCurrentHP() + "\n" + " " +"CurrentManaCrystals:"+" "+ HearthStone.getModel().getOpponent().getCurrentManaCrystals()
	+"\n" + " " +"TotalManaCrystals:"+" "+ HearthStone.getModel().getOpponent().getTotalManaCrystals() + "\n" + " " +"Left in deck:"+" "+ HearthStone.getModel().getOpponent().getDeck().size()+"\n" + " "+"Left in hand:"+" "+HearthStone.getModel().getOpponent().getHand().size();
	HearthStone.getView().getText2().setText(y);
}
	
	
	public void actionPerformed(ActionEvent e) {
		
	
		try {
			HearthStone.getModel().endTurn();
		} 
		catch (FullHandException e1) {
			String z="";
			JFrame f=new JFrame();  
			Card c= e1.getBurned();
			if(c instanceof Minion) {
			Minion m=(Minion)c;
			 z ="<html>Name"+"  "+ m.getName()+"<br />"+"Rarity"+"  "+m.getRarity()+"<br />"+"ManaCost"+m.getManaCost()+"<br />" ;
			z+="Attack="+" "+m.getAttack() +"<br />" +"Current HP="+ m.getCurrentHP()+"<br />"; 
			
			if (m.isTaunt())
				z+= "Taunt" ;
			else {
				z+= "NotTaunt" ;
			}
			z+="<br />";
			if (m.isDivine())
				z+= "Divine" ; 
			else {
				z+= "NotDivine" ; 
			}
			z+="<br />";
			if (!m.isSleeping()) {
				z+="Charge" ;
			}
			else {
				z+= "NotCharge" ; 
			}
			z+="<br />";
			z+="</html>";
			
		} 	else {
			
			Spell s=(Spell)c;
			z ="<html>Name"+"  "+ s.getName()+"<br />"+"Rarity"+"  "+s.getRarity()+"<br />"+"ManaCost"+s.getManaCost()+"</html>" ;

			
		
	}
		JFrame x=new JFrame();  
	    JOptionPane.showMessageDialog(x,z,"U have burned this card",JOptionPane.WARNING_MESSAGE); 
		
	}
			catch (CloneNotSupportedException e1) {
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"U have burned this card","Alert",JOptionPane.WARNING_MESSAGE); 
		}

		
		HearthStone.getView().getContentPane().removeAll();
		HearthStone.getCur().clear();
		HearthStone.getFieldcur().clear();
	
		HearthStone.getView().getPanel2().removeAll();
		for (int i = 0; i < HearthStone.getModel().getCurrentHero().getHand().size(); i++) {
			if (HearthStone.getModel().getCurrentHero().getHand().get(i) instanceof Minion) {
				Minion n = (Minion) HearthStone.getModel().getCurrentHero().getHand().get(i);
				x = "<html>" +"Name :"+" "+n.getName() + "<br>" + " " +"ManaCost :"+" "+ n.getManaCost() + "<br>" + " " +"Rarity :"+" "+ n.getRarity() + "<br>" + " " +"Attack :"+" "+ n.getAttack()
						+ "<br>" + " " +"CurrentHp :"+" "+ n.getCurrentHP() + "<br>" + " " +"Taunt :"+" "+ n.isTaunt() +"<br>" + " " +"Divine :"+" "+ n.isDivine() + "<br>" + " "
						+"Sleeping :"+" "+ n.isSleeping()+"</html>";
				JButton b = new JButton();
				b.addActionListener(Heroes.getH());
				b.setText(x);
				HearthStone.getCur().add(b);
				HearthStone.getView().getPanel2().add(b);
			} else if (HearthStone.getModel().getCurrentHero().getHand().get(i) instanceof Spell) {
				Spell s = (Spell) HearthStone.getModel().getCurrentHero().getHand().get(i);
				x = "<html>"+"Name :"+" "+s.getName() + "<br>" + " " +"ManaCost :"+" "+ s.getManaCost() + "<br>"+ " " +"Rarity :"+" "+ s.getRarity()+"<html>";
				JButton b = new JButton();
				b.addActionListener(Heroes.getH());
				b.setText(x);
				HearthStone.getCur().add(b);
				HearthStone.getView().getPanel2().add(b);
			}
		}
		HearthStone.getView().getCurPanel().removeAll();
		for (int i = 0; i < HearthStone.getModel().getCurrentHero().getField().size(); i++) {
			Minion n = (Minion) HearthStone.getModel().getCurrentHero().getField().get(i);
			x = "<html>" +"Name :"+" "+n.getName() + "<br>" + " " +"ManaCost :"+" "+ n.getManaCost() + "<br>" + " " +"Rarity :"+" "+ n.getRarity() + "<br>" + " " +"Attack :"+" "+ n.getAttack()
					+ "<br>" + " " +"CurrentHp :"+" "+ n.getCurrentHP() + "<br>" + " " +"Taunt :"+" "+ n.isTaunt() +"<br>" + " " +"Divine :"+" "+ n.isDivine() + "<br>" + " "
					+"Sleeping :"+" "+ n.isSleeping()+"</html>";
			JButton b = new JButton();
			b.addActionListener(Heroes.getH());
			b.setText(x);
			HearthStone.getFieldcur().add(b);
			HearthStone.getView().getCurPanel().add(b);
		}
		updatecurHeroStats();
		HearthStone.getView().getPanel1().removeAll();
		HearthStone.getView().getOppPanel().removeAll();

		for (int i = 0; i < HearthStone.getModel().getOpponent().getField().size(); i++) {
			Minion n = (Minion) HearthStone.getModel().getOpponent().getField().get(i);
			x = "<html>" +"Name :"+" "+n.getName() + "<br>" + " " +"ManaCost :"+" "+ n.getManaCost() + "<br>" + " " +"Rarity :"+" "+ n.getRarity() + "<br>" + " " +"Attack :"+" "+ n.getAttack()
					+ "<br>" + " " +"CurrentHp :"+" "+ n.getCurrentHP() + "<br>" + " " +"Taunt :"+" "+ n.isTaunt() +"<br>" + " " +"Divine :"+" "+ n.isDivine() + "<br>" + " "
					+"Sleeping :"+" "+ n.isSleeping()+"</html>";
			JButton b = new JButton();
			b.addActionListener(Heroes.getH());
			b.setText(x);
			HearthStone.getView().getOppPanel().add(b);
		}
		
		
		
		
		
		
		
		
		
		
		updateoppHeroStats();

		
//	HearthStone.getView().add(HearthStone.getView().getPanel1());
	HearthStone.getView().addpanels();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		HearthStone.getView().revalidate();
		HearthStone.getView().repaint();	
		
		
	}
	
}
