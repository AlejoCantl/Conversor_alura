/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import javax.swing.SwingUtilities;

/**
 *
 * @author Alejo
 */
public class Mostrar {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaDeSeleccion().setVisible(true);
        });
    }
}
