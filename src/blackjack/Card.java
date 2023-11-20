
package blackjack;
public class Card {
     private int Suit;
    private int Rank;
    private int Value;

   
    public Card(Card obj)
    {
        this.Suit=obj.Suit;
        this.Rank=obj.Rank;
        this.Value=obj.Value;
    }
     public Card(int Suit, int Rank, int Value) {
        this.Suit = Suit;
        this.Rank = Rank;
        this.Value = Value;
    }

    public void setRank(int Rank) {
        this.Rank = Rank;
    }
 public void setSuit(int Suit) {
        this.Suit = Suit;
    }
  public void setValue(int Value) {
        this.Value = Value;
    }
  
    public int getRank() {
        return Rank;
    }
    public int getSuit() {
        return Suit;
    }
    public int getValue() {
        return Value;
    }
    
}
