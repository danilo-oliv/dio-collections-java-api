package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    List<Item> listaCompras;

    public CarrinhoDeCompras() {
        this.listaCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade)
    {
        listaCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome)
    {
        List<Item> itemToRemove = new ArrayList<>();
        for(Item i : listaCompras)
        {
            if(i.getNome().equalsIgnoreCase(nome))
                itemToRemove.add(i);
        }
        listaCompras.removeAll(itemToRemove);
    }

    public double calcularValorTotal()
    {
        double soma = 0;
        for(Item i : listaCompras)
        {
            soma += i.getPreco() * i.getQuantidade();
        }
        return soma;
    }

    public void exibirItens(){
        System.out.println(listaCompras);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Café", 15, 1);
        carrinhoDeCompras.adicionarItem("Açúcar", 30, 1);
        carrinhoDeCompras.adicionarItem("Sal", 10, 1);

        System.out.println("Valor total = " + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.removerItem("Sal");

        System.out.println("Valor total = " + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItens();

    }
}
