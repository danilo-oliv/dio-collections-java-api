package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> listaNumeros;

    public OrdenacaoNumeros(){
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero)
    {
        listaNumeros.add(numero);
    }

    public List<Integer> ordenarAscendente()
    {
        List<Integer> ordenadoAsc = new ArrayList<>(listaNumeros);
        if(!listaNumeros.isEmpty())
        {
            Collections.sort(ordenadoAsc);
        } else throw new RuntimeException("Lista vazia");
        return ordenadoAsc;
    }

    public List<Integer> ordenarDescendente()
    {
        List<Integer> ordenadoDesc = new ArrayList<>(listaNumeros);
        if(!listaNumeros.isEmpty())
        {
            ordenadoDesc.sort(Collections.reverseOrder());
        } else throw new RuntimeException("Lista vazia");
        return ordenadoDesc;
    }

    public void exibirNumeros()
    {
        System.out.println(listaNumeros);
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(6);
        numeros.adicionarNumero(5);
        numeros.adicionarNumero(2);
        numeros.adicionarNumero(999);
        numeros.adicionarNumero(61);

        numeros.exibirNumeros();

        System.out.println(numeros.ordenarAscendente());
        System.out.println(numeros.ordenarDescendente());
    }

}
