
package Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import View.HearthStoneView;
import Controller.Start;
import engine.Game;
import engine.GameListener;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.minions.Minion;
import model.cards.spells.Spell;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;

public class HearthStone implements ActionListener, GameListener {
	private static Game model;
	private static HearthStoneView view;
	private static ArrayList<JButton> fieldcur ;
	private static ArrayList<JButton> opp ;
	private static ArrayList<JButton> cur ;
	private static boolean attacker=false;
	private static boolean attacked=false;
	private static Minion attackerr;
	private static Minion target;
	private ListenForCastSpell lForCastSpell;
	
	private static Spell s;
	
	
	private ListenForUseHeroPower lForUseHeroPower;
	
	public static Minion getAttackerr() {
		return attackerr;
	}
	public static void setAttackerr(Minion attackerr) {
		HearthStone.attackerr = attackerr;
	}
	public static Minion getTarget() {
		return target;
	}
	public static void setTarget(Minion target) {
		HearthStone.target = target;
	}
	public static boolean isAttacker() {
		return attacker;
	}
	public static void setAttacker(boolean attacker) {
		HearthStone.attacker = attacker;
	}
	public static boolean isAttacked() {
		return attacked;
	}
	public static void setAttacked(boolean attacked) {
		HearthStone.attacked = attacked;
	}
	public static Game getModel() {
		return model;
	}
	public static ArrayList<JButton> getFieldcur() {
		return fieldcur;
	}
	
	public static ArrayList<JButton> getCur() {
		return cur;
	}

	public Hero getP1() {
		return p1;
	}
	public Hero getP2() {
		return p2;
	}
	public JButton getA() {
		return a;
	}
	public Start getStart() {
		return start;
	}
	public JPanel getPanelcurr() {
		return panelcurr;
	}
	public JPanel getPanelopp() {
		return panelopp;
	}
	public String getX() {
		return x;
	}
	public String getY() {
		return y;
	}
	public ListenForEndTurn getlForEndTurn() {
		return lForEndTurn;
	}







	private static ArrayList<JButton> fieldopp ;
	private Hero p1;
	private Hero p2;
	private JButton a ;
	private JButton c ;
	private JButton d ;
	private JButton e ;
	private ListenForAttack lForAttack;
	private Start start;
	public static HearthStoneView getView() {
		return view;
	}
	public static void setView(HearthStoneView view) {
		HearthStone.view = view;
	}

	
	
	
	
	
	
	private JPanel panelcurr;
	private JPanel panelopp;
	String x = " ";
	String y = " ";
private ListenForEndTurn lForEndTurn;










	public HearthStone(Hero hero1, Hero hero2) throws FullHandException, CloneNotSupportedException {
		fieldcur = new ArrayList<JButton>();
		 opp = new ArrayList<JButton>();
		cur = new ArrayList<JButton>();
		fieldopp = new ArrayList<JButton>();
		model = new Game(hero1, hero2);
		model.setListener(this);
		p1 = model.getCurrentHero();
		p2 = model.getOpponent();

		view = new HearthStoneView();
		view.addpanels();

	
		
		
		 a = new JButton();
		a.setText("End Turn");
		ListenForEndTurn lForEndTurn = new ListenForEndTurn();
		a.addActionListener(lForEndTurn);
	view.getChoices().add(a);
	 c = new JButton();
		c.setText("Attack");
		
		 lForAttack=new ListenForAttack();
		c.addActionListener(lForAttack);
		
	view.getChoices().add(c);
	 d = new JButton();
		d.setText("Cast Spell");
		 lForCastSpell = new ListenForCastSpell();
		d.addActionListener(lForCastSpell);
	view.getChoices().add(d);
	 e = new JButton();
		e.setText("Use hero power ");
		
		 lForUseHeroPower=new ListenForUseHeroPower();
		e.addActionListener(lForUseHeroPower);
		
		
		
	view.getChoices().add(e);
		updatecur();
		updatecurHeroStats();
		updateoppHeroStats();
		view.revalidate();
		view.repaint();
	}
public void updatecurHeroStats() {
	y ="Name:"+" "+ p1.getName() + "\n" + " " +"CurrentHp:"+" "+ p1.getCurrentHP() + "\n" + " " +"CurrentManaCrystals:"+" "+ p1.getCurrentManaCrystals()+"\n" + " " +
			"TotalManaCrystals:"+" "+ p1.getTotalManaCrystals() + "\n" + " " +"Left in deck:"+" "+ p1.getDeck().size();
	view.getText1().setText(y);
}
public void updateoppHeroStats() {
	y ="Name:"+" "+ p2.getName() + "\n" + " " +"CurrentHp:"+" "+ p2.getCurrentHP() + "\n" + " " +"CurrentManaCrystals:"+" "+ p2.getCurrentManaCrystals()+"\n" + " " +
			"TotalManaCrystals:"+" "+ p2.getTotalManaCrystals() + "\n" + " " +"Left in deck:"+" "+ p2.getDeck().size();
	view.getText2().setText(y);
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton b = (JButton) arg0.getSource();

		
		if (cur.contains(b)) {
			int o = cur.indexOf(b);
			if (model.getCurrentHero().getHand().get(o) instanceof Minion) {
				Minion n = (Minion) model.getCurrentHero().getHand().get(o);
				try {
					model.getCurrentHero().playMinion(n);
					updatecur();
					updatefieldcur();
				} catch (NotYourTurnException e) {
					 JFrame f=new JFrame();  
					    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
				} catch (NotEnoughManaException e) {
					 JFrame f=new JFrame();  
					    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
				} catch (FullFieldException e) {
					 JFrame f=new JFrame();  
					    JOptionPane.showMessageDialog(f,e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);    
				
				}
			}
			else{
				s=(Spell)model.getCurrentHero().getHand().get(o);
			}
		
		}
		else if(fieldcur.contains(b)){
			attacker=true;
			int p = fieldcur.indexOf(b);
			attackerr= model.getCurrentHero().getField().get(p);
			}
		else if(fieldopp.contains(b)){
			attacked=true;
			int p = fieldopp.indexOf(b);
			target= model.getOpponent().getField().get(p);
		}
	
		view.revalidate();
		view.repaint();
	}
	public static Spell getS() {
		return s;
	}
	public static void setS(Spell s) {
		HearthStone.s = s;
	}
	public void updatecur() {
		view.getPanel2().removeAll();
		view.getPanel2().add(view.getText1());
		cur.clear();

		for (int i = 0; i < model.getCurrentHero().getHand().size(); i++) {
			if (model.getCurrentHero().getHand().get(i) instanceof Minion) {
				Minion n = (Minion) model.getCurrentHero().getHand().get(i);
				x = "<html>" +"Name :"+" "+n.getName() + "<br>" + " " +"ManaCost :"+" "+ n.getManaCost() + "<br>" + " " +"Rarity :"+" "+ n.getRarity() + "<br>" + " " +"Attack :"+" "+ n.getAttack()
						+ "<br>" + " " +"CurrentHp :"+" "+ n.getCurrentHP() + "<br>" + " " +"Taunt :"+" "+ n.isTaunt() +"<br>" + " " +"Divine :"+" "+ n.isDivine() + "<br>" + " "
						+"Sleeping :"+" "+ n.isSleeping()+"</html>";
				JButton b = new JButton();
				b.addActionListener(Heroes.getH());
				b.setText(x);
				cur.add(b);
				view.getPanel2().add(b);
			} else if (model.getCurrentHero().getHand().get(i) instanceof Spell) {
				Spell s = (Spell) model.getCurrentHero().getHand().get(i);
				x = "<html>"+"Name :"+" "+s.getName() + "<br>" + " " +"ManaCost :"+" "+ s.getManaCost() + "<br>"+ " " +"Rarity :"+" "+ s.getRarity()+"<html>";
				JButton b = new JButton();
				b.addActionListener(Heroes.getH());
				b.setText(x);
				cur.add(b);
				view.getPanel2().add(b);
			}
		}
		
		
		
	}


