package gt.magicprobabilityapplet;
import java.math.BigInteger;

public class MagicOpeningHand{
  private int deckSize = 0;
  private int handSize = 0;
  private int landCards = 0;
  private int copies = 0;
  private int maxCopies = 0; 
  
  public void setDeckSize(int deckSize){
    this.deckSize =deckSize;
  }
  
  public void setHandSize(int handSize){
    this.handSize = handSize;
  }
  
  public void setLandCards(int in){
   landCards = in;
  }
  
  public void setCopies(int copies){
    this.copies = copies;
  }
  
  public void setMaxCopies(int maxCopies){
    this.maxCopies = maxCopies;
  }
  
  public int getDeckSize(){
    return deckSize;
  }
  
  public int getHandSize(){
    return handSize;
  }
  
  public int getLandCards(){
    return landCards;
  }
  
  public int getCopies(){
    return copies;
  }
  
   public int getMaxCopies(){
    return maxCopies;
  }
     
  /*Calculates the hypergeometric distribution given the input arguments. 
   * 
   * @param successStates the number of success states in the population.
   * @param popSize the total number of objects in the population
   * @param draws the number of times we are drawing from the population
   * @param successes the target number of successful draws
   * @return the probability of gettting exactly the number of successful draws we want given the parameters.
   * 
   */ 
  public double hypGeoDist(int successStates,int popSize, int draws,int successes){
    return (BinomailCoefficient(successStates, successes)) *( BinomailCoefficient((popSize-successStates), (draws-successes)))/(BinomailCoefficient(popSize, draws));  
  }
  
  /*calculates the binomial Coefficient of two numbers n and k, i.e n choose k
   * calculates the following  n! /  k!(n-k)!
   * @param n the total number of objects we can choose from.
   * @param k the number of objects we consider a success.
   * @return the value of  (n! /  k!(n-k)!)
   */
  /*calculates the binomial Coefficient of two numbers n and k, i.e n choose k*/
  public  double BinomailCoefficient(int n, int k){
    BigInteger bigN = BigInteger.valueOf(n);
    BigInteger bigK = BigInteger.valueOf(k);
    BigInteger nMinusK = BigInteger.valueOf(n-k);
    
    BigInteger top = factorial(bigN); // n!
    BigInteger bottom = (factorial(bigK)).multiply(factorial(nMinusK));  // k!(n-k)!               
    BigInteger bigResult = top.divide(bottom);   
    double result = bigResult.doubleValue();                                
    return result;     
    
  }  
  
  
  /* Calculates the factorial of the integre argument. 
   * Given the context we will not be going above ~60 so a recursive method is fine.
   * @param num the number we are calculating the factorial of.
   */
  public  BigInteger factorial(BigInteger num){  
    if ((num.intValue() == 0) || num.intValue() < 0) return BigInteger.valueOf(1);
    return num.multiply(factorial(num.subtract(BigInteger.valueOf(1))));
  }
  
}

