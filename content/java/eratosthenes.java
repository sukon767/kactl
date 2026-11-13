eratosthenesp-algorithms.com/algebra/sieve-of-eratosthenes.html
public static boolean[] is_prime;
public static void sieve(int n) {
    is_prime = new boolean[n+1];
    Arrays.fill(is_prime, true);
    is_prime[0] = false;
    is_prime[1] = false;
    for(int i = 2; i <= n; i++) {
        if(is_prime[i] && ((long)i) * ((long)i) <= n) {
            for(int j = i*i; j <= n; j += i) {
                is_prime[j] = false;
            }
        }
    }
}