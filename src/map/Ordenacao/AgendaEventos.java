package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private TreeMap<LocalDate, Evento> agendaMap;

    public AgendaEventos(){
        this.agendaMap = new TreeMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        agendaMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        System.out.println(agendaMap);
    }

    public Evento obterProximoEvento(){
        LocalDate hoje = LocalDate.now();
        for(Map.Entry<LocalDate, Evento> entry: agendaMap.entrySet()){
            if(entry.getKey().isEqual(hoje) || entry.getKey().isAfter(hoje))
            {
                return entry.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação", "Competição de soluções criativas");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");

        agendaEventos.exibirAgenda();

        System.out.println(agendaEventos.obterProximoEvento());
    }
}
