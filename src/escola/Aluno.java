package escola;

public class Aluno extends Pessoa{
	
	private static final double MEDIA_MINIMA = 7.0;
	private double nota1;
	private double nota2;
	
	public Aluno(String nome, double nota1, double nota2) {
		super(nome);
		setNota1(nota1);
		setNota2(nota2);
	}
	
	public double calcularMedia() {
		return (nota1 + nota2) / 2;
	}
	
	public boolean estaAprovado() {
		return calcularMedia() >= MEDIA_MINIMA;
	}
	
	public void setNota1(double valor) {
		if (valor >= 0 && valor <= 10) {
			this.nota1 = valor; 
		} else {
			System.out.println("Nota inválida! Digite um valor entre 0 e 10");
		}
	}
	
	public void setNota2(double valor) {
		if (valor >= 0 && valor <= 10) {
			this.nota2 = valor; 
		} else {
			System.out.println("Nota inválida! Digite um valor entre 0 e 10");
		}
	}

}
