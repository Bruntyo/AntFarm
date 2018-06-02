package Gamma;

public class Ant {
    boolean queen;
    boolean female;
    int id;
    Tasks task;
    Action action;
    String description;
    Colony myColony;

    public Ant(int id, boolean queen, boolean female, Tasks task, Colony myColony){
        this.id = id;
        this.queen = queen;
        this.female = female;
        this.task = task;
        this.myColony = myColony;
        action = new Action(this);
        action.start();
        description = "Ant number " + id + " is " + (female ? " female" : " male") + ". It is a" +
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
    public void feed(){
        myColony.food--;
    }
}

class Action implements Runnable {

    Thread thread;
    Ant ant;

    public Action(Ant ant) {
        this.ant = ant;
    }

    public void run() {
        while (true) {
            if (ant.task == Tasks.gatherFood) {
                System.out.println("Ant number " + ant.id + " is gathering food");
                while (ant.task == Tasks.gatherFood) {
                    if (ant.myColony.addFood(3)) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            System.out.println("A problem occurred with " + thread.getName());
                        }
                        ant.feed();
                    } else {
                        System.out.println("Ant number " + ant.id + " has gathered enough food and returned to the colony");
                        ant.task = Tasks.IDLE;
                    }
                }
            }
            if (ant.task == Tasks.layEggs) {
                System.out.println("Ant number " + ant.id + " is laying eggs");
                while (ant.task == Tasks.layEggs) {
                    if (ant.myColony.newEgg() == true) {
                        try {
                            Thread.sleep(2300);
                        } catch (Exception e) {
                            System.out.println("A problem occurred with " + thread.getName());
                        }
                        ant.feed();
                    } else {
                        System.out.println("Ant number " + ant.id + " can not lay any more eggs.");
                        ant.task = Tasks.IDLE;
                    }
                }
            }
            if (ant.task == Tasks.IDLE) {
                System.out.println("Ant number " + ant.id + " is IDLE!!");
                while (ant.task == Tasks.IDLE) {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        System.out.println("A problem occurred with " + thread.getName());
                    }
                    ant.feed();
                    if ((ant.myColony.food <= ant.myColony.population.size() * 4) && !ant.queen) {
                        ant.task = Tasks.gatherFood;
                    }
                }
            }

        }
    }

    public void start(){
        //System.out.println("Ant number " + ant.id + " started working");
        if(thread == null){
            thread = new Thread(this,"thread #" + ant.id);
            thread.start();
        }
    }
}