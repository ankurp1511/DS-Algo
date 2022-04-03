import java.util.*;

public class Tree {

    private static Node root;
    static int maxLevel = 0;
    static Integer num = Integer.MIN_VALUE;
    private static int sum;
    private static int size;
    private static Integer max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Tree tree = new Tree();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        tree.root = node1;
        node1.setlChild(node2);
        node1.setrChild(node3);
        node3.setlChild(node4);
        node3.setrChild(node5);
        node4.setlChild(node6);
        node4.setrChild(node7);
        node7.setrChild(node8);

//        System.out.println(findMaxElement(root));
//        System.out.println(sizeOfTree(root));
//        System.out.println(heightRecursive(root));
//        System.out.println(heightIterative(root));
//        reverseLevelOrderTraversal(root);
//        System.out.println();
//        levelOrderSpiral(root);
//        System.out.println();
//          rightViewRecursive();
//        System.out.println();
//        leftViewRecursive();
          //printAncestors(root, node2);

 //       levelOrder(root);
          maxPathSum(root);
//        Node node = lca(root, node2, node5);
//        System.out.println(node.getData());
//        diameter(root);
//        System.out.println(num);
//
//        sumOfCoveredAndUncoveredNodes();

    }

    private static int maxPathSum(Node root) {

        maxSum(root);
        return max;
    }

    private static int maxSum(Node node) {

        if (node == null) {
            return 0;
        }

        int lMax = maxSum(node.getlChild());
        int rMax = maxSum(node.getrChild());

        int maxPath = Math.max(lMax, rMax);

        if (node.getData() >= node.getData() + maxPath) {
            max = Math.max(max, node.getData());
            return node.getData();
        } else if (node.getData() + maxPath > node.getData() + lMax + rMax) {
            max = Math.max(max, node.getData() + maxPath);
            return node.getData() + maxPath;
        } else {
            max = Math.max(max, node.getData() + lMax + rMax);
            return node.getData() + maxPath;
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        queue.add(root);
        queue.add(null);

        result.add(new ArrayList<>());

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node == null && !queue.isEmpty()) {
                queue.add(null);
                result.add(new ArrayList<>());
            } else if (!queue.isEmpty()){
                result.get(result.size() - 1).add(node.getData());
                if (node.getlChild() != null) {
                    queue.add(node.getlChild());
                }
                if (node.getrChild() != null) {
                    queue.add(node.getrChild());
                }
            }
        }
        return result;
    }

    private static int findMaxElement(Node node){

        int maxElement = Integer.MIN_VALUE;

        if(node != null){
            int lMax = findMaxElement(node.getlChild());
            int rMax = findMaxElement(node.getrChild());

            if(lMax > rMax){
                maxElement = lMax;
            }else {
                maxElement = rMax;
            }
            if(node.getData() > maxElement){
                maxElement = node.getData();
            }
        }
        return maxElement;
    }

    private static int sizeOfTree(Node node){

        if(node == null){
            return 0;
        }
            return 1 + sizeOfTree(node.getlChild()) + sizeOfTree(node.getrChild());
    }

    private static int heightRecursive(Node node){

        if(node == null){
            return 0;
        }
        int lHeight = heightRecursive(node.getlChild());
        int rHeight = heightRecursive(node.getrChild());

        return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
    }

    private static int heightIterative(Node node){

        Queue<Node> queue = new LinkedList<>();
        int count = 1;

        if(node != null){
            queue.offer(node);
            queue.offer(null);
        }else {
            return 0;
        }

        while (!queue.isEmpty()){
            Node node1 = queue.remove();

            if(node1 != null){
                if(node1.getlChild() != null){
                    queue.offer(node1.getlChild());
                }
                if(node1.getrChild() != null){
                    queue.offer(node1.getrChild());
                }
            }else {
                if(!queue.isEmpty()){
                    count++;
                    queue.offer(null);
                }else {
                    break;
                }
            }
        }

        return count;
    }

    private static void reverseLevelOrderTraversal(Node node){

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        if(node == null){
            return;
        }else {
            queue.offer(node);

            while (!queue.isEmpty()){

                Node temp = queue.remove();
                stack.push(temp);

                if(temp.getrChild() != null){
                    queue.offer(temp.getrChild());
                }
                if(temp.getlChild() != null){
                    queue.offer(temp.getlChild());
                }

            }

            while (!stack.isEmpty()){
                System.out.print(stack.pop().getData() + " ");
            }

        }
    }

    private static void levelOrderSpiral(Node node){


        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(node);

        while (!stack1.isEmpty() || !stack2.isEmpty()){

            while(!stack1.isEmpty()){
                Node temp = stack1.pop();
                System.out.print(temp.getData() + " ");

                if(temp.getrChild() != null){
                    stack2.push(temp.getrChild());
                }
                if(temp.getlChild() != null){
                    stack2.push(temp.getlChild());
                }
            }

            while (!stack2.isEmpty()){
                Node temp = stack2.pop();
                System.out.print(temp.getData() + " ");

                if(temp.getlChild() != null){
                    stack1.push(temp.getlChild());
                }
                if(temp.getrChild() != null){
                    stack1.push(temp.getrChild());
                }
            }
        }
    }

    private static void rightViewRecursive(){
        rightViewRecursive(root, 1);
        maxLevel = 0;
    }

    private static void rightViewRecursive(Node node, int level){

        if(node == null){
            return;
        }

        if (maxLevel < level){
            System.out.print(node.getData() + " ");
            maxLevel = level;
        }

        rightViewRecursive(node.getrChild(), level + 1);
        rightViewRecursive(node.getlChild(), level + 1);
    }

    private static void leftViewRecursive(){
        leftViewRecursive(root, 1);
        maxLevel= 0 ;
    }

    private static void leftViewRecursive(Node node, int level){

        if(node == null){
            return;
        }

        if(maxLevel < level){
            System.out.print(node.getData() + " ");
            maxLevel = level;
        }
        leftViewRecursive(node.getlChild(), level + 1);
        leftViewRecursive(node.getrChild(), level + 1);

    }

    private static boolean printAncestors(Node root, Node node){

        if(root == null){
            return false;
        }
        if(node.equals(root.getrChild()) || node.equals(root.getlChild()) ||
               printAncestors(root.getlChild(), node) || printAncestors(root.getrChild(), node)){
            System.out.print(root.getData() + " ");
            return true;
        }
        return false;
    }

    private static Node lca(Node node, Node a, Node b){

        if(node == null){
            return null;
        }
        if(node.getData() == a.getData() || node.getData() == b.getData()){
            return node;
        }

        Node left = lca(node.getlChild(), a, b);
        Node right = lca(node.getrChild(), a, b);

        if(left != null && right != null){
            return node;
        }

        return left != null ? left : right;
    }


    private static int diameter(Node node){

        if(node == null){
            return 0;
        }

        int lDiameter = diameter(node.getlChild());
        int rDiameter = diameter(node.getrChild());

        int temp = Math.max(lDiameter, rDiameter) + 1;
        int ans = Math.max(temp, lDiameter + rDiameter + 1);
        num = Math.max(num, ans);
        return temp;
    }

    /**
     * This method calculates the sum of all the nodes in left and right view of tree (uncovered nodes)
     * and all the nodes apart from uncovered nodes
     */
    private static void sumOfCoveredAndUncoveredNodes(){

        if(root != null) {
            int leftSum = sumOfLeftViewNodes(root);
            System.out.println("LeftSum of tree : " + leftSum);
            int rightSum = sumOfRightViewNodes(root);
            System.out.println("RightSum pf tree : " + rightSum);

            int sumOfUnCoveredNodes = leftSum + rightSum - root.getData();
            int sumOfCoveredNodes = sumOfTreeNodes() - sumOfUnCoveredNodes;

            System.out.println("Sum Of Covered Nodes : " + sumOfCoveredNodes);
            System.out.println("Sum Of Uncovered Nodes : " + sumOfUnCoveredNodes);

        }
    }

    private static int sumOfTreeNodes(){
        if(root != null){
              sumOfTreeNodes(root);
              return sum;
        }
        return 0;
    }

    private static void sumOfTreeNodes(Node node){

        if(node != null){
            sum += node.getData();
            size++;
            sumOfTreeNodes(node.getlChild());
            sumOfTreeNodes(node.getrChild());
        }
    }

    private static int sumOfLeftViewNodes(Node root){

        Node temp = root;
        int leftSum = 0;

        if(temp != null){
            leftSum = temp.getData();
        }

        while (true){
            if(temp.getlChild() != null){
                temp = temp.getlChild();
                leftSum += temp.getData();
            }else if(temp.getrChild() != null){
                temp = temp.getrChild();
                leftSum += temp.getData();
            }else {
                break;
            }
        }
       return leftSum;
    }

    private static int sumOfRightViewNodes(Node root){

        Node temp = root;
        int rightSum = 0;

        if(temp != null){
            rightSum = temp.getData();
        }

        while (true){
            if(temp.getrChild() != null){
                temp = temp.getrChild();
                rightSum += temp.getData();
            }else if(temp.getlChild() != null){
                temp = temp.getlChild();
                rightSum += temp.getData();
            }else {
                break;
            }
        }
        return rightSum;
    }

}
