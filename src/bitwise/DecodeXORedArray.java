package bitwise;

import utils.LeetCode;
import utils.Level;

@LeetCode(no =1720,
        level = Level.EASY,
        title = "Decode XORed Array ",
        url = "https://leetcode.com/problems/")
//1720. [Decode XORed Array ](https://leetcode.com/problems/decode-xored-array/)|Easy|[DecodeXORedArray]()|
public class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        int arr[] = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 1; i < encoded.length + 1; i++) {
            arr[i] = Math.abs(arr[i - 1] ^ encoded[i - 1]);
        }
        return arr;

    }
}
