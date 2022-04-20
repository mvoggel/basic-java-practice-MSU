interface BinaryNodeInterface<T> {
    /**
     * Our tree interface that we're using to designate tree leaves and eventually used
     * to compare between children of that tree, as well as implementing a number 
     * of methods to eventually call our pre- and postorder traversals within our 
     * Project7.java class. 
     */

    public T getData();

    public void setData(T newData);

    public BinaryNodeInterface<T> getLeftChild();

    public BinaryNodeInterface<T> getRightChild();

    public void setLeftChild(BinaryNodeInterface<T> leftChild);

    public void setRightChild(BinaryNodeInterface<T> rightChild);

    public boolean hasLeftChild();

    public boolean hasRightChild();

    public boolean isLeaf();

    public int getNumberOfNodes();

    public int getHeight();

    public BinaryNodeInterface<T> copy();
}