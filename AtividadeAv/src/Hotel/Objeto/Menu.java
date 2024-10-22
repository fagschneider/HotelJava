package Hotel.Objeto;

import java.util.*;

public class Menu {
    public static Scanner scan = new Scanner(System.in);
    public static List<Quarto> listaQuartos = new ArrayList<>();
    public static List<Reserva> listaReservas = new ArrayList<>();
    public static List<Reserva> historicoReservas = new ArrayList<>();

    public static void main(String[] args) {
        teste();
        boolean menu = true;

        while (menu) {
            System.out.println("Escolha uma das opções:");
            System.out.println("1- Cadastrar quarto");
            System.out.println("2- Listar Quartos");
            System.out.println("3- Fazer reserva");
            System.out.println("4- Fazer check-out");
            System.out.println("5- Histórico de reservas");
            System.out.println("6- Quartos ocupados");
            System.out.println("7- Sair");
            int op = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha

            switch (op) {
                case 1:
                    cadastroQuarto();
                    break;
                case 2:
                    listaQuarto();
                    break;
                case 3:
                    checkIn();
                    break;
                case 4:
                    checkOut();
                    break;
                case 5:
                    historicoReserva();
                    break;
                case 6:
                    quartosOcupados();
                    break;
                case 7:
                    menu = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    // Método para cadastrar quartos
    public static void cadastroQuarto() {
        System.out.println("Número do quarto:");
        int num = scan.nextInt();
        scan.nextLine(); // Consumir a nova linha
        System.out.println("Tipo do quarto:");
        String tipo = scan.nextLine();
        System.out.println("Preço do quarto:");
        double preco = scan.nextDouble();
        Quarto quarto = new Quarto(num, tipo, preco, true);
        listaQuartos.add(quarto);
        System.out.println("Quarto cadastrado com sucesso!");
    }

    // Método para listar os quartos
    public static void listaQuarto() {
        if (listaQuartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado");
        } else {
            listaQuartos.forEach(System.out::println);
        }
    }

    // Método para fazer o check-in
    public static void checkIn() {
        System.out.println("Número do quarto:");
        int numQ = scan.nextInt();
        scan.nextLine(); // Consumir a nova linha

        for (Quarto quarto : listaQuartos) {
            if (quarto.getNum() == numQ && quarto.isDisp()) {
                System.out.println("Nome do hóspede:");
                String nomeHospede = scan.nextLine();
                System.out.println("Data de check-in:");
                String checkIn = scan.nextLine();
                System.out.println("Data de check-out:");
                String checkOut = scan.nextLine();

                Reserva reserva = new Reserva(nomeHospede, checkIn, checkOut, quarto.getTipo());
                listaReservas.add(reserva);
                historicoReservas.add(reserva);
                quarto.setDisp(false);
                System.out.println("Check-in realizado com sucesso!");
                return;
            }
        }
        System.out.println("Quarto indisponível ou não encontrado.");
    }

    // Método para fazer o check-out
    public static void checkOut() {
        System.out.println("Nome do hóspede:");
        String nome = scan.nextLine();
        boolean found = false;

        Iterator<Reserva> it = listaReservas.iterator();
        while (it.hasNext()) {
            Reserva reserva = it.next();
            if (reserva.getHospede().equalsIgnoreCase(nome)) {
                it.remove(); // Remove reserva
                found = true;
                for (Quarto quarto : listaQuartos) {
                    if (quarto.getTipo().equals(reserva.getTipo()) && !quarto.isDisp()) {
                        quarto.setDisp(true); // Libera o quarto
                        System.out.println("Check-out realizado com sucesso!");
                        break;
                    }
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Hóspede não encontrado.");
        }
    }

    // Método para listar os quartos ocupados
    public static void quartosOcupados() {
        boolean found = false;
        for (Reserva reserva : listaReservas) {
            System.out.println(reserva);
            found = true;
        }
        if (!found) {
            System.out.println("Nenhum quarto ocupado.");
        }
    }

    // Método para listar histórico de reservas
    public static void historicoReserva() {
        if (historicoReservas.isEmpty()) {
            System.out.println("Nenhuma reserva no histórico.");
        } else {
            historicoReservas.forEach(System.out::println);
        }
    }

    public static void teste() {
        listaQuartos.add(new Quarto(5, "Solteiro", 150, true));
        listaQuartos.add(new Quarto(7, "Casal", 210, true));
    }
}
