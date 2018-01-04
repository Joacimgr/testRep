package laboration3C;

import java.util.ArrayList;

public class PileOfCards extends ArrayList<Card>{

    
    public PileOfCards(){
        
    }
    
    public int getNoOfCards(){
        return this.size();
    }
    
    public void addCard(Card c){
        this.add(c);
    }
    
    public Card getCard(int position){
        return this.get(position);
    }
    
    public Card removeCard(int position){
        if(position > (this.size() - 1) || position < 0){
            throw new NoSuchCardException(position);
        }
        return this.remove(position);
    }
    
    public boolean removeCard(Card c){
        return this.remove(c);
    }
    
    public ArrayList<Card> getCards(){
        return new ArrayList<>(this);
    }
    
    public int getSum(){
        int sumOfCards = 0;
        for(Card c : this){
            sumOfCards += c.getRankValue();
        }
        return sumOfCards;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Pile:\n");
        for(Card c : this){
            sb.append(c.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
