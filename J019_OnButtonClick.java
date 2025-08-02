//On Button Clicks the program should interact with the database and perform the appropriate operation(insert,update,display records or delete records)

package assignment_jdbc;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class J019_OnButtonClick
{
    public static void main(String[] args)
    {
        final String url = "jdbc:mysql://localhost:3306/java";
        final String user = "root";
        final String password = "admin";

        // Create frame
        JFrame frame = new JFrame("User CRUD Form");
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels and TextFields
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(50, 30, 100, 25);
        JTextField txtId = new JTextField();
        txtId.setBounds(150, 30, 200, 25);

        JLabel lblFname = new JLabel("First Name:");
        lblFname.setBounds(50, 70, 100, 25);
        JTextField txtFname = new JTextField();
        txtFname.setBounds(150, 70, 200, 25);

        JLabel lblLname = new JLabel("Last Name:");
        lblLname.setBounds(50, 110, 100, 25);
        JTextField txtLname = new JTextField();
        txtLname.setBounds(150, 110, 200, 25);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 150, 100, 25);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(150, 150, 200, 25);

        // Buttons
        JButton btnInsert = new JButton("Insert");
        btnInsert.setBounds(50, 200, 80, 30);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(140, 200, 80, 30);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(230, 200, 80, 30);

        JButton btnDisplay = new JButton("Display");
        btnDisplay.setBounds(320, 200, 80, 30);

        // Add components
        frame.add(lblId); frame.add(txtId);
        frame.add(lblFname); frame.add(txtFname);
        frame.add(lblLname); frame.add(txtLname);
        frame.add(lblEmail); frame.add(txtEmail);
        frame.add(btnInsert); frame.add(btnUpdate);
        frame.add(btnDelete); frame.add(btnDisplay);

        // Insert Button Action
        btnInsert.addActionListener(e -> {
            try (Connection con = DriverManager.getConnection(url, user, password)) {
                String query = "INSERT INTO userss VALUES (?, ?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(txtId.getText()));
                pst.setString(2, txtFname.getText());
                pst.setString(3, txtLname.getText());
                pst.setString(4, txtEmail.getText());

                int rows = pst.executeUpdate();
                JOptionPane.showMessageDialog(frame, rows + " Record Inserted");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Insert Error: " + ex.getMessage());
            }
        });

        // Update Button Action
        btnUpdate.addActionListener(e -> {
            try (Connection con = DriverManager.getConnection(url, user, password)) {
                String query = "UPDATE users SET fname=?, lname=?, email=? WHERE id=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, txtFname.getText());
                pst.setString(2, txtLname.getText());
                pst.setString(3, txtEmail.getText());
                pst.setInt(4, Integer.parseInt(txtId.getText()));

                int rows = pst.executeUpdate();
                JOptionPane.showMessageDialog(frame, rows + " Record Updated");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Update Error: " + ex.getMessage());
            }
        });

        // Delete Button Action
        btnDelete.addActionListener(e -> {
            try (Connection con = DriverManager.getConnection(url, user, password)) {
                String query = "DELETE FROM userss WHERE id=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(txtId.getText()));

                int rows = pst.executeUpdate();
                JOptionPane.showMessageDialog(frame, rows + " Record Deleted");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Delete Error: " + ex.getMessage());
            }
        });

        // Display Button Action
        btnDisplay.addActionListener(e -> {
            try (Connection con = DriverManager.getConnection(url, user, password);
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM userss")) {

                StringBuilder result = new StringBuilder("ID\tFName\tLName\tEmail\n");
                while (rs.next()) {
                    result.append(rs.getInt("id")).append("\t")
                            .append(rs.getString("fname")).append("\t")
                            .append(rs.getString("lname")).append("\t")
                            .append(rs.getString("email")).append("\n");
                }
                JOptionPane.showMessageDialog(frame, result.toString());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Display Error: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }
}
