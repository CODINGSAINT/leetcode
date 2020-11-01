package arrays;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 419,
        title = "Battleships in a Board",
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/battleships-in-a-board/")
public class BattleshipsinaBoard {
    public int countBattleships(char[][] board) {

        int n= board.length-1;
        int count=0;
        for(int i=0; i<=n;i++){
            int m=board[i].length-1;
            for(int j=0;j<=m;j++){
                if(board[i][j]=='X'){
                    if((j>0 && board[i][j-1]=='X')
                            || (i>0 && board[i-1][j]=='X'))
                        continue;
                    count++;
                }
            }
        }
        return count;
    }
}
