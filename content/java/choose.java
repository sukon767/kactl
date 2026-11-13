public static long MOD = 998244353; //1000000007;

public static long choose(int n, int k) {
    if(k==0) return 1;
    return (((fact[n] * rfact[k])%MOD) * rfact[n-k])%MOD;
}
//set array size as needed
//1-indexed
public static long[] fact = new long[100001];
public static long[] rfact = new long[50001];

//run calc() at start of program
public static void calc() {
    //calculate factorials %MOD
    fact[0] = 1;
    for(int i = 1; i < fact.length; i++) {
        fact[i] = (fact[i-1] * i)%MOD;
    }

    rfact[0] = 1;
    rfact[1] = 1;
    for(int i = 2; i < rfact.length; i++) {
        // 1/b % p = b^(p-2) % p
        //calculate 1/b! % MOD
        rfact[i] = (rfact[i-1] * expo(i, MOD-2))%MOD;
    }
}
//exponent function for a^b %MOD
public static long expo(long a, long b) {
    if(b==0) return 1;
    if(b==1) {
        return a%MOD;
    }
    long ans = 1;
    if(b%2 == 1) {
        ans = ((ans * a)%MOD * expo(a, b-1))%MOD;
    } else {
        ans = (expo((a * a)%MOD, b/2))%MOD;
    }
    return ans;
}