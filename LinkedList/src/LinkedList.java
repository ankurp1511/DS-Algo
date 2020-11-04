public class LinkedList {

    private static Node root;
    private static int count;
    private static int size;

    public static void createNode(int data){
        if (root == null){
            root = new Node(data);
            size++;
        }else {
            Node temp = root;
            while (temp.getLink() != null){
                temp = temp.getLink();
            }
            Node node = new Node(data);
            temp.setLink(node);
            size++;
        }
    }

    public static int size(){
        return size;
    }

    public static void printList(){

        if(root == null){
            return;
        }
        Node temp = root;

        while (temp != null){
            System.out.print(temp.getData() + " ");
            temp = temp.getLink();
        }
    }

    public static void reverseList(){

        Node prev = null;
        Node curr = root;

        while (curr.getLink() != null){
            Node next = curr.getLink();
            curr.setLink(prev);
            prev = curr;
            curr = next;
        }

        curr.setLink(prev);
        root = curr;
    }

    public static void nthFromEnd(int n){
        if(root == null){
            System.out.println("List is Empty");
        }
        Node temp = root;
        nthFromEnd(temp, n);
    }

    public static void nthFromEnd(Node node, int n){

        if(node != null){
            nthFromEnd(node.getLink(), n);
            count++;
            if(count == n){
                System.out.println(node.getData());
            }
        }
    }

}
