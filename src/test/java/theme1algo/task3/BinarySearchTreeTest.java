package theme1algo.task3;

import java.util.Random;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
    final int LENGTH = 50;

    @Test
    void test() {
        Random random = new Random();
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < LENGTH; i++) {
            bst.insert(random.nextInt(LENGTH * 2));
        }
        bst.inOrderTraversal();
        for (int i = 0; i < LENGTH; i++) {
            int value = random.nextInt(LENGTH * 2);
            if (bst.search(value)) {
                System.out.println("Delete " + value);
                bst.delete(value);
                bst.inOrderTraversal();
            }
        }
    }
}
