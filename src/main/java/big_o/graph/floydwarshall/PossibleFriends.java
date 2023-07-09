package big_o.graph.floydwarshall;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class PossibleFriends {
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int n = sc.nextInt();
        while (n-- > 0) {
            String line = sc.readLine();
            int[][] adjMatrix = new int[line.length()][line.length()];
            for (int i = 0; i < line.length(); i++) {
                for (int j = 0; j < line.length(); j++) {
                    adjMatrix[i][j] = line.charAt(j) == 'N' ? 0 : 1;

                }
                if (i != line.length() - 1) {
                    line = sc.readLine();
                }
            }
            int[][] dist = adjMatrix.clone();
            int maxId = 0;
            int maxCount = 0;
            floydWarshall(adjMatrix, dist);
            for (int i = 0; i < dist.length; i++) {
                int count = 0;
                for (int j = 0; j < dist.length; j++) {
                    if (i != j && dist[i][j] == -1) count++;
                }
                if (count > maxCount) {
                    maxId = i;
                    maxCount = count;
                }
            }
            System.out.println(maxId + " " + maxCount);
        }
    }

    private static void floydWarshall(int[][] adjMatrix, int[][] dist) {
        for (int k = 0; k < adjMatrix.length; k++) {
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix[0].length; j++) {
                    if (dist[i][k] + dist[k][j] == 2 && dist[i][j] == 0) {
                        dist[i][j] = -1;
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
