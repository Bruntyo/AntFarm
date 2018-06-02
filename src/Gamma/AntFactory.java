package Gamma;

public class AntFactory {
    private int idCounter = 0;
    Colony myColony;

    public AntFactory(Colony myColony){
        this.myColony = myColony;
    }

    public Ant CreateWorker(){
        //System.out.println("Ant number " + idCounter + " created!");
        Ant tempAnt = new Ant(idCounter++,false,true,Tasks.gatherFood,myColony);
        return tempAnt;
    }

    public Ant CreateQueen(){
        //System.out.println("Ant number " + idCounter + " created!");
        Ant tempAnt = new Ant(idCounter++,true,true, Tasks.layEggs,myColony);
        return tempAnt;
    }

}
