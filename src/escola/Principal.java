package escola;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite o nome do professor:");
		String nomeProfessor = teclado.nextLine();
		
		System.out.println("Digite a matéria que o professor leciona:");
		String materia = teclado.nextLine();
		
		//Cria os objetos
		Professor professor = new Professor(nomeProfessor, materia);
		Turma turma = new Turma("Turma A", professor);
		
		int opcao = -1;
		
		// Menu principal
		while (opcao != 0) {
			
			String nomeAluno;
			double nota1;
			double nota2;
			
			System.out.println();
			System.out.println("======== SISTEMAS DE NOTAS ========");
			System.out.println("1 - Cadastrar aluno");
			System.out.println("2 - Listar alunos");
			System.out.println("3 - Consultar aluno");
			System.out.println("4 - Exibir estatisticas");
			System.out.println("5 - Listar ordem inversa");
			System.out.println("0 - Sair");
			System.out.println("==================================");
			
			opcao = teclado.nextInt();
			teclado.nextLine();
			
			switch (opcao) {
			
				case 1:
					
					//Cadastrar aluno
					System.out.println("Digite o nome do Aluno");
					nomeAluno = teclado.nextLine();
					
					
					// Ler e validar a primeira nota
					System.out.println("Digite a primeira nota");
					nota1 = teclado.nextDouble();
					
					while (nota1 < 0 || nota1 > 10) {
						
						System.out.println("Nota invalida! Digite novamente:");
						nota1 = teclado.nextDouble();
					}
					
					// Ler e validar a segunda nota
					System.out.println("Digite a segunda nota");
					nota2 = teclado.nextDouble();
					
					while (nota2 < 0 || nota2 > 10) {
						
						System.out.println("Nota invalida! Digite novamente:");
						nota2 = teclado.nextDouble();
					}
					
					//Criar o aluno com os dados digitados
					Aluno alunoCadastrado = new Aluno(nomeAluno, nota1, nota2);
					turma.adicionarAluno(alunoCadastrado);
					
					
					// Situação com operador ternário
					String situacao = alunoCadastrado.estaAprovado() ? "Aprovado" : "Reprovado";
					
					// Mostra o resultado
					System.out.println("Aluno cadastrado com sucesso");
					System.out.printf("Média: %.2f%n", alunoCadastrado.calcularMedia());
					System.out.println("Situação: " + situacao);
					
					break;
				
				case 2: {
					ArrayList<Aluno> alunos = turma.listarAlunos();
					
					// Listar alunos
					System.out.println("=== ALUNOS CADASTRADOS - " + turma.getNome() + " ===");
					
					Professor professorResponsavel = turma.getProfessor();
					
					System.out.println("Professor responsável: " + professorResponsavel.getNome());
					System.out.println("Matéria: " + professorResponsavel.getMateria());
					
					if (alunos.isEmpty()) {
						System.out.println("Nenhum aluno cadastrado!");
					} else {
						
						for (Aluno aluno : alunos) {
							exibirNomeEMedia(aluno);
							
							String resultado = aluno.estaAprovado() ? "Aprovado" : "Reprovado";
							
							System.out.println("Situação: " + resultado);
							System.out.println("-------------------------");
						}
					}
					
				break;
				}
				
				case 3: {
					ArrayList<Aluno> alunos = turma.listarAlunos();
					
					//Consultar aluno
					System.out.println("Digite o nome do aluno: ");
					String alunoProcurado = teclado.nextLine();
					Aluno alunoEncontrado = null;
					
					Iterator<Aluno> iterador = alunos.iterator();					
					while (iterador.hasNext()) {
						Aluno aluno = (Aluno) iterador.next();
					
						if (aluno.getNome().equals(alunoProcurado)) {
							alunoEncontrado = aluno;
                            break;                        
						}
					}
						
						if (alunoEncontrado == null) {
							System.out.println("Aluno não encontrado!");
						} else {
							System.out.println("Aluno encontrado!");
							System.out.println("Nome: " + alunoEncontrado.getNome());
							System.out.printf("Média: %.2f%n", alunoEncontrado.calcularMedia());
						}
					break;
				}
							
				case 4: {
					ArrayList<Aluno> alunos = turma.listarAlunos();
					
					//Estatisticas
					if (alunos.isEmpty()) {
						System.out.println("Nenhum aluno cadastrado!");
					} else {						
						double somaMedias = 0;
						int aprovados = 0;
						int reprovados = 0;
						
						for (Aluno aluno : alunos) {	
							somaMedias += aluno.calcularMedia();							
							if (aluno.estaAprovado()) {								
								aprovados++;								
							} else {							
								reprovados++;
							}
						}
						
						double mediaGeral = somaMedias / alunos.size();
						
						System.out.println("=== ESTATISTICAS ===");
						System.out.println("Total de alunos: " + alunos.size());
						System.out.println("Aprovados: " + aprovados);
						System.out.println("Reprovados: " + reprovados);
						System.out.printf("Média geral: %.2f%n", mediaGeral);
					}
					
					break;
				}
				
				case 5: {
					
					//Listas ordem reversa
					System.out.println("=== ORDEM INVERSA ===");
					ArrayList<Aluno> alunosInversos = turma.listarAlunos();
					
					if (alunosInversos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado!");
                    } else {                       
                        Collections.reverse(alunosInversos);

                        for (Aluno aluno : alunosInversos) {
                        	exibirNomeEMedia(aluno);
                        }
                    }
					
					break;
				}
					
				case 0:
					
					//Encerrar sistema
					System.out.println("Encerrando o sistema...");
					break;
					
				default:		
					System.out.println("Opção invalida!");			
			}
		}	
		
		teclado.close();
		
	}
	
	private static void exibirNomeEMedia(Aluno aluno) {
		System.out.println("Aluno: " + aluno.getNome());
		System.out.printf("Média: %.2f%n", aluno.calcularMedia());
		
	}
}
