
public class TestaContas {
	public static void main(String[] args) {
		ContaCorrente c1 = new ContaCorrente();
		ContaPoupanca c2 = new ContaPoupanca();
		
		c1.deposita(1000);
		c2.deposita(500);
		
		c1.saca(500);
		c2.saca(250);
		
		System.out.println(c1.getSaldo());
		System.out.println(c2.getSaldo());
	}

}
