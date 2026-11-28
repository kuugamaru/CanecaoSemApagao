import java.util.Scanner;

import dao.GestorDAO;
import dao.OcorrenciaDAO;
import dao.UsuarioDAO;
import models.Gestor;
import models.Ocorrencia;
import models.Usuario;

public class main {
    public static void main(String[] args) {
        OcorrenciaDAO ocorrenciaDAO = new OcorrenciaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        GestorDAO gestorDAO = new GestorDAO();
         Scanner scanner = new Scanner(System.in);

        // MENU SIMPLES
        int answer = -1;
        while (answer != 0) {
            
            System.out.println("============ MENU ============");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Cadastrar Gestor");
            System.out.println("3. Cadastrar Ocorrência");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Listar Gestores");
            System.out.println("6. Listar Ocorrências");
            System.out.println("0. Sair");
            answer = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            switch (answer) {
                case 1:
                    // Cadastrar Usuário
                    Usuario usuario = new Usuario();
                    System.out.println("Digite o nome do usuário:");
                    String nomeUsuario = scanner.nextLine();
                    usuario.setNome(nomeUsuario);
                    System.out.println("Digite o email do usuário:");
                    String emailUsuario = scanner.nextLine();
                    usuario.setEmail(emailUsuario);
                    try {
                        int idUsuario = usuarioDAO.cadastrar(usuario);
                        System.out.println("Usuário cadastrado com sucesso! ID: " + idUsuario);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                    }
                    break;
                case 2:
                    // Cadastrar Gestor
                    Gestor gestor = new Gestor();
                    System.out.println("Digite o nome do gestor:");
                    String nomeGestor = scanner.nextLine();
                    gestor.setNome(nomeGestor);
                    System.out.println("Digite o setor responsável do gestor:");
                    String setorGestor = scanner.nextLine();
                    gestor.setSetorResponsavel(setorGestor);
                    try {
                        int idGestor = gestorDAO.cadastrar(gestor);
                        System.out.println("Gestor cadastrado com sucesso! ID: " + idGestor);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar gestor: " + e.getMessage());
                    }
                    break;
                case 3:
                    // Cadastrar Ocorrência
                    Ocorrencia ocorrencia = new Ocorrencia();
                    System.out.println("digite a descrição da ocorrência:");
                    String descricaoOcorrencia = scanner.nextLine();
                    ocorrencia.setDescricao(descricaoOcorrencia);
                    System.out.println("Digite a categoria da ocorrência:");
                    String categoriaOcorrencia = scanner.nextLine();
                    ocorrencia.setCategoria(categoriaOcorrencia);
                    System.out.println("Digite o endereço da ocorrência:");
                    String enderecoOcorrencia = scanner.nextLine();
                    ocorrencia.setEndereco(enderecoOcorrencia);
                    System.out.println("Digite o status da ocorrência:");
                    String statusOcorrencia = scanner.nextLine();
                    ocorrencia.setStatus(statusOcorrencia);

                    try {
                        int idOcorrencia = ocorrenciaDAO.cadastrar(ocorrencia);
                        System.out.println("Ocorrência cadastrada com sucesso! ID: " + idOcorrencia);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar ocorrência: " + e.getMessage());
                    }
                    break;
                case 4:
                    // Listar Usuários
                    try {
                        for (Usuario u : usuarioDAO.consultar()) {
                            System.out.println("  " + u);
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao listar usuários: " + e.getMessage());
                    }
                    break;
                case 5:
                    // Listar Gestores
                    try {
                        for (Gestor g : gestorDAO.consultar()) {
                            System.out.println("  " + g);
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao listar gestores: " + e.getMessage());
                    }
                    break;
                case 6:
                    // Listar Ocorrências
                    try {
                        for (var o : ocorrenciaDAO.consultar()) {
                            System.out.println("  " + o);
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao listar ocorrências: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            
        }

    
    }


}