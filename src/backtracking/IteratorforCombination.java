package backtracking;

import utils.LeetCode;
import utils.Level;

import java.util.LinkedList;
import java.util.Queue;

@LeetCode(no=1286,
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/iterator-for-combination/",
        title = "Iterator for Combination")
public class IteratorforCombination {
    public static void main(String[] args) {
        //  IteratorforCombination i= new IteratorforCombination();
        CombinationIterator iterator = new CombinationIterator("abcdefghijkl", 3);
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());

    }

}
class CombinationIterator {
    Queue<String> q;
    public CombinationIterator(String characters, int combinationLength) {
        q= new LinkedList<>();
        StringBuffer sb= new StringBuffer();
        generateSubStrings(characters, 0,combinationLength,sb );

    }
    public void generateSubStrings(String str, int startIndex, int size,StringBuffer sb  ){
        if(size==0){
            q.add(sb.toString());
            return;
        }
        if(startIndex>str.length()-1)
            return ;
        sb.append(str.charAt(startIndex));
        generateSubStrings(str, startIndex+1, size-1, sb);
        sb.setLength(sb.length()-1);
        generateSubStrings(str, startIndex+1, size, sb);
    }

    public String next() {
        return q.poll();
    }

    public boolean hasNext() {
        return  !q.isEmpty();

    }

}
