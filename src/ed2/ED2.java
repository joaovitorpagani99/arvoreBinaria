package ed2;

import java.util.Random;

public class ED2 {

    public static void main(String[] args) {
        Random rand = new Random();
        Arvore ar = new Arvore();
        
        for (int i = 0; i < 10; i++) {
            ar.inserir(rand.nextInt(100), ar.raiz);
        }
        
        System.out.println("\nPre-Ordem ");
        ar.inOrder(ar.raiz);
        
        System.out.println(ar.minimo());
        System.out.println(ar.maxSoma());
        System.out.println(ar.balanceada());
        System.out.println(ar.maiores(10));
        System.out.println(ar.numNo());
    }

}
