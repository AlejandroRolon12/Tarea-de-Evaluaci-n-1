package com.example.login;

/*
 Hecho por Alejandro Rolón
 Versión 2 — Extendida
 Interacción: cambiar idioma etiqueta, recordar usuario (marca/desmarca), botón activable con términos
*/

import javax.swing.*;
import java.awt.*;

public class ExtendedLogin {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ExtendedLogin::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Versión 2 — Extendida (Hecho por Alejandro Rolón)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 320);
        frame.setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout(10,10));

        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel logo = new JLabel("MiApp Extended - Alejandro");
        logo.setFont(new Font("SansSerif", Font.BOLD, 18));
        top.add(logo);

        JPanel center = new JPanel();
        center.setLayout(null);

        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setBounds(30,10,100,25);
        center.add(lblUser);

        JTextField txtUser = new JTextField();
        txtUser.setBounds(140,10,240,25);
        txtUser.setToolTipText("Nombre de usuario");
        center.add(txtUser);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(30,50,100,25);
        center.add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(140,50,240,25);
        txtPass.setToolTipText("Contraseña segura");
        center.add(txtPass);

        JCheckBox chkRemember = new JCheckBox("Recordar usuario");
        chkRemember.setBounds(140,90,180,25);
        chkRemember.setToolTipText("Marca para recordar el usuario");
        center.add(chkRemember);

        JComboBox<String> cmbLang = new JComboBox<>(new String[] { "Español", "English", "Français" });
        cmbLang.setBounds(140,120,140,25);
        cmbLang.setToolTipText("Selecciona idioma");
        center.add(cmbLang);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAccess = new JButton("Acceder");
        btnAccess.setToolTipText("Acceso extendido");
        btnAccess.setEnabled(false);
        bottom.add(btnAccess);

        JCheckBox chkTerms = new JCheckBox("Aceptar términos");
        bottom.add(chkTerms);

        // Acción: habilitar botón con términos
        chkTerms.addActionListener(e -> btnAccess.setEnabled(chkTerms.isSelected()));

        // Acción: recordar usuario (simulado) — al marcar, bloquea edición del campo y lo pone en gris
        chkRemember.addActionListener(e -> {
            boolean remember = chkRemember.isSelected();
            txtUser.setEditable(!remember);
            txtUser.setBackground(remember ? new Color(240,240,240) : Color.WHITE);
        });

        // Acción: cambiar textos según idioma seleccionado (ejemplo simple)
        cmbLang.addActionListener(e -> {
            String lang = (String)cmbLang.getSelectedItem();
            if ("English".equals(lang)) {
                lblUser.setText("User:");
                lblPass.setText("Password:");
                chkRemember.setText("Remember user");
                chkTerms.setText("Accept terms");
                btnAccess.setText("Log in");
            } else if ("Français".equals(lang)) {
                lblUser.setText("Utilisateur:");
                lblPass.setText("Mot de passe:");
                chkRemember.setText("Se souvenir");
                chkTerms.setText("Accepter termes");
                btnAccess.setText("Accéder");
            } else {
                lblUser.setText("Usuario:");
                lblPass.setText("Contraseña:");
                chkRemember.setText("Recordar usuario");
                chkTerms.setText("Aceptar términos");
                btnAccess.setText("Acceder");
            }
        });

        // Pulsar acceder muestra datos básicos (simulado)
        btnAccess.addActionListener(e -> {
            String u = txtUser.getText().trim();
            JOptionPane.showMessageDialog(frame, "Usuario: " + (u.isEmpty() ? "<vacío>" : u), "Acceso simulado", JOptionPane.INFORMATION_MESSAGE);
        });

        main.add(top, BorderLayout.NORTH);
        main.add(center, BorderLayout.CENTER);
        main.add(bottom, BorderLayout.SOUTH);

        frame.setContentPane(main);
        frame.setVisible(true);
    }
}
