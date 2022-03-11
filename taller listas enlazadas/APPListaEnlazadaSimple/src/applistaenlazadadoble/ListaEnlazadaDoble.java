
package applistaenlazadadoble;

public class ListaEnlazadaDoble {
    private Nodo cabeza;
    public ListaEnlazadaDoble(){
        this.cabeza= null;
    }
    public Nodo getCabeza() {
        return cabeza;
    }
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
    //Metodo que recorre la lista y devuelve el ultimo elemento de la lista
    public Nodo ultimo(){
        
        Nodo temp= cabeza; //siempre crear una variable temporal
        while (temp != null){
            if (temp.getSiguiente()== null){
                break;
            }else{
                        temp= temp.getSiguiente();
                        }
            }
        return temp;
        }
    //Método que recorre la lista para contar cuantos nodos hay almacenados
    public int contarNodos(){
        int contar = 0;
        Nodo temp = cabeza;
        while(temp != null){
            contar++;
            temp = temp.getSiguiente(); 
        }
         return contar;
    }
    //Métoo que se encargue de agregar un nuevo nodo en la lista, pot el final
    public void agregarNodo(Nodo nuevo){
        Nodo temp= null;
        if (cabeza == null){ //La lista esta vacia
            this.setCabeza(nuevo); //Asignamos el primer nodo de la lista
        }else{
            temp = ultimo();
         ultimo().setSiguiente(nuevo); //ultimo nodo ahora apunta al nuevo
         nuevo.setAnterior(temp);
         nuevo.setSiguiente(null);
        }
    }
    //metodo de busqueda de un nodo dentro de la lista 
    //pasando como parametro el codigo del estudiante
    Nodo buscar(int cod){
        Nodo temp=cabeza;
        while (temp !=null) {            
            if (temp.getCodigo()==cod) {
                break;
            } else {    
              temp=temp.getSiguiente();     
            }          
        }
        return temp;
    }
   //Metodo que elimine el nodo de la lista pasando como parametro
    //el nodo ah eliminar
    public void eliminar(Nodo eliminar){   
        Nodo anterior;
        if (eliminar==cabeza) {
           cabeza=cabeza.getSiguiente();
        } else{
            anterior=cabeza;
            while (anterior.getSiguiente() != eliminar) {                
                anterior=anterior.getSiguiente();
            }
            anterior.setSiguiente(eliminar.getSiguiente());
        }
        
       eliminar.setSiguiente(null);
    }
     public float maxDefinitiva(){
        float def, max=0;
        Nodo temp = cabeza;
        while(temp != null){
            def = temp.definitiva();
            if(def>max){
                max = def;
            }
            temp = temp.getSiguiente();
        }
        return max;  
    }  
    //implemetancion metodo que calcula el promedio de todas las notas
    //definitivas almacenadas 
    public float notaGeneral (){
        int cantidad=0;
        float suma=0;
        Nodo temp=cabeza;  
        while (temp!=null) {            
            cantidad ++;
            suma=suma + temp.definitiva();
            temp=temp.getSiguiente();
        }
        if (cantidad>0) {
            return suma/cantidad;
        } else {
            return 0;
        }  
    }    
    //metodo que devuelve la nota definitiva mas alta del curso   
    public float notaMasAlta(){ 
     float def,max=0;
     Nodo temp=cabeza;
        while (temp!=null) {            
            def=temp.definitiva();         
            if (def>max) {
                max=def;
            }     
            temp=temp.getSiguiente();
        }
        return max;  
    }
    public void limpiar (){
        while (cabeza!=null) {            
            eliminar(cabeza);
        }
    }
    public float CalcularPromedioGeneral(){
        //creamos las dos variables
       float suma=0, promedio=0;
       //creamos una varibale tipo nodo que se llame temp y la igualamos a la cabeza
        Nodo temp = cabeza;
        // utilizamos un condicional que pare cuando temp sea igual a null
        while(temp != null){
            //creamos un acumulador
            suma = suma+temp.definitiva();
            temp = temp.getSiguiente();
        }
        //hacemos la division para sacar el promedio
        promedio=suma/contarNodos();
        //aqui lo mandamos en resultado que se llama promedio en elreturn
        return promedio;             
         }      
  public void agregarenlaCabeza(Nodo nodo){
      //creo la auxiliar y la pongo como nodo
	Nodo aux=new Nodo(); 
	aux=nodo;
	aux.siguiente=null; 
        //un condicional para pregiuntar si la cabeza es null para llenarla
	if(cabeza==null){ 
            cabeza=aux; 
	} else{
            Nodo cabe;
            //igualamo a cabe con la cabeza
            cabe=cabeza;
            //le aignamos a cabeza el auxiliar
            cabeza=aux; 
            //entonces el auxilar siguiente va a ser igual a cabe
            aux.siguiente=cabe;  	}
}  
  //mandamos como parametro el nodo nuevo, el codigo donde se ubicara, y la pregunta si es antes o despues que se guardara el nodo
  public void agregarIntermedio(Nodo nuevo, int cod, int pregunta){
      
Nodo temp= cabeza;  //creamos una una variable temporal tipo nodo y le asignamos la cabeza
  
Nodo aux =null; //el auxiliar tipo nodo lo igualamos a null
 Nodo aux2=null;
if(cabeza==null){ //si la cabeza es igual a null entonces
     
cabeza.setSiguiente(nuevo);  //lo de la cabeza en el siguiente se le asignara a nuevo
}else{
while(temp!=null){
   
if(temp.getCodigo()==cod && pregunta==1){  //si el codigo del temp es igual codigo que ingreso

aux=temp.getSiguiente(); //al axuiliar se le asiganra el siguiente de temp
//aux2=temp.getAnterior();
nuevo.setSiguiente(aux); //al nuevo se le asignra el siguiente del auxiliar
nuevo.setAnterior(temp);
temp.setSiguiente(nuevo); //y el temp se le asignrara el siguiente del nuevo para que no se pierda
aux.setAnterior(nuevo);

break;

} else if(temp.getSiguiente().getCodigo()==cod && pregunta==2){ //si el codigo del siguiente del actual es igual al codigo que ingreso
    
aux=temp.getSiguiente(); //al axuiliar se le asiganra el siguiente de temp
//aux2=temp.getAnterior();
nuevo.setSiguiente(aux); //al nuevo se le asignra el siguiente del auxiliar
nuevo.setAnterior(temp);
temp.setSiguiente(nuevo); //y el temp se le asignrara el siguiente del nuevo para que no se pierda
aux.setAnterior(nuevo);
  break; 
}
temp=temp.getSiguiente();
         }
     }
}
    public  void ordenar(Nodo nodo){  
      Nodo temp=cabeza;    
    }         
 }

