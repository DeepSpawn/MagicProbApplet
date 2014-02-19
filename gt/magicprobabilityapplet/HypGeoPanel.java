package gt.magicprobabilityapplet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HypGeoPanel extends JPanel {
  
  JButton push; 
  JLabel deckSize, landNo, handSize, targetLands, targetUpper, deckNum, landNum, handNum,targetNum,targetUpperNum, output, outputNum; 
  JTextField deckIn, landIn, handIn, targetIn, targetUpperIn; 
  MagicOpeningHand programGuts = new MagicOpeningHand();
  
  public HypGeoPanel() {// constructor 
    JButton push = new JButton("Calculate"); 
    this.deckSize = new JLabel("Deck size: ");
    this.landNo = new JLabel("Lands in deck: ");
    this.handSize = new JLabel("Cards in opening hand: ");
    this.targetLands = new JLabel("Minimum number of lands in hand: ");
    this.targetUpper = new JLabel("Maximum number lands in hand: ");
    this.deckNum = new JLabel("--");
    this.landNum = new JLabel("--");
    this.handNum = new JLabel("--");
    this.targetNum = new JLabel("--");
    this.targetUpperNum = new JLabel("--");
    this.output = new JLabel("Probability is :");
    this.outputNum = new JLabel("--"); 
    this.deckIn = new JTextField (5);
    this.landIn = new JTextField (5);
    this.handIn = new JTextField (5);
    this.targetIn = new JTextField (5);
    this.targetUpperIn = new JTextField (5);
    deckIn.addActionListener (new DeckListener());
    landIn.addActionListener (new LandListener());
    handIn.addActionListener (new HandListener());
    targetIn.addActionListener (new TargetListener());
    targetUpperIn.addActionListener (new TargetUpperListener());
    push.addActionListener (new CalculateListener());
    
    //GridLayout experimentLayout = new GridLayout(3,5);
    //this.setLayout(experimentLayout);
    SpringLayout layout = new SpringLayout();
    this.setLayout(layout);
    
    
    
    add(deckSize); 
    add(deckNum);
    add(deckIn); 
    add(landNo);
    add(landNum);
    add(landIn); 
    add(handSize);
    add(handNum); 
    add(handIn);
    add(targetLands);
    add(targetNum);
    add(targetIn);
    add(targetUpper);
    add(targetUpperNum);
    add(targetUpperIn);  
    add(push);
    add(output);
    add(outputNum);
    
    
    //layout for first row
    layout.putConstraint(SpringLayout.WEST, deckSize, 5, SpringLayout.WEST, this);
    
    layout.putConstraint(SpringLayout.NORTH, deckSize, 5, SpringLayout.NORTH, this);
    
    layout.putConstraint(SpringLayout.WEST, deckNum, 5, SpringLayout.EAST, deckSize);
    
    layout.putConstraint(SpringLayout.NORTH, deckNum, 5, SpringLayout.NORTH, this);
    
    layout.putConstraint(SpringLayout.EAST, deckIn, 0, SpringLayout.EAST, this);
    
    layout.putConstraint(SpringLayout.NORTH, deckIn,5,SpringLayout.NORTH, this);
   
    //layout for second row
    layout.putConstraint(SpringLayout.WEST, landNo, 5, SpringLayout.WEST, this);
    
    layout.putConstraint(SpringLayout.NORTH, landNo, 5, SpringLayout.SOUTH, deckIn);
    
    layout.putConstraint(SpringLayout.WEST, landNum, 5, SpringLayout.EAST, landNo);
    
    layout.putConstraint(SpringLayout.NORTH, landNum, 5, SpringLayout.SOUTH, deckIn);
    
    layout.putConstraint(SpringLayout.EAST, landIn, 0, SpringLayout.EAST, this);
    
    layout.putConstraint(SpringLayout.NORTH, landIn, 5, SpringLayout.SOUTH, deckIn);
    
     //layout for third row
    layout.putConstraint(SpringLayout.WEST, handSize, 5, SpringLayout.WEST, this);
    
    layout.putConstraint(SpringLayout.NORTH, handSize, 5, SpringLayout.SOUTH, landIn);
    
    layout.putConstraint(SpringLayout.WEST, handNum, 5, SpringLayout.EAST, handSize);
    
    layout.putConstraint(SpringLayout.NORTH, handNum, 5, SpringLayout.SOUTH, landIn);
    
    layout.putConstraint(SpringLayout.EAST, handIn, 0, SpringLayout.EAST, this);
    
    layout.putConstraint(SpringLayout.NORTH, handIn, 5, SpringLayout.SOUTH, landIn);
    
         //layout for fourth row
    layout.putConstraint(SpringLayout.WEST, targetLands, 5, SpringLayout.WEST, this);
    
    layout.putConstraint(SpringLayout.NORTH, targetLands, 5, SpringLayout.SOUTH, handIn);
    
    layout.putConstraint(SpringLayout.WEST, targetNum, 5, SpringLayout.EAST, targetLands);
    
    layout.putConstraint(SpringLayout.NORTH, targetNum, 5, SpringLayout.SOUTH, handIn);
    
    layout.putConstraint(SpringLayout.EAST, targetIn, 0, SpringLayout.EAST, this);
    
    layout.putConstraint(SpringLayout.NORTH, targetIn, 5, SpringLayout.SOUTH, handIn);
    
             //layout for fifth row
    layout.putConstraint(SpringLayout.WEST, targetUpper, 5, SpringLayout.WEST, this);
    
    layout.putConstraint(SpringLayout.NORTH, targetUpper, 5, SpringLayout.SOUTH, targetIn);
    
    layout.putConstraint(SpringLayout.WEST, targetUpperNum, 5, SpringLayout.EAST, targetUpper);
    
    layout.putConstraint(SpringLayout.NORTH, targetUpperNum, 5, SpringLayout.SOUTH, targetIn);
    
    layout.putConstraint(SpringLayout.EAST, targetUpperIn, 0, SpringLayout.EAST, this);
    
    layout.putConstraint(SpringLayout.NORTH, targetUpperIn, 5, SpringLayout.SOUTH, targetIn);
    
                 //layout for sixth row
    layout.putConstraint(SpringLayout.WEST, push, 5, SpringLayout.WEST, this);
    
    layout.putConstraint(SpringLayout.NORTH, push, 5, SpringLayout.SOUTH, targetUpperIn);
    
    layout.putConstraint(SpringLayout.WEST, output, 5, SpringLayout.EAST, push);
    
    layout.putConstraint(SpringLayout.NORTH, output, 5, SpringLayout.SOUTH, targetUpperIn);
    
    layout.putConstraint(SpringLayout.WEST, outputNum, 5, SpringLayout.EAST, output);
    
    layout.putConstraint(SpringLayout.NORTH, outputNum, 5, SpringLayout.SOUTH, targetUpperIn);
    
    
    
    


    
    setPreferredSize(new Dimension(275,170)); // 3 set panel details 
  }
  
  
  //The following just upadate a field based on the appropriate text field
  private class DeckListener implements ActionListener{  
    public void actionPerformed (ActionEvent event){
      programGuts.setDeckSize(Integer.parseInt(deckIn.getText()));
      deckNum.setText(Integer.toString(programGuts.getDeckSize()));        
    }
  }
  
  
  private class LandListener implements ActionListener{
    
    public void actionPerformed (ActionEvent event){
      programGuts.setLandCards(Integer.parseInt(landIn.getText()));
      landNum.setText(Integer.toString(programGuts.getLandCards()));
    }
  }
  
  
  private class HandListener implements ActionListener{
    
    public void actionPerformed (ActionEvent event){    
      programGuts.setHandSize( Integer.parseInt(handIn.getText()));
      handNum.setText(Integer.toString(programGuts.getHandSize()));
    }
  }
   
  private class TargetListener implements ActionListener{
    
    public void actionPerformed (ActionEvent event){
      programGuts.setCopies(Integer.parseInt(targetIn.getText()));
      programGuts.setMaxCopies(Integer.parseInt(targetIn.getText()));
      targetNum.setText(Integer.toString(programGuts.getCopies()));
      targetUpperNum.setText(Integer.toString(programGuts.getCopies()));
    }
  }
  
    private class TargetUpperListener implements ActionListener{  
    public void actionPerformed (ActionEvent event){
      programGuts.setMaxCopies(Integer.parseInt(targetUpperIn.getText()));
      targetUpperNum.setText(Integer.toString(programGuts.getMaxCopies()));
    }
    }
    
    
    //When calcualte is clicked, calculate the probability 
    private class CalculateListener implements ActionListener{
      
      public void actionPerformed (ActionEvent event){
        updateFields();
        if(programGuts.getDeckSize() > 0 &&  // Do some sanity checking on the numbers
           (programGuts.getCopies() < programGuts.getMaxCopies() 
              ||  programGuts.getCopies() == programGuts.getMaxCopies())){
          if(programGuts.getDeckSize() > programGuts.getMaxCopies() &&
             programGuts.getDeckSize() > programGuts.getHandSize()){
            int successStates = programGuts.getLandCards();
            int popSize = programGuts.getDeckSize();
            int draws = programGuts.getHandSize();
            int minTargetSuccesses =  programGuts.getCopies();
            int maxTargetSuccesses =  programGuts.getMaxCopies();
            double result =0;
            for(int i =  minTargetSuccesses; i <= maxTargetSuccesses; i++){ // sum of probs from the lower to upper bound
              result += programGuts.hypGeoDist(successStates, popSize, draws, i);
            }
            outputNum.setText( String.format( "%.3f", result));
          }
        }
      }
      
    public void updateFields(){ // sets all fields to what is found in the text box
      programGuts.setDeckSize(Integer.parseInt(deckIn.getText()));
      deckNum.setText(Integer.toString(programGuts.getDeckSize()));  
      programGuts.setLandCards(Integer.parseInt(landIn.getText()));
      landNum.setText(Integer.toString(programGuts.getLandCards()));
      programGuts.setHandSize( Integer.parseInt(handIn.getText()));
      handNum.setText(Integer.toString(programGuts.getHandSize()));
      programGuts.setCopies(Integer.parseInt(targetIn.getText()));
      targetNum.setText(Integer.toString(programGuts.getCopies()));
      programGuts.setMaxCopies(Integer.parseInt(targetUpperIn.getText()));
      targetUpperNum.setText(Integer.toString(programGuts.getMaxCopies()));
    }
  }
  
}

