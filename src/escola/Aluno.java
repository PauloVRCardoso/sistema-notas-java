package escola;

public class Aluno {
	
	private static final double MEDIA_MINIMA = 7.0;
	private String nome;
	private double nota1;
	private double nota2;
	
	public Aluno(String nome, double nota1, double nota2) {
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double calcularMedia() {
		return (nota1 + nota2) / 2;
	}
	
	public boolean estaAprovado() {
		return calcularMedia() >= MEDIA_MINIMA;
	}

}
