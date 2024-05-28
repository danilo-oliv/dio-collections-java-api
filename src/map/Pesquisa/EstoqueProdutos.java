package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueMap;

    public EstoqueProdutos(){
        this.estoqueMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos(){
        System.out.println(estoqueMap);
    }

    public double calcularValorTotalEstoque(){
        double total = 0d;
        for(Produto p : estoqueMap.values()){
            total += p.getPreco() * p.getQuantidade();
        }
        return total;
    }

    public Produto obterProdutoMaisCaro(){
        double maior = Double.MIN_VALUE;
        Produto produtoMaisCaro = null;
        for(Produto p : estoqueMap.values()){
            if(p.getPreco()>maior) {
                maior = p.getPreco();
                produtoMaisCaro = p;
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato(){
        double menor = Double.MAX_VALUE;
        Produto produtoMaisBarato = null;
        for(Produto p : estoqueMap.values()){
            if(p.getPreco()<menor) {
                menor = p.getPreco();
                produtoMaisBarato = p;
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        double maiorValor = Double.MIN_VALUE;
        Produto produtoMaiorValor = null;
        for(Produto p : estoqueMap.values()){
            double valor = p.getPreco()*p.getQuantidade();
            if(valor>maiorValor){
                maiorValor = valor;
                produtoMaiorValor = p;
            }
        }
        return produtoMaiorValor;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
        estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
        estoque.adicionarProduto(4L, "Teclado", 2, 40.0);

        estoque.exibirProdutos();

        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro);

        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato);

        Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
    }
}
