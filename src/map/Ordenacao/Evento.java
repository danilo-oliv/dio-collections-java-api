package map.Ordenacao;

public class Evento {
    private String nomeEvento;
    private String nomeAtracao;

    @Override
    public String toString() {
        return "Evento{" +
                "nomeEvento='" + nomeEvento + '\'' +
                ", nomeAtracao='" + nomeAtracao + '\'' +
                '}';
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public String getNomeAtracao() {
        return nomeAtracao;
    }

    public Evento(String nomeEvento, String nomeAtracao) {
        this.nomeEvento = nomeEvento;
        this.nomeAtracao = nomeAtracao;
    }
}
