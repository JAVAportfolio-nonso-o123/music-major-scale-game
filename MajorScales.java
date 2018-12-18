import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.Timer;
import java.util.Random;
/**
 *
 * @author Nonso Obidike
 * https://prezi.com/p/lqiqpla3-ojc/
 * This program is a game that checks your knowledge of the musical major scales
 * It chooses a random scale and prompts the user to write out the major scales
 * of that scale.
 * If the user's entry is wrong, the program tells the user so,
 * otherwise, the user is congratulated.
 */
public class MajorScales {
    public static void main(String [] args) {
PopUp myPop = new PopUp();
myPop.setVisible(true);


Timer timer = new Timer(3000, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            myPop.setVisible(false);
       myPop.dispose();
   }
    });
timer.setRepeats(false);
timer.start();
//create an object of the MajorScales class
        MajorScales majorScales = new MajorScales();
      Scanner keyboard = new Scanner(System.in);
      
//randomly choose a major scale for the user
      String myRand = majorScales.randScale();
      String name = myRand + " Major";          
      String input, tryAgain;
      String[] myScale;
      int inputLength, pos, scalesLength[];
      char answer;
      
//ask the user to enter the values of the randomly chosen scale and confirm
//if the user wants to correct their enterd values
     do{ 
      System.out.println("enter the major scales for "+ name);
      input = keyboard.nextLine();
      myScale = input.split(" |\n|_|-|\t");
      inputLength = myScale.length;
//print out the vlues the user entered and ask if they want to re-enter their values
      System.out.println("You entered:");
      for(String val: myScale){
          System.out.print(val + " ");
      }
      System.out.println("\nDo you want to change your inputs? [Enter yes or no]");
      tryAgain = keyboard.nextLine();
      answer = Character.toUpperCase(tryAgain.charAt(0));
     }while(answer == ('Y'));
     

//throw out of bounds exception if the user enters toomany inputs
try{
    scalesLength = majorScales.getLength(myRand);
     pos = scalesLength[1];    
    
       if (inputLength > scalesLength[0]){
           throw new ArrayIndexOutOfBoundsException();
       }
       
//check if the user's entry matches the actual values of the random scale chosen
       else if(majorScales.isCorrect(myScale, pos ))
         System.out.println("\nCongratulations!!\nYou're right!");
      else
         System.out.println("\nYou're wrong! Your inputs don't match, sorry!");
}
  
//catch out of bounds exception
      catch(ArrayIndexOutOfBoundsException e){
                  System.out.println("\n You're wrong! You entered too many values");
                 }
     
   }

    
    
//declare a constant field of 2D array of the values of all the maajor scales 
   private  final String[][] SCALES;
   
  /**MajorScales constructor
   *constructor creates an object of the MajorScales
   */
   public MajorScales(){  
//fill up the 2D array with the values of the music major scales
      SCALES = new String[][]
               {{"C"," D", "E", "F", "G", "A", "B"}, 
                {"F", "G", "A", "Bb", "C", "D", "E"}, 
                {"Bb", "C", "D", "Eb", "F", "G", "A"},
                {"Eb", "F", "G", "Ab", "Bb", "C", "D"},
                {"Ab", "B", "C", "Db", "Eb", "F", "Ab"},
                {"Db", "Eb", "F", "Gb", "Ab", "Bb", "C"},
                {"C#", "D#", "E#", "F#", "G#", "A#", "B#"},
                {"Gb", "Ab", "Bb", "Cb", "Db", "Eb", "F"},
                {"F#", "G#", "A#", "B", "C#", "D#", "E#"},
                {"B", "C#", "D#", "E", "F#", "G", "A#"},
                {"Cb", "Db", "Eb", "Fb", "Gb", "Ab", "B"},
                {"E", "F#", "G#", "A", "B", "C#", "D#"},
                {"A", "B", "C#", "D", "E", "F#", "G#"},
                {"D", "E", "F#", "G", "A", "B", "C#"},
                {"G", "A", "B", "C", "D", "E", "F#"}
                };
   } 
   
   
   /**
    * randomly choose a scale to give to the user
    * @return the first value of the randomly chosen scale
    */
   public String randScale(){      
// declare a temporary place to store the value of first index of the scales array
   String temp;
   
//declare an array to store the values of the first indices of the music scale 2D array 
    String[] firstIndex = new String[15];
    
   Random rand = new Random();
   for(int i = 0; i < SCALES.length; i++){
       temp = SCALES[i][0];
       
 //transfer the temp value to the specified position of firstIndex array
       firstIndex[i] = temp;
   }
      
//randomly select a value from the firstIndex array, which correspons to 
//a first value in the music scales array
       String randomScale = firstIndex[rand.nextInt(firstIndex.length)]; 
      return randomScale;
   }
   
   
    /**Get the length and position of the randomly chosen scale
    * @param randLetter the first value of the random scale selected
    * @return and array of the length and position of the selected random scale
    */
   public int[] getLength (String randLetter){
       int[] val;
       int position = 0;
        int length= 0;
//Loop through the values of the scales array and pick the scale that matches
//the random scale chosen for the user

       for (int i = 0; i < SCALES.length; i++) {
           if (SCALES[i][0].equalsIgnoreCase(randLetter)) {
               length = SCALES[i].length;
               position = i;
           }    
       }
       val = new int[]{length, position};
       return val;
   }
   
   /**
    * isCorrect method checks if the values entered by the user is correct
    * @param str a String array that accepts the users major scales input
    * @return returns true if the check is correct, false if the check is wrong
    * @param len the position of the chosen random scale in the major scale array
    */
   public boolean isCorrect(String[] str, int len){      
//Loop through the matched scale and the user's input to compare their 
//values. Return true if the values match, false if they don't
          for(int k = 0; k < str.length; k++){
              if(!str[k].equalsIgnoreCase(SCALES[len][k])) {         
                  return false;
              }         
      }

          
      return true;
   } 
}



/*
1) starts
2)store them in an array
3) chooses a random scale
4) asks the user to enter complete scale for chosen major
5) if user entry correct, congratulate user and chooses new scale
6)if incorrect, gives hints until correct
7)array is in main class, dice game in extended class of main
*/
    

