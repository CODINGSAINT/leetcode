package stack;

import utils.LeetCode;
import utils.Level;

import java.util.Stack;

/**
 * The Leetcode file system keeps a log each time some user performs a change folder operation.
 * <p>
 * The operations are described below:
 * <p>
 * "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
 * "./" : Remain in the same folder.
 * "x/" : Move to the child folder named x (This folder is guaranteed to always exist).
 * You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.
 * <p>
 * The file system starts in the main folder, then the operations in logs are performed.
 * <p>
 * Return the minimum number of operations needed to go back to the main folder after the change folder operations.
 */

/**
 * <b>Results</b>
 *Runtime: 1 ms, faster than 76.24% of Java online submissions for Crawler Log Folder.
 * Memory Usage: 38.7 MB, less than 52.92% of Java online submissions for Crawler Log Folder.
 */

@LeetCode(no = 1598,
        title = "Crawler Log Folder"
        , url = "https://leetcode.com/problems/crawler-log-folder/",
        level = Level.EASY)
public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> folders = new Stack<>();


        for (String s : logs) {
            switch (s) {
                case "../":
                    if (!folders.isEmpty())
                        folders.pop();
                case "./":
                    continue;
                default:
                    folders.push(s);
            }
        }
        return folders.size();
    }

}
