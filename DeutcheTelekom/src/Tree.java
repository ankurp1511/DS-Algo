import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    static Node root;

    public static void main(String[] args) {


        Tree tree = new Tree();

        Node node1 = new Node(1);

        tree.root = node1;

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Queue<Node> queue = new LinkedList<>();

        if (root != null){
            queue.offer(root);
            queue.offer(null);
        }

        while (!queue.isEmpty()){
            Node node = queue.remove();
            if(node != null) {
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }else {
                if(!queue.isEmpty()){
                    System.out.println();
                    queue.offer(null);
                }
            }
        }
    }
}
