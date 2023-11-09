package Test;

import conversor_de_monedas_v2.*;
import conversor_de_temperaturas.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Alejo
 */
public class Convirtiendo extends JFrame {

    private JTextField amountField;
    private JComboBox<Object> fromCurrencyComboBox;
    private JComboBox<Object> toCurrencyComboBox;
    private JButton convertButton;
    private JButton back;
    private JLabel resultLabel;
    private final List<Object> currencies;

    public Convirtiendo(String tipo) {
        setTitle("Convirtiendo " + tipo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Diseño de borde con espaciado
        setPreferredSize(new Dimension(700, 400));

        currencies = new ArrayList<>();
        if (tipo.equals("Monedas")) {
            currencies.add(new PesoColombiano());
            currencies.add(new Dolar());
            currencies.add(new LibraEsterlina());
            currencies.add(new Euro());
        } else if (tipo.equals("Temperaturas")) {
            currencies.add(new TemperaturaCelsius());
            currencies.add(new TemperaturaFahrenheit());
            currencies.add(new TemperaturaKelvin());
        }

        createUI();
    }

    private void createUI() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10)); // Cuadrícula para campos de entrada
        inputPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        amountField = new JTextField(10);
        try {
            fromCurrencyComboBox = new JComboBox<>(currencies.toArray());
            toCurrencyComboBox = new JComboBox<>(currencies.toArray());
        } catch (Exception e) {
            e.printStackTrace();

        }
        fromCurrencyComboBox.setFont(new Font("Arial",Font.CENTER_BASELINE,18));
        toCurrencyComboBox.setFont(new Font("Arial",Font.CENTER_BASELINE,18));
        convertButton = new JButton("Convertir");
        convertButton.setFont(new Font("Arial", Font.BOLD, 16));
        convertButton.setBackground(Color.orange);
        convertButton.setForeground(Color.red);
        resultLabel = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.RED, 2);
        resultLabel.setPreferredSize(new Dimension(300, 30));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setBorder(border);

        fromCurrencyComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                String displayValue = "";
                String className = value.getClass().getName(); // Obtén el nombre de la clase del objeto
                String classNameWithoutPackage = className.substring(className.lastIndexOf('.') + 1);
                if (value instanceof Dinero) {

                    // Itera sobre el array Dinero.tip para encontrar una coincidencia
                    for (String tip : Dinero.tip) {
                        if (tip.equals(classNameWithoutPackage)) {
                            displayValue = tip; // Establece el valor a mostrar en el JComboBox
                            break;
                        }
                    }
                } else {
                    if (value instanceof Temperatura) {
                        for (String tip : Temperatura.tip) {
                            if (tip.equals(classNameWithoutPackage)) {
                                displayValue = tip; // Establece el valor a mostrar en el JComboBox
                                break;
                            }
                        }
                    }
                }

                JLabel label = (JLabel) super.getListCellRendererComponent(list, displayValue, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        }
        );

        toCurrencyComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                String displayValue = "";
                String className = value.getClass().getName(); // Obtén el nombre de la clase del objeto
                String classNameWithoutPackage = className.substring(className.lastIndexOf('.') + 1); // Obtiene solo el nombre de la clase sin el paquete
                if (value instanceof Dinero) {
                    // Itera sobre el array Dinero.tip para encontrar una coincidencia
                    for (String tip : Dinero.tip) {
                        if (tip.equals(classNameWithoutPackage)) {
                            displayValue = tip; // Establece el valor a mostrar en el JComboBox
                            break;
                        }
                    }
                } else {
                    if (value instanceof Temperatura) {
                        for (String tip : Temperatura.tip) {
                            if (tip.equals(classNameWithoutPackage)) {
                                displayValue = tip; // Establece el valor a mostrar en el JComboBox
                                break;
                            }
                        }
                    }
                }
                JLabel label = (JLabel) super.getListCellRendererComponent(list, displayValue, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        }
        );

        inputPanel.add(new JLabel("Cantidad: "));
        amountField.setHorizontalAlignment(SwingConstants.CENTER);
        amountField.setFont(new Font("Arial",Font.PLAIN,16));
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("De: "));
        inputPanel.add(fromCurrencyComboBox);
        inputPanel.add(new JLabel("A: "));
        inputPanel.add(toCurrencyComboBox);
        inputPanel.add(new JLabel()); // Espacio en blanco para el diseño
        inputPanel.add(convertButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        back = new JButton("Regresar a ventana principal");
        back.setBackground(Color.MAGENTA);
        back.setForeground(Color.white);
        buttonPanel.add(back);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultLabel.setPreferredSize(new Dimension(300, 30));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultPanel.add(resultLabel);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultPanel, BorderLayout.NORTH);

        // Agregar acción al botón de conversión
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConvertCurrency();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaDeSeleccion().setVisible(true);
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    private void ConvertCurrency() {
        double amount = Double.parseDouble(amountField.getText());

        Object fromCurrency = fromCurrencyComboBox.getSelectedItem();
        Object toCurrency = toCurrencyComboBox.getSelectedItem();

        if (fromCurrency != null && toCurrency != null) {
            // Verifica si ambos objetos son instancias de Temperatura
            if (fromCurrency instanceof Temperatura && toCurrency instanceof Temperatura) {
                Temperatura fromTemperature = (Temperatura) fromCurrency;
                Temperatura toTemperature = (Temperatura) toCurrency;
                fromTemperature.setTemperatura(amount);
                double convertedAmount = 0;

                // Realiza la conversión utilizando las implementaciones por defecto de la interfaz
                if (toTemperature instanceof TemperaturaCelsius) {
                    convertedAmount = (double) fromTemperature.convertToCelsius().doubleValue();
                } else if (toTemperature instanceof TemperaturaFahrenheit) {
                    convertedAmount = (double) fromTemperature.convertToFahrenheit().doubleValue();
                } else if (toTemperature instanceof TemperaturaKelvin) {
                    convertedAmount = (double) fromTemperature.convertToKelvin().doubleValue();
                }
                // Mostrar el resultado
                resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromTemperature.getSimbolo(), convertedAmount, toTemperature.getSimbolo()));
            } else {
                // Si no son instancias de Temperatura, se asume que son instancias de Dinero (moneda)
                Dinero fromMoney = (Dinero) fromCurrency;
                Dinero toMoney = (Dinero) toCurrency;

                // Realiza la conversión de moneda
                double convertedAmount = (double) fromMoney.convertir(amount, toMoney);

                // Mostrar el resultado
                resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromMoney.getSimbolo(), convertedAmount, toMoney.getSimbolo()));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccion 'De' y 'a' currencies or temperatures.", "Invalid Selection", JOptionPane.ERROR_MESSAGE);
        }
    }
}
