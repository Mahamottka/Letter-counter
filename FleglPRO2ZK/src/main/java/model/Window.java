package model;

import tableModel.TableModel;
import utils.Filter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Window {

    private JFrame frame;
    private Filter filter = new Filter();
    private JPanel panel, panel2;
    private JTable table;
    private TableModel tableModel = new TableModel();

    public Window() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Zkouska");

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.SOUTH);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 5)); // Set GridLayout with 1 row and 4 columns
        frame.add(panel2, BorderLayout.NORTH);


        JButton load = new JButton("Load");
        load.setBounds(100, 100, 100, 30);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser dialog = new JFileChooser(".");
                if (dialog.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    String soubor = dialog.getSelectedFile().getPath();
                    try {
                        System.out.println("test");
                        tableModel.nacti(soubor);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Při ukladání JSON nastala chyba");
                    }
                }
            }
        });
        JButton save = new JButton("save");
        save.setBounds(100, 100, 100, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser dialog = new JFileChooser(".");
                if (dialog.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    String soubor = dialog.getSelectedFile().getPath();
                    try {
                        System.out.println("test");
                        tableModel.uloz(soubor);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Při ukladání JSON nastala chyba");
                    }
                }
            }
        });

        table = new JTable();
        table.setModel(tableModel);
        table.setFillsViewportHeight(true);
        JScrollPane scPane = new JScrollPane(table);
        panel.add(scPane);
        panel2.add(load);
        panel2.add(save);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
