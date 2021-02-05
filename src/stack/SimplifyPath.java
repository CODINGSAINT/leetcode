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
            Stack<String> st = new Stack<String>();
            for (String str : path.split("/")){
                if (str.equals("..")){
                    if(!st.empty()){
                        st.pop();
                    }
                } else if (str.equals(".") || str.equals("")){
                    continue;
                } else {
                    st.push(str);
                }
            }
            if (st.empty()){
                return "/";
            }
            String spath = "";
            while(!st.empty()){
                spath = "/" + st.pop() + spath;
            }
            return spath;
        }
    }