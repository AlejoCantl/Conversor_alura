/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Alejo
 */
public class VentanaDeSeleccion extends JFrame {
    JLabel Mensaje = new JLabel("Selecciona una opcion");
    JButton Monedas = new JButton("Monedas");
    JButton Temperaturas = new JButton("Temperaturas");
    public VentanaDeSeleccion() {
        setTitle("Ventana de Selección");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20)); // Espaciado horizontal y vertical
        setLocationRelativeTo(null);
        
        Mensaje.setFont(new Font("Arial", Font.PLAIN, 16));
        Monedas.setFont(new Font("Arial", Font.BOLD, 14));
        Temperaturas.setFont(new Font("Arial", Font.BOLD, 14));

        Monedas.setBackground(Color.GREEN);
        Temperaturas.setBackground(Color.BLUE);
        Monedas.setForeground(Color.WHITE);
        Temperaturas.setForeground(Color.WHITE);
        
        Monedas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInterfaz("Monedas");
            }
        });
         Temperaturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInterfaz("Temperaturas");
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(Monedas);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0))); // Agrega un espacio horizontal entre los botones
        buttonPanel.add(Temperaturas);
        
        add(Mensaje);
        add(buttonPanel);
        pack();
    }
    private void mostrarInterfaz(String texto){
    new Convirtiendo(texto).setVisible(true);
    this.dispose();
    }
}
