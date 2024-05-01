package leetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankTeamByVote1366 {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> countMap = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char c = vote.charAt(i);
                countMap.computeIfAbsent(c, o1 -> new int[votes[0].length()]);
                countMap.get(c)[i]++;
            }
        }
        List<Character> res = countMap.keySet().stream().collect(Collectors.toList());
        Collections.sort(res, ((o1, o2) -> {
            int[] rank1 = countMap.get(o1);
            int[] rank2 = countMap.get(o2);
            for (int i = 0; i < rank1.length; i++) {
                int compare = Integer.compare(rank1[i], rank2[i]);
                if (compare != 0) {
                    return -compare;
                }
            }
            return Character.compare(o1, o2);
        }));
        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }
        return sb.toString();
    }
}
