package big_o.graph.floydwarshall;

import java.util.*;

public class CityOfHope {
    static final int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n == 0) break;

            int[][] young = new int[26][26];
            int[][] old = new int[26][26];

            for(int i = 0; i < 26; i++){
                Arrays.fill(young[i], INF);
                Arrays.fill(old[i], INF);
                young[i][i] = old[i][i] = 0;
            }

            while(n-- > 0){
                char type = sc.next().charAt(0);
                char dir = sc.next().charAt(0);
                int u = sc.next().charAt(0) - 'A';
                int v = sc.next().charAt(0) - 'A';
                int c = sc.nextInt();

                if(type == 'Y'){
                    young[u][v] = Math.min(young[u][v], c);
                    if(dir == 'B')
                        young[v][u] = Math.min(young[v][u], c);
                }else{
                    old[u][v] = Math.min(old[u][v], c);
                    if(dir == 'B')
                        old[v][u] = Math.min(old[v][u], c);
                }
            }

            for(int k = 0; k < 26; k++)
                for(int i = 0; i < 26; i++)
                    for(int j = 0; j < 26; j++){
                        young[i][j] = Math.min(young[i][j], young[i][k] + young[k][j]);
                        old[i][j] = Math.min(old[i][j], old[i][k] + old[k][j]);
                    }

            int u = sc.next().charAt(0) - 'A';
            int v = sc.next().charAt(0) - 'A';

            int min = INF;
            for(int i = 0; i < 26; i++)
                if(young[u][i] + old[v][i] < min)
                    min = young[u][i] + old[v][i];

            if(min == INF){
                System.out.println("You will never meet.");
            }else{
                System.out.print(min);
                for(int i = 0; i < 26; i++)
                    if(young[u][i] + old[v][i] == min)
                        System.out.print(" " + (char)(i + 'A'));
                System.out.println();
            }
        }
        sc.close();
    }
}