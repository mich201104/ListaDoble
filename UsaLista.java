public class UsaLista{
    public static void main(String[] args){
        ListaDoble lista = new ListaDoble();
        lista.insertaPrimerNodo("H");
        lista.insertaAntesPrimerNodo("O");
        lista.insertaAlFinal("Y");
        lista.insertaEntreNodos("R", "A");
        System.out.println("Lista:");
        lista.imprimir();
        System.out.println();
        //Referencia
        String contenido = "H";
        Nodo buscarnodo = lista.buscarContenido(contenido);
        if(buscarnodo != null){
            System.out.println("El nodo se ha encontrado");
        }else{
            System.out.println("El nodo no se encontró");
        }
        //Agregé otras letras aquí
        lista.insertarnodoDespues("Y", "Z");
        System.out.println("Se inserta Nodo [Z] después del Nodo [Y]:");
        lista.imprimir();
        System.out.println("Cambiar Nodo [H] por [Z]:");
        lista.cambiarNodo("H", "Z");
        lista.imprimir();
    }
}
