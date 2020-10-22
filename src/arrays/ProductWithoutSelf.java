package arrays;
//238. Product of Array Except Self
//https://leetcode.com/problems/product-of-array-except-self/
class  ProductofArrayExceptSelf {
    public int[] productExceptSelf(int []a){
        int res[]= new int[a.length];
        res[0]=1;
        for(int i=0;i<a.length-1;i++){
            res[i+1]=res[i]*a[i];
        }

        int r=1;
        for(int i=a.length-1;i>=0;i--){
            res[i]=r*res[i];
            r=r*a[i];

        }

        return res;
    }

}