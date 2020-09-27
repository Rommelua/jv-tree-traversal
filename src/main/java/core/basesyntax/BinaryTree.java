package core.basesyntax;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTree {
    // Root of Binary Tree
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /* Given a binary tree, print its nodes according to the 
      "bottom-up" post order traversal. */
    public List<Node> getNodesPostOrder(Node node) {
        List<Node> nodeList = new ArrayList<>();
        getNodesPostOrder(node, nodeList);
        return nodeList;
    }

    private void getNodesPostOrder(Node node, List<Node> nodeList) {
        if (node.getLeft() != null) {
            getNodesPostOrder(node.getLeft(), nodeList);
        }
        if (node.getRight() != null) {
            getNodesPostOrder(node.getRight(), nodeList);
        }
        nodeList.add(node);
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> nodeList = new ArrayList<>();
        getNodesInorder(node, nodeList);
        return nodeList;
    }

    private void getNodesInorder(Node node, List<Node> nodeList) {
        if (node.getLeft() != null) {
            getNodesInorder(node.getLeft(), nodeList);
        }
        nodeList.add(node);
        if (node.getRight() != null) {
            getNodesInorder(node.getRight(), nodeList);
        }
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(node);
        if (node.getLeft() != null) {
            nodeList.addAll(getNodesPreOrder(node.getLeft()));
        }
        if (node.getRight() != null) {
            nodeList.addAll(getNodesPreOrder(node.getRight()));
        }
        return nodeList;
    }

//    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(node);
        int start = 0;
        int nextStart;
        while ((nextStart = nodeList.size()) != start) {
            for (int i = start; i < nextStart; i++) {
                Node currentNode = nodeList.get(i);
                if (currentNode.getLeft() != null) {
                    nodeList.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    nodeList.add(currentNode.getRight());
                }
            }
            start = nextStart;
        }
        return nodeList;
    }
}
