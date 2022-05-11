 package Blackjack_project;
// import BlackJack.Card;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//import java.util.stream.Collectors;



public class Deck {

    // class variable (denoted by static) -- for testing purposes!

    public static Random shuffler = new Random(); // use this Random object for shuffling
   
    // a one instance property:
    //A List<Card> named cards to maintain the Card instances in this deck
    private static List<Card> cards;

    /* constructor 
    that Requires one parameters for whether to 
    shuffle the deck initially (true) or leave it in order (false) */
    public  Deck (boolean initshuffle){
        
        //  constructing a new instance of an ArrayList<Card> that is empty
        cards = new ArrayList<Card> ();
        // add 52 cards
        add52Cards();
        //shuffle
        if (initshuffle == true)
            shuffle();
    }

    //  instance method called isEmpty
    public boolean isEmpty() {
        // Should return true if there are no cards left in the deck
        boolean ans = cards.isEmpty(); 
        if (ans == true)  
            return true;
        else { 
            return false;
        }
    }
    
    // instance method called add52Cards
    public void add52Cards () {
        // Should create 52 Card objects and add them to the deck

        // initalize an array with the 4 suits
        String [] suits = {"♤","♡","♢","♧"};   
        // we'll store 13 ranks in an array
        String[] ranks = new String[13];
        // set the first index to hold the ace
        ranks[0] = "A";
        // numbers 2 through 10
        for (int i = 2; i <= 10; i++ ){ 
            ranks[i-1] = Integer.toString( i );
        }
        //// add the jack, queen and king

        ranks[10] = "J";

        ranks[11] = "Q";

        ranks[12] = "K";
        for (String suit: suits) {
            for (String rank: ranks){
                Card card = new Card (suit, rank);
                cards.add(card);
            }
        }
        
    } 

    // create a method shuffle
    public void shuffle()

   {
       Collections.shuffle(cards, shuffler);

   }
   // an instance method called dealCard
   public Card dealCard() {
       Card firstCard = cards.get(0);
       cards.remove(0);
       return firstCard;
   }

   //an instance method called toString
   public String toString (){
    
    //Should return a String representation of the deck by invoking the List's built-in toString method   
    
    return cards.toString();
   }
   public static void main (String[] args){
        Deck A = new Deck (true);
        //System.out.println(A);
        Card B = A.dealCard();
        System.out.println(B.toString());

   }
}
