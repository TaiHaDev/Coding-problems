package big_o.graph.bellmanford;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class EnergyRoom {
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        while (true) {
            int vertices = sc.nextInt();
            if (vertices == -1) break;
            List<int[]> edges = new ArrayList<>();
            int[] weights = new int[vertices + 1];
            for (int i = 0; i < vertices; i++) {
                int weight = sc.nextInt();
                weights[i + 1] = weight;
                int total = sc.nextInt();
                while (total-- > 0) {
                    int v = sc.nextInt();
                    edges.add(new int[] {i + 1, v});
                }
            }
            int[] dist = new int[vertices + 1];
            if (bellmanFord(edges, weights, dist, 1)) {
                System.out.println("winnable");
            } else {
                System.out.println("hopeless");
            }
        }

    }

    private static boolean bellmanFord(List<int[]> edges, int[] weights, int[] dist, int start) {
        Arrays.fill(dist, Integer.MIN_VALUE);
        if (edges.isEmpty()) return false;
        dist[start] = 100;
        for (int i = 0; i < weights.length - 2; i++) {
            for (int j = 0; j < edges.size(); j++) {
                int[] cur = edges.get(j);
                int u = cur[0];
                int v = cur[1];
                int weight = weights[v];
                if (dist[u] > 0 && dist[u] + weight > dist[v]) {
                    dist[v] = dist[u] + weight;

                }
            }
        }
        for (int i = 0; i < weights.length - 2; i++) {
            int[] cur = edges.get(i);
            int u = cur[0];
            int v = cur[1];
            int weight = weights[v];
            if (dist[u] > 0 && dist[u] + weight > dist[v] && hasPathBFS(edges, u, weights.length -1)) {
                return true;
            }
        }
        return dist[weights.length -1] > 0;
    }

    private static boolean hasPathBFS(List<int[]> edges, int u, int des) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[des + 1];
        queue.add(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            if (cur == des) return true;
            for (int[] edge : edges) {
                if (edge[0] == cur && !visited[edge[1]]) {
                    queue.add(edge[1]);
                    visited[edge[1]] = true;
                }
            }
        }
        return false;
    }


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}


