import java.time.LocalDate;

public class Mentoria extends Atividade {

    private LocalDate data;
    
    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        setData(data);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20.0;
    }

    @Override
    public String toString() {
        return String.format("Mentoria { título='%s', descrição='%s', data='%s' }", getTitulo(), getDescricao(), data);
    }

}