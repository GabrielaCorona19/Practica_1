package practica1_20084;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Hilo1 extends Thread{
    private JTextArea area;
    public boolean suspender,pausar;
    public Hilo1(JTextArea area){
        this.area=area;
        this.suspender=false;
        this.pausar=false;
    }
    public void run(){
        int i=0;
            while(true){
                if(suspender==false && pausar==false){
                    area.append(i + "\n");
                    i++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(suspender==true && pausar==true){
                    area.append("Hilo Detenido");
                    break;
                }
            }
    }
    
    //Pausar el hilo
    public void pausarhilo(){
        this.pausar=false;
        //lo siguiente garantiza que un hilo suspendido puede detenerse.
        this.suspender=true;
    }

    //Renaudar un hilo
   public void renaudarhilo(){
       this.pausar=false;
        this.suspender=false;
    }
   
   public void deterhilo(){
       this.pausar=true;
       this.suspender=true;
   }
}
