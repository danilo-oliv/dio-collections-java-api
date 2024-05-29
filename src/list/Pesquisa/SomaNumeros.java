package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> lista;

    public SomaNumeros(){
        this.lista = new ArrayList<>();
    }

    public void adicionarNumero(int numero)
    {
        lista.add(numero);
    }

    public int calcularSoma()
    {
        int soma = 0;
        for(Integer i : lista)
        {
            soma += i;
        }
        return soma;
    }

    public int encontrarMaiorNumero(){
        int tamanhoLista = lista.size();
        int maior = 0;
        if(!lista.isEmpty()){
            for (int i = 0; i < tamanhoLista; i++) {
                if (lista.get(i) > maior)
                    maior = lista.get(i);
            }
        } else
            throw new RuntimeException("Lista vazia!");
        return maior;
    }

    public int encontrarMenorNumero(){
        int tamanhoLista = lista.size();
        int menor = 0;
        if(!lista.isEmpty()){
            for (int i = 0; i < tamanhoLista; i++) {
                if(menor==0){
                    menor = lista.get(i);
                }
                if (lista.get(i) < menor)
                    menor = lista.get(i);
            }
        } else
            throw new RuntimeException("Lista vazia!");
        return menor;
    }

    public void exibirNumeros(){
        System.out.println(lista);
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(20);
        somaNumeros.adicionarNumero(30);
        somaNumeros.adicionarNumero(-25);
        somaNumeros.adicionarNumero(-10);

        System.out.println("Números adicionados:");
        somaNumeros.exibirNumeros();

        System.out.println("Soma dos números = " + somaNumeros.calcularSoma());

        System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());

        System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
    }
}
