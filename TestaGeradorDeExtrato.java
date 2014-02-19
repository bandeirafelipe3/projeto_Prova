
public class TestaGeradorDeExtrato {
	public static void main(String[] args) {
		ContaCorrente c1 = new ContaCorrente();
		ContaPoupanca c2 = new ContaPoupanca();
		
		c1.deposita(1000);
		c2.deposita(500);
		
		GeradorDeExtrato g = new GeradorDeExtrato();
		g.geraExtrato(c1);
		g.geraExtrato(c2);
	}

}
