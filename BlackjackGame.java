package Blackjack_project;

// import java.util.FormatterClosedException;
import java.util.Scanner;

public class BlackjackGame {
    //game of Blackjack, supporting one player versus the house.
    //three instance properties

    // A Deck instance to maintain the deck of cards
    private Deck deck;
    // A Hand instance to maintain the house's hand
    private Hand houseHand;
    // A Hand instance to maintain the player's hand
    private Hand playerHand;

    //a constructor
    public BlackjackGame (){
        /*initialize the instance properties by constructing new instances of the 
        appropriate class for each*/
        
        //initialize deck
        deck = new Deck (true);
        houseHand = new Hand();
        playerHand = new Hand();
    }
    // an instance method called playGame
    public void playGame (){
        //deal to deal out initial cards
        //System.out.println(deck.toString());
        deal();
        System.out.println(toString());
        //playerTurn to prompt the user hitting/standing
        playerTurn();
        //houseTurn to have the house hit if required
        //System.out.println(deck.toString());
        houseTurn();
        //endGame to end the game (determining the outcome and printing results)
        endGame();
    }
    
    //an instance method called deal
    public void deal(){
        //deal one card to the player, face up
        dealCardTo(playerHand, true);
        //deal one card to the house, face up
        dealCardTo(houseHand, true);
        //deal one card to the player, face up
        dealCardTo(playerHand, true);
        //deal one card to the house, face down
        dealCardTo(houseHand, false);
        
        // Need fix (why return type of dealCardTo is boolean)
    }
    // an instance method called dealCardTo
    public void dealCardTo(Hand Hand, boolean isFaceUp){
        //deal a card from the deck to the given hand. If faceUp is true, flip the card so it's face up.
        Card card = deck.dealCard();
        if (isFaceUp){
            card.flip();
        }
        Hand.add(card);

    }

    // an instance method called playerTurn
    public void playerTurn (){
        // output: (H)it or (S)tand? s
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        String userDecision;
        
        // keep ask for new card until the user said stand
        boolean valid = false;
        while (!valid){
            System.out.print( "(H)it or (S)tand? " );  // print a prompt
            userDecision= sc.nextLine();     // wait for and accept input  
            if ((userDecision.equals("s")) || (userDecision.equals("S"))){
                System.out.println(toString());
                valid = true;
                }
            else if ((userDecision.equals("h")) || (userDecision.equals("H"))){
                valid = false;
                dealCardTo(playerHand, true);
                System.out.println(toString());
                }
        }
        
        sc.close();
        
        }
        
        //Need check
    
    //an instance method called houseTurn 
    public void houseTurn(){
        // flip the face down card
        Card flippedCard = houseHand.getCard(1);
        flippedCard.flip();
        System.out.println(toString());

        /*While the house's hand is valued < 17, deal a card with the instance method
        dealCardTo and print the current state of the game using toString */
    
        int houseValue = houseHand.determineValue();
        //System.out.println(houseValue);
        while (houseValue < 17  ) {
            dealCardTo(houseHand, true);
            System.out.println(toString());
            houseValue = houseHand.determineValue();
            //System.out.println(houseValue);
        }
        }

    // an instance method called determineOutcome
    public int determineOutcome(){
        /* Should determine the outcome of the game: -1 if the player loses, 
        0 if there is a tie, 1 if the player wins */
        int outcome = 0;
        int houseScore = houseHand.determineValue();
        int playerScore = playerHand.determineValue();
        // If the player busted, print out the following and return -1
        if (playerHand.busted()) {
            outcome = -1;
            System.out.println( 
                "Your hand's a bust...\nAww, the house won.");}
                // System.out.println( """
                //     Your hand's a bust...
                //     Aww, the house won.""");}
            //If the house busted, print out the following and return 1
        else if (houseHand.busted()){
            outcome = 1;
            System.out.println( 
                "The house's hand's a bust!\nCongrats, you won!");}
        // If it's a tie, print out the following and return 0
        else if ((houseScore == playerScore) || (( (houseHand.busted()== true) && (playerHand.busted() == true) ))){
            outcome = 0;
            System.out.println("Tie");}
        /*If neither hand is a bust and the player is closer to 21, 
        print out the following and return 1*/
        else if ((houseHand.busted()== false) && (playerHand.busted() == false)) {
            if (playerScore>houseScore) {
                outcome = 1; 
                System.out.println("Congrats, you won!");
            }
            else{
            /* If neither hand is a bust and the house is closer to 21,
            print out the following and return -1 */
                outcome = -1;
                System.out.println("Aww, the house won.");}
        }
        return outcome;
    }
    //a method called endGame
    public void endGame(){
        //(determining the outcome and printing results)
        determineOutcome();
        // Need check
    }

    //a method called toString
    public String toString(){
        // output: Player: [♤7, ♢8], House: [♧10, 🂠]
        return "Player: " + playerHand.toString() + ", House: " + houseHand.toString();
    }

    //main function to play the game
    public static void main (String [] args){
        BlackjackGame firstRound = new BlackjackGame();
        firstRound.playGame();
    }
}
