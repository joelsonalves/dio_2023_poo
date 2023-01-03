public abstract class Atividade implements Comparable<Atividade> {

    protected static final double XP_PADRAO = 10.0;
    private static int instanciados = 0;
    
    private String titulo;
    private String descricao;
    private final int ordem;
    
    public Atividade(String titulo, String descricao) {
        setTitulo(titulo);
        setDescricao(descricao);
        ordem = ++instanciados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int compareTo(Atividade atividade) {
        return Integer.compare(ordem, atividade.ordem);
    }

    public abstract double calcularXp();

}