package Performance;

import java.util.*;

/**
 *
 * @author Kyle Hewitt
 * Makes an ArrayList and a Linked List and fills them with random Integer objects.
 * It then tests the time and determines which computes faster using different methods;
 * .get() and .remove() on ArrayList and .next() on the Linked List.
 */
public class Timing {
    
    private long first, last, sumGetDown, sumGetUp, sumRemoveDown,sumRemoveUp,
                 timeDif1;// Holds the values for the nanotime and their differences
    public ArrayList <Integer> testList = new ArrayList();//ArrayList to time
    private Random ran = new Random();//To fill lists with random int
    private static LinkList list;//Linked List to time
    private static Timing obj;
    public String betterGet, betterRemove;//assigns for display purposes
    
    public static void main(String[] args) {
        list = new LinkList();
        obj = new Timing();
        
    }
    public Timing(int i){
        //empty constuctor
    }
    
    //Fills ArrayList with random Integer objects
    public Timing(){
        msg("\nArrayList (NanoSeconds)");
        first = System.nanoTime();
        for(int i =0;i<100000;i++){
            testList.add(new Integer(ran.nextInt()));
        }
        last = System.nanoTime();
        timeDif1 = last - first;
        msg("\tBuild: \t\t"+timeDif1);
        getLowToHigh();
        getHighToLow();
        removeLowToHigh();
        removeHighToLow();
        results();
    }
    
    //Times the .get() method starting from low index
    public void getLowToHigh(){
        sumGetUp = 0;
        first = System.nanoTime();
        for(int i =0;i<testList.size()-1;i++){
            testList.get(i);
        }
        last = System.nanoTime();
        sumGetUp = last - first;
        msg("\n\t.get() assending: \t"+sumGetUp);        
    }
    
    //Times the .get() method starting from high index
    public void getHighToLow(){
        sumGetDown = 0;
        first = System.nanoTime();
        for(int i =testList.size()-1;i>-1;i--){
            testList.get(i);
        }
        last = System.nanoTime();
        sumGetDown = last - first;
        msg("\t.get() decending: \t"+sumGetDown);
    }
    
    //Times the .remove() method starting from low index
    public void removeLowToHigh(){
        sumRemoveUp = 0;
        first = System.nanoTime();
        for(int i =0;i<testList.size()-1;i++){
            testList.remove(i);
        }
        last = System.nanoTime();
        sumRemoveUp = last - first;
        msg("\n\t.remove() assending: \t"+sumRemoveUp);
    }
    
    //Times the .remove() method starting from high index
    public void removeHighToLow(){
        sumRemoveDown = 0;
        first = System.nanoTime();
         for(int i =testList.size()-1;i>-1;i--){
            testList.remove(i);
        }
        last = System.nanoTime();
        sumRemoveDown = last - first;
        msg("\t.remove() decending: \t"+sumRemoveDown);
    }
    
    //Finds the difference to find the better time for the .get() methods
    public long getDiff(){
        if(sumGetUp>sumGetDown){
            betterGet = "Decending";
            return sumGetUp - sumGetDown;
        }
        else{
            betterGet = "Accending";
            return sumGetDown - sumGetUp;
        }
    }
    
    //Finds the difference to find the better time for the .remove() methods
    public long removeDiff(){
        if(sumRemoveUp>sumRemoveDown){
            betterRemove = "Decending";
            return sumRemoveUp - sumRemoveDown;
        }
        else{
            betterRemove = "Accending";
            return sumRemoveDown - sumRemoveUp;
        }
    }
    
    //displays results
    public void results(){
        msg("\nPerformance Difference ArrayList (NanoSeconds)");
        msg("\n\t.get(): \t\t"+getDiff()+"\t\tBetter Performance: "+betterGet);
        msg("\t.remove(): \t\t"+removeDiff()+"\tBetter Performance: "+betterRemove);
        
        msg("\nPerformance Difference LinkedList (NanoSeconds)");
        msg("\n\t.get() VS. Iterator: \t"+list.diff()+"\tBetter Performance: "+list.better);
    }
    
    //Used to print strings
    public void msg(String s){
        System.out.println(s);
    }
    
}
