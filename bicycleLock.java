/*
A bicycle combination lock has four rings with numbers 0 through 9. 
Given the actual numbers and the combination to unlock, print instructions 
to unlock the lock using the minimum number of twists. A string input of "twist up" increases 
the number value of a ring, and a "twist down" decreases it. For example, if 
the actual number shown is 1729 and the desired combination is 5714, write your 
instructions in java like this: 
Ring 1: Twist up 4 times 
Ring 1: Twist up once
Ring 3: Twist down once
Ring 3: Twist down twice
Ring 3: Twist up or down 3 times
Ring 4: Twist down 2 times
Ring 4: Twist down once
Ring 4: Twist up or down 5 times

*/
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;


class BicycleLock{
    public static int[] lock = new int[]{1,7,2,9};
    public static int[] unlock = new int[]{5,7,1,4};
    
    public static int twistOption;

    int currentRing = 0;
    
    
    public BicycleLock(){
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

        boolean equal = true;
        for(int i = 0; i < array1.length; i++){
            if(array1[i] != array2[i]){
                equal = false; 
            }
        }
        return equal;
        
    }

    public boolean hasTwist(String twist){
        if(twist.contains("Twist up") || twist.contains("twist up")){
            twistOption = 1;
            return true;
        }

        else if(twist.contains("Twist down") || twist.contains("twist down")){
            twistOption = 2;
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

 

   public void turnRing(int ring, int times, int twistOption, int turnTimeString){
       // turnTimeString is going to be 1 for once and 2 for twice
       // twist option is 1 for up and 2 for down

        if(turnTimeString == 1 || turnTimeString == 2){
            times = 0;

            for(int i = 0; i < turnTimeString; i++){
                if(twistOption == 1 && (turnTimeString == 1 || turnTimeString == 2)){
                    lock[ring] += 1;
                if(lock[ring] > 9){
                    lock[ring] = 0;
                }   
            }
                else if(twistOption == 2 && (turnTimeString == 1 || turnTimeString == 2)){
                    lock[ring] -= 1;
                    if(lock[ring] < 0){
                        lock[ring] = 9;
                    }
                }
            }
        }

        for(int i = 0; i < times; i++){
            if(twistOption == 1){               
                lock[ring] += 1;
            if(lock[ring] > 9){
                lock[ring] = 0;
            }   
        }
            else if(twistOption == 2){
                lock[ring] -= 1;
                if(lock[ring] < 0){
                    lock[ring] = 9;
                }
            }      
        }
   }
   
   public void setRing(int currentRing){
       this.currentRing = currentRing;
   }
   
   public int getRing(){
       return currentRing;
   }


   public void containsRing(String s){
       // check if string has a digit
       // if it does return that digit
       String ring = "";
       String numbers = "";
       int ringNum = 0;
       int firstNum = 0;
       int turnTimes = 0;
       int turnTimeString = 0;
       String ringSub = s.substring(0, 7);
       String turnSub= s.substring(7, s.length());
       String turnSubString = s.substring(7, s.length()); // "once or twice"

       char[] charArray = new char[s.length()];

       for(int i = 0; i < s.length(); i++){
        //loop through substring then get tw    he number
           ring += s.charAt(i);
           numbers += s.charAt(i);
        }
        if(turnSub.contains("once")){
            System.out.println("valid");
            turnTimeString = 1;
        }
        if(turnSub.contains("twice")){
            System.out.println("valid");
            turnTimeString = 2;
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
        }
    }
            if(hasRing(s) && hasTwist(s)){
                switch(getRing()){
                    case 1: turnRing(0, turnTimes, twistOption, turnTimeString);
                    break;
                    case 2: turnRing(1, turnTimes, twistOption, turnTimeString);
                    break;
                    case 3: turnRing(2, turnTimes, twistOption, turnTimeString);
                    break;
                    case 4: turnRing(3, turnTimes, twistOption, turnTimeString);                
                    break; 
                }
            }
        }

    int actualNumber = 0;
    public void setLockNumber(int value){
        actualNumber = value;
    }  
    
    public static void main(String...args){
        BicycleLock newLock = new BicycleLock();
        String userInput;
        while(!newLock.lockEquals(lock, unlock)){
        userInput = newLock.userInput();
        newLock.containsRing(userInput);
        newLock.printLock();
        System.out.println();
        }
        System.out.println("unlocked");
        }
    }