	public void updatefieldcur() {
		
		view.getCurPanel().removeAll();
		fieldcur.clear();
		for (int i = 0; i < model.getCurrentHero().getField().size(); i++) {
			Minion n = (Minion) model.getCurrentHero().getField().get(i);
			x = "<html>" +"Name :"+" "+n.getName() + "<br>" + " " +"ManaCost :"+" "+ n.getManaCost() + "<br>" + " " +"Rarity :"+" "+ n.getRarity() + "<br>" + " " +"Attack :"+" "+ n.getAttack()
					+ "<br>" + " " +"CurrentHp :"+" "+ n.getCurrentHP() + "<br>" + " " +"Taunt :"+" "+ n.isTaunt() +"<br>" + " " +"Divine :"+" "+ n.isDivine() + "<br>" + " "
					+"Sleeping :"+" "+ n.isSleeping()+"</html>";
			JButton b = new JButton();
			b.addActionListener(Heroes.getH());
			b.setText(x);
			fieldcur.add(b);
			view.getCurPanel().add(b);
		}
	}

	public void updatefieldopp() {
		
		view.getOppPanel().removeAll();
	    fieldopp.clear();
		
		for (int i = 0; i < model.getOpponent().getField().size(); i++) {
			Minion n = (Minion) model.getOpponent().getField().get(i);
			x = "<html>" +"Name :"+" "+n.getName() + "<br>" + " " +"ManaCost :"+" "+ n.getManaCost() + "<br>" + " " +"Rarity :"+" "+ n.getRarity() + "<br>" + " " +"Attack :"+" "+ n.getAttack()
					+ "<br>" + " " +"CurrentHp :"+" "+ n.getCurrentHP() + "<br>" + " " +"Taunt :"+" "+ n.isTaunt() +"<br>" + " " +"Divine :"+" "+ n.isDivine() + "<br>" + " "
					+"Sleeping :"+" "+ n.isSleeping()+"</html>";
			JButton b = new JButton();
			b.addActionListener(Heroes.getH());
			b.setText(x);
			fieldopp.add(b);
			view.getOppPanel().add(b);
		}
	}


	public void onGameOver() {
		view.setVisible(false);
		JFrame frame = new JFrame();
		frame.setTitle("WINNER");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelwinner = new JPanel();
		panelwinner.setPreferredSize(new Dimension(600,600));
		panelwinner.setLayout(new GridLayout(1,10));
		frame.add(panelwinner,BorderLayout.CENTER);
		JTextArea j = new JTextArea();
		j.setPreferredSize(new Dimension(300,300));
		j.setEditable(false);
		panelwinner.add(j,BorderLayout.CENTER);
		if(model.getCurrentHero().getCurrentHP()<=0) {
			j.setText(model.getOpponent().getName());
		}
		else {
			j.setText(model.getCurrentHero().getName());
		}
		frame.setVisible(true);
		frame.revalidate();
		frame.repaint();
	}
}
