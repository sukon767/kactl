public static int[] link;
public static int[] size;
public static void solve() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    link = new int[n];
    size = new int[n];
    for(int i = 0; i < n; i++) {
        link[i] = i;
        size[i] = 1;
    }
}

public static int find(int x) {
    while(x != link[x]) x = link[x];
    return x;
}

public static boolean same(int a, int b) {
    return find(a)==find(b);
}

public static void unite(int a, int b) {
    a = find(a);
    b = find(b);
    if(size[a] < size[b]) {
        int temp = a;
        a = b;
        b = temp;
    }
    size[a] += size[b];
    link[b] = a;
}