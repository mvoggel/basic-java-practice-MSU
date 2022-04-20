/** 
 * 
 * @author Matthew Voggel
 * Page 693, Project 1 (java program): Using the examples in Figures 24-6 and 
 * 24-7 to suggest algorithms, implement iterator classes for preorder, postorder,
 *  and level-order traversals of a binary tree. Begin by writing iterative 
 *  versions of the traversals similar to the method interativeInorderTraverse 
 *  given in segment 24.13.
 *  
 *  This class is simply the implementation of the binary tree we're creating, 
 *  by inserting a number of letters in the alphabet to then sort order them 
 *  in a string based upon when they're added to our stack. We include setRightChild
 *  and setLeftChild as a way to build our tree, and then ultimately order them 
 *  based on either preorder traversal or postorder traversal.
 *
 */

public class Project7 {

        public static void main(String[] args) {
            BinaryNode nd2 = new BinaryNode("p");
            BinaryNode nd3 = new BinaryNode('d');
            BinaryNode nd4 = new BinaryNode('r');
            BinaryNode nd5 = new BinaryNode('y');
            BinaryNode nd6 = new BinaryNode('o');
            BinaryNode nd7 = new BinaryNode('b');
            BinaryNode nd8 = new BinaryNode('e');
            BinaryNode nd9 = new BinaryNode('x');
            nd3.setRightChild(nd2);
            nd6.setLeftChild(nd3);
            nd7.setLeftChild(nd5);
            nd7.setRightChild(nd4);
            nd8.setLeftChild(nd7);
            nd8.setRightChild(nd6);
            nd6.setRightChild(nd9);
            System.out.println("Number of elements in our tree to be ordered: "
                    + nd8.getNumberOfNodes());
            System.out.println("Binary tree string via Preorder traversal: "
                    + nd8.preorderTraversal());
            System.out.println("Binary tree string via Postorder traversal: "
                    + nd8.levelorderTraversal());
        }
    }