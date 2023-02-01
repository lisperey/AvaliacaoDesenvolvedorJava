import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class Operations {
    public static void visualizarSaldo() throws ParseException {
        System.out.println("|Visualizar Saldo|");
        try{
            System.out.println("Informe o número da conta.");
            int numeroConta = Main.leitor.nextInt();
            numeroConta= numeroConta -1;
            System.out.println("Informe o número da agência.");
            int agencia = Main.leitor.nextInt();

            if(CreateAccount.accounts.get(numeroConta).getAgencia() == agencia){
                System.out.println("Conta " + CreateAccount.accounts.get(numeroConta).getTipo());
                System.out.println("Nome: " + CreateAccount.accounts.get(numeroConta).getNome());
                System.out.println("Número da Conta: " + CreateAccount.accounts.get(numeroConta).getNumeroConta());
                System.out.println("Agência: " + CreateAccount.accounts.get(numeroConta).getAgencia());
                System.out.println("Saldo em conta: " + CreateAccount.accounts.get(numeroConta).getSaldo());
                Main.menu();

            }
            else{
                System.out.println("Conta não encontrada!");
                visualizarSaldo();
            }

        } catch (InputMismatchException i){
            System.out.println("Ocorreu um erro!");
            Main.menu();

        }



    }

    public static void sacar() throws ParseException {
        System.out.println("|Sacar Valor|");

        try{
            System.out.println("Informe o número da conta.");
            int numeroConta = Main.leitor.nextInt();
            numeroConta= numeroConta -1;
            System.out.println("Informe o número da agência.");
            int agencia = Main.leitor.nextInt();

            if(CreateAccount.accounts.get(numeroConta).getAgencia() == agencia){
                System.out.println("Conta " + CreateAccount.accounts.get(numeroConta).getTipo());
                System.out.println("Nome: " + CreateAccount.accounts.get(numeroConta).getNome());
                System.out.println("Número da Conta: " + CreateAccount.accounts.get(numeroConta).getNumeroConta());
                System.out.println("Agência: " + CreateAccount.accounts.get(numeroConta).getAgencia());
                System.out.println("Saldo em conta: " + CreateAccount.accounts.get(numeroConta).getSaldo());

                System.out.println("Informe o valor que deseja sacar:");
                float valorSacar = Main.leitor.nextFloat();

                switch (CreateAccount.accounts.get(numeroConta).getTipo()){
                    case "Poupança":

                        while (valorSacar > CreateAccount.accounts.get(numeroConta).getSaldo()){
                            System.out.println("Valor indisponível para saque...");
                            System.out.println("Tente outro valor!");
                            valorSacar = Main.leitor.nextFloat();

                        }

                        CreateAccount.accounts.get(numeroConta).setSaldo(CreateAccount.accounts.get(numeroConta).getSaldo()-valorSacar);
                        System.out.println("Processando...");
                        System.out.println("Novo saldo: " + CreateAccount.accounts.get(numeroConta).getSaldo());
                        Main.menu();
                        break;

                    case "Corrente":

                        while (valorSacar > (CreateAccount.accounts.get(numeroConta).getSaldo()+CreateAccount.accounts.get(numeroConta).getLimite())){
                            System.out.println("Valor indisponível para saque...");
                            System.out.println("Tente outro valor!");
                            valorSacar = Main.leitor.nextFloat();

                        }

                        CreateAccount.accounts.get(numeroConta).setSaldo(CreateAccount.accounts.get(numeroConta).getSaldo()-valorSacar);
                        System.out.println("Processando...");
                        if(CreateAccount.accounts.get(numeroConta).getSaldo()<0){
                            Date today = new Date();
                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                            CreateAccount.accounts.get(numeroConta).setDataCalculoJuros(formato.format(today));
                        }
                        System.out.println("Novo saldo: " + CreateAccount.accounts.get(numeroConta).getSaldo());
                        Main.menu();


                        break;
                }

            }
            else{
                System.out.println("Conta não encontrada!");
                sacar();
            }

        } catch (InputMismatchException i){
            System.out.println("Ocorreu um erro!");
            Main.menu();

        }




    }

    public static void depositar() throws ParseException {
        System.out.println("|Depositar Valor|");
        try{
            System.out.println("Informe o número da conta.");
            int numeroConta = Main.leitor.nextInt();
            numeroConta= numeroConta -1;

            System.out.println("Informe o número da agência.");
            int agencia = Main.leitor.nextInt();

            if(CreateAccount.accounts.get(numeroConta).getAgencia() == agencia){
                System.out.println("Conta " + CreateAccount.accounts.get(numeroConta).getTipo());
                System.out.println("Nome: " + CreateAccount.accounts.get(numeroConta).getNome());
                System.out.println("Número da Conta: " + CreateAccount.accounts.get(numeroConta).getNumeroConta());
                System.out.println("Agência: " + CreateAccount.accounts.get(numeroConta).getAgencia());
                System.out.println("Saldo em conta: " + CreateAccount.accounts.get(numeroConta).getSaldo());

                System.out.println("Informe o valor que deseja depositar:");
                float valorDepositar = Main.leitor.nextFloat();

                switch (CreateAccount.accounts.get(numeroConta).getTipo()){
                    case "Poupança":

                        while (valorDepositar < 0){
                            System.out.println("Valor inválido...");
                            System.out.println("Tente outro valor!");
                            valorDepositar = Main.leitor.nextFloat();

                        }

                        CreateAccount.accounts.get(numeroConta).setSaldo(CreateAccount.accounts.get(numeroConta).getSaldo()+valorDepositar);
                        Date today = new Date();
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        CreateAccount.accounts.get(numeroConta).setDataCalculoJuros(formato.format(today));


                        System.out.println("Processando...");
                        System.out.println("Novo saldo: " + CreateAccount.accounts.get(numeroConta).getSaldo());
                        Main.menu();
                        break;

                    case "Corrente":

                        while (valorDepositar < 0){
                            System.out.println("Valor inválido...");
                            System.out.println("Tente outro valor!");
                            valorDepositar = Main.leitor.nextFloat();

                        };

                        CreateAccount.accounts.get(numeroConta).setSaldo(CreateAccount.accounts.get(numeroConta).getSaldo()+valorDepositar);
                        System.out.println("Processando...");
                        System.out.println("Novo saldo: " + CreateAccount.accounts.get(numeroConta).getSaldo());
                        Main.menu();


                        break;
                }


            }
            else{
                System.out.println("Conta não encontrada!");
                depositar();
            }

        } catch (InputMismatchException i){
            System.out.println("Ocorreu um erro!");
            Main.menu();

        }


    }




}
