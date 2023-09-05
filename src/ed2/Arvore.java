package ed2;

import java.util.*;
import java.util.Queue;


public class Arvore implements metodosArvore {

    No raiz = null;
    int max = 0;

    void inserir(int valor, No lugar) {
        if (lugar == null) {
            raiz = new No(valor);
        } else if (valor < lugar.valor) {
            if (lugar.esquerda == null) {
                System.out.println("  Inserindo " + valor + " a esquerda de " + lugar.valor);
                lugar.esquerda = new No(valor);
            } else {
                inserir(valor, lugar.esquerda);
            }
        } else if (valor > lugar.valor) {
            if (lugar.direita == null) {
                System.out.println("  Inserindo " + valor + " a direita de " + lugar.valor);
                lugar.direita = new No(valor);
            } else {
                inserir(valor, lugar.direita);
            }
        }
    }

    void preOrder(No lugar) {
        System.out.println(" " + lugar.valor);
        if (lugar.esquerda != null) {
            preOrder(lugar.esquerda);
        }

        if (lugar.direita != null) {
            preOrder(lugar.direita);
        }
    }

    void inOrder(No lugar) {
        if (lugar.esquerda != null) {
            preOrder(lugar.esquerda);
        }

        System.out.println(" " + lugar.valor);

        if (lugar.direita != null) {
            preOrder(lugar.direita);
        }
    }

    void posOrder(No lugar) {
        if (lugar.esquerda != null) {
            preOrder(lugar.esquerda);
        }

        if (lugar.direita != null) {
            preOrder(lugar.direita);
        }
        System.out.println(" " + lugar.valor);
    }

    @Override
    public boolean contem(int dado) {
        if (raiz == null) {
            return false;
        }
        No atual = raiz;
        while (atual.valor != dado) {
            if (dado < atual.valor) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
            if (atual == null) {
                return false;
            }
        }
        return atual.valor == dado;

    }

    @Override
    public int minimo() {
        No atual = raiz;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.esquerda;
        }
        return anterior.valor;
    }

    @Override
    public int maximo() {
        No atual = raiz;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.direita;
        }
        return anterior.valor;
    }

    @Override
    public String maiores(int valor) {
        No atual = raiz;
        StringBuilder result = new StringBuilder();
        maioresRecursivo(atual, valor, result);
        return result.toString().trim();
    }

    @Override
    public String menores(int valor) {
        No atual = raiz;
        StringBuilder result = new StringBuilder();
        menoresRecursivo(atual, valor, result);
        return result.toString().trim();
    }

    @Override
    public boolean isomorfica(No arv) {
        if (raiz == null && arv == null) {
            return true;
        }
        if (raiz == null || arv == null) {
            return true;
        }
        return isomorfica(raiz, arv);
    }

    @Override
    public int maxSoma() {
        if (raiz == null) {
            return 0;
        }
        maxSoma(raiz);
        return max;
    }

    @Override
    public String pathTo(int dado) {
        StringBuilder result = new StringBuilder();
        pathTo(raiz, dado, result);
        return result.toString().trim();

    }

    @Override
    public int numNo() {
        return numNo(raiz);
    }

    @Override
    public int numFolhas() {
        return numFolhas(raiz);
    }

    @Override
    public boolean balanceada() {
        return balanceada(raiz);
    }

    @Override
    public String percursoEmLargura() {
        StringBuilder result = new StringBuilder();
        Queue<No> fila = new LinkedList<>();
        if (raiz != null) {
            fila.offer(raiz);
        }
        while (!fila.isEmpty()) {
            No lugar = fila.poll();
            result.append(lugar.valor).append(" ");
            if (lugar.esquerda != null) {
                fila.offer(lugar.esquerda);
            }
            if (lugar.direita != null) {
                fila.offer(lugar.direita);
            }
        }
        return result.toString();

    }

    private int numNo(No raiz) {
        if (raiz == null) {
            return 0;
        } else {
            return (numNo(raiz.esquerda) + numNo(raiz.direita) + 1);
        }
    }

    private int numFolhas(No raiz) {
        if (raiz == null) {
            return 0;
        }
        if (raiz.esquerda == null && raiz.direita == null) {
            return 1;
        }
        return numFolhas(raiz.esquerda) + numFolhas(raiz.direita);
    }

    private boolean balanceada(No raiz) {
        if (raiz == null) {
            return true;
        }
        int esq = altura(raiz.esquerda);
        int dir = altura(raiz.direita);

        return Math.abs(esq - dir) <= 1 && balanceada(raiz.esquerda) && balanceada(raiz.direita);
    }

    public int altura(No raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + Math.max(altura(raiz.esquerda), altura(raiz.direita));
    }

    private void menoresRecursivo(No atual, int valor, StringBuilder result) {
        if (atual == null) {
            return;
        }

        if (atual.valor < valor) {
            result.append(atual.valor).append(" ");
        }

        menoresRecursivo(atual.esquerda, valor, result);
        menoresRecursivo(atual.direita, valor, result);
    }

    private void maioresRecursivo(No lugar, int valor, StringBuilder result) {
        if (lugar == null) {
            return;
        }

        if (lugar.valor > valor) {
            result.append(lugar.valor).append(" ");
        }

        maioresRecursivo(lugar.esquerda, valor, result);
        maioresRecursivo(lugar.direita, valor, result);
    }

    private boolean isomorfica(No raiz, No arv) {
        return isomorfica(raiz.esquerda, arv.esquerda) && isomorfica(raiz.direita, arv.direita);
    }

    private boolean pathTo(No raiz, int dado, StringBuilder result) {
        if (raiz == null) {
            return false;
        }

        if (raiz.valor == dado) {
            result.append(raiz.valor).append(" ");
            return true;
        }

        if (pathTo(raiz.esquerda, dado, result) || pathTo(raiz.direita, dado, result)) {
            result.append(raiz.valor).append(" ");
            return true;
        }

        return false;
    }

    private int maxSoma(No raiz) {
        No atul = raiz;
        if (atul == null) {
            return 0;
        }

        int esq = maxSoma(atul.esquerda);
        int dir = maxSoma(atul.direita);

        int tmpMax = esq + dir + atul.valor;

        if (tmpMax > max) {
            max = tmpMax;
        }

        if (esq > dir) {
            return esq + atul.valor;
        }

        return dir + atul.valor;
    }

}
