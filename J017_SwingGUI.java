package assignment_jdbc;

import javax.swing.*;

public class J017_SwingGUI
{
    public static void main(String[] args)
    {

        // Create a frame
        JFrame frame = new JFrame("User Form");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels and text fields
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(50, 30, 100, 25);
        JTextField txtId = new JTextField();
        txtId.setBounds(150, 30, 180, 25);

        JLabel lblFname = new JLabel("First Name:");
        lblFname.setBounds(50, 70, 100, 25);
        JTextField txtFname = new JTextField();
        txtFname.setBounds(150, 70, 180, 25);

        JLabel lblLname = new JLabel("Last Name:");
        lblLname.setBounds(50, 110, 100, 25);
        JTextField txtLname = new JTextField();
        txtLname.setBounds(150, 110, 180, 25);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 150, 100, 25);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(150, 150, 180, 25);

        // Create a button
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(150, 200, 100, 30);

        // Add components to frame
        frame.add(lblId);
        frame.add(txtId);
        frame.add(lblFname);
        frame.add(txtFname);
        frame.add(lblLname);
        frame.add(txtLname);
        frame.add(lblEmail);
        frame.add(txtEmail);
        frame.add(btnSubmit);

        // Make frame visible
        frame.setVisible(true);
    }
}
