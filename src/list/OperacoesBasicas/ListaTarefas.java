package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    List<Tarefa> lista;

    public ListaTarefas()
    {
        this.lista = new ArrayList<>();
    }

    public void adicionarTarefa(String desc)
    {
        lista.add(new Tarefa(desc));
    }

    public void removerTarefa(String desc)
    {
        List<Tarefa> toRemove = new ArrayList<>();
        for(Tarefa t : lista)
        {
            if(t.getDescricao().equalsIgnoreCase(desc))
            {
                toRemove.add(t);
            }
        }
        lista.removeAll(toRemove);
    }

    public int obterNumeroTotalTarefas()
    {
        return lista.size();
    }

    public void obterDescricoesTarefas()
    {
        System.out.println(lista);
    }

    public static void main(String[] args) {
        ListaTarefas tarefaList = new ListaTarefas();
        tarefaList.adicionarTarefa("Tarefa 1");
        tarefaList.adicionarTarefa("Tarefa 2");
        tarefaList.adicionarTarefa("Tarefa 3");
        tarefaList.adicionarTarefa("Tarefa 1");

        System.out.println(tarefaList.obterNumeroTotalTarefas());

        tarefaList.removerTarefa("Tarefa 1");

        System.out.println(tarefaList.obterNumeroTotalTarefas());

        tarefaList.obterDescricoesTarefas();


    }
}
