package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.cards.minions.Minion;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;

public class ListenForUseHeroPower implements ActionListener{
String x;
	String y;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(HearthStone.getModel().getCurrentHero().getName().equals("Rexxar")){
			try {
				HearthStone.getModel().getCurrentHero().useHeroPower();
				updatecurHeroStats();
			} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
					| NotYourTurnException | FullHandException
					| FullFieldException | CloneNotSupportedException e1) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE); 
			}
		}
		else if (HearthStone.getModel().getCurrentHero().getName().equals("Jaina Proudmoore")){
			if(HearthStone.isAttacked()==true){
				Mage m = (Mage) HearthStone.getModel().getCurrentHero();
				try {
					m.useHeroPower(HearthStone.getTarget());
					HearthStone.getView().getOppPanel().removeAll();
					HearthStone.getFieldopp().clear();
					for (int i = 0; i < HearthStone.getModel().getOpponent().getField().size(); i++) {
						Minion n = (Minion) HearthStone.getModel().getOpponent().getField().get(i);
						x = "<html>" +"Name :"+" "+n.getName() + "<br>" + " " +"ManaCost :"+" "+ n.getManaCost() + "<br>" + " " +"Rarity :"+" "+ n.getRarity() + "<br>" + " " +"Attack :"+" "+ n.getAttack()
								+ "<br>" + " " +"CurrentHp :"+" "+ n.getCurrentHP() + "<br>" + " " +"Taunt :"+" "+ n.isTaunt() +"<br>" + " " +"Divine :"+" "+ n.isDivine() + "<br>" + " "
								+"Sleeping :"+" "+ n.isSleeping()+"</html>";
						JButton b = new JButton();
						b.addActionListener(Heroes.getH());
						b.setText(x);
						HearthStone.getFieldopp().add(b);
						HearthStone.getView().getOppPanel().add(b);
					}
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
						| NotYourTurnException | FullHandException
						| FullFieldException | CloneNotSupportedException e1) {
					JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE); 
				}
			}
			else if(HearthStone.isAttacked()==false){
				Mage m = (Mage) HearthStone.getModel().getCurrentHero();
				try {
					m.useHeroPower(HearthStone.getModel().getOpponent());
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
						| NotYourTurnException | FullHandException
						| FullFieldException | CloneNotSupportedException e1) {
					JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE); 
				}
			}
			else{
				JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"YOU DIDN'T CHOOSE","Alert",JOptionPane.WARNING_MESSAGE); 
			}
		}
	else if (HearthStone.getModel().getCurrentHero().getName().equals("Uther Lightbringer")){
		Paladin p = (Paladin) HearthStone.getModel().getCurrentHero();
		try {
			p.useHeroPower();
			Minion n = HearthStone.getModel().getCurrentHero().getField().get(HearthStone.getModel().getCurrentHero().getField().size()-1);
			x = "<html>" +"Name :"+" "+n.getName() + "<br>" + " " +"ManaCost :"+" "+ n.getManaCost() + "<br>" + " " +"Rarity :"+" "+ n.getRarity() + "<br>" + " " +"Attack :"+" "+ n.getAttack()
					+ "<br>" + " " +"CurrentHp :"+" "+ n.getCurrentHP() + "<br>" + " " +"Taunt :"+" "+ n.isTaunt() +"<br>" + " " +"Divine :"+" "+ n.isDivine() + "<br>" + " "
					+"Sleeping :"+" "+ n.isSleeping()+"</html>";
			JButton r = new JButton();
			r.setText(x);
			HearthStone.getView().getCurPanel().add(r);
			HearthStone.getFieldcur().add(r);
			r.addActionListener(Heroes.getH());
		} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
				| NotYourTurnException | FullHandException | FullFieldException
				| CloneNotSupportedException e1) {
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE); 
		}	
		}
	else if (HearthStone.getModel().getCurrentHero().getName().equals("Anduin Wrynn")){
		if(HearthStone.isAttacker()==true){
			Priest p = (Priest) HearthStone.getModel().getCurrentHero();
			try {
				p.useHeroPower(HearthStone.getAttackerr());
				HearthStone.getView().getCurPanel().removeAll();
				HearthStone.getFieldcur().clear();
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
			} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
					| NotYourTurnException | FullHandException
					| FullFieldException | CloneNotSupportedException e1) {
				JFrame f=new JFrame();  
			    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE); 
			}
		}
		else if(HearthStone.isAttacker()==false){
			Priest p = (Priest) HearthStone.getModel().getCurrentHero();
			try {
				p.useHeroPower(HearthStone.getModel().getCurrentHero());
			} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
					| NotYourTurnException | FullHandException
					| FullFieldException | CloneNotSupportedException e1) {
				JFrame f=new JFrame();  
			    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE); 
			}
		}
		else{
			JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,"YOU DIDN'T CHOOSE","Alert",JOptionPane.WARNING_MESSAGE); 
		}
	}
	else if (HearthStone.getModel().getCurrentHero().getName().equals("Gul'dan")){
		Warlock w = (Warlock) HearthStone.getModel().getCurrentHero();
		try {
			w.useHeroPower();
			Minion n = HearthStone.getModel().getCurrentHero().getField().get(HearthStone.getModel().getCurrentHero().getField().size()-1);
			x = "<html>" +"Name :"+" "+n.getName() + "<br>" + " " +"ManaCost :"+" "+ n.getManaCost() + "<br>" + " " +"Rarity :"+" "+ n.getRarity() + "<br>" + " " +"Attack :"+" "+ n.getAttack()
					+ "<br>" + " " +"CurrentHp :"+" "+ n.getCurrentHP() + "<br>" + " " +"Taunt :"+" "+ n.isTaunt() +"<br>" + " " +"Divine :"+" "+ n.isDivine() + "<br>" + " "
					+"Sleeping :"+" "+ n.isSleeping()+"</html>";
			JButton r = new JButton();
			r.setText(x);
			HearthStone.getView().getPanel2().add(r);
			HearthStone.getCur().add(r);
			r.addActionListener(Heroes.getH());
			} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
				| NotYourTurnException | FullHandException | FullFieldException
				| CloneNotSupportedException e1) {
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE); 
		}
	}
		
		
		
		
		updatecurHeroStats();
		updateoppHeroStats();
		HearthStone.setAttacker(false);
		HearthStone.setAttacked(false);
		HearthStone.setAttackerr(null);
		HearthStone.setTarget(null);
		HearthStone.getView().revalidate();
		HearthStone.getView().repaint();
			
	}
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

}
