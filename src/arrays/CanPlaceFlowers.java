package arrays;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        byte b=1;
        b+=1;
        System.out.println(b);
    }
    public boolean canPlaceFlowers(int[] f, int n) {
        for(int i=0; i<f.length;){
            if(f[i]==1){
                i+=2;
            }
            else if(i+1==f.length || f[i+1]==0){
                n--;
                i+=2;
            }
            else{
                i+=3;
            }
        }
        return n<=0;
    }
}
