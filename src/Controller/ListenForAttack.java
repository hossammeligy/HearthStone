package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.cards.minions.Minion;
import exceptions.CannotAttackException;
import exceptions.InvalidTargetException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;

public class ListenForAttack implements ActionListener {
	String x;
	String y;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(HearthStone.isAttacker()==true&&HearthStone.isAttacked()==true){
			try {
				HearthStone.getModel().getCurrentHero().attackWithMinion(HearthStone.getAttackerr(), HearthStone.getTarget());
			HearthStone.getView().getCurPanel().removeAll();
			HearthStone.getView().getOppPanel().removeAll();
			HearthStone.getFieldcur().clear();
			HearthStone.getFieldopp().clear();
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
			} catch (CannotAttackException | NotYourTurnException
					| TauntBypassException | InvalidTargetException
					| NotSummonedException e1) {
				 JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
			}
		}
		else if (HearthStone.isAttacker()==true&&HearthStone.isAttacked()==false){
			try {
		
				HearthStone.getModel().getCurrentHero().attackWithMinion(HearthStone.getAttackerr(), HearthStone.getModel().getOpponent());
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
			} catch (CannotAttackException | NotYourTurnException
					| TauntBypassException | NotSummonedException
					| InvalidTargetException e1) {
				JFrame f=new JFrame();  
			    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
			}
		
		}
		
	
		
		
		
		
		HearthStone.setAttacker(false);
		HearthStone.setAttacked(false);
		HearthStone.setAttackerr(null);
		HearthStone.setTarget(null);
		updatecurHeroStats();
		updateoppHeroStats();
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
