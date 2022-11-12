import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class Jogo_da_Forca {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        Random r = new Random();
        Scanner scan = new Scanner(System.in);

        String letraPlacar[] = {"|| #", "#", "#", "#", "#", "#"};
        String palavras[] = {"ABELHA", "TAMBOR", "IGREJA", "GOIABA", "CAMISA"}, palavraUsada = "";
        String dicas[] = {"Inseto que produz doce atraves do polen.", "Instrumento musical.", "Local religioso.", "Fruta usada para fazer doce.", "E uma peca de roupa."}, dicaUsada = "";

        String  mensagem = "";
        int foiDigitado[] = new int[6];
        int erros = 0;
        int acertos = 0;
        boolean fimPartida = false;
        boolean sair = false;

        int numAleatorio = 0;
        String letraDigitada = "";

        numAleatorio = r.nextInt(0, 5);

        palavraUsada = palavras[numAleatorio];
        dicaUsada = dicas[numAleatorio];

        do  {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            if(mensagem != "") {
                System.out.printf("Mensagem: %s\n", mensagem);
            }     
			mensagem = "";

            if(erros == 0) {

                System.out.println("||=========");
                System.out.println("||        |");
                System.out.println("||        +");
                System.out.println("||");
                System.out.println("||");
                System.out.println("||");
                System.out.println("||");
                System.out.println("||");
                System.out.println("||");
                System.out.println("||");

            }
            else if(erros == 1) {

                System.out.println("||=========");
                System.out.println("||        |");
                System.out.println("||        +");
                System.out.println("||       ( )");
                System.out.println("||        |");
                System.out.println("||");
                System.out.println("||");
                System.out.println("||");
                System.out.println("||");
                System.out.println("||");

            }
            else if(erros == 2) {

                System.out.println("||=========");
                System.out.println("||        |");
                System.out.println("||        +");
                System.out.println("||       ( )");
                System.out.println("||        |");
                System.out.println("||       /");
                System.out.println("||      /");
                System.out.println("||");
                System.out.println("||");
                System.out.println("||");

            }

            else if(erros == 3) {

                System.out.println("||=========");
                System.out.println("||        |");
                System.out.println("||        +");
                System.out.println("||       ( )");
                System.out.println("||        |");
                System.out.println("||       / \\");
                System.out.println("||      /   \\");
                System.out.println("||");
                System.out.println("||");
                System.out.println("||");

            }
            else if(erros == 4) {

                System.out.println("||=========");
                System.out.println("||        |");
                System.out.println("||        +");
                System.out.println("||       ( )");
                System.out.println("||        |");
                System.out.println("||       /|\\");
                System.out.println("||      / | \\");
                System.out.println("||        |");
                System.out.println("||");
                System.out.println("||");

            }
            else if(erros == 5) {

                System.out.println("||=========");
                System.out.println("||        |");
                System.out.println("||        +");
                System.out.println("||       ( )");
                System.out.println("||        |");
                System.out.println("||       /|\\");
                System.out.println("||      / | \\");
                System.out.println("||        |");
                System.out.println("||       /");
                System.out.println("||      /");

            }
            else if(erros == 6) {

                System.out.println("||=========");
                System.out.println("||        |");
                System.out.println("||        +");
                System.out.println("||       ( )");
                System.out.println("||        |");
                System.out.println("||       /|\\");
                System.out.println("||      / | \\");
                System.out.println("||        |");
                System.out.println("||       / \\");
                System.out.println("||      /   \\");
            
            }

            System.out.printf("|| Dica: %s", dicaUsada);

            for (int i = 0; i < palavraUsada.length(); i++) {
                if(letraDigitada.toUpperCase().equals("" + palavraUsada.charAt(i))) {
                    if(i == 0) {
                        letraPlacar[i] = "|| " + palavraUsada.charAt(i);
                    }
                    else {
                        letraPlacar[i] = "" + palavraUsada.charAt(i);
                    }
                }
            }

            System.out.println();
            System.out.println(letraPlacar[0] + letraPlacar[1] + letraPlacar[2] + letraPlacar[3] + letraPlacar[4] + letraPlacar[5]);
            System.out.println("|| ______");
			
            if(fimPartida == true) {
                if(acertos == 6) {
                    System.out.print("Parabens. Voce acertou!");
                }
                else {
                    System.out.print("Voce errou! A resposta era " + (palavraUsada.charAt(0) + palavraUsada.charAt(1) + palavraUsada.charAt(2) + palavraUsada.charAt(3) + palavraUsada.charAt(4) + palavraUsada.charAt(5)));
                }
                sair = true;
            }

            try{

                if(fimPartida == false) {

                    System.out.print("Digite uma letra: ");
                    letraDigitada = scan.nextLine();

                    boolean achouLetra = false;

                    for (int i = 0; i < palavraUsada.length(); i++) {
                        if(letraDigitada.toUpperCase().equals("" + palavraUsada.charAt(i))) {
                            achouLetra = true;
                            
                            if(foiDigitado[i] == 0) {
                                acertos += 1;
                                foiDigitado[i] = 1; 
                            }
                            else if(foiDigitado[i] == 1) {
                                mensagem = "Letra já digitada. Insira outra.";
                            }
                        }
                    }

                    if(achouLetra == false) {
                        erros += 1;
                        if(erros < 6) {
                            mensagem = "A palavra nao possui esse caractere, tente novamente. Voce ainda tem mais " + (6 - erros) + " chances.";
                        }
                        else {
                            mensagem = "Suas chances acabaram.";
                        }
                    }
                }    
            }

            catch(Exception ex) {
                mensagem = "Erros na digitacao da possicao!!!";
				scan.nextLine();
            }

            if(acertos == 6 || erros == 6) {
                fimPartida = true;
            }

        } while(sair == false);

        scan.close();
    }
    
}