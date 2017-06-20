package GUI;

import Domain.Tree;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Pablo Castillo
 */
public class MainWindow extends JFrame implements ActionListener {

    JMenuBar barra;
    JMenu menu;
    JMenuItem item;
    private Panel jPanelPaint;
    private JScrollPane scroll;

    private Tree aVLtree;
    private JFileChooser chooser;

    public MainWindow() {

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        init();

    }

    public void init() {
        aVLtree = new Tree();
        this.barra = new JMenuBar();

        this.setJMenuBar(barra);

        this.menu = new JMenu("Menu");
        barra.add(menu);
        this.item = new JMenuItem("cargar Archivo");
        menu.add(item);
        this.item.addActionListener(this);

    }

    public void createAndPaintTree(String message) {

        String[] createArray = message.split("[ \n]");

        for (int i = 0; i < createArray.length; i++) {
            this.aVLtree.insert(createArray[i]);
        }//for i

    }//createAndPaintTree

    public String openFile() throws IOException {
        String information = "";
        chooser = new JFileChooser();
        String rute;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            FileReader fileReader = null;
            try {
                rute = chooser.getSelectedFile().getAbsolutePath();
                File file = new File(rute);

                fileReader = new FileReader(file);

                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    information += line + "\n";
                }//while
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }

        return information;
    }//openFIle

    public void paint() {
        this.jPanelPaint = new Panel(this.aVLtree);
        this.scroll = new JScrollPane();
        this.scroll.setBounds(new Rectangle(10, 100, 1345, 600));
        this.scroll.setViewportView(this.jPanelPaint);
        this.scroll.getViewport().setView(this.jPanelPaint);
        this.jPanelPaint.setPreferredSize(new Dimension(4500, 4500));
        this.jPanelPaint.repaint();
        this.jPanelPaint.revalidate();
        SwingUtilities.updateComponentTreeUI(this);
        this.add(this.scroll);

    }//paint

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            createAndPaintTree(openFile());
            paint();
            JOptionPane.showMessageDialog(null, "entro");
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }///actionPerformed

}//class
