

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Matriz gato = new Matriz();
        boolean i = true;
        //gato.colores();
        do{
            gato.mostrar();
            gato.cambiar();
            if(gato.terminar()==true){
                gato.mostrar();
                if(gato.preguntar("Escribe (si), si quieres seguir jugando: ").equalsIgnoreCase("si")){
                    gato.reiniciar();
                }else {
                    gato.mostrarPuntaje();
                    i=false;
                }
            }
        }while(i==true);
    }
}