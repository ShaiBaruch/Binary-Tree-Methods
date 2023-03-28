
import java.util.*;
public class IntTreeTest 
{
    public static void main(String[] args) {
     IntTreeNode tree = new IntTreeNode(50);
     tree.add(44);
     tree.add(56);
     tree.add(14);
     tree.add(75);
     tree.add(48);
     tree.add(42);
     tree.add(3);
     tree.add(7);
     tree.add(235);
     System.out.println("before deleting a value: "); 
     tree.printInOrder();
     tree.delete(tree, 42);
     System.out.println("after deleting a value: ");
     tree.printInOrder();
     System.out.println("tree in post order: ");
     tree.post(tree);
     System.out.println();
     System.out.println("tree in pre order: ");
     tree.pre(tree);
     System.out.println();
     tree.printHeight(tree);
     
    }


}