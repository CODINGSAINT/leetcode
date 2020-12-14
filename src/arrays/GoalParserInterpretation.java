package arrays;

public class GoalParserInterpretation {
    public String interpret(String command) {
        StringBuilder ans= new StringBuilder();

        for(int i=0;i<command.length();i++){
            char current=command.charAt(i);
            if(current=='G'){
                ans.append("G");

            }else if(current=='('){
                if(command.charAt(i+1) == ')'){
                    ans.append("o");
                    i+=1;
                }else {
                    ans.append("al") ;
                    i+=2;
                }
            }
        }
        return ans.toString();

    }
}
