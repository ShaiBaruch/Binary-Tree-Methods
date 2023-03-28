public class IntTreeNode

/**
 * Author: Shai Baruch
 * Description: This program adds values to the left and right sides of a tree.
 * It,finds values in the tree, printing the values in pre-order and post-order, 
 * returns the size and height of the tree, finds minimum value and deletes nodes.
 */
{
    public int data;//value
    public IntTreeNode left;//left child
    public IntTreeNode right;//right child
    public IntTreeNode(int data)//constructor
    {
        this.data =  data; 
    }

    public void add(int value)//method for adding value
    {
        if(value< data)//is value less than root
        {
            if(left == null)//is left side null
            {
                left =new IntTreeNode(value); //create a new node with value   
            }
            else
            {
                left.add(value);//add node with value (Recursive)
            }
        }
        else{
            if(right == null)
            {
                right = new IntTreeNode(value); 
            }
            else
            {
                right.add(value); //Recursive
            }
        }
    }

    public boolean find(int value)
    {
        if(value == data)//checking root for the value
        {
            return true;//if found return true
        }
        else if(value < data)//if value smaller go left
        {
            if(left == null)
            {
                return false;
            }
            else
            {
                return left.find(value);//(recursive find)
            }
        }
        else
        {
            if(right == null)
            {
                return false;
            }
            else
            {
                return right.find(value);//recursive find
            }
        }
    }

    public void printInOrder()//print in order left - root - right
    {
        if(left != null)//check left child
        {
            left.printInOrder(); //(recursive call) 
        }
        System.out.println(data);
        if(right != null)//check right child
        {
            right.printInOrder(); //recursive call
        }
    }

    public int size(IntTreeNode root)//pass node here
    {
        if(root == null)//check if empty
        {
            return 0;//if empty return 0
        }
        else
        {
            return size(root.left) + size(root.right) + 1;//recursively counting to determine size        
        }
    }

    public int findMinimum(IntTreeNode node) {
        int min = node.data;
        while(node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

    public IntTreeNode delete(IntTreeNode root,int value ) {
        if(root == null) {
            return root;
        }
        else if(root.data > value) {
            root.left = delete(root.left, value);
        }
        else if(root.data < value) {
            root.right = delete(root.right, value);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            root.data = findMinimum(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public void post(IntTreeNode node) {
        if (node == null) {
            return;
        }
        post(node.left);
        post(node.right);
        System.out.print(node.data +", ");
    }

    public void pre(IntTreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + ", ");
        pre(node.left);
        pre(node.right);
    }

    public int getHeight(IntTreeNode root) {
        if(root == null) {
            return 0;
        }
        int height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        return height;
    }
    
    public void printHeight(IntTreeNode root) {
        System.out.println(getHeight(root));
    }
    
   
}
