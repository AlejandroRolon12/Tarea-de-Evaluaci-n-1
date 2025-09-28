package com.example.login;

/*
 Hecho por Alejandro Rolón
 Versión 3 — Creativa
 Interacción: pestañas login/registro, progress bar, slider, spinner y validaciones simples visuales
*/

import javax.swing.*;
import java.awt.*;

public class CreativeLogin {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CreativeLogin::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Versión 3 — Creativa (Hecho por Alejandro Rolón)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 420);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        // Tab: Login
        JPanel pnlLogin = new JPanel(null);
        JLabel logo = new JLabel("MiApp Creative - Alejandro");
        logo.setFont(new Font("Monospaced", Font.BOLD, 20));
        logo.setBounds(10,10,600,30);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        pnlLogin.add(logo);

        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setBounds(100,70,80,25);
        pnlLogin.add(lblUser);

        JTextField txtUser = new JTextField();
        txtUser.setBounds(190,70,220,25);
        pnlLogin.add(txtUser);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(100,110,80,25);
        pnlLogin.add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(190,110,220,25);
        pnlLogin.add(txtPass);

        JProgressBar pbar = new JProgressBar(0,100);
        pbar.setBounds(100,150,310,20);
        pbar.setString("Listo");
        pbar.setStringPainted(true);
        pbar.setValue(100);
        pnlLogin.add(pbar);

        JSlider slider = new JSlider(0,100,50);
        slider.setBounds(100,185,310,45);
        slider.setToolTipText("Barra creativa (sin uso real)");
        pnlLogin.add(slider);

        JButton btnAccess = new JButton("Acceder");
        btnAccess.setBounds(260,240,100,30);
        pnlLogin.add(btnAccess);

        btnAccess.addActionListener(e -> {
            String u = txtUser.getText().trim();
            // pequeño efecto: progresBar se pone a 0 y luego a 100 (simulado) — sin hilos pesados
            pbar.setValue(30);
            JOptionPane.showMessageDialog(frame, "Intento de acceso (simulado) por: " + (u.isEmpty() ? "<vacío>" : u), "Acceso", JOptionPane.INFORMATION_MESSAGE);
            pbar.setValue(100);
        });

        tabs.addTab("Login", pnlLogin);

        // Tab: Registro
        JPanel pnlRegister = new JPanel(null);
        JLabel lblReg = new JLabel("Registro rápido");
        lblReg.setBounds(10,10,600,30);
        lblReg.setFont(new Font("Dialog", Font.BOLD, 18));
        pnlRegister.add(lblReg);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(100,60,80,25);
        pnlRegister.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(190,60,220,25);
        pnlRegister.add(txtEmail);

        JLabel lblAge = new JLabel("Edad:");
        lblAge.setBounds(100,100,80,25);
        pnlRegister.add(lblAge);

        JSpinner spinnerAge = new JSpinner(new SpinnerNumberModel(18, 13, 99, 1));
        spinnerAge.setBounds(190,100,80,25);
        pnlRegister.add(spinnerAge);

        JButton btnRegister = new JButton("Registrar");
        btnRegister.setBounds(300,150,110,30);
        pnlRegister.add(btnRegister);

        btnRegister.addActionListener(e -> {
            String email = txtEmail.getText().trim();
            int age = (Integer) spinnerAge.getValue();
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Introduce un email", "Registro", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Registro simulado:\nEmail: " + email + "\nEdad: " + age, "Registro", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        tabs.addTab("Registro", pnlRegister);

        frame.setContentPane(tabs);
        frame.setVisible(true);
    }
}
