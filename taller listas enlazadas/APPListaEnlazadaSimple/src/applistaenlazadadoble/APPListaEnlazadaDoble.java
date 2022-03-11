/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applistaenlazadadoble;

import javax.swing.JOptionPane;

/**
 *
 * @author 1005664564
 */
public class APPListaEnlazadaDoble {

    public static void llenar(Nodo nod){
       int cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese código: "));
        nod.setCodigo(cod);
        String nombre = JOptionPane.showInputDialog("Ingrese nombre: ");
        nod.setNombre(nombre);
        float nota1 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese nota 1: "));
        nod.setNota1(nota1);
        float nota2 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese nota 2: "));
        nod.setNota2(nota2);
        float nota3 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese nota 3: "));
        nod.setNota3(nota3);   
        
        
    }
    public static void mostrar(Nodo nod){
        
        String datosNodo="";
        datosNodo=datosNodo+String.valueOf("Codigo : "+nod.getCodigo()+"\n"+"nombre : "+nod.getNombre()+"\n"+"Nota 1 : "+nod.getNota1()+"\n"+"Nota 2 : "+nod.getNota2()+
                "\n"+"Nota 3 : "+nod.getNota3()+"\n"+"Definitva: "+nod.definitiva()+"\n"+"\n");
        
        JOptionPane.showMessageDialog(null, "========= INFORMACION DE LOS ESTUDIANTES ========= \n"+datosNodo);
    }
    
    //meotod para alistar uno a uno los nodos de la lista
    
    public static void listarNodos(Nodo nod){
        
        Nodo temp=nod;
        
        while (temp!=null) {            
            mostrar(temp);
            temp=temp.getSiguiente();
        }
        
   
    }
    
    
 
    
    
    
    
    
    //metodo para crear el menu de opciones
    
    public static int menu(){
    
    int opcion=0;
    
    
        do {            
            opcion=Integer.parseInt(JOptionPane.showInputDialog("====== Selecione una opcion del menu ======== \n"+
                    "1. Agregar un Estudiante a la lista. \n"
                    + "2. Mostrar todos los estdiantes del curso.\n"
                    + "3. Cantidad de estudiantes existentes de la lista. \n"
                    + "4. Buscar la informacion de un estudiante. \n"
                    + "5. Eliminar un estudiante de la lista. \n"
                    + "6. Informe: Promedio general y maxima nota. \n"
                    + "7. Borrar la lista de estudiantes \n"
                    + "8. Mostrar el promedio general del curso\n"
                    + "9. Agregar un estudiante en la cabeza de la lista\n"
                    +"10. Agregar un estudiante en la posicion que usted elija \n"
                    
                    +"11. Salir  \n"
                    +"Selecione una opcion del 1-11"));
            
            
        } while (opcion <=0 || opcion>=12);
    
    return opcion;
}
    
    
    
    public static void main(String[] args) {
     
    
       ListaEnlazadaDoble lista= new ListaEnlazadaDoble();
       Nodo aux;
    int opcion=0;
        do {            
             opcion=menu();  
            switch(opcion){
                case 1:
                   aux = new Nodo(); 
                    llenar(aux);
                    lista.agregarNodo(aux);
                    break;
                  
                case 2 :
                    if (lista.getCabeza()!=null) {
                        listarNodos(lista.getCabeza());
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista esta vacia ");
                        
                    }
                    
                    break;
                    
                case 3 :
                    
                    JOptionPane.showMessageDialog(null, "========Numero de nodos de la lista ========\n"
                            + lista.contarNodos()+" Estudiantes");
                    
                    break;
                    
                case 4:
                    
                    int cod=Integer.parseInt(JOptionPane.showInputDialog( "Digite el codigo del estudiante"));
                    aux =lista.buscar(cod);
                    if (aux !=null) {
                        mostrar(aux);
                    } else{
                        JOptionPane.showMessageDialog(null, "Informacion no encontrada");
                        
                    }
                    
                    
                    break;
                    
                case 5:
                    
                     cod= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del estudiante a eliminar"));
                    
                    aux =lista.buscar(cod);
                    
                    if (aux!=null) {
                        lista.eliminar(aux);
                        
                        JOptionPane.showMessageDialog(null, "Informacion eliminada con exito...");
                    } else{
                        
                        
                                             JOptionPane.showMessageDialog(null, "El codigo del estudiante no existe en la lista");
   
                    }
                    
                    
              case 6:
                    JOptionPane.showMessageDialog(null, "-------- Informe Promedio General y Nota Máxima -------\n"+
                            "Promedio General : "+"\n"+"Nota máxima del curso: "+lista.maxDefinitiva());
                break;
                case 7:
                    lista.limpiar();
                    JOptionPane.showMessageDialog(null, "Lista Vacía....");
                break;
                
                
                case 8:

                    JOptionPane.showMessageDialog(null, "-------- Informe del promedio general del curso ------ \n"+ 
                        "El Promedio general del curso es: "
                            +lista.CalcularPromedioGeneral());
                    
                    break;
                
                case 9:
                  //llamo la funcion llenar y le mando como parametro el auxiliar
                    aux = new Nodo();
                    //llamo la funcion llenar y le mando como parametro el nodo
                    llenar(aux);
                    //lamo la funcion lista.agregarenlaCabeza y le mando como parametro el nodo
                    lista.agregarenlaCabeza(aux); 
                    
                    
                    
                    
                    break;
              
                       case 10:
                       //creo un auxiliar de clase nodo    
                    aux = new Nodo();
                    //llamo la funcion llenar y le mando como parametro el auxiliar
                    llenar(aux);
              
int codigo =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo en el que se va a ubicar"));
int pregunta= Integer.parseInt(JOptionPane.showInputDialog("1. si quieres agregarlo despues del codigo donde se ubico "
        + "\n 2. si quieres agregarlo detras del codigo donde se ubico "
        + "\n Selecione una opcion 1-2"));
         lista.agregarIntermedio(aux, codigo, pregunta);
                    
               
                     
                        
                        break; 
                       case 11:
                           JOptionPane.showMessageDialog(null, "Adios");
                           
                           break;
                        
                          
            }
       
            
        } while (opcion !=11);
       
        
        
        
    }
    
}
