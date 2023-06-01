import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalCRUD {
    private static List<Paciente> pacientes = new ArrayList<>();
    private static int proximoId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Cadastrar paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("3. Atualizar paciente");
            System.out.println("4. Excluir paciente");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    atualizarPaciente();
                    break;
                case 4:
                    excluirPaciente();
                    break;
                case 5:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void cadastrarPaciente() {
        System.out.print("Digite o nome do paciente: ");
        scanner.nextLine(); // Consumir a nova linha pendente
        String nome = scanner.nextLine();

        System.out.print("Digite a data da consulta (dd/mm/aaaa): ");
        String data = scanner.next();

        System.out.print("Digite o horário da consulta (hh:mm): ");
        String horario = scanner.next();

        System.out.print("Digite o nome do médico: ");
        scanner.nextLine(); // Consumir a nova linha pendente
        String medico = scanner.nextLine();

        Paciente paciente = new Paciente(proximoId, nome, data, horario, medico);
        pacientes.add(paciente);
        proximoId++;

        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            System.out.println("Lista de Pacientes:");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }

    private static void atualizarPaciente() {
        System.out.print("Digite o ID do paciente a ser atualizado: ");
        int id = scanner.nextInt();

        Paciente paciente = buscarPacientePorId(id);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
        } else {
            System.out.print("Digite o novo nome do paciente: ");
            scanner.nextLine(); // Consumir a nova linha pendente
            String nome = scanner.nextLine();

            System.out.print("Digite a nova data da consulta (dd/mm/aaaa): ");
            String data = scanner.next();

            System.out.print("Digite o novo horário da consulta (hh:mm): ");
            String horario = scanner.next();

            System.out.print("Digite o novo nome do médico: ");
            scanner.nextLine(); // Consumir a nova linha pendente
            String medico = scanner.nextLine();

            paciente.setNome(nome);
            paciente.setData(data);
            paciente.setHorario(horario);
            paciente.setMedico(medico);

            System.out.println("Paciente atualizado com sucesso!");
        }
    }

    private static void excluirPaciente() {
        System.out.print("Digite o ID do paciente a ser excluído: ");
        int id = scanner.nextInt();

        Paciente paciente = buscarPacientePorId(id);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
        } else {
            pacientes.remove(paciente);
            System.out.println("Paciente excluído com sucesso!");
        }
    }

    private static Paciente buscarPacientePorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }
}

class Paciente {
    private int id;
    private String nome;
    private String data;
    private String horario;
    private String medico;

    public Paciente(int id, String nome, String data, String horario, String medico) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.horario = horario;
        this.medico = medico;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Data: " + data + ", Horário: " + horario + ", Médico: " + medico;
    }
}
