package miguel.moura.banco;
import java.util.ArrayList;
public class BancoList {
    private String nome;
    private String cnpj;
    private ArrayList<Conta> contas;

    public BancoList(String nome, String cnpj, ArrayList<Conta> contas) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contas = contas;
    }

    public String toString() {
        return "Banco " + this.nome + " de CNPJ " + this.cnpj + " e que tem " + this.contas.size() + " contas";
    }
    public void transferir(String numContaR, String numAgR, String numContaD, String numAgD, double valor) {
        for (Conta c : contas){
            if (c.getNumeroConta().equals(numContaR) && c.getNumeroAgencia().equals(numAgR)){
                    c.creditar(valor);
            }
            if (c.getNumeroConta().equals(numContaD) && c.getNumeroAgencia().equals(numAgD)){
                c.debitar(valor);
            }
        }
        System.out.println("Transferencia concluida "+valor+" R$ enviados da conta "+numAgD+" para "+numAgR);
    }

    public void abrirConta(String cpfTitular, String numConta, String numAgencia, double saldoInicial) {
        Conta conta = new Conta(cpfTitular, numConta, numAgencia, saldoInicial);
        contas.add(conta);

    }

    public ArrayList<Conta> pesquisarContasComSaldoNegativo() {
        ArrayList<Conta> saldoNegativo = new ArrayList<>();
        for(int k=0;k<contas.size();k++){
            if (contas.get(k).getSaldo() < 0){
                saldoNegativo.add(contas.get(k));


            }
        }
        return saldoNegativo;
    }

    public double consultarSaldoDeConta(String numConta, String numAgencia) {
        double saldo = 0;
        for (Conta c : this.contas) {
            if (c.getNumeroConta().equals(numConta) && c.getNumeroAgencia().equals(numAgencia)) {
                saldo = c.getSaldo();
            }
        }
        return saldo;
    }
    public double sacarDeConta(String numConta, String numAgencia, double valor) {
        double saldo = 0.0;
        for (Conta c : this.contas){
            if (c.getNumeroConta().equals(numConta) && c.getNumeroAgencia().equals(numAgencia)){
                c.debitar(valor);
                saldo  = c.getSaldo();
            }
        }
        return saldo;
    }

    public double depositarEmConta(String numConta, String numAgencia, double valor) {
        double saldo = 0.0;
        for (Conta c : this.contas){
            if (c.getNumeroConta().equals(numConta) && c.getNumeroAgencia().equals(numAgencia)){
                c.creditar(valor);
                saldo = c.getSaldo();
            }
        }
        return saldo;
    }

    public ArrayList<Conta> pesquisarContasDoCliente(String cpf) {
        ArrayList<Conta> contasDoCliente = new ArrayList<Conta>();
        for (Conta c : contas){
            if (c.getCpfTitular().equals(cpf)){
                contasDoCliente.add(c);
            }
        }
        return contasDoCliente;
    }
}
