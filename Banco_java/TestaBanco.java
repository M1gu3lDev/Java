package miguel.moura.banco;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class TestaBanco {
    public static void main(String [] agrs){
        BancoList meuBanco = new BancoList("Santos Farias'Bank", "123/321", new ArrayList<Conta>());
        String sair = "N";
        while (sair.equals("N")){
            int menu = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao Santos-Farias Bank escolha uma das opçôes a seguir: \n " +
                    "1- abrir conta\n 2- pesquisar conta com saldo negativo\n 3- consultar contas\n 4- entrar na conta"));
            switch (menu){
                case 1:
                    Random rand = new Random();
                    String cpf = JOptionPane.showInputDialog("abertura de conta: digite seu cpf");
                    String numConta = String.valueOf(rand.nextInt(10000, 99999));
                    String numAgencia = JOptionPane.showInputDialog("numero da agencia");
                    double saldoInicial = 100;
                    meuBanco.abrirConta(cpf, numConta, numAgencia, saldoInicial);
                    System.out.println("conta: "+numConta+" de angecia: "+numAgencia);
                    break;
                case 2:
                    System.out.println(meuBanco.pesquisarContasComSaldoNegativo());
                    break;
                case 3:
                    String cpfTitular = JOptionPane.showInputDialog("digite seu cpf");
                    System.out.println(meuBanco.pesquisarContasDoCliente(cpfTitular));
                    break;
                case 4:
                    String numConta2 = JOptionPane.showInputDialog("digite o numero da conta");
                    String numeroAgencia2 = JOptionPane.showInputDialog("digite a agencia");
                    int menu2 = Integer.parseInt(JOptionPane.showInputDialog("Achei sua conta! agora qual opção deseja fazer? \n 1- depositar\n 2- sacar\n 3- trasnferir \n 4- consultar saldo"));
                    switch (menu2){
                        case 1:
                            double deposito = Integer.parseInt(JOptionPane.showInputDialog("quanto deseja depositar?"));
                            double saldoDeposito = meuBanco.depositarEmConta(numConta2, numeroAgencia2, deposito);
                            System.out.println("deposito concluido seu saldo atual é de "+saldoDeposito+" R$");
                            break;
                        case 2:
                            double saque = Integer.parseInt(JOptionPane.showInputDialog("quanto deseja sacar?"));
                            double saldoSaque = meuBanco.sacarDeConta(numConta2, numeroAgencia2, saque);
                            System.out.println("saque concluido seu saldo atual é de "+saldoSaque+" R$");
                            break;
                        case 3:
                            String numContaR = JOptionPane.showInputDialog("conta a receber");
                            String numAgenciaR = JOptionPane.showInputDialog("numero da agencia a receber");
                            int transferencia = Integer.parseInt(JOptionPane.showInputDialog("quanto deseja transferir?"));
                            meuBanco.transferir(numContaR, numAgenciaR, numConta2, numeroAgencia2, transferencia);
                            System.out.println("Transferencia concluida");
                            break;
                        case 4:
                            double saldo = meuBanco.consultarSaldoDeConta(numConta2, numeroAgencia2);
                            System.out.println(saldo);
                            break;
                    }
            }
        }

            }
}
