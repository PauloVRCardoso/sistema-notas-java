package escola;
import java.util.ArrayList;

public class Turma {
	
	private String nome;
	private ArrayList<Aluno> alunos;
	private Professor professor;
	
	public Turma (Professor professor) {
		this("Turma A", professor);
	}
	
	public Turma(String nome, Professor professor) {
		this.nome = nome;
		this.professor = professor;
		this.alunos = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public ArrayList<Aluno> listarAlunos() {
		return new ArrayList<>(alunos);
	}

}
