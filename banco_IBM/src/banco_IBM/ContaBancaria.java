package banco_IBM;

public class ContaBancaria {
	private String numeroDaConta;
	private Double saldo;
	private Cliente titular;
	
	
	public ContaBancaria(String numeroDaConta, Double saldo, Cliente titular) {
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
		this.titular = titular;
	}
	
	public String getNumeroConta() {
        return numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
    	return titular;
    }
    

    public void sacar(double valor) {
        try {
            if (this.saldo < valor) {
                throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
            }
            this.saldo -= valor;
            System.out.printf("Saque de %.2f realizado com sucesso. Novo saldo: %.2f \n", valor, saldo);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.printf("Valor de %.2f depositado na conta de número %s \n", valor, this.numeroDaConta);
    }
    
    public void transferir(ContaBancaria origem, ContaBancaria destino, double valor) {
        try {
            if (origem.getSaldo() < valor) {
                throw new SaldoInsuficienteException("Saldo insuficiente para realizar a transferência.");
            }
            origem.sacar(valor);
            destino.depositar(valor);
            System.out.printf("Transferência de: R$ %.2f da conta %s para a conta %s realizada com sucesso.\n"
            		, valor, origem.getNumeroConta(), destino.getNumeroConta());
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}

