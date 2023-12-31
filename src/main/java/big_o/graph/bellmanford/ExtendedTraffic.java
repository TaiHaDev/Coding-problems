package big_o.graph.bellmanford;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ExtendedTraffic {
    /**
     * it's not just about detecting the negative cycle but also mark all the negative cycle as MIN_VALUE.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int c = 1;
        while (n-- > 0) {
            System.out.println("Case " + c++ + ":");
            int junctions = reader.nextInt();
            int[] weights = new int[junctions + 1];
            for (int i = 1; i <= junctions; i++) {
                weights[i] = reader.nextInt();
            }
            int m = reader.nextInt();
            int[][] edges = new int[m][3];
            for (int i = 0; i < edges.length; i++) {
                int u = reader.nextInt();
                int v = reader.nextInt();
                edges[i] = new int[]{u, v, (int) Math.pow(weights[v] - weights[u], 3)};
            }
            int[] dist = new int[junctions + 1];
            bellmanFord(edges,  dist, junctions);
            int count = reader.nextInt();
            while(count-- > 0) {
                int des = reader.nextInt();
                int result = dist[des];
                if (result == Integer.MAX_VALUE || result < 3) {
                    System.out.println("?");
                } else {
                    System.out.println(result);
                }
            }
        }
    }

    public static void bellmanFord(int[][] edges, int[] dist, int junctions) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        for (int i = 0; i < junctions - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int[] cur = edges[j];
                int u = cur[0];
                int v = cur[1];
                int w = cur[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + (long) w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        for (int i = 0; i < junctions - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int[] cur = edges[j];
                int u = cur[0];
                int v = cur[1];
                int w = cur[2];
                if (dist[u] != Integer.MAX_VALUE && (long) dist[u] + w < dist[v]) {
                    dist[v] = Integer.MIN_VALUE;
                }
            }
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
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

        public long nextLong() throws IOException
        {
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

        public double nextDouble() throws IOException
        {
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

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
