/** 
 * LinkedQueue.java is here to serve as our class that brings everything together 
 * and allows our implementation class, Project7.java, to actually compile properly. 
 * 
 * Linking other classes to interfaces has proven difficult throughout this course, 
 * but creating these separate classes to break down the needs of each has helped. 
 * This is most importantly used to create iterator classes for preorder, postorder,
 *  and level-order traversals of our binary tree, that we then implement in our main
 *  Project7 class.
 */

import java.util.ArrayList;

public class LinkedQueue<BinaryNodeInterface> implements
        Queuelnterface<BinaryNodeInterface> {
	//creating our initial object of an array list to be used. 
	//our highest-level node is from where our remaining tree branches will form
	
    ArrayList arrNode = new ArrayList();
    //implements all instances of BinaryNodeInterface and its methods, and checks initially
    //to see if the tree is empty or not. 
    @Override
    public boolean isEmpty() {
        return arrNode.isEmpty();
    }

    @Override
    public void enqueue(BinaryNodeInterface node) {
        arrNode.add(node);
    }

    @Override
    public BinaryNodeInterface dequeue() {
        BinaryNodeInterface node = (BinaryNodeInterface) arrNode.remove(0);
        return node;
    }

}

final class LinkedStack<BinaryNodelnterfaoe> implements
        Stacklnterface<BinaryNodeInterface> {
//States our initial ArrayList that is created. From here all our branches will be
	//created, as well as our iterations for lower nodes. 

    ArrayList arrNode = new ArrayList();
    @Override
    public boolean isEmpty() {
        if (arrNode.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public void push(BinaryNodeInterface node) {
        arrNode.add(node);
    }

    @Override
    public BinaryNodeInterface pop() {
        BinaryNodeInterface node = (BinaryNodeInterface) arrNode
                .remove(arrNode.size() - 1);
        return node;
    }

    @Override
    public BinaryNodeInterface top() {
        BinaryNodeInterface node = (BinaryNodeInterface) arrNode
                .get(arrNode.size() - 1);
        return node;
    }
}
//set BinaryNode class as final as it is not to be extended further, and allows us
//to construct our binary nodes for each new leaf under the tree. 
final class BinaryNode<T> implements BinaryNodeInterface<T> {
//outlines the two binary (left vs. right) sides of a new node to be added while 
//values will be compared.
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode() {
        this(null);
    }

    public BinaryNode(T dataPortion) {
        this(dataPortion, null, null);
    }
//denotes which child of the tree is to be set based on it's data point above
    public BinaryNode(T dataPortion, BinaryNode<T> leftChild,
            BinaryNode<T> rightChild) {
        data = dataPortion;
        left = leftChild;
        right = rightChild;
    }
//BinaryNodeInterface methods to set, get, or have specific children within our 
//tree. 
    @Override
    public void setData(T newData) {
        data = newData;
    }

    @Override
    public BinaryNodeInterface<T> getLeftChild() {
        return left;
    }

    @Override
    public void setLeftChild(BinaryNodeInterface<T> leftChild) {
        left = (BinaryNode<T>) leftChild;
    }

    @Override
    public boolean hasLeftChild() {
        return left != null;
    }

    @Override
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    public BinaryNodeInterface<T> getRightChiId() {
        return right;
    }

    @Override
    public void setRightChild(BinaryNodeInterface<T> rightChild) {
        right = (BinaryNode<T>) rightChild;
    }

    @Override
    public boolean hasRightChild() {
        return right != null;
    }

    @Override
    public BinaryNodeInterface<T> copy() {
        return left;
    }

    @Override
    public int getNumberOfNodes() {
        int a = getNumberOfNodes(this);
        return a;
    }

    private int getNumberOfNodes(BinaryNode<T> node) {
        int number = 0;
        if (node != null) {
            number = 1 + getNumberOfNodes(node.left)
                    + getNumberOfNodes(node.right);
            return number;
        }
        return number;
    }

    @Override
    public int getHeight() {
        int leftheight = 0;
        int rightheight = 0;
        if (left != null) {
            leftheight = left.getHeight();
        }
        if (right != null) {
            rightheight = right.getHeight();
        }
        return 1 + Math.max(leftheight + rightheight, rightheight);
    }

//PREORDER
//This is where we create our method for preorder Traversal. 
   final public String preorderTraversal() {
        Stacklnterface<BinaryNodeInterface> nodeStack = new LinkedStack<>();
        BinaryNodeInterface<T> currentNode = this;
        String result = "";
        if (currentNode != null) {
            nodeStack.push(currentNode);
        }
        while (!nodeStack.isEmpty()) {
            BinaryNodeInterface<T> nextNode = nodeStack.pop();
            assert nextNode != null;
            result = result.concat(" ");
            result = result.concat(String.valueOf(nextNode.getData()));
            if (nextNode.hasRightChild()) {
                currentNode = nextNode.getRightChild();
                nodeStack.push(currentNode);
            }
            if (nextNode.hasLeftChild()) {
                currentNode = nextNode.getLeftChild();
                nodeStack.push(currentNode);
            }
        }
        return result;
    }

//POSTORDER   
//our method constructor for post order of our traversal. 
  final  public String postorderTraversal() {
        Stacklnterface<BinaryNodeInterface> nodeStack = new LinkedStack<>();
        BinaryNodeInterface<T> currentNode = this;
        BinaryNodeInterface<T> prevNode = null;
        String result = "";
        if (currentNode != null) {
            nodeStack.push(currentNode);
        }
        while (!nodeStack.isEmpty()) {
            if ((prevNode == null)
                    || (prevNode.getLeftChild() == currentNode)
                    || (prevNode.getRightChild() == currentNode)) {
                if (currentNode.hasLeftChild()) {
                    currentNode = currentNode.getLeftChild();
                    nodeStack.push(currentNode);
                } else if (currentNode.hasRightChild()) {
                    currentNode = currentNode.getRightChild();
                    nodeStack.push(currentNode);
                } else {
                    nodeStack.pop();
                    result = result.concat(" ");
                    result = result.concat(String.valueOf(currentNode
                            .getData()));
                    prevNode = currentNode;
                    currentNode = nodeStack.top();
                }
            } else if (currentNode.getLeftChild() == prevNode) {
                if (currentNode.hasRightChild()) {
                    currentNode = currentNode.getRightChild();
                    nodeStack.push(currentNode);
                }
                nodeStack.pop();
                result = result.concat(" ");
                result = result
                        .concat(String.valueOf(currentNode.getData()));
                prevNode = currentNode;
                currentNode = nodeStack.top();
            }
        }
        if (currentNode.getRightChild() == prevNode) {
            nodeStack.pop();
            result = result.concat(" ");
            result = result.concat(String.valueOf(currentNode.getData()));
            prevNode = currentNode;
            if (!nodeStack.isEmpty()) {
                currentNode = nodeStack.top();
            }
        }
        return result;
    }
//LEVEL ORDER  
//our method constructor for level order of our traversal. 
 final public String levelorderTraversal() {
        Queuelnterface<BinaryNodeInterface<T>> nodeQueue = new LinkedQueue<>();
        BinaryNodeInterface<T> currentNode = this;
        String result = "";
        java.util.ArrayList arr = new ArrayList();
        if (currentNode != null) {
            nodeQueue.enqueue((BinaryNodeInterface) currentNode);
            nodeQueue.dequeue();
            arr.add(currentNode);
            result = result.concat(" ");
            result = result.concat(String.valueOf(currentNode.getData()));
        }
        if ((nodeQueue.isEmpty() == true) && (!arr.isEmpty())) {
            while (!arr.isEmpty()) {
                for (int i = 0; i < arr.size(); i++) {
                    currentNode = (BinaryNodeInterface<T>) arr.get(i);
                    if (currentNode.hasLeftChild()) {
                        nodeQueue.enqueue((BinaryNodeInterface) currentNode.getLeftChild());
                    }
                    if (currentNode.hasRightChild()) {
                        nodeQueue.enqueue((BinaryNodeInterface) currentNode.getRightChild());
                    }
                }
                arr.clear();
                while (!nodeQueue.isEmpty()) {
                    currentNode = nodeQueue.dequeue();
                    arr.add(currentNode);
                    result = result.concat(" ");
                    result = result.concat(String.valueOf(currentNode
                            .getData()));
                }
            }
        }
        return result;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public BinaryNodeInterface<T> getRightChild() {
        return right;
    }
    
 
}