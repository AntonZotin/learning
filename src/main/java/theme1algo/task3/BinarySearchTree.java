package theme1algo.task3;

public class BinarySearchTree {
    private Node rootNode = null;

    public void insert(int value) {
        rootNode = insertRecursive(rootNode, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.value)
            node.left = insertRecursive(node.left, value);
        else if (value > node.value)
            node.right = insertRecursive(node.right, value);
        return node;
    }

    public void delete(int value) {
        rootNode = deleteRecursive(rootNode, value);
    }

    private Node deleteRecursive(Node node, int value) {
        if (node != null) {
            if (value < node.value)
                node.left = deleteRecursive(node.left, value);
            else if (value > node.value)
                node.right = deleteRecursive(node.right, value);
            else {
                if (node.left == null)
                    return node.right;
                else if (node.right == null)
                    return node.left;
                node.value = minValue(node.right);
                node.right = deleteRecursive(node.right, node.value);
            }
        }
        return node;
    }

    private int minValue(Node node) {
        int minval = node.value;
        while (node.left != null) {
            minval = node.left.value;
            node = node.left;
        }
        return minval;
    }

    public void inOrderTraversal() {
        inOrderRecursive(rootNode);
        System.out.println("");
    }

    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.value + " ");
            inOrderRecursive(node.right);
        }
    }

    public boolean search(int value) {
        return searchRecursive(rootNode, value) != null;
    }

    private Node searchRecursive(Node node, int value) {
        if (node == null || node.value == value)
            return node;
        if (node.value > value)
            return searchRecursive(node.left, value);
        return searchRecursive(node.right, value);
    }

    private class Node {
        int value;
        Node left, right;

        public Node(int rootValue) {
            value = rootValue;
            left = right = null;
        }
    }
}
