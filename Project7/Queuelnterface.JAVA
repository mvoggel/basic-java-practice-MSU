/** 
 * This interface also connects to BinaryNodeInterface, but is setup for each node
 * of our eventual tree. These two operations effect the way we're adding or removing
 * items from our queue. Enqueue is our queue operation that adds an item
 * at the back of a queue, while dequeue is a queue operation where you remove an
 * item from the front of a queue.
 */

interface Queuelnterface<BinaryNodeInterface> {

    public boolean isEmpty();

    public void enqueue(BinaryNodeInterface node);

    public BinaryNodeInterface dequeue();
}