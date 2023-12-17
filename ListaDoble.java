public class ListaDoble{
	Nodo topForward;
	Nodo topBackward;
	//Métodos para los casos de inserción de nodos
	public boolean insertaPrimerNodo(String dato){
		if (topForward == null) { //La lista está vacía
			topForward = new Nodo();
			topForward.name = dato;
			topForward.previous = null;
			topForward.next = null;
			
			topBackward = topForward;

			return true;
		}
		else {
			return false;
		}
	}
	//Imprimir lista
	public void imprimir(){
		System.out.print("[X]"); 

		for (Nodo temp = this.topForward; temp != null; temp = temp.next){
			System.out.print(" <- [ " + temp.name + " ] -> ");
		}

		System.out.print("[X]\n"); 
	}
	//Se muestra como cadena de texto
	public String toString(){
		String cadAux = "[X]";
		for (Nodo temp = this.topForward; temp != null; temp = temp.next){
			cadAux += " <- [ " + temp.name + " ] -> ";
		}
		cadAux += "[X]\n"; 
		return cadAux;
	}
        //Insertar antes del primer nodo
	public void insertaAntesPrimerNodo(String nombre){
		Nodo temp; 
		temp = new Nodo ();
		temp.name = nombre;
		temp.next = this.topForward;
		this.topForward.previous = temp;
		this.topForward = temp;
		temp = null;
	}
        //Ultimo nodo
	public void insertaAlFinal(String nombre){
		Nodo temp = new Nodo ();
		temp.name = nombre;
		temp.next = null;
		temp.previous = this.topBackward;
		this.topBackward.next = temp;
		this.topBackward = temp;
		temp = null;
	}
	public boolean insertaEntreNodos(String nombre, String buscado){
		Nodo temp = new Nodo();
		temp.name = nombre;
		Nodo temp2 = this.topForward;
		//boolean NodoNoEncontrado = true;
		while ( (temp2 != null) 
				&& temp2.name.equals(buscado) == false ) {	
		         temp2 = temp2.next;
		}
		if (temp2 != null){  //Nodo buscado se encontró
			temp.next = temp2.next;
			temp2.next = temp;
			temp.previous = temp2;
			temp.next.previous = temp;
			temp = null;
			temp2 = null;
			return true;
		}
		else return false;
	} 
	//Métodos de borrado
	public void borrarPrimerNodo(){
		this.topForward = this.topForward.next;
		this.topForward.previous.next = null;
		this.topForward.previous = null;
	}
         //Borrar ultimo nodo
	public void borrarUltimoNodo(){
		this.topBackward = this.topBackward.previous;
		this.topBackward.next.previous = null;
		this.topBackward.next = null;
	}
	//Borrar cualquier nodo que no sea el primero
	public boolean borrarCualquierNodo(String buscado){
		Nodo temp = this.topForward;
		while ( (temp != null) 
				&& temp.name.equals(buscado) == false ) {	
		         temp = temp.next;
		}
		if (temp != null){  //Nodo buscado se encontró
			temp.next = temp.next.next;
			temp.next.previous.previous = null;
			temp.next.previous.next = null;
			temp.next.previous = temp;
			temp = null;
			
			return true;
		}
		else return false;
	}
	//TODO: Crear el método para borrar el nodo buscado
	//Adecuación del método de borrado: borrarCualquierNodo()
    public Nodo buscarContenido(String contenido){
        Nodo temp = this.topForward;
        while(temp != null){
            if(temp.name.equals(contenido)){
                return temp;
            }
            temp = temp.next;
        }
        return null; // Regresa que no se encontró el nodo
    }
    //Insertar despues del nodo
    public boolean insertarnodoDespues(String contenido, String nombre){
        Nodo buscarnodo = buscarContenido(contenido);//se declara buscar nodo para utizarlo
        if(buscarnodo != null){
            if(buscarnodo.next == null){
                insertaAlFinal(nombre);
            }else{//De no ser así
                Nodo nuevoNodo = new Nodo();
                nuevoNodo.name = nombre;
                nuevoNodo.next = buscarnodo.next;
                buscarnodo.next = nuevoNodo;
                nuevoNodo.previous = buscarnodo;//Busca el nodo para colocarlo
                nuevoNodo.next.previous = nuevoNodo;
            }
            return true;//De ser verdadero se muestra
        }
        return false; //De no ser así regresa que no se encontró el nodo
    }
    //Cambiar nodos
    public boolean cambiarNodo(String nombre, String buscando){
        //Cambiar nodos
        Nodo nodoprimero = buscarContenido(nombre);
        Nodo nodosegundo = buscarContenido(buscando);
        //Si nodo 1 y nodo2 son encontrados
        //previos atras
        //next adelante
        if(nodoprimero != null && nodosegundo != null){
            Nodo Nodoprev = nodoprimero.previous;
            Nodo Nodonext = nodoprimero.next;
            Nodo Nodoprev2 = nodosegundo.previous;
            Nodo tempNext2 = nodosegundo.next;
            nodoprimero.previous = Nodoprev2;
            nodoprimero.next = tempNext2;
            nodosegundo.previous = Nodoprev;
            nodosegundo.next = Nodonext;
            if(Nodoprev != null){
                Nodoprev.next = nodosegundo;
            }
            if(Nodoprev2 != null){
                Nodoprev2.next = nodoprimero;
            }
            if (Nodonext != null){
                Nodonext.previous = nodosegundo;
            }
            if(tempNext2 != null){
                tempNext2.previous = nodoprimero;
            }
            return true;//Se encontró el nodo
        }
        return false; //No se encontró ningun nodo
    }
}

