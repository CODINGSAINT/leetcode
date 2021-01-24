package string;

public class ChangeMinimumCharacterstoSatisfyOneofThreeConditions {
    public int minCharacters(String a, String b) {

        return Integer.min(transformAllChar(a,b) ,
                Integer.min(
                        minChanges(a,b)
                        ,minChanges(b,a)  ));

    }
    public int minChanges(String a, String b){

        //check for elements from b-z calculating the number of changes required so that all elements are less than b-z in a and greater that b-z in b
        int minChanges=a.length()+b.length();
        for(char current='b';current<='z' ;current++){
            //check no of changes required to make the String Strictly less than current
            int count=0;

            for(int i=0;i<a.length();i++){
                if(a.charAt(i)<current){
                    count++;
                }
            }
            for(int i=0;i<b.length();i++){
                if(b.charAt(i)>=current){
                    count++;
                }
            }
            minChanges=Integer.min(minChanges,count);
        }
        //System.out.println("minChanges ="+minChanges);

        return minChanges;
    }



    int transformAllChar(String a,String b){
        int minChanges=a.length()+b.length();
        for(char current='a';current<='z' ;current++){
            //check no of changes required to make the String Strictly less than current
            int count=0;

            for(int i=0;i<a.length();i++){
                if(a.charAt(i)!=current){
                    count++;
                }
            }
            for(int i=0;i<b.length();i++){
                if(b.charAt(i)!=current){
                    count++;
                }
            }
            minChanges=Integer.min(minChanges,count);
        }
        // System.out.println("Transfomation ="+minChanges);
        return minChanges;
    }
}