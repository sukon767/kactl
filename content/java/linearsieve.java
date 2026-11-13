// https://cp-algorithms.com/algebra/prime-sieve-linear.html
// use to find least prime factor of all numbers i <= N, (lp[i]), and all prime numbers <= N, pr, in O(N)
public static int[] lp;
public static ArrayList<Integer> pr;
public static void linSieve(int N) { // max val of N = 10000000
    lp = new int[N+1];
    pr = new ArrayList<>();
    for(int i = 2; i <= N; i++) {
        if(lp[i] == 0) { // i is prime
            lp[i] = i;
            pr.add(i);
        }
        for(int j = 0; i * pr.get(j) <= N; j++) {
            lp[i * pr.get(j)] = pr.get(j);
            if(pr.get(j) == lp[i]) break;
        }
    }
}