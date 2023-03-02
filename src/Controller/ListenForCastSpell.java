package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.minions.Minion;
import model.cards.spells.CurseOfWeakness;
import model.cards.spells.DivineSpirit;
import model.cards.spells.Flamestrike;
import model.cards.spells.HolyNova;
import model.cards.spells.KillCommand;
import model.cards.spells.LeechingSpell;
import model.cards.spells.LevelUp;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.MultiShot;
import model.cards.spells.Polymorph;
import model.cards.spells.Pyroblast;
import model.cards.spells.SealOfChampions;
import model.cards.spells.ShadowWordDeath;
import model.cards.spells.Spell;
import model.cards.spells.TwistingNether;

public class ListenForCastSpell implements ActionListener {
String x;
String y;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(HearthStone.getS()==null){
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"YOU DIDN'T CHOOSE","Alert",JOptionPane.WARNING_MESSAGE); 
		}
		
		else if(HearthStone.getS()!=null){
		Spell s = HearthStone.getS();
if(s.getName().equals("Curse of Weakness")){
	try {
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
		}		HearthStone.getModel().getCurrentHero().castSpell((CurseOfWeakness)s, HearthStone.getModel().getOpponent().getField());
	} catch (NotYourTurnException | NotEnoughManaException e1) {
		JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
	}
			
		}
else if(s.getName().equals("Divine Spirit")){
	try {
		if(HearthStone.getAttackerr()==null){
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"You don't choose a minion","Alert",JOptionPane.WARNING_MESSAGE);
		}
		HearthStone.getModel().getCurrentHero().castSpell((DivineSpirit)s, HearthStone.getAttackerr());
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
	} catch (NotYourTurnException | NotEnoughManaException
			| InvalidTargetException e1) {
		JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
	}
}
else if(s.getName().equals("Flamestrike")){
try {
		
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
		}HearthStone.getModel().getCurrentHero().castSpell((Flamestrike)s, HearthStone.getModel().getOpponent().getField());
	} catch (NotYourTurnException | NotEnoughManaException e1) {
		JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
	}
			
}
else if(s.getName().equals("Holy Nova")){
	try {
		
	HearthStone.getModel().getCurrentHero().castSpell((HolyNova)s, HearthStone.getModel().getOpponent().getField());
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
		HearthStone.getView().getOppPanel().add(b);}
	} catch (NotYourTurnException | NotEnoughManaException e1) {
		JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
	}
}
else if(s.getName().equals("Kill Command")){
	if(HearthStone.isAttacked()==true){
		try {
			if(HearthStone.getTarget()==null){
				JFrame f=new JFrame();  
			    JOptionPane.showMessageDialog(f,"You don't choose a minion","Alert",JOptionPane.WARNING_MESSAGE);
			}
			HearthStone.getModel().getCurrentHero().castSpell((MinionTargetSpell) s, HearthStone.getTarget());
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
			
		} catch (NotYourTurnException | NotEnoughManaException
				| InvalidTargetException e1) {
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
		}
	}
	else {
		try {
			HearthStone.getModel().getCurrentHero().castSpell((KillCommand)s, HearthStone.getModel().getOpponent());
		} catch (NotYourTurnException | NotEnoughManaException e1) {
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
		}
	}
}
else if(s.getName().equals("Level Up!")){
	try {
		HearthStone.getModel().getCurrentHero().castSpell((LevelUp)s);
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
	} catch (NotYourTurnException | NotEnoughManaException e1) {
		JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
	}
	
}
else if(s.getName().equals("Multi-Shot")){
	try {
		HearthStone.getModel().getCurrentHero().castSpell((MultiShot)s, HearthStone.getModel().getOpponent().getField());
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
	} catch (NotYourTurnException | NotEnoughManaException e1) {
		JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
	}

}
else if(s.getName().equals("Polymorph")){
	try {
		if(HearthStone.getAttackerr()==null){
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"You don't choose a minion","Alert",JOptionPane.WARNING_MESSAGE);
		}
		HearthStone.getModel().getCurrentHero().castSpell((Polymorph)s, HearthStone.getAttackerr());
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
	} catch (NotYourTurnException | NotEnoughManaException
			| InvalidTargetException e1) {
		JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
	}

}
else if(s.getName().equals("Pyroblast")){
	if(HearthStone.isAttacked()==true){
		try {
			if(HearthStone.getTarget()==null){
				JFrame f=new JFrame();  
			    JOptionPane.showMessageDialog(f,"You don't choose a minion","Alert",JOptionPane.WARNING_MESSAGE);
			}
			HearthStone.getModel().getCurrentHero().castSpell((MinionTargetSpell) s, HearthStone.getTarget());
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
			
		} catch (NotYourTurnException | NotEnoughManaException
				| InvalidTargetException e1) {
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
		}
	}
	else {
		try {
			HearthStone.getModel().getCurrentHero().castSpell((Pyroblast)s, HearthStone.getModel().getOpponent());
		} catch (NotYourTurnException | NotEnoughManaException e1) {
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
		}
	}
	
}
else if(s.getName().equals("Seal of Champions")){
	try {
		if(HearthStone.getAttackerr()==null){
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"You don't choose a minion","Alert",JOptionPane.WARNING_MESSAGE);
		}
		HearthStone.getModel().getCurrentHero().castSpell((SealOfChampions)s, HearthStone.getAttackerr());
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
	} catch (NotYourTurnException | NotEnoughManaException
			| InvalidTargetException e1) {
		JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
	}
}
	
