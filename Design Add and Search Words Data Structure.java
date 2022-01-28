class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        private final int N = 26;
        
        TrieNode() {
            children = new TrieNode[N];
        }
    }
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
        root.isWord = true;
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfsSearch(root, word, 0);
    }
    
    private boolean dfsSearch(TrieNode cur, String word, int i) {
        if (cur == null) return false;
        if (i == word.length()) return cur.isWord;
        char c = word.charAt(i);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (dfsSearch(cur.children[j], word, i + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return dfsSearch(cur.children[c - 'a'], word, i + 1);
        }
    }
}
