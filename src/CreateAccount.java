import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Calendar;
import java.util.Date;

public class CreateAccount{

    public static ArrayList<Account> accounts = new ArrayList<>();




    public static void CadastrarContaCorrente() throws ParseException {
        try{
            System.out.println("Informe o CPF:");
            int cpf = Main.leitor.nextInt();
            System.out.println("Informe o nome:");
            Main.leitor.nextLine();
            String nome = Main.leitor.nextLine();
            System.out.println("Informe o endereço:");
            String endereco = Main.leitor.nextLine();
            System.out.println("Informe a profissão:");
            String profissao = Main.leitor.nextLine();
            System.out.println("Informe o limite:");
            float limite = Main.leitor.nextFloat();
            String tipo = "Corrente";
            int numeroConta = accounts.size()+1;
            System.out.println("Informe a agência:");
            int agencia = Main.leitor.nextInt();
            float saldo = 0f;

            Account account = new Account(cpf, nome, endereco, profissao, tipo, numeroConta, agencia, saldo);

            account.setLimite(limite);

            System.out.println("Dados da conta" +
                    "\nNome:" + nome +
                    "\nCPF:" + cpf +
                    "\nEndereço: " + endereco +
                    "\nProfissão: " + profissao +
                    "\nConfirma?" +
                    "\n1-Sim | 2-Não");

            int confirmar = Main.leitor.nextInt();

            if(confirmar==1){
                System.out.println("Conta cadastrada com sucesso!");
                accounts.add(account);
                System.out.println("Número da conta: " + accounts.get(numeroConta-1).getNumeroConta());
                System.out.println("Agência: " + accounts.get(numeroConta-1).getAgencia());
                Main.menu();

            } else if (confirmar==2){
                System.out.println("Conta não cadastrada.");
                Main.menu();

            }
            else{
                System.out.println("Opção inválida!");
                Main.menu();
            }

        } catch (InputMismatchException i){
            System.out.println("Ocorreu um erro!");
            Main.menu();

        }




    }

    public static void CadastrarContaPoupanca() throws ParseException {

        try{
            System.out.println("Informe o CPF(Somente os números):");
            int cpf = Main.leitor.nextInt();
            System.out.println("Informe o nome:");
            Main.leitor.nextLine();
            String nome = Main.leitor.nextLine();
            System.out.println("Informe o endereço:");
            String endereco = Main.leitor.nextLine();
            System.out.println("Informe a profissão:");
            String profissao = Main.leitor.nextLine();
            String tipo = "Poupança";
            int numeroConta = accounts.size()+1;
            System.out.println("Informe a agência:");
            int agencia = Main.leitor.nextInt();
            float saldo = 0f;

            Account account = new Account(cpf, nome, endereco, profissao, tipo, numeroConta, agencia, saldo);

            System.out.println("Dados da conta" +
                    "\nNome:" + nome +
                    "\nCPF:" + cpf +
                    "\nEndereço: " + endereco +
                    "\nProfissão: " + profissao +
                    "\nTipo: " + tipo +
                    "\nConfirma?" +
                    "\n1-Sim | 2-Não");
            int confirmar = Main.leitor.nextInt();

            if(confirmar==1){
                System.out.println("Conta cadastrada com sucesso!");
                accounts.add(account);
                System.out.println("Número da conta: " + accounts.get(numeroConta-1).getNumeroConta());
                System.out.println("Agência: " + accounts.get(numeroConta-1).getAgencia());
                Main.menu();
            } else if (confirmar==2){
                System.out.println("Conta não cadastrada.");
                Main.menu();

            }
            else{
                System.out.println("Opção inválida!");
                Main.menu();
            }

        } catch (InputMismatchException i){
            System.out.println("Ocorreu um erro!");
            Main.menu();

        }



    }

    public static void rendimento(float taxa) throws ParseException {


        taxa = taxa/100;


        for (int i = 0; i < accounts.size(); i++) {
            Account a = accounts.get(i);

            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dataFormatada.parse(a.getDataCalculoJuros());
            Date today = new Date();
            date.setDate(date.getDate() + 30);


            if(a.getTipo()=="Poupança"){

                if(a.getSaldo()>0){

                    if(dataFormatada.format(today) == dataFormatada.format(date)){

                        a.setSaldo(a.getSaldo()+(a.getSaldo()*taxa));
                    }
                }


            }


        }

    }

    public static void jurosDevedor(float taxa) throws ParseException {



        taxa = taxa/100;


        for (int i = 0; i < accounts.size(); i++) {
            Account a = accounts.get(i);
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dataFormatada.parse(a.getDataCalculoJuros());
            Date today = new Date();
            date.setDate(date.getDate() + 30);



            if(a.getTipo()=="Corrente"){
                if(a.getSaldo()<0){
                    if(dataFormatada.format(today) == dataFormatada.format(date)){
                        a.setSaldo(a.getSaldo()+(a.getSaldo()*taxa));
                    }
                }


            }


        }

    }



}
