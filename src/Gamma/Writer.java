package Gamma;

public class Writer implements  Runnable{

    Thread thread;
    Colony colony;
    public Writer(Colony colony)
    {
        this.colony = colony;
        System.out.println("Writer created!");
        this.start();
    }

    @Override
    public void run() {
        while(true){
            this.colony = colony;
            System.out.println("there's " + colony.eggs + " eggs in the colony, and " + colony.space + " units of space, and " + colony.food + " food");
            try{
                Thread.sleep(3000);
            }
            catch (Exception e){

            }
        }
    }

    public void start(){
        //System.out.println("Ant number " + ant.id + " started working");
        if(thread == null){
            thread = new Thread(this,"writer");
            thread.start();
        }
    }
}
