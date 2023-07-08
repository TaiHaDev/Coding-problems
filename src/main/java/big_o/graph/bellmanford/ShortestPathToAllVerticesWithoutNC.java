package big_o.graph.bellmanford;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ShortestPathToAllVerticesWithoutNC {
    /**
     * Care using MIN_VALUE can cause overfloating lead to wrong answer
     */
    static final int INF = (int)1e9 + 7;
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        while (true) {
            int vertices = sc.nextInt();
            int edges = sc.nextInt();
            int queries = sc.nextInt();
            int start = sc.nextInt();
            if (vertices == 0) break;
            int[][] edgeList = new int[edges][3];
            for (int i = 0; i < edges; i++) {
                edgeList[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
            }
            int[] dist = new int[vertices];
            bellmanFord(edgeList, dist, start);
            while (queries-- > 0) {
                int des = sc.nextInt();
                int distance = dist[des];
                if (distance == INF) {
                    System.out.println("Impossible");
                } else if (distance == -INF) {
                    System.out.println("-Infinity");
                } else {
                    System.out.println(distance);
                }
            }
            System.out.println();
        }
    }

    private static void bellmanFord(int[][] edgeList, int[] dist, int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            for (int[] edge : edgeList) {
                int u  = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        for (int i = 0; i < dist.length - 1; i++) {
            for (int[] edge : edgeList) {
                int u  = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = -INF;
                }
            }
        }
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
