import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Sistema de Biblioteca ---");
                System.out.println("1. Cadastrar Livro");
                System.out.println("2. Listar Livros");
                System.out.println("3. Buscar Livro");
                System.out.println("4. Emprestar Livro");
                System.out.println("5. Devolver Livro");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opcao: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        System.out.println("Titulo: ");
                        String titulo = scanner.nextLine();
                        System.out.println("Autor:");
                        String autor = scanner.nextLine();
                        System.out.println("Ano: ");
                        int ano = scanner.nextInt();
                        livros.add(new Livro(titulo, autor, ano));
                        System.out.println("Livro adicionado com sucesso! ");
                        break;

                    case 2:
                        for (Livro livro : livros) {
                            System.out.println("Titulos: " + livro.titulo + ", Autor: " + 
                            livro.autor + ", Ano: " + livro.ano + ", Disponivel: " + 
                            (livro.disponivel? "Sim" : "Nao"));
                        }   
                        break;

                    case 3:
                        System.out.println("Digite o titulo ou autor para bsucar: ");
                        String busca = scanner.nextLine();
                        for (Livro livro : livros) {
                            if (livro.titulo.equalsIgnoreCase(busca) || livro.autor.equalsIgnoreCase
                            (busca)) {
                                System.out.println("Titulo: " + livro.titulo + ", Autor: " + livro.autor
                                 + ", Ano: " + livro.ano + ", Disponivel: " + (livro.disponivel ? "Sim" : "Nao "));
                                
                            }
                        }
                        break;

                    case 4:
                    System.out.println("Digite o titulo do livro para emprestar: ");
                    String tituloEmprestimo = scanner.nextLine();
                    for (Livro livro : livros) {
                        if (livro.titulo.equalsIgnoreCase(tituloEmprestimo)) {
                            if (livro.disponivel) {
                                livro.disponivel = false;
                                System.out.println("Livro emprestado com sucesso! ");
                            } else {
                                System.out.println("Livro ja esta empestado! ");
                            }
                            
                        }
                    }
                        break;

                    case 5:
                    System.out.println("Digite o titulo do livro para devolver: ");
                    String tituloDevolucao = scanner.nextLine();
                    for (Livro livro : livros) {
                        if (livro.titulo.equalsIgnoreCase(tituloDevolucao)) {
                            if (!livro.disponivel) {
                                livro.disponivel = true;
                                System.out.println("Livro devolvido com sucesso! ");   
                            } else {
                                System.out.println("Livro já esta disponivel! ");
                            }
                            
                        }
                    }
                      break;

                    case 6:
                    System.out.println(" Saindo do sistema ....");  
                    scanner.close();
                    return;

                    default:
                    System.out.println("opção invalida! ");


                }
            }
        }
    }
}
