
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static Scanner leitor;
    public static void menu() throws ParseException {


        leitor = new Scanner(System.in);
        int opcao = 0;
        System.out.println("1 - Cadastrar conta");
        System.out.println("2 - Visualizar saldo");
        System.out.println("3 - Depositar valor");
        System.out.println("4 - Sacar valor");
        System.out.println("100 - Sair.");
        try{
            opcao = leitor.nextInt();

        }catch (InputMismatchException i){
            System.out.println("Ocorreu um erro..." +
                    "Escolha uma opção válida!");
            menu();

        }

        switch (opcao) {
            case 1:
                int tipo = 0;
                System.out.println("1- Conta Corrente");
                System.out.println("2- Conata Poupança");
                try{
                    tipo = leitor.nextInt();

                }catch (InputMismatchException i){
                    while(tipo!=1 || tipo !=2){
                        System.out.println("Ocorreu um erro..." +
                                "Escolha uma opção válida!");
                        tipo = leitor.nextInt();

                    };


                }

                if(tipo == 1){
                    CreateAccount.CadastrarContaCorrente();

                } else if (tipo == 2) {
                    CreateAccount.CadastrarContaPoupanca();

                }
                else{
                    System.out.println("Opção invalida!");
                    menu();

                }


                break;
            case 2:
                Operations.visualizarSaldo();

                break;
            case 3:
                Operations.depositar();

                break;
            case 4:
                Operations.sacar();

                break;
            case 100:
                CreateAccount.jurosDevedor(0.6f);
                CreateAccount.rendimento(0.5f);
                System.exit(0);
                break;
            default:
                System.out.println("Opção invalida.");
                menu();
                break;
        }

    }
    public static void main(String[] args) throws ParseException {


        menu();



    }


}
