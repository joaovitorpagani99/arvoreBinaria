package ed2;

public interface metodosArvore {

    public boolean contem(int dado); // verifica se a árvore contém

    public int minimo(); // retorna o menor valor

    public int maximo(); // retorna o maior valor.

    public String maiores(int valor);

    public String menores(int valor);

     public boolean isomorfica(No arv); // verifica se a estrutura de duas arvores é igual

    public int maxSoma(); // maior somatório de um caminho

    public String pathTo(int dado); // devolver caminho para chegar a um dado nó

    public int numNo(); // retorna o número de nós

    public int numFolhas(); // retorna o número de nós que são folhas

    public boolean balanceada(); // verificar se a árvore é balanceada

    public String percursoEmLargura(); // mostrar o percurso em largura da árvor

}
