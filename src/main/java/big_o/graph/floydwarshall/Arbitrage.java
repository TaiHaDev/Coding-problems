package big_o.graph.floydwarshall;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Arbitrage {
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int c = 1;
        while (true) {
            int vertices = sc.nextInt();
            if (vertices == 0) break;
            Map<String, Integer> curMap = new HashMap<>();
            for (int i = 0; i < vertices; i++) {
                curMap.put(sc.readLine(), i);
            }
            double[][] adjMatrix = new double[vertices][vertices];
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (i != j) {
                        adjMatrix[i][j] = Double.MIN_VALUE;
                    } else {
                        adjMatrix[i][j] = 1.0;
                    }
                }
            }
            int edges = sc.nextInt();
            for (int i = 0; i < edges; i++) {
                String[] tokens = sc.readLine().split(" ");
                adjMatrix[curMap.get(tokens[0])][curMap.get(tokens[2])] = Double.parseDouble(tokens[1]);
            }
            if (floydWarshall(adjMatrix)) {
                System.out.println("Case " + c++ + ": " + "Yes");
            } else {
                System.out.println("Case " + c++ + ": " + "No");
            }
        }
    }

    private static boolean floydWarshall(double[][] adjMatrix) {
        for (int k = 0; k < adjMatrix.length; k++) {
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix[0].length; j++) {
                    if (adjMatrix[i][k] != Integer.MIN_VALUE && adjMatrix[k][j] != Integer.MIN_VALUE && adjMatrix[i][j] < adjMatrix[i][k] * adjMatrix[k][j]) {
                        adjMatrix[i][j] = adjMatrix[i][k] * adjMatrix[k][j];
                    }
                }
                if (adjMatrix[i][i] > 1.0) return true;
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
