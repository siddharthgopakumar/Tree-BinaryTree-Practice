
/**
 * Write a description of BinaryTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Stack;
public class BinaryTree {
    class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    class Queue {
        Node[] arr;
        int capacity;
        int front, rear, size;      
        public Queue(int capacity)  {
            this.capacity = capacity;
            this.front = this.size = 0;
            rear = capacity - 1;
            arr = new Node[this.capacity];
        }
        
        public boolean isEmpty () {
            return (size == 0)? true: false;
        }
        
        
        public void enqueue (Node node) {
            this.rear = (this.rear + 1)%this.capacity;
            this.arr[this.rear] = node;
            this.size++;
        }
        
        public Node dequeue(Node node) {
            Node deletedNode = this.arr[this.front];
            this.front = (this.front + 1)%capacity;
            this.size --;
            return deletedNode;
        }        
    }
    
    public Node manualTree () {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node size = new Node(6);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.right = size;
        Node root = one;
        return root;        
        /*                  1
         *                /   \
         *               2     3
         *              / \     \
         *             4   5     6
         */
    } 
    
    public void depthFirstIteration () {         
        Node root = manualTree();        
        Stack<Node> stack = new Stack<Node>();
        stack.push(root); 
        while(!stack.isEmpty()){
            Node current = stack.pop();
            System.out.print(current.data + ", ");
            if(current.right != null)   stack.push(current.right);            
            if(current.left != null)    stack.push(current.left);
        }
    }
    
    public void depthFirstRecursion (Node root) {        
        if(root == null)    return;
        System.out.print(root.data + ", ");
        depthFirstRecursion(root.left);
        depthFirstRecursion(root.right);
    }
    
    public void depthFirstRecursionAux () {
        depthFirstRecursion(manualTree());
    }
    
    public void breadthFirstTraversalIteration () {     // output : 1, 2, 3, 4, 5, 6
        
        
    }    
    
}
