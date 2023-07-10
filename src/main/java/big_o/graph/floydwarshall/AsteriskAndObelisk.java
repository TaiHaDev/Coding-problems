package big_o.graph.floydwarshall;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AsteriskAndObelisk {
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int c = 1;
        while (true) {
            int vertices = sc.nextInt();
            int edges = sc.nextInt();
            int queries = sc.nextInt();
            if (vertices == 0 && edges == 0 && queries == 0) break;
            int[] feasts = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                feasts[i] = sc.nextInt();
            }
            int[][][] adjMatrix = new int[vertices][vertices][2]; // [weight, feast]
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    adjMatrix[i][j] = i == j ? new int[] {0, feasts[i]} : new int[] {Integer.MAX_VALUE, feasts[i]};
                }

            }
            for (int i = 0; i < edges; i++) {
                int u = sc.nextInt() -1;
                int v = sc.nextInt() - 1;
                int w = sc.nextInt();
                adjMatrix[u][v] = new int[] {w, Math.max(feasts[u], feasts[v])};
                adjMatrix[v][u] = new int[] {w, Math.max(feasts[u], feasts[v])};
            }
            floydwarshall(adjMatrix, vertices);
            System.out.println("Case #" + c++);
            for (int i = 0; i < queries; i++) {
                int start = sc.nextInt() - 1;
                int des = sc.nextInt() - 1;
                System.out.println(adjMatrix[start][des][1] + adjMatrix[start][des][0]);
            }
        }
    }

    private static void floydwarshall(int[][][] adjMatrix, int vertices) {
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (adjMatrix[i][k][0] != Integer.MAX_VALUE && adjMatrix[k][j][0] != Integer.MAX_VALUE && adjMatrix[i][j][0] > adjMatrix[i][k][0] + adjMatrix[k][j][0]) {
                        adjMatrix[i][j][0] = adjMatrix[i][k][0] + adjMatrix[k][j][0];
                        adjMatrix[i][j][1] = Math.max(adjMatrix[i][k][1], adjMatrix[k][j][1]);
                    }
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
