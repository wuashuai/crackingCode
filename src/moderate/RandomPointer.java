package moderate;

public class RandomPointer {
    public static RandomListNode copyRandomList(RandomListNode head) {

        if(head == null) return null;

        RandomListNode node = head;


        while(node != null){
            RandomListNode tmp = new RandomListNode(node.label);
            tmp.next = node.next;
            node.next = tmp;
            node = tmp.next;
        }

        node = head;

        while(node != null){
            if(node.random != null) node.next.random = node.random.next;
            node = node.next.next;
        }

        node = head;
        RandomListNode copyHead = head.next;
        RandomListNode copyNode = copyHead;

        while(node.next.next != null){
            node.next = node.next.next;
            copyNode.next = node.next.next;
            node = node.next;
            copyNode = copyNode.next;
        }

        return copyHead;
    }


    public static void main(String[] args){
        RandomListNode r1 = new RandomListNode(-1);
        RandomListNode cr1 = copyRandomList(r1);
    }
}
class RandomListNode{
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
