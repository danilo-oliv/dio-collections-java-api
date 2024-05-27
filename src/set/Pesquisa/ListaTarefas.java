package set.Pesquisa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> conjuntoTarefas;

    public ListaTarefas(){
        this.conjuntoTarefas = new HashSet<>();
    }

    public void adicionarTarefa(String desc){
        conjuntoTarefas.add(new Tarefa(desc, false));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        for(Tarefa t : conjuntoTarefas){
            if(t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaRemover = t;
                break;
            }
        }
        conjuntoTarefas.remove(tarefaParaRemover);
    }

    public void exibirTarefas(){
        System.out.println(conjuntoTarefas);
    }

    public int contarTarefas(){
        return  conjuntoTarefas.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for(Tarefa t : conjuntoTarefas){
            if(t.estaConcluida()){
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for(Tarefa t : conjuntoTarefas){
            if(!t.estaConcluida()){
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao){
        for(Tarefa t : conjuntoTarefas){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                t.setEstaConcluida(true);
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao){
        for(Tarefa t : conjuntoTarefas){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                t.setEstaConcluida(false);
                break;
            }
        }
    }

    public void limparListaTarefas(){
        conjuntoTarefas.removeAll(conjuntoTarefas);
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefas
        ListaTarefas listaTarefas = new ListaTarefas();

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        // Exibindo as tarefas na lista
        listaTarefas.exibirTarefas();

        // Removendo uma tarefa
        listaTarefas.removerTarefa("Fazer exercícios físicos");
        listaTarefas.exibirTarefas();

        // Contando o número de tarefas na lista
        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

        // Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());

        // Marcando tarefas como concluídas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        // Obtendo tarefas concluídas
        System.out.println(listaTarefas.obterTarefasConcluidas());

        // Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        // Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
