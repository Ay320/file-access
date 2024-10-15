// Name: Al Aiham Ahmed Saleh
// Student ID: 201765086
//
// Time Complexity and explanation: 
// f denotes initial cabinet size
// n denotes the total number of requests 
// d denotes number of distinct requests
// You can use any of the above notations or define additional notation as you wish.
// 
// appendIfMiss():
// the method iterates through the requests Array, O(n).
// then for each item in the array, it performs a linear search on the linked list (while loop), O(f).
// if the item is not found, append it to the tail, O(1) since constant operations.
// printing from head to tail or from tail to head is O(f) bcz it requires going through the list.
// So the function will look like this: n*f + 1 + f + f
// The overall time complexity is O(n*f).
// 	
// freqCount():
  // n*(f+f) + f+f+f
  //  the method iterates through the requests Array, O(n).
  //  For each element in the Array, it performs a linear search on the linked list (while loop). O(f)
  // Aditionally, for each element in the array, it performs a swaping operation if the element is not found, this has O(d).
  // the rest are similar to appendIfMiss().
  // So, The overall time complexity is: O(n*(f+d)).

class COMP108Cab {

	public COMP108Node head, tail;
	
	public COMP108Cab() {
		head = null;
		tail = null;
	}

	// append to end of list when miss
	public COMP108CabOutput appendIfMiss(int rArray[], int rSize) {
		COMP108CabOutput output = new COMP108CabOutput(rSize);

		for(int i =0; i< rSize; i++){
			boolean found = false;
		    COMP108Node curr = head;
             // Iterate through the list to find the requested item
			while (curr != null && found == false){
				if(curr.data == rArray[i]){
					output.hitCount++;
					found = true;
				}
				else{
				curr=curr.next;
				}
				output.compare[i]++;         // Increment comparison count
			}
			// If item not found, insert it at the end
			if(found == false){
				output.missCount++;
				insertTail(new COMP108Node(rArray[i]));
			}
		}

		output.cabFromHead = headToTail();
		output.cabFromTail = tailToHead();
		return output;
	}

	// move the file requested so that order is by non-increasing frequency
	public COMP108CabOutput freqCount(int rArray[], int rSize) {
		COMP108CabOutput output = new COMP108CabOutput(rSize);

		for(int i =0; i< rSize; i++){
			boolean found = false;
		    COMP108Node curr = head;
            // Iterate through the list to find the requested item
			while (curr != null && found == false){
				if(curr.data == rArray[i]){
					output.hitCount++;
					curr.freq++;
					found = true;
				}
				else{
				curr=curr.next;
				}
				output.compare[i]++;    
			}

			boolean exit = false;
			while(exit == false && curr != head && found != false){
			if(curr.freq > curr.prev.freq){
				// swap values

				int dataSave = curr.data;
				int freqSave = curr.freq;
				curr.data = curr.prev.data;
				curr.freq = curr.prev.freq;

				curr.prev.data = dataSave;
				curr.prev.freq = freqSave;

				curr = curr.prev;
			}
			else{
				exit = true;
			}
		}

		     // If item not found, insert it at the end
			if(found == false){
				output.missCount++;
				insertTail(new COMP108Node(rArray[i]));
			}
		}


		
		output.cabFromHead = headToTail();
		output.cabFromTail = tailToHead();
		output.cabFromHeadFreq = headToTailFreq();
		return output;		
	}

	
	// insert newNode to head of list
	public void insertHead(COMP108Node newNode) {		

		newNode.next = head;
		newNode.prev = null;
		if (head == null)
			tail = newNode;
		else
			head.prev = newNode;
		head = newNode;
	}

	
	// insert newNode to tail of list
	public void insertTail(COMP108Node newNode) {

		newNode.next = null;
		newNode.prev = tail;
		if (tail != null)
			tail.next = newNode;
		else head = newNode;
		tail = newNode;
	}

	
	// delete the node at the head of the linked list
	public COMP108Node deleteHead() {
		COMP108Node curr;

		curr = head;
		if (curr != null) {
			head = head.next;
			if (head == null)
				tail = null;
			else
				head.prev = null;
		}
		return curr;
	}
	
	
	// empty the cabinet by repeatedly removing head from the list
	public void emptyCab() {
		while (head != null)
			deleteHead();
	}


	
	// this will turn the list into a String from head to tail
	// Only to be used for output, do not use it to manipulate the list
	public String headToTail() {
		COMP108Node curr;
		String outString="";
		
		curr = head;
		while (curr != null) {
			outString += curr.data;
			outString += ",";
			curr = curr.next;
		}
		return outString;
	}

	// this will turn the list into a String from tail to head
	// Only to be used for output, do not use it to manipulate the list
	public String tailToHead() {
		COMP108Node curr;
		String outString="";
		
		curr = tail;
		while (curr != null) {
			outString += curr.data;
			outString += ",";
			curr = curr.prev;
		}
		return outString;
	}

	
	// this will turn the frequency of the list nodes into a String from head to tail
	// Only to be used for output
	public String headToTailFreq() {
		COMP108Node curr;
		String outString="";
		
		curr = head;
		while (curr != null) {
			outString += curr.freq;
			outString += ",";
			curr = curr.next;
		}
		return outString;
	}

}
