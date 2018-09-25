package interview.dropbox;

public class CycleArray {

    int[] array;
    int index;
    int bound;
    int start;
    boolean isEmpty;

    CycleArray(int size){
        bound = size;
        index = 0;
        start = 0;
        isEmpty = true;

        array = new int[bound];
    }

    int poll(){


        if(isEmpty){
            return -1;
        }

        int res = array[start++];
        start = start % bound;

        if(start == index) isEmpty = true;

        return res;
    }

    void offer(int value){

        if(!isEmpty && index == start){
            start++;
            start = start % bound;
        }

        isEmpty = false;

        array[index++] = value;
        index = index % bound;

    }

    boolean hasNext(){
        return isEmpty;
    }


    public static void main(String[] args){
        CycleArray queue = new CycleArray(4);

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        queue.offer(8);
        queue.offer(9);
        queue.offer(10);
        queue.offer(11);
        queue.offer(12);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }



}
