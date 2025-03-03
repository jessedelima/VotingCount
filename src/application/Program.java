package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        // Mapa para armazenar o total de votos por candidato
        Map<String, Integer> voteCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {

                // Divide a linha em nome do candidato e quantidade de votos
                String[] fields = line.split(",");
                String candidate = fields[0];
                int votes = Integer.parseInt(fields[1]);

                // Atualiza o total de votos do candidato no mapa
                voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + votes);

                line = br.readLine();
            }

            // Imprime o relatório consolidado
            for (String candidate : voteCount.keySet()) {
                System.out.println(candidate + ": " + voteCount.get(candidate));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}
