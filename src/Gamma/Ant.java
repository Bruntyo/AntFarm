package Gamma;

public class Ant {
    private boolean queen;
    private boolean female;
    int id;
    Tasks task;
    Action action;
    String description;

    public Ant(int id, boolean queen, boolean female, Tasks task){
        this.id = id;
        this.queen = queen;
        this.female = female;
        this.task = task;
        action = new Action(this);
        action.start();
        description = "This is a" + (female ? " female" : " male") + " ant." + " It is a" +
                (queen ? " queen" : " regular") + " ant. It's currently doing its best to " + task.toString();
        System.out.println(description);
    }

    public String getFemale(){
        if (this.female)
            return "female";
        else
            return "male";
    }
    public String getQueen(){
        if (this.queen)
            return "queen";
        else
            return "regular";
    }
}

class Action implements Runnable {

    Thread thread;
    Ant ant;

    public Action(Ant ant) {
        this.ant = ant;
    }

    public void run() {
        while (ant.task == Tasks.gatherFood) {
            System.out.println("Ant number " + ant.id + " is gathering food");
            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {
                System.out.println("A problem occurred with " + thread.getName());
            }
        }
        while (ant.task == Tasks.layEggs) {
            System.out.println("Ant number " + ant.id + " is laying eggs");
            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {
                System.out.println("A problem occurred with " + thread.getName());
            }        }

    }

    public void start(){
        System.out.println("Ant number " + ant.id + " started working");
        if(thread == null){
            thread = new Thread(this,"thread #" + ant.id);
            try {
                Thread.sleep(1000);
            }
            catch(Exception e){}
            thread.start();
        }
    }
}