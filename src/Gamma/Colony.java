package Gamma;

import java.util.ArrayList;
import java.util.List;

public class Colony implements  Listener{
    List<Ant> population;
    AntFactory factory ;
    Writer writer;
    int food;
    int space;
    int eggs;

    public Colony(){
        food = 8;
        space = 16;
        eggs = 0;
        factory = new AntFactory(this);
        population = new ArrayList<>();
        population.add(factory.CreateQueen());
        population.add(factory.CreateWorker());
        population.add(factory.CreateWorker());
        population.add(factory.CreateWorker());
        writer = new Writer(this);

    }

    public void AddWorker(){
        population.add(factory.CreateWorker());
    }

    public void AddQueen(){
        population.add(factory.CreateQueen());
    }

    @Override
    public boolean newEgg() {
        eggs++;
        space--;
        if(space <= 1)
            return false;
        return true;
    }
    @Override
    public boolean addFood(int amount){
        food+=amount;
        if(food >= population.size()*10)
            return false;
        return true;
    }
}
