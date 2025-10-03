

public class recursion {
    public static int sum(int start,int end){
        if (start<end){
            return end+sum(start,end-1);
        }
        else{
            return end;
        }

    }   public static void main(String[] args){
        int x= sum(5,11);
        System.out.println(x);
    } 
    }

