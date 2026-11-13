public static void solve() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    //num nodes
    int n = Integer.parseInt(st.nextToken());
    //num edges
    int m = Integer.parseInt(st.nextToken());
    //adjacency list
    ArrayList<ArrayList<int[]>> e = new ArrayList<>();
    for(int i = 0; i < n; i++) e.add(new ArrayList<>());
    for(int i = 0; i < m; i++) {
        //{a, b, w} edge between a and b with weight w
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        //change if for directed graph
        e.get(a).add(new int[]{b, w});
        e.get(b).add(new int[]{a, w});
    }
    int[] d = new int[n];
    boolean[] seen = new boolean[n];
    Arrays.fill(d, Integer.MAX_VALUE);
    int start = Integer.parseInt(br.readLine());
    d[start] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
        public int compare(int[] a, int[] b) {
            return a[1]-b[1];
        }
    });
    pq.add(new int[]{start, 0});
    while(!pq.isEmpty()) {
        int curr = pq.remove()[0];
        if(seen[curr]) continue;
        seen[curr] = true;
        for(int[] x : e.get(curr)) {
            if(d[curr]+x[1] < d[x[0]]) {
                d[x[0]] = d[curr]+x[1];
                pq.add(new int[]{x[0], d[x[0]]});
            }
        }
    }
}