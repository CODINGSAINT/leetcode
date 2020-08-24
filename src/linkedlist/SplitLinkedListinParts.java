package linkedlist;

public class SplitLinkedListinParts {
    public static void main(String[] args) {

    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode node = root;
        int len = len(node);

        ListNode[] ret = new ListNode[k];
        if(len == 0) return ret;

        int size = len / k;
        int extra = len % k;

        while(k-- > 0){
            ListNode n = new ListNode(node.val);
            ret[ret.length - k - 1] = n;

            int count = size + (extra-- > 0? 1 : 0);
            while(count-- > 0){
                node = node.next;

                if(count > 0 && node != null){
                    n.next = new ListNode(node.val);
                    n = n.next;
                }else{
                    break;
                }
            }
            if(node == null){
                break;
            }
        }

        return ret;
    }

    private int len(ListNode node){
        int len = 0;
        while(node != null){
            node = node.next;
            len++;
        }

        return len;
    }

}
