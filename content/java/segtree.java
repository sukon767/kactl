public static int[] segTree;
public static void solve() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    readArr(arr);
    segTree = new int[n*2];
    for(int i = 0; i < n; i++) segTree[i+n] = arr[i];
    for(int i = n-1; i > 0; i--) {
        //sum queries
        segTree[i] = segTree[i*2] + segTree[i*2+1];
        //max queries
        //segTree[i] = Math.max(segTree[i*2], segTree[i*2+1]);
        //min queries
        //segTree[i] = Math.min(segTree[i*2], segTree[i*2+1]);
        //xor queries
        //segTree[i] = segTree[i*2] ^ segTree[i*2+1];
    }
}

public static void modify(int idx, int val, int n) {
    idx += n;
    segTree[idx] = val;
    idx/=2;
    while(idx > 0) {
        segTree[idx] = segTree[idx*2] + segTree[idx*2+1];
        idx/=2;
    }
}

public static int query(int l, int r, int n) { //interval [l, r]
    int res = 0;
    l+=n; r+=n;
    while(l<=r) {
        if(l%2==1) res += segTree[l++];
        if(r%2==0) res += segTree[r--];
        l/=2; r/=2;
    }
    return res;
}