package com.bittech.test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/3/4
 */
public class Main2 {
    private static LinkedList<Integer[]>[] road = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int st = scanner.nextInt();
        road = new LinkedList[m];
        for (int i = 0; i < n; i++) {
            road[i] = new LinkedList<Integer[]>();
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int d = scanner.nextInt();
            road[x - 1].add(new Integer[]{y - 1, d});
        }
        System.out.println(dijkstra(st - 1, en - 1) + dijkstra(en - 1, st - 1));
    }

    private static int dijkstra(int st, int en) {
        int n = road.length;
        int[] dis = new int[n];
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE / 2;
        }
        PriorityQueue<Integer[]> que = new PriorityQueue<>(new Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b) {
                return a[1] - b[1];
            }

        });
        que.add(new Integer[]{st, 0});
        dis[st] = 0;
        while (!que.isEmpty()) {
            Integer[] temp = que.poll();
            if (vis[temp[0]]) {
                continue;
            }
            vis[temp[0]] = true;
            for (Integer[] r : road[temp[0]]) {
                if (!vis[r[0]] && temp[1] + r[1] < dis[r[0]]) {
                    dis[r[0]] = temp[1] + r[1];
                    que.add(new Integer[]{r[0], dis[r[0]]});
                }
            }
            if (vis[en]) {
                return dis[en];
            }
        }
        return dis[en];
    }

}
