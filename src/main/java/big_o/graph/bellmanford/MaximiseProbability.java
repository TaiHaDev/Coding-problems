package big_o.graph.bellmanford;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MaximiseProbability {
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        while (true) {
            int vertices = sc.nextInt();
            int edges = sc.nextInt();
            if (vertices == 0) break;
            int[][] edgeList = new int[edges * 2][3];
            for (int i = 0; i < edges * 2; i+= 2) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int weight = sc.nextInt() ;
                edgeList[i] = new int[] {u,v, weight};
                edgeList[i + 1] = new int[] {v, u, weight};
            }
            double[] dist = new double[vertices + 1];
            bellmanFord(edgeList, dist, 1);
            System.out.printf("%.6f percent\n", dist[vertices] * 100);

        }
    }

    private static void bellmanFord(int[][] edgeList, double[] dist, int start) {
        Arrays.fill(dist, -1);
        dist[start] = 1.0;
        for (int i = 1; i < dist.length; i++) {
            for (int j = 0; j < edgeList.length; j++) {
                int[] cur = edgeList[j];
                int u = cur[0];
                int v = cur[1];
                int weight = cur[2];
                if (dist[u] > 0 && dist[u] * (double) weight / 100 > dist[v]) {
                    dist[v] = dist[u] * ((double) weight/100.0);
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
