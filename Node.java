public class Node {
	public int data; 
	public Node next;
	public Node prev;
	public int freq; // only to be used in freqCount algorithm
    
	// constructor to create a new node with data equals to parameter i
	public Node (int i) {
		next = null;
		prev = null;
		data = i;
		freq = 1;
	}
}
