//inside solve(), put LazySegmentTree lst = new LazySegmentTree(arr, n);
//put this class outside of main class
class LazySegmentTree {
    long[] segTree;
    long[] lazy;
    int n;

    public LazySegmentTree(long[] arr, int nn) {
        n = nn;
        segTree = new long[4*n];
        lazy = new long[4*n];
        build(arr, 1, 0, n-1);
    }

    public void build(long[] arr, int node, int l, int r) {
        if(l==r) {
            segTree[node] = arr[l];
            return;
        }
        int m = (l+r)/2;
        build(arr, node*2, l, m);
        build(arr, node*2+1, m+1, r);

        //sum queries
        segTree[node] = segTree[node*2] + segTree[node*2+1];
        //max queries
        //segTree[node] = Math.max(segTree[node*2], segTree[node*2+1]);
        //min queries
        //segTree[node] = Math.min(segTree[node*2], segTree[node*2+1]);
        //xor queries
        //segTree[node] = segTree[node*2] ^ segTree[node*2+1];
    }

    public void updateRange(int ul, int ur, int d) {
        updateRangeUtil(1, 0, n-1, ul, ur, d);
    }
    //node: curr node, [nl, nr]: node's range coverage, [ul, ur]: update's range, d: update val
    public void updateRangeUtil(int node, int nl, int nr, int ul, int ur, int d) {
        if(lazy[node] != 0) { //propagate existing updates
            segTree[node] += (nr-nl+1)*lazy[node]; //CHANGE FOR DIFFERENT QUERIES
            //make sure node isn't leaf
            if(nl!=nr) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            lazy[node] = 0;
        }
        if(nr < ul || ur < nl) return; //out of update range
        if(ul <= nl && nr <= ur) { //node fully in range
            segTree[node] += (nr-nl+1)*d; //CHANGE FOR DIFFERENT QUERIES
            //make sure node isn't leaf
            if(nl!=nr) {
                lazy[node*2] += d;
                lazy[node*2+1] += d;
            }
            return;
        }
        //overlapping ranges
        int m = (nl+nr)/2;
        updateRangeUtil(node*2, nl, m, ul, ur, d);
        updateRangeUtil(node*2+1, m+1, nr, ul, ur, d);
        //update based on children
        segTree[node] = segTree[node*2] + segTree[node*2+1]; 
        //CHANGE FOR DIFFERENT QUERIES ^
    }

    public long query(int ql, int qr) {
        return queryUtil(1, 0, n-1, ql, qr);
    }

    public long queryUtil(int node, int nl, int nr, int ql, int qr) {
        if(lazy[node] != 0) { //propagate existing updates
            segTree[node] += (nr-nl+1)*lazy[node]; //CHANGE FOR DIFFERENT QUERIES
            //check if children nodes are leafs
            if(nl!=nr) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            lazy[node] = 0;
        }
        if(nr < ql || qr < nl) return 0; //out of query range, CHANGE FOR DIFFERENT QUERIES
        if(ql <= nl && nr <= qr) return segTree[node]; //node fully in range
        //overlapping ranges
        int m = (nl+nr)/2;
        return queryUtil(node*2, nl, m, ql, qr) + queryUtil(node*2+1, m+1, nr, ql, qr);  
        //CHANGE FOR DIFFERENT QUERIES ^
    }
}