public class Node {

    private int data;
    private Node lChild;
    private Node rChild;

    public Node(int data) {
        this.data = data;
        this.lChild = null;
        this.rChild = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getlChild() {
        return lChild;
    }

    public void setlChild(Node lChild) {
        this.lChild = lChild;
    }

    public Node getrChild() {
        return rChild;
    }

    public void setrChild(Node rChild) {
        this.rChild = rChild;
    }
}
