import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha;
        Util util = new Util();

       do{
           System.out.println("1 - Somar todos os números pares até um limite escolhido pelo usuário");
           System.out.println("2 - Somar todos os elementos de um vetor (array) de números double");
           System.out.println("3 - Contar a quantidade de repetições, em um vetor (array), de um número escolhido pelo usuário.");
           System.out.println("4 - sair");

           escolha = sc.nextInt();

       switch (escolha){
           case 1:
               System.out.println("opção 1 selecionada");
               System.out.println("digite um valor limite: ");
               int resultado = util.somarNumerosPares(sc.nextInt());
               System.out.println(resultado);
               break;
           case 2:
               System.out.println("opção 2 selecionada");
               System.out.println("digite um tamanho:");
               int n = sc.nextInt();
               System.out.println("digite um valor limite: ");
                double vetor[] = new double[n];
                for(int j = 0; j < n; j++){
                    vetor[j] = sc.nextDouble();
                }
               break;
           case 3:
               System.out.println("opção 3 selecionada");
               break;
           case 4:
               System.out.println("opção 4 selecionada");
               break;
           default:
               System.out.println("opção invalida");
               break;
       }

       }while(escolha != 4);
    }
}
