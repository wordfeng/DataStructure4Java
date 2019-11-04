package datastruct.basic.collections;

import datastruct.basic.tree.BST;
import org.junit.Test;

import java.util.ArrayList;

public class BSTTreeTest {
    @Test
    public void prideAndPrejudiceAnalyze() {
        System.out.println("Pride And Prejudice");
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", words);
        System.out.println(words.size());
        BST<String> bst = new BST<>();
        for (String word : words) {
            bst.add(word);
        }
        System.out.println(bst.size());
    }

    public void reverseString(char[] s) {
//        输入：["h","e","l","l","o"]
//        输出：["o","l","l","e","h"]
        reverse(s, s.length);

    }

    public void reverse(char[] s, int length) {
        if (length == 0) {
            return;
        }
        length--;
        int pos = s.length - length - 1;
        char tmp = s[length];
        s[length] = s[pos];
        s[pos] = tmp;
        System.out.println("ni " + s[length] + " length =" + length + " s.length = " + (s.length - length - 1));
        reverse(s, length);
    }

    @Test
    public void reString() {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(s);
    }

    @Test
    public void mmm() {
        short s = 3;
        short s2 = 1;
        System.out.println(s);
        s2 = (short) (s2 +1);
        System.out.println(s2);
    }
}
