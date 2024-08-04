import java.util.Random;

public class MyRandom extends Random {
 
    int m = 2147483647;
    int a = 48271;
    int b = 0;
    long seed;

    public MyRandom () {}

    public MyRandom(long seed) {
       
        this.setSeed(seed);
    }
  
   
    //x = ax0+b mod m
    protected int next(int bits) {
      
        int nextSeed = (int) ((a * seed + b) % m);
        seed = nextSeed;
        return nextSeed;
    }
    
    public void setSeed(long seed) {
        this.seed = seed;
    }
}
    
