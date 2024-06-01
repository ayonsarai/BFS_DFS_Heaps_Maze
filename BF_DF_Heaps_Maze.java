/* Sarai Ayon
 * 6/1/2024
 * CS 240 Data base structures and algorithms 
 * Data Structures HW 4 : Breadth First Search and Depth First Search Trees and Heaps (OPTIONAL) - Extra Credit
 * In this assignment, you will implement a Breadth First Search (BFS),Depth First Search (DFS) and Heaps algorithms to solve a maze.*/

/* Breadth First Search (BFS) is an algorithm for traversing or searching tree or graph data structures. 
Queue data structure is used to implement BFS for finding the shortest path in an unweighted maze.

Depth First Search (DFS) is an algorithm for traversing or searching tree or graph data structures. 
Stack data structure is used to implement DFSfor exploring all possible paths in the maze.

Heaps are a type of binary tree that satisfy the heap property. Heaps are used to implement Heap (Priority Queue) for finding the shortest 
path in a weighted maze (Dijkstra’s algorithm).  */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BF_DF_Heaps_Maze {
        //main method
        public static void main(String[] args) { 
            int[][] maze = { //maze
                {0, 1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 0}
            }; //end maze
            BFS(maze, 0, 8); //BFS
            DFS(maze, 0, 8); //DFS 
            Heaps(maze, 0, 8); //Heaps 
        } //end main

    //Breadth First Search (BFS) algorithm
    public static void BFS(int[][] maze, int start, int end) { //start = 0, end = 8
         Queue<Integer> queue = new LinkedList<Integer>(); //queue = 0
        boolean[] visited = new boolean[maze.length]; //visited = 0
        int[] parent = new int[maze.length]; //parent = 0
        queue.add(start); //queue = 0
        visited[start] = true; //visited = 0
        parent[start] = -1; //parent = -1
        while (!queue.isEmpty()) { //queue = 0
            int current = queue.poll(); //current = 0
            if (current == end) { //current = 0, end = 8
                break; //break
            } //end if
            for (int i = 0; i < maze.length; i++) { //i = 0
                if (maze[current][i] == 1 && !visited[i]) { //maze = 0, visited = 0
                    queue.add(i); //queue = 0
                    visited[i] = true; //visited = 0
                    parent[i] = current; //parent = 0
                } //end if
            } //end for
        }//end while

        //path
        int current = end; //current = 8
        Stack<Integer> path = new Stack<Integer>(); //path = 8
        while (current != -1) { //current = 8
            path.push(current); //path = 8
            current = parent[current]; //current = 8
        }//end while
        System.out.print("BFS Path: ");// BFS Path
        while (!path.isEmpty()) { //path = 8
            System.out.print(path.pop() + " "); //path = 8
        } //end while
        System.out.println();
    }//end BFS

    
    //Depth First Search (DFS) algorithm
    public static void DFS(int[][] maze, int start, int end) { //start = 0, end = 8
        Stack<Integer> stack = new Stack<Integer>(); //stack = 0
        boolean[] visited = new boolean[maze.length]; //visited = 0
        int[] parent = new int[maze.length]; //parent = 0
        stack.push(start); //stack = 0
        visited[start] = true; //visited = 0
        parent[start] = -1; //parent = -1
        while (!stack.isEmpty()) { //stack = 0
            int current = stack.pop(); //current = 0
            if (current == end) { //current = 0, end = 8
                break; //break
            } //end if
            for (int i = 0; i < maze.length; i++) { //i = 0
                if (maze[current][i] == 1 && !visited[i]) { //maze = 0, visited = 0
                    stack.push(i); //stack = 0
                    visited[i] = true; //visited = 0
                    parent[i] = current; //parent = 0
                } //end if
            } //end for
        } //end while
        //path

        int current = end;//current = 8
        Stack<Integer> path = new Stack<Integer>();//path = 8
        while (current != -1) { //current = 8
            path.push(current);//path = 8
            current = parent[current];//current = 8
        }//end while
        System.out.print("DFS Path: ");//DFS Path
        while (!path.isEmpty()) { //path = 8
            System.out.print(path.pop() + " ");//path = 8
        }// end while
        System.out.println();
    } //end DFS


    //Heaps algorithm
    public static void Heaps(int[][] maze, int start, int end) { //start = 0, end = 8
        int[] distance = new int[maze.length]; //distance = 0
        int[] parent = new int[maze.length];//parent = 0
        for (int i = 0; i < maze.length; i++) { //i = 0 
            distance[i] = Integer.MAX_VALUE; //distance = 0
        } //end for
        distance[start] = 0; // distance = 0
        parent[start] = -1; //parent = -1
        Heap heap = new Heap(maze.length); //heap = 0
        heap.insert(start, 0); //heap = 0
        while (!heap.isEmpty()) { //heap = 0
            Heap.Node node = heap.delete(); //node = 0
            int current = node.vertex; //current = 0
            if (current == end) { //current = 0, end = 8
                break;
            } //end if
            for (int i = 0; i < maze.length; i++) { //i = 0
                if (maze[current][i] != 0) { //maze = 0
                    int newDistance = distance[current] + maze[current][i]; //newDistance = 0
                    if (newDistance < distance[i]) { //newDistance = 0, distance = 0
                        distance[i] = newDistance; //distance = 0
                        parent[i] = current; //parent = 0
                        heap.insert(i, newDistance); //heap = 0
                    } //end if
                } //end if
            } //end for
        } //end while
        int current = end; //current = 8
        Stack<Integer> path = new Stack<Integer>(); //path = 8
        while (current != -1) { //current = 8
            path.push(current); //path = 8
            current = parent[current]; //current = 8
        } //end while
        System.out.print("Heaps Path: "); //Heaps Path
        while (!path.isEmpty()) { //path = 8
            System.out.print(path.pop() + " "); //path = 8
        } //end while
        System.out.println(); 
    } //end Heaps
} //end class


