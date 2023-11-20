package blackjack;


public class BlackJack {
    
    static Game  g_jack=new Game();
   
    public static void main(String[] args) {
//    Game g_jack=new Game();
       g_jack.generateCard();
       g_jack.first_Game();
       g_jack.play_3PL();
       g_jack.play_dealer();
       g_jack.check_win();
       
    }
    
 }


    
 

