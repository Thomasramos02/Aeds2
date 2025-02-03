public class Util {

    public Util() {
    }

    public static int somarNumerosPares(int n) {
        if (n == 0){
            return 0;
        }else if(n % 2 == 0){
            return n + somarNumerosPares(n-1);
        }
        else{
            return 0;
        }
    }

    public static double SomarArrayDouble(double[] limite, int n){
        if(limite.length == 1){
            return limite[0];
        }
        return limite[n] + SomarArrayDouble(limite,n-1);
    }

    public static int ContarRepeticoesArray(int [] array, int right, int left){
        if(array.length == 1){
            return array[0];
        }else if(right >= left){
            return 0;
        }
        return ContarRepeticoesArray(array,right - 1,left+1);
    }
}
