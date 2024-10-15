// Testing
import java.util.*;
import java.io.*;


class COMP108CabApp {

	private static final int MaxInitSize = 10; // maximum cabinet size to start with
	private static final int MaxReqSize = 100; // maximum number of requests
	private static final int AllAlg = 0;
	private static final int AppendIfMiss = 1;
	private static final int FreqCount = 2;
	private static final int AllOutput = 0;
	private static final int AllOutputFreq = 1;
	private static final int HitMissCount = 2;
	private static final int HitMissPattern = 3;
	private static final int CacheContent = 4;
	private static final int Comparison = 5;
	private static final int HeadTail = 6;
	private static final int TailHead = 7;
	private static final int FreqHeadTail = 8;

	private static Scanner keyboardInput = new Scanner (System.in);

	public static void main(String[] args) throws Exception {
		COMP108Cab cab = new COMP108Cab();
		COMP108CabOutput output = new COMP108CabOutput(MaxReqSize);
		int[] request = new int[MaxReqSize];
		int[] initCab = new int[MaxInitSize];
		int reqSize = 0;
		int initSize = 0;
		int algorithmChoice = AllAlg;
		int outputChoice = AllOutput;

		// get option of algorithms to run and output to display
		try {
			algorithmChoice = AllAlg;
			outputChoice = AllOutput;
			if (args.length > 0) {
				algorithmChoice = Integer.parseInt(args[0]);
				if (args.length > 1) {
					outputChoice = Integer.parseInt(args[1]);
				}
			}
			
		}
		catch (Exception e) {
			System.err.println("Command-line argument: algorithm choice; output choice"); 
			System.exit(0);
		}
		
		try {

			if (algorithmChoice == AllAlg) {
				System.out.println();
				System.out.print("Enter the initial number of files in the cabinet (1-" + MaxInitSize + "): ");
			}
			initSize = keyboardInput.nextInt();
			if (initSize > MaxInitSize || initSize <= 0)
				System.exit(0);
			if (algorithmChoice == AllAlg)
				System.out.print("Enter the initial file IDs in the cabinet (" + initSize + " different +ve integers): ");
			for (int i=0; i<initSize; i++)
				initCab[i] = keyboardInput.nextInt();				
			if (algorithmChoice == AllAlg) {
				System.out.println();
				System.out.print("Enter the number of file requests (1=" + MaxReqSize + "): ");
			}
			reqSize = keyboardInput.nextInt();
			if (reqSize > MaxReqSize || reqSize <= 0)
				System.exit(0);
			if (algorithmChoice == AllAlg)
				System.out.print("Enter the request file IDs (" + reqSize + " +ve integers): ");
			for (int i=0; i<reqSize; i++)
				request[i] = keyboardInput.nextInt();				
		}
		catch (Exception e) {
			keyboardInput.next();
			System.exit(0);
		}

		if (algorithmChoice == AllAlg) {
			System.out.println();
			System.out.println("Initial cabinet:");
			printArray(initCab, initSize);
			System.out.println("Request sequence:");
			printArray(request, reqSize);
		}

		if (algorithmChoice == AllAlg || algorithmChoice == AppendIfMiss) {
			try {
				System.out.println();
				System.out.print("appendIfMiss");
				// create a list with the input data
				// call appendIfMiss()
				cab.emptyCab();
				for (int i=initSize-1; i>=0; i--) {
					cab.insertHead(new COMP108Node(initCab[i]));
				}
				output = cab.appendIfMiss(request, reqSize);
				output.printCab(outputChoice);
			}
			catch (Exception e) {
				errTraceMsg(e, "appendIfMiss");
			}
		}		

		if (algorithmChoice == AllAlg || algorithmChoice == FreqCount) {
			if (outputChoice == AllOutput)
				outputChoice = AllOutputFreq;
			try {
				System.out.println();
				System.out.print("freqCount");
				// create a list with the input data
				// call freqCount()
				cab.emptyCab();
				for (int i=initSize-1; i>=0; i--) {
					cab.insertHead(new COMP108Node(initCab[i]));
				}
				output = cab.freqCount(request, reqSize);
				output.printCab(outputChoice);
			}
			catch (Exception e) {
				errTraceMsg(e, "freqCount");
			}
		}
	
	}


	
	// print array[0]..array[size-1]
	static void printArray(int[] array, int size) {
		for (int i=0; i<size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	static void errTraceMsg(Exception e, String errString) {
			System.err.println("Exception: " + errString);
			e.printStackTrace();
	}

}
