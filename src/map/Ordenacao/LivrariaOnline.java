package map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livrosMap;

    public LivrariaOnline(){
        this.livrosMap = new TreeMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        livrosMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo){
        for(Map.Entry<String, Livro> livro : livrosMap.entrySet()){
            if(livro.getValue().getTitulo().equalsIgnoreCase(titulo)){
                livrosMap.remove(livro.getKey());
                break;
            }
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> ordemPorPreco = new ArrayList<>(livrosMap.entrySet());
        Collections.sort(ordemPorPreco, new ComparatorPorPreco());
        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : ordemPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor){
        Map<String, Livro> livrosPorAutor = new HashMap<>();
        for(Map.Entry<String, Livro> livro : livrosMap.entrySet()){
            if(livro.getValue().getAutor().equalsIgnoreCase(autor)){
               livrosPorAutor.put(livro.getKey(), livro.getValue());
            }
        }
        return livrosPorAutor;
    }

    public Map<String, Livro> obterLivroMaisCaro(){
        double maior = Double.MIN_VALUE;
        Map<String, Livro> maisCaro = new HashMap<>();
        for(Map.Entry<String, Livro> livroEntry : livrosMap.entrySet()){
            if(livroEntry.getValue().getPreco()>maior){
                maior = livroEntry.getValue().getPreco();
                maisCaro.clear();
                maisCaro.put(livroEntry.getKey(), livroEntry.getValue());
            }
        }
        return maisCaro;
    }

    public void exibirLivroMaisBarato(){
        double menor = Double.MAX_VALUE;
        Map<String, Livro> maisBarato = new HashMap<>();
        for(Map.Entry<String, Livro> livroEntry : livrosMap.entrySet()){
            if(livroEntry.getValue().getPreco()<menor){
                menor = livroEntry.getValue().getPreco();
                maisBarato.clear();
                maisBarato.put(livroEntry.getKey(), livroEntry.getValue());
            }
        }
        System.out.println(maisBarato);
    }
    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z","1984", "George Orwell", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun","A Revolução dos Bichos", "George Orwell", 7.05d);
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6","Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d);
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk","Malorie", "Josh Malerman", 5d);
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L","E Não Sobrou Nenhum", "Agatha Christie", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4","Assassinato no Expresso do Oriente", "Agatha Christie", 5d);

        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        System.out.println("Pesquisando por autor: \n" + livrariaOnline.pesquisarLivrosPorAutor("George Orwell"));

        String autorPesquisa = "Josh Malerman";
        livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        livrariaOnline.exibirLivroMaisBarato();

        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.livrosMap);
    }
}
