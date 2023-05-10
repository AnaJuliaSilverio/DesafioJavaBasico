import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Olá, "+nome);
        System.out.println("Deseja jogar? (1-sim 2-não)");
        int opcaoUsuario;
        opcaoUsuario = sc.nextInt();
        switch (opcaoUsuario) {
            case (1) -> jogarDado();
            case (2) -> System.out.println("Que pena " + nome + " :( Até a próxima então ");
            default -> System.out.println("Valor Invalido");
        }

    }
    public static void jogarDado(){
        Scanner sc =new Scanner(System.in);
        List<Boolean> acertouErrou = new ArrayList<>();
        List<Integer> acertouErrouValores = new ArrayList<>();
        int somaQuantidadePontos=0;

        while (true){
            int valorRecebidoUsuario= verificaValor();
            int numeroGerado = geraNumero();

            if (valorRecebidoUsuario==numeroGerado){
                somaQuantidadePontos+=10;
                acertouErrou.add(true);
                acertouErrouValores.add(valorRecebidoUsuario);
                System.out.println("Você acertou! Acaba de ganhar 10 pontos :)");
            }
            else if (valorRecebidoUsuario==(numeroGerado+1)||valorRecebidoUsuario==(numeroGerado-1)) {
                somaQuantidadePontos+=5;
                acertouErrou.add(true);
                acertouErrouValores.add(valorRecebidoUsuario);
                System.out.println("Foi quase!Você digitou "+valorRecebidoUsuario+", mas o valor era " +numeroGerado+". Você acaba de ganhar 5 pontos :)");
            }
            else{
                acertouErrou.add(false);
                acertouErrouValores.add(valorRecebidoUsuario);
                System.out.println("A que pena não foi dessa vez:( Você digitou "+valorRecebidoUsuario+", mas o valor era " +numeroGerado);
            }
            System.out.println("----------------------Pontuação atual----------------------------");
            System.out.println(somaQuantidadePontos+" pontos.");
            System.out.println("-----------------------------------------------------------------");
            if (!menu()){
                historicoDoJogo(acertouErrou,somaQuantidadePontos,acertouErrouValores);
                break;
            }

        }
    }

    public static boolean menu(){
        Scanner sc =new Scanner(System.in);
        while (true){
            System.out.println("Para jogar novamente digite 1. Para sair digite 2");
            int opcaoUsuario = sc.nextInt();
            if (opcaoUsuario == 1) {
                return true;
            } else if (opcaoUsuario == 2) {
                return false;
            }else {
                System.out.printf("Valor Invalido! ");
            }
        }
    }
    public static int verificaValor(){
        Scanner sc =new Scanner(System.in);
        int valorRecebidoUsuario;
        while (true){
            System.out.println("Vamos lá! Você deve digitar um valor entre 1-6: ");
            //se esse valor ta entre um e 6
             valorRecebidoUsuario = sc.nextInt();
            if (valorRecebidoUsuario<1 || valorRecebidoUsuario>6){
                System.out.printf("Valor Invalido! ");
            }else break;
        }
        return valorRecebidoUsuario;
    }

    public static int geraNumero(){
        Random geradorDoDado = new Random();
        //gerando um numero de 1 a 6
       return geradorDoDado.nextInt(6)+1;
    }

    public static void historicoDoJogo(List<Boolean> acertouErrou,int somaAcertos,List<Integer> acertouErrouValores ) {
        int numerosAcerto = 0, numeroErros = 0;
        System.out.println("-------------HISTÓRICO DE JOGADAS-------------");
        for (int i = 0; i < acertouErrou.size(); i++) {
            System.out.printf("------Rodada %d -------- Digitou %d e ", (i + 1), acertouErrouValores.get(i));
            if (acertouErrou.get(i)) {
                System.out.printf("acertou :)\n");
                numerosAcerto++;
            } else {
                System.out.printf("errou :(\n");
                numeroErros++;
            }

        }
        System.out.println("-------------------RESULTADO FINAL------------------------");
        System.out.println("Numero de acertos: " + numerosAcerto);
        System.out.println("Numero de erros: " + numeroErros);
        System.out.println(somaAcertos + " pontos!");
    }


}