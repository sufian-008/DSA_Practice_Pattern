
// This is leetcode paid question
import java.util.PriorityQueue;

class Solution {

    // Inner class Edge that implements Comparable
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost; // for min-heap behavior
        }
    }

    // Method to connect cities (like Prim's MST)
    public static int connectCities(int[][] cities) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;
    }



    public static void main(String[] args) {
        int[][] cities = {
            {0, 1, 2, 3},
            {1, 0, 4, 0},
            {2, 4, 0, 5},
            {3, 0, 5, 0}
        };

        System.out.println("Minimum cost to connect cities: " + connectCities(cities));
    }
}