//Heap class
class Heap { 
    int maxSize; //maxSize = 0
    int size; //size = 0
    Node[] heap; //heap = 0

    //Heap constructor
    public Heap(int maxSize) { //maxSize = 0
        this.maxSize = maxSize; //maxSize = 0
        this.size = 0; //size = 0
        heap = new Node[maxSize]; //heap = 0
    } //end Heap constructor

    public boolean isEmpty() { //isEmpty
        return size == 0; //size = 0
    } //end isEmpty

    public void insert(int vertex, int distance) { //vertex = 0, distance = 0
        Node node = new Node(vertex, distance); //node = 0
        heap[size] = node; //heap = 0
        int current = size; //current = 0
        int parent = (current - 1) / 2; //parent = 0
        while (heap[current].distance < heap[parent].distance) { //heap = 0
            Node temp = heap[current]; //temp = 0
            heap[current] = heap[parent]; //heap = 0
            heap[parent] = temp; //heap = 0
            current = parent; //current = 0
            parent = (current - 1) / 2; //parent = 0
        } //end while
        size++; 
    } //end insert


    public Node delete() { //delete
        Node node = heap[0]; //node = 0
        heap[0] = heap[size - 1]; //heap = 0
        size--; //size = 0
        int current = 0; //current = 0
        while (true) { 
            int left = 2 * current + 1; //left = 0
            int right = 2 * current + 2; //right = 0
            if (left >= size) { //left = 0
                break;
            } //end if
            int min = left; //min = 0
            if (right < size && heap[right].distance < heap[left].distance) { //right = 0, heap = 0
                min = right; //min = 0
            } //end if
            if (heap[current].distance < heap[min].distance) { //heap = 0
                break; 
            } //end if
            Node temp = heap[current]; //temp = 0
            heap[current] = heap[min]; //heap = 0
            heap[min] = temp; //heap = 0
            current = min; //current = 0
        } //end while
        return node;
    } //end delete

    static class Node { //Node class
        int vertex; 
        int distance;

        public Node(int vertex, int distance) { //vertex = 0, distance = 0
            this.vertex = vertex; //vertex = 0
            this.distance = distance; //distance = 0
        } //end Node constructor
    } //end Node class
    
} //end Heap class


/* Output:
BFS Path: 0 1 7 8
DFS Path: 0 1 7 8
Heaps Path: 0 1 7 8
*/

/* Time Complexity:
Breadth First Search (BFS) algorithm: O(V + E)
Depth First Search (DFS) algorithm: O(V + E)
Heaps algorithm: O(V log V)
Space Complexity: O(V) */
