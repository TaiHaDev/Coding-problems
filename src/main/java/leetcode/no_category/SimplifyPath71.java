package leetcode.no_category;

public class SimplifyPath71 {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < paths.length; i++) {
            String cur = paths[i];
            if (cur.equals("..")) {
                int idx = sb.lastIndexOf("/");
                if (idx >= 0) {
                    sb.delete(idx, sb.length());
                }
            } else if (cur.isBlank() || cur.equals(".")) {
                continue;
            } else {
                sb.append("/").append(cur);
            }
        }
        if (sb.isEmpty()) {
            sb.append("/");
        }
        return sb.toString();
    }
}
