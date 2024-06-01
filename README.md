# BFS_DFS_Heaps_Maze

# Technical Description: 

## In my main method: 

I have defined a 2D array to represent the maze. I am then calling the BFS, DFS, and Heaps methods, passing the maze, start, and end as parameters to each method.




## In the BFS method: the Breadth First Search algorithm to solve a maze. This Uses a queue to explore the maze level by level & Finds the shortest path in an unweighted maze.

* I start by initializing a queue, a boolean array visited to keep track of visited nodes, and an integer array parent to keep track of the parent of each node. I add the start node to the queue, mark it as visited, and set its parent as -1 since it has no parent.
* Then, I enter a loop that continues until the queue is empty. In each iteration, I dequeue a node and check if it's the end node. If it is, I break the loop. If it's not, I iterate over all the nodes in the maze. If a node is connected to the current node (indicated by maze[current][i] == 1) and it hasn't been visited yet, I add it to the queue, mark it as visited, and set its parent as the current node.
* After the loop, I initialize a stack to store the path from the start to the end node. I start from the end node and keep pushing the current node to the stack and moving to its parent until I reach the start node (which has a parent of -1).
* Finally, I print out the path by popping nodes from the stack until it's empty. This gives me the path from the start to the end node




## Depth First Search (DFS) Method: This algorithm is also used to solve the maze. This Uses recursion to explore all possible paths & Determines if there is a path from the start to the end.This Uses a priority queue (min-heap) to explore paths in a weighted maze.& Finds the shortest path considering weights.

* I start by initializing a stack, a boolean array visited to keep track of visited nodes, and an integer array parent to keep track of the parent of each node. I push the start node onto the stack, mark it as visited, and set its parent as -1 since it has no parent.
* Then, I enter a loop that continues until the stack is empty. In each iteration, I pop a node from the stack and check if it's the end node. If it is, I break the loop. If it's not, I iterate over all the nodes in the maze. If a node is connected to the current node (indicated by maze[current][i] == 1) and it hasn't been visited yet, I push it onto the stack, mark it as visited, and set its parent as the current node.
* After the loop, I initialize a stack to store the path from the start to the end node. I start from the end node and keep pushing the current node onto the stack and moving to its parent until I reach the start node (which has a parent of -1).
* Finally, I print out the path by popping nodes from the stack until it's empty. This gives me the path from the start to the end node.




## Heaps Method: I implemented the Dijkstra's algorithm using a binary heap to solve a maze.

* First, I initialize two arrays: distance and parent. The distance array keeps track of the shortest distance from the start node to each node, and the parent array keeps track of the parent of each node. I set the distance to each node as Integer.MAX_VALUE to represent infinity, since I haven't found any paths yet.
* Then, I set the distance to the start node as 0 and its parent as -1, since it has no parent. I also create a Heap object, which is a binary heap that I'll use as a priority queue. I insert the start node into the heap with a priority of 0.
* Next, I enter a loop that continues until the heap is empty. In each iteration, I delete the node with the smallest distance from the heap and check if it's the end node. If it is, I break the loop. If it's not, I iterate over all the nodes in the maze. If a node is connected to the current node (indicated by maze[current][i] != 0), I calculate the new distance to that node through the current node. If this new distance is less than the current shortest distance to that node, I update the shortest distance and the parent of that node, and insert that node into the heap with the new distance as its priority.
* After the loop, I initialize a stack to store the path from the start to the end node. I start from the end node and keep pushing the current node onto the stack and moving to its parent until I reach the start node (which has a parent of -1).
* Finally, I print out the path by popping nodes from the stack until it's empty. This gives me the shortest path from the start to the end node.




## Heaps Class: I'm defining a Heap class which is a binary heap data structure. This heap is used as a priority queue in the Dijkstra's algorithm.

* I start by defining three fields: maxSize to store the maximum size of the heap, size to store the current size of the heap, and heap which is an array of Node objects that represents the heap.
* In the Heap constructor, I initialize maxSize with the value passed as a parameter, set size to 0, and create the heap array with a size of maxSize.
* The isEmpty method checks if the heap is empty by checking if size is 0.
* The insert method inserts a new node into the heap. It creates a new Node object with the given vertex and distance, adds it to the end of the heap, and then sifts it up to its proper position to maintain the heap property.
* The delete method removes and returns the node with the smallest distance from the heap. It replaces the root of the heap with the last node in the heap, decreases the size of the heap by 1, and then sifts down the new root to its proper position to maintain the heap property.
* The Node class is a static inner class of the Heap class. Each Node object represents a node in the heap, containing a vertex (which represents a node in the maze) and a distance (which represents the shortest known distance from the start node to this node).


# Resources: 

Codeademy.com Graph Data Structures, BroCode Youtube video "Learn Breadth First Search in 6 minutes", [C++] ASCII art - Maze Blaze game youtube video,  Grokking Chapter 6  Breadth-First Search, Chapter 7 Dijkstra’s Algorithm, Skiena pg 145, 162-184 , Skiena Chapter 7 Heuristic Methods.


