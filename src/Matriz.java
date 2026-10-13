import java.util.Scanner;

public class Matriz {

    private Scanner lee;
    byte [][] matriz = new byte[3][3];
    boolean acabar = false;
    byte turno=1;
    int empate =0;
    int p1=0;
    int p2=0;
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_BLUE = "\u001B[34m";

    public void mostrar(){
        if(turno!=1&& !acabar){
            System.out.println("Turno: "+ANSI_BLUE+"○"+ANSI_RESET);
        }else{
            if(!acabar){
                System.out.println("Turno: "+ANSI_RED+"X"+ANSI_RESET);
            }
        }
        for(int i=0;i<=2;i++){
            System.out.println();
            for(int f=0;f<=2;f++){

                if(matriz[i][f]==0){
                    System.out.print("|"+" "+"|");
                }
                else{
                    if(matriz[i][f]==1){
                        System.out.print("|"+ANSI_BLUE+"○"+ANSI_RESET+"|");

                    }
                    else{
                        if(matriz[i][f]==2){
                            System.out.print("|"+ANSI_RED+"X"+ANSI_RESET+"|");
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public boolean terminar(){
       byte a=0;

        if(((matriz[0][0]==1)&&(matriz[0][1]==1)&&(matriz[0][2]==1))||
                ((matriz[1][0]==1)&&(matriz[1][1]==1)&&(matriz[1][2]==1))||
                ((matriz[2][0]==1)&&(matriz[2][1]==1)&&(matriz[2][2]==1))||
                ((matriz[0][0]==1)&&(matriz[1][0]==1)&&(matriz[2][0]==1))||
                ((matriz[0][1]==1)&&(matriz[1][1]==1)&&(matriz[2][1]==1))||
                ((matriz[0][2]==1)&&(matriz[1][2]==1)&&(matriz[2][2]==1))||
                ((matriz[0][0]==1)&&(matriz[1][1]==1)&&(matriz[2][2]==1))||
                ((matriz[2][0]==1)&&(matriz[1][1]==1)&&(matriz[0][2]==1))){
            System.out.println("el ganador es "+"○");
            acabar =true;
            p1++;
        }else{
            if(((matriz[0][0]==2)&&(matriz[0][1]==2)&&(matriz[0][2]==2))||
                    ((matriz[1][0]==2)&&(matriz[1][1]==2)&&(matriz[1][2]==2))||
                    ((matriz[2][0]==2)&&(matriz[2][1]==2)&&(matriz[2][2]==2))||
                    ((matriz[0][0]==2)&&(matriz[1][0]==2)&&(matriz[2][0]==2))||
                    ((matriz[0][1]==2)&&(matriz[1][1]==2)&&(matriz[2][1]==2))||
                    ((matriz[0][2]==2)&&(matriz[1][2]==2)&&(matriz[2][2]==2))||
                    ((matriz[0][0]==2)&&(matriz[1][1]==2)&&(matriz[2][2]==2))||
                    ((matriz[2][0]==2)&&(matriz[1][1]==2)&&(matriz[0][2]==2))){
                System.out.println("el ganador es "+"X");
                acabar =true;
                p2++;
            }else{
                for(int i=0;i<=2;i++){
                    for(int f=0;f<=2;f++){

                        if(matriz[i][f]!=0){
                            a++;
                        }
                        if(a==9){
                            System.out.println("Empate");
                            empate++;
                            acabar =true;
                        }
                    }
                }
            }
        }
        return acabar;
    }

    public void reiniciar(){
        for(int i=0;i<=2;i++){
            for(int f=0;f<=2;f++){
                matriz[i][f]=0;
                acabar=false;
            }
        }
    }

    public void  cambiar(){
        lee = new Scanner(System.in);
        byte columna;
        byte fila =0;
        do{
            if(turno ==1){
                turno++;
            }else{
                turno--;
            }
            System.out.println("Columna");
            columna = lee.nextByte();
            if((columna<=3)&&(1<=columna)){

                System.out.println("Fila");
                fila = lee.nextByte();

                if((fila<=3)&&(1<=fila)){
                    if (!(matriz[fila-1][columna-1]==0)){
                        System.out.println("este lugar esta ocupado, intenta otra vez");
                        columna =0;

                        if(turno ==1){
                            turno++;
                        }else{
                            turno--;
                        }
                    }
                }else {
                    System.out.println("la fila debe ser entre 1 a 3");
                }
            }else{

                System.out.println("la columna debe ser entre 1 a 3");
            }
        }while(!(((columna<=3)&&(1<=columna))&&((fila<=3)&&(1<=fila))));

        matriz[fila-1][columna-1]= turno;
    }

    public void mostrarPuntaje(){
        System.out.println(ANSI_BLUE+"○ "+"= "+p1+ANSI_RESET);
        System.out.println(ANSI_RED+"X "+"= "+p2+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Empates "+"= "+empate+ANSI_RESET);
    }

    public String preguntar(String s){
        lee = new Scanner(System.in);
        String R;

        System.out.println(s);
        R= lee.nextLine();

        return R;
    }
}
