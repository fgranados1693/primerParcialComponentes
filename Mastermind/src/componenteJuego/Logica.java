package componenteJuego;

import java.util.Random;

/**
 *
 * @author Fernanda
 */
public class Logica {
    
    Random r = new Random();
    String listaColores = "ARBNVA";
    char [] arrayOculto = new char[4];
    char [] arrayUsuario = new char[4];
    int aciertoParcial; 
    int aciertoTotal;
    int intentos = 8;
    char letra;
    
    public void generarColoresRandom() {
     
        for (int i = 0; i < 4; i++) {
            letra = listaColores.charAt(r.nextInt(listaColores.length()));
            arrayOculto[i] = letra;
            System.out.print(arrayOculto[i]);            
        }
    }   
    
    public void compararArrays(){
        
        char [] copia_arrayOculto = new char[] {'0','0','0','0'};
        char [] copia_arrayUsuario = new char[] {'0','0','0','0'};
        for (int i = 0; i < 4; i++){
            copia_arrayOculto[i] = arrayOculto[i];
            copia_arrayUsuario[i] = arrayUsuario[i];
            
        }
        for (int i = 0; i < 4; i++) {
            if (copia_arrayOculto[i] == copia_arrayUsuario[i]) {
                copia_arrayOculto[i] = '1';
                copia_arrayUsuario[i] = '2';
                aciertoTotal++;
            }
            
            for (int j = 0; j < 4; j++) {
                if(copia_arrayOculto[i] == copia_arrayUsuario[j]) {
                    copia_arrayOculto[i] = '1';
                    copia_arrayUsuario[j] = '2';
                    aciertoParcial++;
                }
            }
        }
        intentos --;
    }    
    
    public int getIntentos() {
    
        return intentos;
    }
    
    public void setInputUsuario(String inputUsuario) {
       
        arrayUsuario = inputUsuario.toCharArray();
    }
    
    public int getAciertoParcial() {
        return aciertoParcial;
    }
    
    public int getAciertoTotal() {
        return aciertoTotal;
    }
    public void resetJuego(){
    
        intentos = 8;
        aciertoParcial = 0;
        aciertoTotal = 0;
    }
    
    public void resetPuntajes(){
        aciertoParcial = 0;
        aciertoTotal = 0;
    }
}
