package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int pre = 0;
        int len = 0;

        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if ((len + words[i].length() + i - pre) > maxWidth) {
                res.add(form(words, pre, i - 1, maxWidth, len));
                pre = i;
                len = 0;
            }

            len += words[i].length();

        }

        if (len != 0) {
            res.add(lastLine(words, pre, words.length - 1, maxWidth, len));
        }

        return res;
    }

    public String form(String[] words, int start, int end, int maxWidth, int len) {
        int count = end - start;

        String line = "";

        int sp = maxWidth - len;
        int space = 0;


        for (int i = start; i <= end; i++) {
            space = i == end ? sp : (sp + count - 1) / count;
            sp -= space;
            line = line + words[i] + formSpace(space);
            count--;
        }
        return line;
    }

    public String formSpace(int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }

    public String lastLine(String[] words, int start, int end, int maxWidth, int len) {

        int count = end - start;

        String line = "";

        int sp = maxWidth - len - count;

        for (int i = start; i <= end; i++) {
            int space = i == end ? sp : 1;
            line = line + words[i] + formSpace(space);
            count--;
        }
        return line;
    }

    public static void main(String[] args){
        TextJustification tj = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = tj.fullJustify(words, 16);
        res.stream().forEach(x -> System.out.println(x));

    }
}