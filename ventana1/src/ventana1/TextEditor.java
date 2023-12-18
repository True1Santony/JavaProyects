package ventana1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class TextEditor extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem newMenuItem;
    private JMenuItem openMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem exitMenuItem;
    private File currentFile;
    private JButton saveButton;

    public TextEditor() {
        super("Editor de texto");
        
        saveButton = new JButton("Guardar");
        saveButton.addActionListener(this);
        
                textArea = new JTextArea();
                textArea.setEditable(false);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        			.addContainerGap(71, Short.MAX_VALUE)
        			.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
        			.addGap(65))
        		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        			.addContainerGap(196, Short.MAX_VALUE)
        			.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        			.addGap(188))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
        			.addComponent(saveButton)
        			.addContainerGap())
        );
        getContentPane().setLayout(groupLayout);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("Archivo");
        newMenuItem = new JMenuItem("Nuevo");
        openMenuItem = new JMenuItem("Abrir");
        saveMenuItem = new JMenuItem("Guardar");
        exitMenuItem = new JMenuItem("Salir");

        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == newMenuItem) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Crear archivo");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (.txt)", "txt"));

            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
                try {
                    FileWriter writer = new FileWriter(currentFile.getAbsolutePath());
                    writer.write("");
                    writer.close();
                    textArea.setEditable(true);
                    textArea.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al crear el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (source == openMenuItem) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Abrir archivo");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (.txt)", "txt"));

            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(currentFile.getAbsolutePath()));
                    String line = null;
                    textArea.setText("");
                    while ((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                    reader.close();
                    textArea.setEditable(true);
                    saveButton.setEnabled(true); // Habilitar el botón Guardar
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al abrir el fichero", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (source == saveMenuItem) {
            try {
                FileWriter writer = new FileWriter(currentFile.getAbsolutePath());
                writer.write(textArea.getText());
                writer.close();
                JOptionPane.showMessageDialog(null, "El fichero ha sido guardado", "Información", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar el fichero", "Error", JOptionPane.ERROR_MESSAGE);
            }
            textArea.setEditable(false);
        } else if (source == exitMenuItem) {
            System.exit(0);
        }else if (source == saveButton) {
            saveFile();
        }
    }
    
    private void saveFile() {
        if (currentFile == null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar archivo");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (.txt)", "txt"));

            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
            } else {
                return;
            }
        }

        try {
            FileWriter writer = new FileWriter(currentFile.getAbsolutePath());
            writer.write(textArea.getText());
            writer.close();
            JOptionPane.showMessageDialog(null, "El archivo ha sido guardado exitosamente.", "Guardar archivo", JOptionPane.INFORMATION_MESSAGE);
            textArea.setEditable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo.", "Guardar archivo", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String args []) {
    	
    	TextEditor a=new TextEditor();
    	
    	
    	
    }
}