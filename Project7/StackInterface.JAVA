/** 
 * This interface is used as our constructors for pushing and popping our unordered 
 * letters stack. It references our BinaryNodeInterface interface,  as a means to 
 * push, pop, or put an element at the top of our stack based off of the traversal.
 */

interface Stacklnterface<BinaryNodelnterfaoe> {

    public boolean isEmpty();

    public void push(BinaryNodeInterface node);

    public BinaryNodeInterface pop();

    public BinaryNodeInterface top();
}