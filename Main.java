package D_JavaAdvancedOOP.Lecture4_InterfaceAndAbstraction.ExProblem_4;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Citizen> listOfCitizens = new LinkedHashMap<>();
        Map<String, Rebel> listOfRebels = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            if (input.length == 4) {
                if (!listOfRebels.containsKey(name)) {
                    Citizen newCitizen = new Citizen(name, age, input[2], input[3]);
                    listOfCitizens.putIfAbsent(name, newCitizen);
                }
            } else if (input.length == 3) {
                if (!listOfCitizens.containsKey(name)) {
                    Rebel newRebel = new Rebel(name, age, input[2]);
                    listOfRebels.putIfAbsent(name, newRebel);
                }
            }
        }

        int totalFoodPurchased = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String name = command;

            if (listOfCitizens.containsKey(name)) {
                listOfCitizens.get(name).buyFood();
                totalFoodPurchased += 10;
            } else if (listOfRebels.containsKey(name)) {
                listOfRebels.get(name).buyFood();
                totalFoodPurchased += 5;
            }
            command = scanner.nextLine();
        }

        System.out.println(totalFoodPurchased);



    }
}
