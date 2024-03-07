    package Coding_assessment.Rando;

    import java.io.File;
    import java.io.FileNotFoundException;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Scanner;

    public class PyramidDecode {
        public static void main(String[] args) {
            File file = new File("/Users/taiha/Desktop/algorithm/leetcode/leetcode/src/main/java/Coding_assessment/Rando/input.txt");
            try (Scanner sc = new Scanner(file)) {
                Map<Integer, String> wordMap = new HashMap<>();
                while (sc.hasNextLine()) {
                    String curLine = sc.nextLine();
                    if (curLine.isEmpty()) {
                        break;
                    }
                    String[] split = curLine.split(" ");
                    wordMap.put(Integer.parseInt(split[0]), split[1]);
                }

                String result = decode(wordMap);
                System.out.println(result);
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            }
        }
        private static String decode(Map<Integer, String> wordMap) {
            int curStep = 1;
            int total = 1;
            StringBuilder resultBuilder = new StringBuilder();
            while(wordMap.containsKey(total)) {
                resultBuilder.append(wordMap.get(total)).append(" ");
                curStep += 1;
                total += curStep + 1;
            }
            return resultBuilder.toString();
        }
    }
