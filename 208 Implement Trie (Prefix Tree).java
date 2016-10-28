class TrieNode {
    // Initialize your data structure here.
    public char val;
    public TrieNode[] children = new TrieNode[26];
    public boolean isWord;
    public TrieNode() {}
    public TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode pointer = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (pointer.children[c-'a'] == null) {
                pointer.children[c-'a'] = new TrieNode(c);
            }
            pointer = pointer.children[c-'a'];
        }
        pointer.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode pointer = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (pointer.children[c-'a'] == null) {
                return false;
            }
            pointer = pointer.children[c-'a'];
        }
        return pointer.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode pointer = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (pointer.children[c-'a'] == null) {
                return false;
            }
            pointer = pointer.children[c-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

