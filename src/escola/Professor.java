package escola;

public class Professor extends Pessoa{
	
	private String materia;
	
	public Professor(String nome, String materia) {
		super(nome);
		this.materia = materia;
	}
	
	public String getMateria() {
		return materia;
	}
	
	@Override
	public void exibirDados() {
		System.out.println("Professor responsável: " + getNome());
		System.out.println("Matéria: " + getMateria());
	}

}
