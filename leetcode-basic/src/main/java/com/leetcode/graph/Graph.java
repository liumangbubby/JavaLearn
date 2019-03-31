package com.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph { // 无向图
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        visited[s] = true;
        queue.offer(s);
        while (true) {
            int target = queue.poll();
            for (int i = 0; i < adj[target].size(); i++) {
                Integer step = adj[target].get(i);
                if(!visited[step]) {
                    visited[step] = true;
                    prev[step] = target;
                    queue.offer(step);
                    if(step == t) {
                        print(prev, s, t);
                        return;
                    }
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        System.out.print(t + " ---> ");
        if(s == t)
            return;
        print(prev, s, prev[t]);
    }

    boolean found = false; // 全局变量或者类成员变量

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if(found) return;
        visited[w] = true;
        if(w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int next = adj[w].get(i);
            if(visited[next])
                continue;
            prev[next] = w;
            recurDfs(next, t, visited, prev);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.bfs(0,7);
        System.out.println();
        graph.dfs(0,7);
        System.out.println();
    }
}
