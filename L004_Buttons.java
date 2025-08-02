//Implement buttons for insert,update,select and delete
package LabAssignment;

import javax.swing.*;
import java.awt.*;

public class L004_Buttons
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("CRUD Button Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JLabel title = new JLabel("Choose an Operation", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15)); // better spacing

        // Buttons
        JButton insertBtn = new JButton("Insert");
        JButton updateBtn = new JButton("Update");
        JButton selectBtn = new JButton("Select");
        JButton deleteBtn = new JButton("Delete");


        Dimension btnSize = new Dimension(80, 30);
        insertBtn.setPreferredSize(btnSize);
        updateBtn.setPreferredSize(btnSize);
        selectBtn.setPreferredSize(btnSize);
        deleteBtn.setPreferredSize(btnSize);

        buttonPanel.add(insertBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(selectBtn);
        buttonPanel.add(deleteBtn);

        frame.setLayout(new BorderLayout());
        frame.add(title, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
