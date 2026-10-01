/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notas;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class Notas {

    public static void main(String[] args) {
        List<Double> nums_notas = leerNotas("src/notas/notitas.txt");
        Double sum_total = 0.0;
        Double media;
        for (Double n : nums_notas) {
            System.out.println(n);
            sum_total+=n;
        }
        
        
        media = sum_total/nums_notas.size();
        System.out.println("Calcular media: "+media);
    }

    public static List<Double> leerNotas(String ruta) {
        String archivo = ruta;
        System.out.println(Files.exists(Path.of(archivo)));
        List<Double> notasAlumnos = new ArrayList();
        try (BufferedReader in = Files.newBufferedReader(Path.of(archivo))) {
            String linea;
            while ((linea = in.readLine()) != null) {
                String[] nums = linea.split(" ");
                if (!linea.isBlank()) {

                    notasAlumnos.add(Double.parseDouble(nums[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        return notasAlumnos;
    }

}
