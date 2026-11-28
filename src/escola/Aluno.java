package escola;

public class Aluno extends Pessoa{
	
	private static final double MEDIA_MINIMA = 7.0;
	private double nota1;
	private double nota2;
	
	public Aluno(String nome) {
		super(nome);
	}
	
	public double calcularMedia() {
		return (nota1 + nota2) / 2;
	}
	
	public boolean estaAprovado() {
		return calcularMedia() >= MEDIA_MINIMA;
	}
	
	public SituacaoAluno obterSituacao() {
		if (estaAprovado()) {
			return SituacaoAluno.APROVADO;
		} else {
			return SituacaoAluno.REPROVADO;
		}
	}
	
	@Override
	public void exibirDados() {
		System.out.println("Aluno: " + getNome());
		System.out.printf("Média: %.2f%n", calcularMedia());
		
		SituacaoAluno situacao = obterSituacao();
		System.out.println("Situação: " + situacao);
	}
	
	@Override
	public String toString() {
		return  "Aluno: " + getNome() + "\n" +
				"Média: " + calcularMedia() + "\n" +
				"Situação: " + obterSituacao();
	}
	
	public void setNota1(double valor) throws NotaInvalidaException {
		if (valor >= 0 && valor <= 10) {
			this.nota1 = valor; 
		} else { 
			throw new NotaInvalidaException("Nota inválida! Digite um valor entre 0 e 10");
		}
	}
	
	public void setNota2(double valor)  throws NotaInvalidaException{
		if (valor >= 0 && valor <= 10) {
			this.nota2 = valor; 
		} else {
			throw new NotaInvalidaException("Nota inválida! Digite um valor entre 0 e 10");
		}
	}

}
