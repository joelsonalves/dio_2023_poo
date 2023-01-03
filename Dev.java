import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Dev implements Comparable<Dev> {

    private String nome;
    private SortedSet<Atividade> atividadesInscritas = new TreeSet<Atividade>();
    private SortedSet<Atividade> atividadesConcluidas = new TreeSet<Atividade>();

    public Dev(String nome) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SortedSet<Atividade> getAtividadesInscritas() {
        return atividadesInscritas;
    }

    public void setAtividadesInscritas(SortedSet<Atividade> atividadesInscritas) {
        this.atividadesInscritas = atividadesInscritas;
    }

    public SortedSet<Atividade> getAtividadesConcluidas() {
        return atividadesConcluidas;
    }

    public void setAtividadesConcluidas(SortedSet<Atividade> atividadesConcluidas) {
        this.atividadesConcluidas = atividadesConcluidas;
    }

    public void inscricaoBootcamp(Bootcamp bootcamp) {
        this.atividadesInscritas.addAll(bootcamp.getAtividades());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        if (atividadesInscritas.size() > 0) {
            Atividade atividade = atividadesInscritas.first();
            atividadesConcluidas.add(atividade);
            atividadesInscritas.remove(atividade);
            System.out.println(String.format("%s concluiu %s.", nome, atividade));
        } else {
            System.out.println(String.format("%s não possui atividades pendentes.", nome));
        }
    }

    public double calcularXpTotal() {
        double xpTotal = 0;
        Iterator<Atividade> atividade = atividadesConcluidas.iterator();
        while (atividade.hasNext()) {
            xpTotal += atividade.next().calcularXp();
        }
        return xpTotal;
    }

    @Override
    public int compareTo(Dev dev) {
        return nome.compareTo(dev.nome);
    }
    
}
