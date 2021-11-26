package ejemplo3;

public class HiloDecrementador extends Thread{
    private Contador contador;

    public HiloDecrementador(String n, Contador c){
        setName(n);
        contador = c;
    }

    public void run(){
        for (int i = 0; i < 300; i++) {
            contador.decrementa();
            try{
                sleep(10);
            }catch (InterruptedException e){
            }
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}
