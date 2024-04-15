package leetcode.hash;

import java.util.*;

public class GroupShiftedStrings249 {
    public static void main(String[] args) {
        System.out.println(new GroupShiftedStrings249().groupStrings(new String[] {"abc","bcd","acef","xyz","az","ba","a","z"}));
    }
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap();
        for (String str : strings) {
            char[] curStr = str.toCharArray();
            int offset = curStr[0] - 'a';
            for (int i = 0; i < curStr.length; i++) {
                curStr[i] = (char) ((curStr[i] - 'a' - offset + 26) % 26 + 'a');
            }
            map.computeIfAbsent(Arrays.toString(curStr), k -> new ArrayList()).add(str);
        }
        return map.values().stream().toList();
    }
}
