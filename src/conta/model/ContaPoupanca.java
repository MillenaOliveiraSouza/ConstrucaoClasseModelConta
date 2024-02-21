package conta.model;

public class ContaPoupanca extends Conta {
	
	private String cpf;
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, String cpf) {
		
		super(numero, agencia, tipo, titular, saldo);

			this.cpf= cpf;
		
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		
		this.cpf = cpf;
		
	}
	
}
