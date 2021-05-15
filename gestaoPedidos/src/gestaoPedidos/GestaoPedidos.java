package gestaoPedidos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GestaoPedidos {
	private Scanner scanner = new Scanner(System.in);
	private Queue<String> fila = new LinkedList<>();
	private Stack<Integer> pilha = new Stack<>();
	
	private String mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ----------Gestão de Pedidos----------\n");
		sb.append("|1 - Consultar fila de pedidos.       |\n");
		sb.append("|2 - Inserir pedido na fila.          |\n");
		sb.append("|3 - Remover pedido na fila.          |\n");
		sb.append("|4 - Organizar as entregas.           |\n");
		sb.append("|5 - Desempilhar pedido.              |\n");
		sb.append("|6 - Sair.                            |\n");
		sb.append(" -------------------------------------");
		System.out.println(sb.toString());
		
		return scanner.nextLine();
	}
		public void iniciar() {
		String opcao = mostrarMenu();
		while (!opcao.equals("6")) {
			switch (opcao) {
			case "1":
				System.out.println(fila + "\n");
				opcao = mostrarMenu();
				break;
			case "2":
				System.out.println("Digite o nome do pedido: ");
				fila.add(scanner.nextLine());
				opcao = mostrarMenu();
				break;
			case "3":
				System.out.println("Pedido removido: " + fila.remove());
				System.out.println(fila);
				opcao = mostrarMenu();
				break;
			case "4":
				System.out.println("Digite os pedidos de acordo com a distância para organizar: ");
				String str[] = scanner.nextLine().split(",");
				ArrayList<Integer> distancias = new ArrayList<>();
				for (int i = 0; i < str.length; i++) {
					distancias.add(Integer.valueOf(str[i]));
				}
				
				while (!distancias.isEmpty()) {
					int indiceMaiorDistancia = 0;
					int maiorDistancia = distancias.get(indiceMaiorDistancia);
					
					for (int i = 0; i < distancias.size(); i++) {
						if (distancias.get(i) > maiorDistancia) {
							maiorDistancia = distancias.get(i);
							indiceMaiorDistancia = i;
						}
					}
					pilha.add(maiorDistancia);
					distancias.remove(indiceMaiorDistancia);
				}
				System.out.println(pilha);
				opcao = mostrarMenu();
				break;
			case "5":
				System.out.println("Pedido entregue: " + pilha.pop());
				opcao = mostrarMenu();
				break;
			case "6":
				opcao = mostrarMenu();
				break;
			default:
				System.out.println("Opção inválida.");
				opcao = mostrarMenu();
			}
		}
		
	}
}
