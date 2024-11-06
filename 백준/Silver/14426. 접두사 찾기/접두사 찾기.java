import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
 
class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;
 
    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
 
public class Main {
    static TrieNode root;
 
    static void insert(String str) {
        TrieNode currentNode = root;
        for (char c : str.toCharArray()) {
            currentNode.children.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.children.get(c);
        }
        currentNode.isEndOfWord = true;
    }
 
    static boolean searchPrefix(String prefix) {
        TrieNode currentNode = root;
        for (char c : prefix.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.children.get(c);
        }
        return true;
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
 
        root = new TrieNode();
        for (int i = 0; i < N; i++) {
            insert(in.readLine());
        }
 
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (searchPrefix(in.readLine())) {
                cnt++;
            }
        }
 
        System.out.println(cnt);
    }
}