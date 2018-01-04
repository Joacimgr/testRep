package laboration3C;

import java.util.ArrayList;

public class Player{
    
    private final Strategy strategy;
    private final PileOfCards hand;

    public Player(Strategy strategy){
        this.strategy = strategy;
        hand = new PileOfCards();
    }
    
    public void addCard(Card c){
        hand.add(c);
    }
    
    public void clearHand(){
        hand.clear();
    }
    
    public PlayerMove getChoice(Player other){
        return strategy.executeStrategy(this, other);
    }

    public int getCardSum(){
        int cardSum = 0;
        for(Card c : hand){
            cardSum += c.getRankValue();
        }
        return cardSum;
    }
    
    public ArrayList<Card> getHand(){
        return new ArrayList<>(hand);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(Card c : hand){
            sb.append(c.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}