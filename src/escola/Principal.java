package escola;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		// Cria as listas
		ArrayList<String> nomes = new ArrayList<>();
		ArrayList<Double> medias = new ArrayList<>();
		
		int opcao = -1;
		
		// Menu principal
		while (opcao != 0) {
			
			String nomeAluno;
			double nota1;
			double nota2;
			double media;
			
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
					
					// Cálculo da média
					media = (nota1 + nota2) / 2;
					
					// Armazenar nas listas
					nomes.add(nomeAluno);
					medias.add(media);
					
					// Situação com operador ternário
					String situacao = media >= 7 ? "Aprovado" : "Reprovado";
					
					// Mostra o resultado
					System.out.println("Aluno cadastrado com sucesso");
					System.out.printf("Média: %.2f%n", media);
					System.out.println("Situação" + situacao);
					
					break;
				
				case 2:
					
					// Listar alunos
					System.out.println("=== ALUNOS CADASTRADOS ===");
					
					if (nomes.size() == 0) {
						System.out.println("Nenhum aluno cadastrado!");
					} else {
						
						for (int i = 0; i < nomes.size(); i++) {
							
							System.out.println("Aluno: " + nomes.get(i));
							System.out.printf("Média: %.2f%n", medias.get(i));
							
							String resultado = medias.get(i) >= 7 ? "Aprovado" : "Reprovado";
							
							System.out.println("Situação: " + resultado);
							System.out.println("-------------------------");
						}
					}
					
				break;
				
				case 3:
					
					//Consultar aluno
					System.out.println("Digite o nome do aluno: ");
					String alunoProcurado = teclado.nextLine();
					
					if (nomes.contains(alunoProcurado)) {
						
						for (int i = 0; i < nomes.size(); i++) {
							
							if (nomes.get(i).equals(alunoProcurado)) {
								
								System.out.println("Aluno encontrado!");
                                System.out.println("Nome: " + nomes.get(i));
                                System.out.printf("Media: %.2f%n", medias.get(i));
                                
                                break;
								
							}
						}
					} else {
						System.out.println("Aluno não encotrado!");
					}
				
				break;
				
				case 4:
					
					//Estatisticas
					if (nomes.size() == 0) {
						
						System.out.println("Nenhum aluno cadastrado!");
						
					} else {
						
						double somaMedias = 0;
						int aprovados = 0;
						int reprovados = 0;
						
						for (int i = 0; i < medias.size(); i++) {
							
							double mediaAluno = medias.get(i);
							
							somaMedias += mediaAluno;
							
							if (mediaAluno >= 7) {								
								aprovados++;								
							} else {							
								reprovados++;
							}
						}
						
						double mediaGeral = somaMedias / medias.size();
						
						System.out.println("=== ESTATISTICAS ===");
						System.out.println("Total de alunos: " + nomes.size());
						System.out.println("Aprovados: " + aprovados);
						System.out.println("Reprovados: " + reprovados);
						System.out.printf("Médias geral: %.2f%n", mediaGeral);
					}
					
					break;
					
				case 5:
					
					//Listas ordem reversa
					System.out.println("=== ORDEM INVERSA ===");
					
					if (nomes.size() == 0) {

                        System.out.println("Nenhum aluno cadastrado!");

                    } else {

                        // Criar copias para preservar a ordem original
                        ArrayList<String> nomesInversos =
                                new ArrayList<>(nomes);

                        ArrayList<Double> mediasInversas =
                                new ArrayList<>(medias);

                        Collections.reverse(nomesInversos);
                        Collections.reverse(mediasInversas);

                        for (int i = 0; i < nomesInversos.size(); i++) {

                            System.out.println("Aluno: " + nomesInversos.get(i));

                            System.out.printf(
                                    "Media: %.2f%n",
                                    mediasInversas.get(i)
                            );
                        }
                    }
					
					break;
					
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
}
