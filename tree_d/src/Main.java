
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(7);
        bst.insert(9);
        bst.insert(11);
        bst.insert(12);
        bst.insert(13);

        System.out.println(bst.getRoot());

        System.out.println("Pre-order traversal:");
        bst.pre_order(bst.getRoot());
        System.out.println("\nPost-order traversal:");
        bst.post_order(bst.getRoot());

        System.out.println("\n");

        int valueToSearch = 11;
        BSTNode<Integer> foundNode = bst.search(bst.getRoot(), valueToSearch);

        if (foundNode != null) {
            System.out.println(valueToSearch + " found!");
        } else {
            System.out.println(valueToSearch + " not found!");
        }
    }
}