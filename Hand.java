 package Blackjack_project;
import java.util.List;
//import java.util.stream.Collectors;
import java.util.ArrayList;

public class Hand {
    
    //one instance property:
    //A List<Card> named cards to maintain the Card instances in this deck
    private List<Card> cards;
    //a constructor
    public Hand (){
        cards = new ArrayList<>();
    }

    //getter for Cards
    public Card getCard(int pos){
        return cards.get(pos);
    }
    //an instance method called add
    public void add (Card card){
        // add the card to the hand
        cards.add(card);
    }
    //an instance method called revealCards
    public void revealCards(){
        //reveal all cards by making sure they are all set as face up
        //Iterate over the list of cards and flip any that are face down
        for (Card card: cards){
            if (card.isFaceUp() == false) {
                card.flip();
            }
        }
    }

    // an instance method called busted
    public boolean busted (){
        int value = determineValue();
        boolean isBusted = false;
        if (value > 21){
            isBusted = true;
        }
        return isBusted;
    } 

    // an instance method called determineValue
    public int determineValue(){

        //  count the sum of the value
        int sum = 0;
        Card Ace = new Card("♤", "A");
        for (Card card: cards){
            int value = card.getValue();
            sum = sum + value;
            
            // find the card that has the rank A
            if (card.getRank() == "A"){
                Ace = card;
            }
        }
        /* If there is an ace and treating it as an 11 keeps the sum <= 21 
        (inclusive), returns that value. */

        //If there is an ace
        if (containsRank("A") == true) {
            // and treating it as an 11 
            int newSum = 11;
            //create a new list that has the same elements of cards and remove Ace from it
            List<Card> newCards = new ArrayList<>(cards);
            newCards.remove(Ace);
            //count the new sum that has the ace value as 11 and plus the other card's values
            for (Card card: newCards){
                int newValue = card.getValue();
                newSum += newValue;
            }
            //check if the new sum is <= 21: change the value of the sum into it
            if (newSum <= 21) {
                sum = newSum;
            }
        }
        return sum;
        // Need check
    }
    
    //an instance method called containsRank 
    public boolean containsRank (String rank){
        //Should checks if this hand has a card with the given rank and returns true if so
        boolean contained = false;
        for (Card card: cards){
            if (card.getRank().equals(rank) )
                contained = true;
            // else contained = false;
        }
        return contained;
    }
    
    // an instance method called toString
    public String toString (){
        // output: [♤7, ♢8]
        //String listString = cards.stream().map(Object::toString).collect(Collectors.joining(", "));
        //return listString;
        return cards.toString();
    }
}
