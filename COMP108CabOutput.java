// A class to store output
//
class COMP108CabOutput {
	private static final int AllOutput = 0;
	private static final int AllOutputFreq = 1;
	private static final int HitMissCount = 2;
	private static final int HitMissPattern = 3;
	private static final int CacheContent = 4;
	private static final int Comparison = 5;
	private static final int HeadTail = 6;
	private static final int TailHead = 7;
	private static final int FreqHeadTail = 8;

	public int hitCount;
	public int missCount;
	public int[] compare;
	public String cabFromHead;
	public String cabFromTail;
	public String cabFromHeadFreq;
	
	// Constructor
	// parameter size is used to define the size of the array to store number of comparisons
	public COMP108CabOutput(int size) {
		hitCount = 0;
		missCount = 0;
		cabFromHead = "";
		cabFromTail = "";
		cabFromHeadFreq = "";
		compare = new int[size];
		for (int i=0; i<size; i++)
			compare[i] = 0;
		
	}

	// an auxiliary method to print its attributes in a readable form
	public void printCab(int item) {
		System.out.println();
		if (item == AllOutput || item == AllOutputFreq || item == Comparison) {
			System.out.print("Comparisons: ");
			for (int i=0; i<compare.length; i++)
				System.out.print(compare[i] + ",");
			System.out.println();
		}
		if (item == AllOutput || item == AllOutputFreq || item == HitMissCount) 
			System.out.println(hitCount + " h " + missCount + " m");
		if (item == AllOutput || item == AllOutputFreq || item == HeadTail) 
			System.out.println("From head to tail: " + cabFromHead);
		if (item == AllOutput || item == AllOutputFreq || item == TailHead) 
			System.out.println("From tail to head: " + cabFromTail);
		if (item == AllOutputFreq || item == FreqHeadTail) 
			System.out.println("Frequency from head to tail: " + cabFromHeadFreq);
	}	
}
