
package classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Concurso {
    public static void main(String[] args) {
        List<Candidato> candidatos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Concurso.class.getResourceAsStream("/resources/dadosConcurso.csv")))) {
            
            String linha = br.readLine();  

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                
                
                if (dados.length == 4) {
                    String id = dados[0];
                    String nome = dados[1];
                    String dataNascimento = dados[2];
                    double nota = Double.parseDouble(dados[3]);
                    candidatos.add(new Candidato(id, nome, dataNascimento, nota));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        Collections.sort(candidatos);

        
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }
    }
}

