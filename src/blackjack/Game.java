
package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
     Card card=new Card(1,2,3);
   GUI gui = new GUI();
    Scanner input=new Scanner(System.in);
     public Player[] PL=new Player[4]; 
     public Card [] CA=new Card[52];
    public int ind=2;
    
    public void generateCard()
    { int index=0;
        for(int j=0;j<4;j++)
        {
            
            for(int i=0;i<13;i++)
            {if(i<10)
          
                CA[index++]=new Card(j,i,i+1);
                else
                CA[index++]=new Card(j,i,10);
            }
        }
        
    }
    public Card Random_Card()
    {
        Random Rand=new Random();
        
        while(true)
        {
            
        int randCard=Rand.nextInt(52);
        if(CA[randCard]!=null)
        {
           card= CA[randCard];
           CA[randCard]=null;
           return card;
        }
       
        }
    }
    public void first_Game(){
        
        
        for(int i=0;i<3;i++)
        {
           
                   System.out.println("Enter the player _name "+(i+1));
            String name=input.nextLine();
            PL[i]=new Player(name);
           PL[i].c[0]=Random_Card();
           PL[i].c[1]=Random_Card();
        PL[i].setScore(PL[i].c[0].getValue()+PL[i].c[1].getValue());
        
    }
        
    PL[3]=new Player("Dealer");
     PL[3].c[0]=Random_Card();
     PL[3].c[1]=Random_Card();
     PL[3].setScore( PL[3].c[0].getValue()+ PL[3].c[1].getValue());
  gui.runGUI( this.CA , this.PL[0].c , this.PL[1].c , this.PL[2].c  ,this.PL[3].c);
}
   
    public Card Add_Card ( int pindex)
    {
      
         card= Random_Card();
   
      PL[pindex].c[ind++]=card;
     
     PL[pindex].setScore(PL[pindex].getScore()+card.getValue());
        
         
               return card;
    }
   
    public int High_Score(Player PL[],int Size){
   
int Max=0,index=0;
for(int i=0;i<Size;i++)
{
if(PL[i].getScore()>Max)
{
    Max=PL[i].getScore();
    index=i;
  }
}
return index;
    }
      
    
      public void play_3PL()
      {
      for(int i=0;i<3;i++){
           System.out.println("player :"+(i+1) +"•");
           int tmp=this.PL[i].getScore();
       while( tmp<21)
       {
       System.out.println("Press 1 ► HIT   OR 2 ► Stand");
       int desire=input.nextInt();
       
     
  if (desire==1)
  {
       card= this.Add_Card(i);
      gui.updatePlayerHand(card,i);
      if(this.PL[i].getScore()>21)
      {
          System.out.println("You are pasted !*!your score  is "+this.PL[i].getScore());
          
          tmp=this.PL[i].getScore();
          this.PL[i].setScore(0);
         
      } 
      else if(this.PL[i].getScore()==21)
          
      { 
          System.out.println("You Are BlackJack  ");
      break;
      }
  }
 
  else 
  {
      System.out.println("Your Score is ► "+this.PL[i].getScore());
      
      break;
  }
  
       }
       
       }
      
      
      }
    
    public void play_dealer()
    {
       int index= this.High_Score(this.PL,3);
      if(this.PL[index].getScore()>this.PL[3].getScore()){     
                                                                                 
        while( true)   {
           
         card=  this.Add_Card(3);
          gui.updateDealerHand(card,this.CA);
           if((this.PL[3].getScore()>this.PL[index].getScore()&&this.PL[3].getScore()<21)||this.PL[3].getScore()==21||this.PL[3].getScore()>21)
               break;
        } 
        
      }
    
    }
    public void check_win()
    {
    if(this.PL[3].getScore()>21)
        
 {  this.PL[3].setScore(0);}
       
int lind=this.High_Score(this.PL,4);
int counter=0;
 
for(int i=0;i<4;i++)
{
  
    
if(this.PL[i].getScore()==this.PL[lind].getScore()&&this.PL[lind].getScore()!=0)
    
    counter++;
}
if(counter>1)
    
            System.out.println("PUSH!!");
else

  
{
    
 if (lind+1==4)
                System.out.println("The Dealer is  WInner☺!");
 else 
        System.out.println("the player " +(lind+1)+ "is Winner ☺");
}
      
}
    }
    
      


