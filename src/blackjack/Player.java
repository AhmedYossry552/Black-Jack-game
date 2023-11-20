package blackjack;

public class Player {
    private String  name;
   private int score;
 public  Card []c=new Card[11];
   private boolean isBlackjack;
   private boolean islost;

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isIslost() {
        return islost;
    }

    public boolean isIsBlackjack() {
        return isBlackjack;
    }
}
