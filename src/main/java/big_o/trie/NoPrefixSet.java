package big_o.trie;

public class NoPrefixSet {
    static class Trie {
        Node root = new Node();

        public void addNumber(String number) {
            Node temp = root;
            char[] charArray = number.toCharArray();
            boolean isPrefix = false;
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                int index = Character.getNumericValue(c);
                if (temp.child[index] == null) {
                    temp.child[index] = new Node();
                } else {
                    if (temp.child[index].wordCount != 0 || (i == charArray.length - 1 && ))
                }
                temp = temp.child[index];
            }
            temp.wordCount = 1;
        }

    }

    static class Node {
       Node[] child = new Node[10];
        int wordCount = 0;
    }
}
