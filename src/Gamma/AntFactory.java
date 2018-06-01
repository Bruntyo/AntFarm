package Gamma;

public class AntFactory {
    private int idCounter = 0;

    public Ant CreateWorker(){
        System.out.println("Ant number " + idCounter + " created!");
        Ant tempAnt = new Ant(idCounter++,false,true,Tasks.gatherFood);
        return tempAnt;
    }

    public Ant CreateQueen(){
        System.out.println("Ant number " + idCounter + " created!");
        Ant tempAnt = new Ant(idCounter++,true,true, Tasks.layEggs);
        return tempAnt;
    }

}
