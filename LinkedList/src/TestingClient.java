public class TestingClient {

    public static void main(String[] args) {

        LinkedList.createNode(1);
        LinkedList.createNode(2);
        LinkedList.createNode(3);
        LinkedList.createNode(4);

        LinkedList.printList();

        System.out.println();

//        LinkedList.reverseList();
//        LinkedList.printList();

        LinkedList.nthFromEnd(2);
        LinkedList.printList();
        System.out.println();
        System.out.println(LinkedList.size());

    }
}
