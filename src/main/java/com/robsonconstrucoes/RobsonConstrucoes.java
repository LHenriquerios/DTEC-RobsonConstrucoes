package com.robsonconstrucoes;

import java.util.Scanner;
import java.util.ArrayList;


class Funcionario {
    int codigo;
    String nome;
    int codigoCargo;

    public Funcionario (int codigo, String nome, int codigoCargo){
        this.codigo = codigo;
        this.nome = nome;
        this.codigoCargo = codigoCargo;
    }
}

public class RobsonConstrucoes {
    private ArrayList<Double> salarios = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrarCargo(double salario){
        salarios.add(salario);
        System.out.println("Cargo cadastrado com sucesso.");
    }

    public void cadastrarFuncionario(int codigo, String nome, int codigoCargo) {
        for (Funcionario func : funcionarios) {
            if (func.codigo == codigo) {
                System.out.println("Código de funcionário já existe. Escolha outro.");
                return;
            }
        }
        if (codigoCargo < 0 || codigoCargo >= salarios.size()) {
            System.out.println("Código de cargo inválido.");
            return;
        }
        funcionarios.add(new Funcionario(codigo, nome, codigoCargo));
        System.out.println("Funcionário cadastrado com sucesso.");
    }

    public static void main(String[] args) {
        RobsonConstrucoes empresa = new RobsonConstrucoes();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar cargo");
            System.out.println("2. Cadastrar funcionário");
            System.out.println("3. Mostrar relatório");
            System.out.println("4. Mostrar total de salário por cargo");
            System.out.println("5. Sair");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Digite o salário do novo cargo: ");
                    double salario = scanner.nextDouble();
                    empresa.cadastrarCargo(salario);
                    break;
                case 2:
                    System.out.print("Digite o código do funcionário: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Digite o nome do funcionário: ");
                    String nome = scanner.next();
                    System.out.print("Digite o código do cargo: ");
                    int codigoCargo = scanner.nextInt();
                    empresa.cadastrarFuncionario(codigo, nome, codigoCargo);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }
    }
    }