else if(s.getName().equals("Shadow Word: Death")){
	try {
		if(HearthStone.getTarget()==null){
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"You don't choose a minion","Alert",JOptionPane.WARNING_MESSAGE);
		}
		HearthStone.getModel().getCurrentHero().castSpell((ShadowWordDeath)s, HearthStone.getTarget());
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
			HearthStone.getView().getOppPanel().add(b);}
	} catch (NotYourTurnException | NotEnoughManaException
			| InvalidTargetException e1) {
		JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
	}

	
}
else if(s.getName().equals("Siphon Soul")){
	try {
		if(HearthStone.getTarget()==null){
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"You don't choose a minion","Alert",JOptionPane.WARNING_MESSAGE);
		}
		HearthStone.getModel().getCurrentHero().castSpell((LeechingSpell)s, HearthStone.getTarget());
		HearthStone.getView().getOppPanel().removeAll();
		HearthStone.getFieldopp().clear();
		if(HearthStone.getTarget()==null){
			JFrame f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"You don't choose a minion","Alert",JOptionPane.WARNING_MESSAGE);
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
			HearthStone.getView().getOppPanel().add(b);}
	} catch (NotYourTurnException | NotEnoughManaException e1) {
		JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);
	}
	
}
else if(s.getName().equals("Twisting Nether")){
	try {
		HearthStone.getModel().getCurrentHero().castSpell((TwistingNether)s, HearthStone.getModel().getOpponent().getField());
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
			HearthStone.getView().getOppPanel().add(b);}
	} catch (NotYourTurnException | NotEnoughManaException e1) {
		JFrame f=new JFrame();  
	    JOptionPane.showMessageDialog(f,e1.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE);	
	}
    
}
HearthStone.getView().getPanel2().removeAll();
HearthStone.getView().getPanel2().add(HearthStone.getView().getText1());
HearthStone.getCur().clear();

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
		Spell l = (Spell) HearthStone.getModel().getCurrentHero().getHand().get(i);
		x = "<html>"+"Name :"+" "+l.getName() + "<br>" + " " +"ManaCost :"+" "+ l.getManaCost() + "<br>"+ " " +"Rarity :"+" "+ l.getRarity()+"<html>";
		JButton b = new JButton();
		b.addActionListener(Heroes.getH());
		b.setText(x);
		HearthStone.getCur().add(b);
		HearthStone.getView().getPanel2().add(b);
	}
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
