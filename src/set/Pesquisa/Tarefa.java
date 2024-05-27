package set.Pesquisa;

import java.util.Objects;

public class Tarefa {
    private String descricao;
    private boolean estaConcluida;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(getDescricao(), tarefa.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDescricao());
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", estaConcluida=" + estaConcluida +
                '}';
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean estaConcluida() {
        return estaConcluida;
    }

    public void setEstaConcluida(boolean estaConcluida) {
        this.estaConcluida = estaConcluida;
    }

    public Tarefa(String descricao, boolean estaConcluida) {
        this.descricao = descricao;
        this.estaConcluida = estaConcluida;
    }
}
