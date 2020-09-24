package graph;
import java.util.*;
public class SortIntegersbyThePowerValue {
    public static void main(String[] args) {
        SortIntegersbyThePowerValue s= new SortIntegersbyThePowerValue();
        //System.out.println(s.getKth(12,15,2));
        int x=s.getKth(10,20,5);
        System.out.println("Result "+x);

    }
    //Creating a Helper class just to sort based on pow and get the val
    class ValAndPower{
        public int val;
        public int pow;
        public ValAndPower(int val, int pow) {
            this.val = val;
            this.pow = pow;
        }
        public int getPow() {
            return pow;
        }


    }
    /*
    Let us create a step memory to save time. It will keep the values of all the steps required to make a number 1,
    so it it comes again , we use it rather computing again*/
    HashMap<Integer,Integer> stepMemory= new HashMap<>();


    public int getKth(int lo, int hi, int k) {
        ArrayList<ValAndPower>allSteps= new ArrayList<>();
        for(int i=lo ; i<=hi;i++){
            int steps= calculateSteps(i);
            ValAndPower v= new ValAndPower(i,steps );
            allSteps.add(v);
        }
        allSteps.sort(Comparator.comparingInt(ValAndPower::getPow));
        return allSteps.get(k-1).val;

    }

    int calculateSteps(int val){
        int x=val;
        int steps=0;
        //This variable will store all the sequence , it will help stepMemory to count number of steps that is taken to become 1,
        // In case if we encountred a number already present in hashmap we cant put all of the steps in our stepMemory HashMap as , the number of steps
        //found will not be actual as we will ternmiate the counting there, in that case we will have only 1 value in map the power and the number
        List<Integer>memory = new ArrayList<>();
        memory.add(x);
        boolean stepsPresent=false;
        while(x!=1){
            // Check if already have this in memory
            if(stepMemory.get(x)!=null) {
                steps+=stepMemory.get(x);
                // in steps were found in memory no point in counting how many steps more it will take from here , just use it
                stepsPresent=true;
                break;
            }

            if(x%2==0){
                x= x / 2;
            }else{
                x=(3 * x) + 1;

            }
            steps++;
            memory.add(x);
        }
        if(!stepsPresent)
            stepTables(memory);
        else
            stepMemory.put(val,steps);// No steps are in memory so we can add all of the values found till now to steps

        return steps;
    }

    void stepTables( List<Integer>memory ){

        for(int i=0;i<memory.size();i++){
            stepMemory.putIfAbsent( memory.get(i),(memory.size()-(i+1))  );
        }
    }
}