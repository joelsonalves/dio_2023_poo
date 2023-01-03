import java.time.LocalDate;
import java.util.Random;

public class Main {

    public static void exibirAndamento(Dev[] devs) {   

        for (Dev dev : devs) {
            System.out.println(dev.getNome());
            System.out.println("\nAtividades Inscritas: ");
            System.out.println(dev.getAtividadesInscritas());
            System.out.println("\nAtividades Concluídas: ");
            System.out.println(dev.getAtividadesConcluidas());
            System.out.println("\nExperiência Acumulada: ");
            System.out.println(dev.calcularXpTotal() + "XP\n");
        }

    }
    
    public static void main(String[] args) {
        
        // Instanciamento do Bootcamp

        Bootcamp bootcamp = new Bootcamp("Bootcamp 701", "Bootcamp 701");

        // Adicionar Atividades ao Bootcamp

        bootcamp.getAtividades().add(new Curso("Curso 01", "Curso 01", 20));

        bootcamp.getAtividades().add(new Mentoria("Mentoria 01", "Mentoria 01", LocalDate.now().plusDays(5)));

        bootcamp.getAtividades().add(new Curso("Curso 02", "Curso 02", 30));

        bootcamp.getAtividades().add(new Mentoria("Mentoria 02", "Mentoria 02", LocalDate.now().plusDays(10)));

        bootcamp.getAtividades().add(new Curso("Curso 03", "Curso 03", 40));

        // Instanciamento de Devs

        Dev[] devs = {
            new Dev("Maria"),
            new Dev("João")
        };

        // Inscrever os Devs no Bootcamp

        for (Dev dev : devs) {
            dev.inscricaoBootcamp(bootcamp);
        }

        // Exibição do Andamento

        exibirAndamento(devs);

        // Progresso aleatório

        int quantAtividades = bootcamp.getAtividades().size();

        for (Dev dev : devs) {

            for (int i = new Random().nextInt(quantAtividades + 1); i > 0; i-- ) {
                dev.progredir();
            }

        }

        // Exibição do Andamento

        exibirAndamento(devs);

    }

}
