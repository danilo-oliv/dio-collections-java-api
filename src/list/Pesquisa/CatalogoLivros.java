package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> catalogo;

    public CatalogoLivros()
    {
         this.catalogo = new ArrayList<>();
    }

    public void adicionarLivro(String nome, String autor, int ano)
    {
        catalogo.add(new Livro(nome, autor, ano));
    }

    public List<Livro> pesquisarPorAutor(String autor)
    {
        List<Livro> pesquisaAutor = new ArrayList<>();
        int tamanhoLista = catalogo.size();
        if(!catalogo.isEmpty()){
            for (int i = 0; i < tamanhoLista; i++)
            {
                if (catalogo.get(i).getAutor().equalsIgnoreCase(autor))
                    pesquisaAutor.add(catalogo.get(i));
            }
            return pesquisaAutor;
        }
        else{
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal)
    {
        List<Livro> pesquisaIntervaloAnos = new ArrayList<>();
        int tamanhoLista = catalogo.size();
        if (!catalogo.isEmpty())
        {
            for(int i=0; i<tamanhoLista; i++)
            {
                int anoLivro = catalogo.get(i).getAnoDePublicacao();
                if((anoInicial-anoLivro<=0) && (anoFinal-anoLivro>=0))
                {
                    pesquisaIntervaloAnos.add(catalogo.get(i));
                }
            }
            return pesquisaIntervaloAnos;
        }
        else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public Livro pesquisarPorTitulo(String titulo)
    {
        if(!catalogo.isEmpty()){
            for (Livro l : catalogo) {
                if (l.getTitulo().equalsIgnoreCase(titulo))
                    return l;
            }
        } else {
            throw new RuntimeException("Lista vazia");
        }
        return null;
    }
    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2005);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 1", 2006);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2007);

        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 1"));
        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 5"));

        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2003, 2005));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2010, 2013));

        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 3"));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 5"));
    }
}
