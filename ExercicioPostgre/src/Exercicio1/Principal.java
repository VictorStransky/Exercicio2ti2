package Exercicio1;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        XDAO dao = new XDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1. Listar");
            System.out.println("2. Inserir");
            System.out.println("3. Atualizar");
            System.out.println("4. Excluir");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    for (X x : dao.listar()) {
                        System.out.println(x);
                    }
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("Descrição: ");
                    String descricao = scanner.next();
                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    dao.inserir(new X(0, nome, descricao, valor));
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Nome: ");
                    nome = scanner.next();
                    System.out.print("Descrição: ");
                    descricao = scanner.next();
                    System.out.print("Valor: ");
                    valor = scanner.nextDouble();
                    dao.atualizar(new X(id, nome, descricao, valor));
                    break;

                case 4:
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    dao.excluir(id);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
}
