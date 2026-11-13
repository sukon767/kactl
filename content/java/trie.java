public static int ALPH_SIZE = 26;

public static class TrieNode {
    TrieNode[] children = new TrieNode[ALPH_SIZE];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for(int i = 0; i < ALPH_SIZE; i++) {
            children[i] = null;
        }
    }
}

public static TrieNode root; //call root = new TrieNode(); in program

public static void insert(String s) {
    TrieNode crawl = root;
    for(int i = 0; i < s.length(); i++) {
        int idx = s.charAt(i)-'a';
        if(crawl.children[idx]==null) {
            crawl.children[idx] = new TrieNode();
        }
        crawl = crawl.children[idx];
    }
    crawl.isEndOfWord = true;
}

public static boolean search(String s) {
    TrieNode crawl = root;
    for(int i = 0; i < s.length(); i++) {
        int idx = s.charAt(i)-'a';
        if(crawl.children[idx]==null) return false;
        crawl = crawl.children[idx];
    }
    return crawl.isEndOfWord;
}