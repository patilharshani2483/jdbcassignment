//Perform the corresponding JDBC operation for each button click
package LabAssignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class L005_CorrespondingJdbcOperationsForEachButtonClick
{

    static final String DB_URL = "jdbc:mysql://localhost:3306/java";
    static final String DB_USER = "root";
    static final String DB_PASS = "admin";

    public static void main(String[] args)
    {
        // Frame
        JFrame frame = new JFrame("JDBC CRUD Operations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        // Fields
        JTextField idField = new JTextField();
        JTextField fnameField = new JTextField();
        JTextField lnameField = new JTextField();
        JTextField emailField = new JTextField();

        // Buttons
        JButton insertBtn = new JButton("Insert");
        JButton updateBtn = new JButton("Update");
        JButton selectBtn = new JButton("Select");
        JButton deleteBtn = new JButton("Delete");

        // Add components
        frame.add(new JLabel("ID:"));
        frame.add(idField);
        frame.add(new JLabel("First Name:"));
        frame.add(fnameField);
        frame.add(new JLabel("Last Name:"));
        frame.add(lnameField);
        frame.add(new JLabel("Email:"));
        frame.add(emailField);
        frame.add(insertBtn);
        frame.add(updateBtn);
        frame.add(selectBtn);
        frame.add(deleteBtn);

        // JDBC Operations
        insertBtn.addActionListener(e -> {
            try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS))
            {
                String query = "INSERT INTO usersjdbc (id, fname, lname, email) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(idField.getText()));
                pst.setString(2, fnameField.getText());
                pst.setString(3, lnameField.getText());
                pst.setString(4, emailField.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Record Inserted Successfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        updateBtn.addActionListener(e ->
        {
            try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS))
            {
                String query = "UPDATE usersjdbc SET fname=?, lname=?, email=? WHERE id=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, fnameField.getText());
                pst.setString(2, lnameField.getText());
                pst.setString(3, emailField.getText());
                pst.setInt(4, Integer.parseInt(idField.getText()));
                int result = pst.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(frame, "Record Updated Successfully");
                } else {
                    JOptionPane.showMessageDialog(frame, "No record found with given ID");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        selectBtn.addActionListener(e ->
        {
            try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                String query = "SELECT * FROM usersjdbc WHERE id=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(idField.getText()));
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    fnameField.setText(rs.getString("fname"));
                    lnameField.setText(rs.getString("lname"));
                    emailField.setText(rs.getString("email"));
                    JOptionPane.showMessageDialog(frame, "Record Retrieved");
                } else {
                    JOptionPane.showMessageDialog(frame, "Record Not Found");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        deleteBtn.addActionListener(e ->
        {
            try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                String query = "DELETE FROM usersjdbc WHERE id=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(idField.getText()));
                int result = pst.executeUpdate();
                if (result > 0) {
                    fnameField.setText("");
                    lnameField.setText("");
                    emailField.setText("");
                    JOptionPane.showMessageDialog(frame, "Record Deleted Successfully");
                } else {
                    JOptionPane.showMessageDialog(frame, "No record found to delete");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
