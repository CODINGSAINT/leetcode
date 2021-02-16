package stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath s= new SimplifyPath();
      /*  System.out.println(s.simplifyPath("/home/"));
        System.out.println(s.simplifyPath("/../"));
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
*/
        System.out.println(s.simplifyPath("/a/./b/../../c/"));

    }


    public String simplifyPath(String path) {
        Stack<String> st= new Stack<>();
        StringBuffer sb= new StringBuffer();
        String paths[]=path.split("/");
        for(int i=0;i<paths.length;i++){
            String current=paths[i];
            if(current.equals(""))
                continue;
            if( !current.equals(".") && !current.equals("..")){
                st.push(current);
                continue;
            }
            if(current.equals("..") && !st.isEmpty()){
                st.pop();
            }



        }
        if (st.empty()){
            return "/";
        }
        String result="";
        while(!st.empty()){
            result = "/" + st.pop() + result;
        }
        return result;
    }
    }