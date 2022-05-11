 package Blackjack_project;

public class Card {
    //a three instance properties
    
    // A String to track the suit
    private String suit;
    // A String to track the rank
    private String rank;
    // A boolean to track if the card is face up
    private boolean faceUp;

    //  constructor 
    public Card (String initSuit, String initRank) {
        suit = initSuit; 
        rank = initRank;
        faceUp = false;
    }

    // getters
    public String getSuit (){
        return suit;
    }
    
    public String getRank (){
        return rank;
    }

    public boolean isFaceUp (){
        
        return faceUp;
    }
    

    //an instance method called getValue
    public int getValue (){
        int value = 0;
        if (rank == "A")
            value = 1;
        else if ((rank == "J") || (rank == "Q") || (rank == "K"))
            value = 10;
        else 
            value = Integer.valueOf(rank);
        return value;
        }
    
    // an instance method called flip
    public void flip () {
        //flip the card (face up -> face down; face down -> face up)
        if (faceUp == true) {
            faceUp = false;
        }
        if (faceUp == false) {
            faceUp = true;
        }
        /// Need recheck
    }

    // an instance method called toString 
    public String toString () {
        String display = "";
        if (faceUp == true){
            display = suit + rank;
        }
        else {
            display = "🂠";
        }
        return display;
    }
}
