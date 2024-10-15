# Filing Cabinet Access Simulation

This project simulates two file access and reorganization algorithms used to manage a filing cabinet with unsorted files. The cabinet is represented as a **linked list**, and each file has a unique ID. The project tracks the **number of comparisons** (or cost) incurred during a sequence of file access requests, and also demonstrates how reorganization of the cabinet affects performance.

## Problem Overview

We have a filing cabinet containing some files, each with a unique ID. When a file is requested:
- If the file is in the cabinet, it's called a **hit**, and the file is located by scanning through the files one by one. 
- If the file is **not in the cabinet**, we pay a cost equal to the number of files in the cabinet, and then go to a storage to fetch the file.

Once a file has been accessed, it is inserted in a new location based on a reorganization strategy.
The results of the methods will be stored in an object of the class COMP108CabOutput that has the following attributes:
- hitCount : storing the number of hits
- missCount : storing the number of misses
- compare[] : storing the number of comparisons for each requests
- cabFromHead : storing the data attribute of the final list (from head to tail) 
- cabFromTail : storing the data attribute of the final list (from tail to head)

### Algorithms Implemented

The project implements two algorithms for managing file access and reorganization:

### 1. **Append if Miss**
- In this algorithm, when a file is requested and is **not found** in the cabinet (a miss), the file is **appended** to the end of the cabinet after fetching it from storage.
- If the file is already in the cabinet (a hit), the cabinet remains unchanged.
- **Cost Calculation**: The cost for each request is the **number of comparisons** needed to find the file in the cabinet. If the file is not found, the cost is the size of the cabinet.
  
#### Example:
- Initial files in cabinet: `20 30 10`
- Request sequence: `20 30 5 30 5 20`
- Final cabinet: `20 30 10 5`
- Costs: `1 2 3 2 4 1`

### 2. **Frequency Count**
- In this algorithm, the cabinet is **reorganized based on the frequency of access** of each file. Each file has an associated access counter, which is incremented each time the file is requested.
- After each request, the file is moved to its correct position in the cabinet based on its frequency of access. Files with the same frequency are kept in their original relative order.
- Newly inserted files start with a frequency count of 1.
- **Cost Calculation**: Similar to the "Append if Miss" algorithm, the cost is the number of comparisons needed to find the file.

#### Example:
- Initial files in cabinet: `20 30 10` (each with frequency 1)
- Request sequence: `20 30 5 30 5 20`
- Final cabinet: `30 20 5 10`
- Costs: `1 2 3 2 4 2`

## File Descriptions

### 1. `COMP108Cab.java`
- **Description**: Implements the filing cabinet using a linked list. Contains methods to handle file requests and to update the cabinet using both the **Append if Miss** and **Frequency Count** algorithms. Also contains time complexity analysis for each algorithm.
- **Key Methods**:
  - `appendIfMiss()`: Handles file requests using the append-if-miss strategy.
  - `frequencyCount()`: Handles file requests using the frequency count strategy.
  - Other methods to handle the linked list (cabinet)

### 2. `COMP108CabApp.java`
- **Description**: The main application that initializes the filing cabinet, processes the sequence of file requests, and prints the results (final cabinet state and total cost for each algorithm).

### 3. `FilingCabinetOutput.java`
- **Description**: Provides methods to output the cabinet's state and the cost of each request.

## 4. `COMP108Node.java`
- **Description**: This class defines a node in the doubly linked list representing the file cabinet. Each node stores frequency counter (freq) used for reordering files based on the Frequency Count algorithm.

## Run
Run the COMP108CabOutput.java program and provide the following inputs:

- The size of the initial file cabinet (between 1 and 10 inclusively)
- Initial content of the file cabinet (all positive integers)
- The number of requests in the request sequence (between 1 and 100 inclusively)
- The request sequence (all positive integers)
