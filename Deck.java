package laboration3C;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
        
    private final ArrayList<Card> cards;
    
    public Deck(){
        cards = new ArrayList<>();
        fill();
    }
    
    public int getNoOfCards(){
        return cards.size();
    }
    
    public Card dealCard(){
        if(cards.isEmpty()){
            throw new NoSuchCardException(cards.size() - 1);
        }
        return cards.remove(cards.size() -1);
    }
    
    public void shuffleCards(){
        Collections.shuffle(cards);
    }
    
    public void fill(){
        if(!cards.isEmpty()){
            cards.clear();
        }
        for(Suit s : Suit.values()){
            for(Rank r : Rank.values()){
                cards.add(new Card(r, s));
            }
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Deck:\n");
        for(int i = 0; i < cards.size(); i++){
            sb.append(cards.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
