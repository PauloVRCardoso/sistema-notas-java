package escola;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		try {
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
						
						Aluno alunoCadastrado = new Aluno(nomeAluno);
										
						// Ler e validar a primeira nota
						boolean nota1Valida = false;
						
						
						while (!nota1Valida) {
							
							System.out.println("Digite a promeira nota: ");
							nota1 = teclado.nextDouble();
							
							try {
								alunoCadastrado.setNota1(nota1);
								nota1Valida = true;
							} catch (NotaInvalidaException e) {
								System.out.println(e.getMessage());
							}
						}
						
						// Ler e validar a segunda nota
						boolean nota2Valida = false;
						
						while (!nota2Valida) {
							
							System.out.println("Digite a segunda nota: ");
							nota2 = teclado.nextDouble();
							
							try {
								alunoCadastrado.setNota2(nota2);
								nota2Valida = true;
							} catch (NotaInvalidaException e) {
								System.out.println(e.getMessage());
							}
						}
						
						// Adicionar o aluno depois que as duas notas forem válidas	
						turma.adicionarAluno(alunoCadastrado);
						
						
						// Situação com operador ternário
						SituacaoAluno situacao = alunoCadastrado.obterSituacao();
						
						// Mostra o resultado
						System.out.println("Aluno cadastrado com sucesso");
						System.out.printf("Média: %.2f%n", alunoCadastrado.calcularMedia());
						System.out.println("Situação: " + situacao);
						
						break;
					
					case 2: {
						ArrayList<Aluno> alunos = turma.listarAlunos();
						ArrayList<Pessoa> pessoas = turma.listarPessoas();
						
						// Listar alunos
						System.out.println("=== ALUNOS CADASTRADOS - " + turma.getNome() + " ===");
						
						for (Pessoa pessoa : pessoas) {
							pessoa.exibirDados();
							System.out.println("-------------------------");
						}
						
						if (alunos.isEmpty()) {
							System.out.println("Nenhum aluno cadastrado!");
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
								System.out.println("Aluno Encontrado!");
								System.out.println(alunoEncontrado);
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
		} finally {	
			teclado.close();
			}			
	}
	
	private static void exibirNomeEMedia(Aluno aluno) {
		System.out.println("Aluno: " + aluno.getNome());
		System.out.printf("Média: %.2f%n", aluno.calcularMedia());
		
	}
}
