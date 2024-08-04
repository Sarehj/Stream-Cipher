import java.util.Random;

public class MyRandom extends Random {
 
    int a = 0;
    int b = 0;
    long seed;
    int[] S = new int[256];
    
    
    public MyRandom () {}

    public MyRandom(long seed) {
       
        this.setSeed(seed);
        RC4();
    }
    

    protected int next(int bits) {

        a = (a + 1) % 256;
        b = (b + S[a]) % 256;

        //Swap values a,b
        int t = S[a];
        S[a] = S[b];
        S[b] = t;

        // create the key
        t = (S[a] + S[b]) % 256;
        int K = S[t];

        return K;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    
    
    //RC4 - initialization
    private void RC4() {
    byte[] Key = (seed + "").getBytes();

        //Initialize a vector S[i] of 256 bytes to its position
        for (int i = 0; i < 256; i++) {
           S[i] = i;
        }

     
        //A vector KEY of length keyLength are used to process the vector S
        int j = 0;
        int keyLength = Key.length;
        for (int i = 0; i < 256; i++) {
            j = (j + S[i] + Key[i % keyLength]) % 256;
       
       
        //Swap Values i ,j
        int tmp = S[i];
            S[i] = S[j];
            S[j] = tmp;
        }
    }


}

