package hw3;
import static hw3.RedBlackTree.printRedBlackTree;

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.add(5);
        tree.add(7);
        tree.add(10);
        tree.add(3);
        tree.add(6);
        tree.add(20);
        tree.add(25);
        tree.add(35);
        printRedBlackTree(tree);
    }
}