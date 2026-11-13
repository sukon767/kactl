// When data[x] < 0, x is a root and -data[x] is its tree size
// When data[x] >= 0, data[x] is x's parent
static class UnionFind {
    int[] data;
    int components;

    public UnionFind(int n) {
        data = new int[n];
        Arrays.fill(data, -1);
        components = n;
    }

    public int find(int x) {
        return data[x] < 0 ? x :(data[x] = find(data[x]));
    }

    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

    public int getSize(int x) {
        return -data[find(x)];
    }

    public boolean unite(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) 
            return false;

        if(-data[x] < -data[y]) {
            int temp = x;
            x = y;
            y = temp;
        }

        data[x] += data[y];
        data[y] = x;
        components--;
        return true;
    }
}
