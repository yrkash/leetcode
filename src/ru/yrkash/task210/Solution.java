package ru.yrkash.task210;


import java.util.*;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Create an array to store the in-degree (number of prerequisites) for each course
        int[] inDegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            inDegrees[course]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> order = new ArrayList<>();

        // Initialize the queue with courses that have no prerequisites
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll(); // Use poll() instead of pop() for better readability
            order.add(course); // Add the course to the order

            for (int neighbor : graph.get(course)) {
                // Reduce the in-degree of the neighbor
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If we were able to complete all courses, return the order
        if (order.size() == numCourses) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = order.get(i);
            }
            return result;
        } else {
            // If not all courses can be completed, return an empty array
            return new int[0];
        }
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create a graph represented by an adjacency list where each course points to its prerequisites
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Create an array to store the in-degree (number of prerequisites) for each course
        int[] inDegrees = new int[numCourses];

        // Populate the graph and update the in-degrees based on the prerequisites
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            inDegrees[course]++; // Increment the in-degree of the course
        }

        // Queue to hold courses with in-degree of 0 (no prerequisites)
        Deque<Integer> queue = new ArrayDeque<>();

        // Enqueue all courses which have no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        // Counter for number of courses that have been processed
        int processedCourses = 0;

        // Process the courses in the queue
        while (!queue.isEmpty()) {
            int course = queue.poll();
            processedCourses++; // Increment count of processed courses

            // Iterate over the neighbors of the current course
            for (int neighbor : graph.get(course)) {
                // Decrement the in-degree of each neighbor, since we have processed one of their prerequisites
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    // If in-degree becomes 0, it means all prerequisites are met, so enqueue the course
                    queue.offer(neighbor);
                }
            }
        }

        // If the number of processed courses equals the total number of courses, all can be finished
        return processedCourses == numCourses;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[][] prerequisites = {{1,0}, {0,1}};
        int numCourses = 2;
        int[] result = solution.findOrder(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            System.out.println(result[i]);
        }
    }
}