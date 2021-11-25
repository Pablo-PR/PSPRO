package ejemploHiloSimple1;

public class HiloSimple extends Thread{
    public void run(){
        try {
            Thread.sleep(2500) ;
            System.out.println("Ejecuto");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}