package Gamma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) {
        AntFactory factory = new AntFactory();
        Scanner scanner = new Scanner(System.in);
        List<Ant> colony = new ArrayList<>();
        colony.add(factory.CreateQueen());
        colony.add(factory.CreateWorker());

        //String asd = scanner.next();
        try {
            Thread.sleep(4000);
        }
        catch (Exception e) {}
        colony.get(1).task = Tasks.layEggs;
        colony.add(factory.CreateWorker());
        colony.get(2).task = Tasks.gatherFood;

    }
}
