/*
A bicycle combination lock has four rings with numbers 0 through 9. 
Given the actual numbers and the combination to unlock, print instructions 
to unlock the lock using the minimum number of twists. A "twist up" increases 
the number value of a ring, and a "twist down" decreases it. For example, if 
the actual number shown is 1729 and the desired combination is 5714, write your 
instructions in java like this: 
Ring 1: Twist up 4 times 
Ring 3: Twist down once
Ring 4: Twist up or down 5 times

Haven't completely finished, still need to shorten code and edit
*/
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;


class BicycleLock{
    public static int[] lock = new int[]{1,7,1,4};
    public static int[] unlock = new int[]{5,7,1,4};
    
    int currentRing = 0;
    
    HashMap<Integer, Integer> mapNum = new HashMap<>();

    public void createMap(){
        for(int i = 0; i < 10; i++){
            mapNum.put(i,i);
        }
    }
    public void printLock(){
        for(int i = 0; i < lock.length; i++){
            System.out.print(lock[i]+" ");
        }
    }
    public String userInput(){
        Scanner input = new Scanner(System.in);
        String ring;

        
        System.out.println("Choose a ring: ");
        ring = input.nextLine();
        return ring;

    }
        
    public boolean lockEquals(int[] array1, int[] array2){

        for(int i = 0; i < array1.length; i++){
            if(array1[i] == array2[i]){
                return true;
            }
            else 
            return false;
        }
        return false;
    }

   public boolean hasTwistUp(String twistUp){
       if(twistUp.contains("Twist up") || twistUp.contains("twist up")){
           return true;
       }
       else return false;
    }

    public boolean hasRing(String ring){
        if (ring.contains("ring") ||
            ring.contains("Ring")){
        return true;
            }
        else return false;
    }

   public boolean hasTwistDown(String twistDown){
    if(twistDown.contains("Twist down") || twistDown.contains("twist down")){
        return true;
    }
    else return false;
     }

   public void turnCell1(int n){
    
        for(int i = 0; i < n; i++){
            
           
            lock[0] += 1;

            if(lock[0] > 9){
                lock[0] = 0;
            }
            
        }
   }

   public void turnCell2(int n){
    for(int i = 0; i < n; i++){
        lock[1] += 1;

        if(lock[1] > 9){
            lock[1] = 0;
    }
    
   }
}
   public void turnCell3(int n){
    for(int i = 0; i < n; i++){
        lock[2] += 1;

        if(lock[2] > 9){
            lock[2] = 0;
    }
}
    }   
    public void turnCell4(int n){
        for(int i = 0; i < n; i++){
            lock[3] += 1;

            if(lock[3] > 9){
                lock[3] = 0;
        }
     }
    }
   public void currentRing(int ring){

   }

   
   public void setRing(int currentRing){
       this.currentRing = currentRing;
   }
   
   public int getRing(){
       return currentRing;
   }

//    public void containsRing(String ring){
//        if(ring.contains("Ring 1") ||
//        ring.contains("Ring 2") ||
//        ring.contains("Ring 3") ||
//        ring.contains("Ring 4") 
//        ){

//        }
//    }

   public void containsRing(String s){
       // check if string has a digit
       // if it does return that digit
       
       String ring = "";
       String numbers = "";
       int ringNum = 0;
       int firstNum = 0;
       int turnTimes = 0;
       String ringSub = s.substring(0, 7);
       String turnSub= s.substring(7, s.length());
       String turnSubString = s.substring(7, s.length()); // "once or twice"

       char[] charArray = new char[s.length()];

       for(int i = 0; i < s.length(); i++){

        //loop through substring then get the number

           ring += s.charAt(i);
           numbers += s.charAt(i);
        

        
        //    if (s.charAt(i) == (':')){
        //    System.out.println("end");
        //    break;
        //    }
        }

        System.out.println(ring);
        if(hasRing(ring)){
            System.out.println("has ring");
        }

        if(hasTwistUp(s)){
               System.out.println("has twist up ");
               
               // changing the cell turnTimes incrementing by 1 each time

               }
        

        if(hasTwistDown(s)){
            System.out.println("has twist down");
         }
        
        if(ring.contains("ring 1")){

            System.out.println(1);
        }
        else if(ring.equals("ring 2")){
            System.out.println(2);
        }
         
        else if(ring.equals("ring 3")){
            System.out.println(3);
        }
        else if(ring.equals("ring 4")){
            System.out.println(4);
        }

       for(int j = 0; j < ringSub.length(); j++){
            
        if(Character.isDigit(ringSub.charAt(j))){
            ringNum = ringSub.charAt(j);
            ringNum = Character.getNumericValue(ringNum);
            System.out.println("Ring number: " + ringNum);

            setRing(ringNum);

        }

    }
    // do if statement for string number of turns i.e once or twice
    for(int k = 0; k < turnSub.length(); k++){
        
        if(Character.isDigit(turnSub.charAt(k))){
            turnTimes = turnSub.charAt(k);
            turnTimes = Character.getNumericValue(turnTimes);
            System.out.println("Turn times: " + turnTimes);

            if(hasRing(s) && hasTwistUp(s)){
                switch(getRing()){
                    // turn array([ringnumber])
        
                    case 1: turnCell1(turnTimes);
                    break;
                    case 2: turnCell2(turnTimes);
                    break;
                    case 3: turnCell3(turnTimes);
                    break;
                    case 4: turnCell4(turnTimes);                
                    break;
                    
                }

            
        }

    }
    
    }
       

        
        }

  
       
   /*
   public final boolean containsDigit(String s) {
    boolean containsDigit = false;

    if (s != null && !s.isEmpty()) {
        for (char c : s.toCharArray()) {
            if (containsDigit = Character.isDigit(c)) {
                break;
            }
        }
    }
    
    return containsDigit;
}*/
    
    int actualNumber = 0;

    public BicycleLock(){

    }

    public void setLockNumber(int value){
        actualNumber = value;
    }  

    
    public static void main(String...args){
        BicycleLock newLock = new BicycleLock();
        String userInput;
        newLock.createMap();

        

        while(!newLock.lockEquals(lock, unlock)){
        userInput = newLock.userInput();
        newLock.containsRing(userInput);
        newLock.printLock();
        System.out.println();
        }
        
        System.out.println("unlocked");

        }
        
 
        /*
        Ring 1: Twist up 4 times 
        Ring 3: Twist down once
            Ring 4: Twist up or down 5 times
*/
        
    }


