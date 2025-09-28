package com.example.login;

/*
 Hecho por Alejandro Rolón
 Versión 1 — Clásica
 Usuario: interfaz básica con interacción mínima (activar botón al aceptar términos, mostrar diálogo)
*/

import javax.swing.*;
import java.awt.*;

public class ClassicLogin {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClassicLogin::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Versión 1 — Clásica (Hecho por Alejandro Rolón)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblLogo = new JLabel("MiApp Classic - Alejandro");
        lblLogo.setFont(new Font("Serif", Font.BOLD, 20));
        lblLogo.setBounds(20,10,380,30);
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblLogo);

        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setBounds(50,60,80,25);
        panel.add(lblUser);

        JTextField txtUser = new JTextField();
        txtUser.setBounds(140,60,200,25);
        txtUser.setToolTipText("Introduce tu nombre de usuario");
        panel.add(txtUser);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(50,100,80,25);
        panel.add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(140,100,200,25);
        txtPass.setToolTipText("Introduce tu contraseña");
        panel.add(txtPass);

        JCheckBox chkTerms = new JCheckBox("Aceptar términos y condiciones");
        chkTerms.setBounds(50,140,280,25);
        chkTerms.setToolTipText("Debes aceptar para continuar");
        panel.add(chkTerms);

        JButton btnAccess = new JButton("Acceder");
        btnAccess.setBounds(140,180,100,30);
        btnAccess.setFocusable(false);
        btnAccess.setToolTipText("Pulsa para acceder");
        btnAccess.setEnabled(false); // inicialmente deshabilitado
        panel.add(btnAccess);

        // Interacción mínima: habilitar botón si acepta términos; al pulsar mostrar diálogo con usuario
        chkTerms.addActionListener(e -> btnAccess.setEnabled(chkTerms.isSelected()));
        btnAccess.addActionListener(e -> {
            String user = txtUser.getText().trim();
            JOptionPane.showMessageDialog(frame,
                    "Intento de acceso por: " + (user.isEmpty() ? "<sin usuario>" : user),
                    "Acceso (simulado)",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
