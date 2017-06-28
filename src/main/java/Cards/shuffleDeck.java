package Cards;
import java.util.Scanner;

class shuffleDeck{

      static String[] deck;

    public static void main(String[] args) {
                String ans = "";

        do{
        Scanner input = new Scanner(System.in);
        
        System.out.println("Select the options below");
        System.out.println("Enter 1: To shuffle the cards!!");
        System.out.println("Enter 2: To display the shuffled cards!!");
        System.out.println("Enter x: Exit");

        ans = input.nextLine();

        if (ans.equals("1")) {
            shuffle();
        } else if (ans.equals("2")) {
            dealOneCard();
        } else if (ans.equals("x")) {
            System.out.print("Thank you !");
        }
        } while(!ans.equals("x"));
    }

    public static void shuffle() {

        String[] suits = {"hearts", "spades", "clubs", "diamonds"};
        
        String[] face_value = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                               "Jack", "Queen", "King", "Ace"};
        

        //length=52
        int n = suits.length * face_value.length;
        deck = new String[n];

        //generating full deck of 52 cards
        for (int i = 0; i < face_value.length; i++) {
        for (int j = 0; j < suits.length; j++) {
            deck[suits.length * i + j] = face_value[i] + " Of " + suits[j];
        }
        }

        int i = deck.length;
        int j = 0;
        String temp;
            // To shuffle the cards
        while (--i > 0) {
            j = (int) Math.floor(Math.random() * (i + 1));
            //swapping the cards
            temp = deck[j];
            deck[j] = deck[i];
            deck[i] = temp;
        }

        System.out.println("The deck is shuffled!!!!");
    }

    public static void dealOneCard() {
        shuffle();
        Scanner input = new Scanner(System.in);
        int count = 0;
        int i = 0;
        // To display shuffled cards with # sign so user can't see the cards
        for (int d = 0; d < deck.length; d++) {
        System.out.printf("#", deck[d]);
        }
        System.out.println(" ");
        System.out.println("The above is shuffled cards!! ");
        System.out.println(" ");

        int cardSelection;
        while (count < 52) {
        //input from the user for card selection
        System.out.println("To view the shuffled card please make the card choice from 1 to 52 or press 53 to EXIT!! ");
        cardSelection = input.nextInt();
        if(cardSelection==53)
        {
            System.out.println("Thank you!");
            break;
        }
        // To make the selection unique 
        if (!"".equals(deck[cardSelection - 1])) {
        System.out.println(deck[cardSelection - 1]);
        deck[cardSelection - 1] = "";
        count++;
        } else if(deck[cardSelection-1].equals(""))  {
        System.out.println("Sorry you have already picked the card.Please make other choice");
        } 
            
        }
        if(count>52)
        {
            System.out.print("Yaay picked all cards..No card is dealt!!");
        }
        
    }

}


       
        
    
    



