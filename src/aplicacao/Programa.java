package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Funcionario;

public class Programa {

   public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();
		
		// PART 1 - DADOS DE LEITURA:
		
		System.out.print("Quantos funcionarios serão registrados? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Funcionario #" + i + ": ");

			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			double salario = sc.nextDouble();
			list.add(new Funcionario(id, nome, salario));
		}

		// PART 2 - ATUALIZAÇÃO DO SALÁRIO DE DETERMINADO EMPREGADO:
		
		System.out.println();
		System.out.print("Insira o ID do funcionário que terá aumento salarial: ");
		int id = sc.nextInt();
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("Esse id não existe!");
		}
		else {
			System.out.print("Insira a porcentagem: ");
			double porcentagem = sc.nextDouble();
			emp.aumentarSalario(porcentagem);
		}
		
		// PART 3 - LISTA DE FUNCIONÁRIOS:
		
		System.out.println();
		System.out.println("Lista de funcionarios:");
		for (Funcionario obj : list) {
			System.out.println(obj);
		}
				
		sc.close(); 
	}
	
	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
    
}