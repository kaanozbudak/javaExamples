package finalExam;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

public class menu {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame window = new JFrame("Simple Editor");
        JTextArea jtxtArea = new JTextArea(30,40);
        JMenuBar jmb = new JMenuBar();
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic('F');

        JToolBar jtb = new JToolBar();
        jtb.setFloatable(false);
        JButton jbtnOpen = new JButton(new ImageIcon("open.png"));
        jbtnOpen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                JFileChooser jfc = new JFileChooser(".");
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Text files", "txt");
                jfc.setFileFilter(filter);
                int retVal = jfc.showOpenDialog(null);

                if(retVal == JFileChooser.APPROVE_OPTION) {
                    //jtxtArea.append(jfc.getSelectedFile().toString());
                    try {
                        Scanner input = new Scanner(jfc.getSelectedFile());

                        while(input.hasNextLine())
                            jtxtArea.append(input.nextLine());

                    }catch (FileNotFoundException e) {
                        System.out.println("file do not exist");
                    }

                }
            }

        });
        JButton jbtnSave = new JButton("Save");
        jbtnSave.setToolTipText("saves the contents to file");
        jtb.add(jbtnOpen);
        jtb.add(jbtnSave);

        JPanel jpnTA = new JPanel();

        jtxtArea.setLineWrap(true);
        jtxtArea.setWrapStyleWord(true);

        jpnTA.add(new JScrollPane(jtxtArea));

        JMenuItem jmiNew = new JMenuItem("New");
        JMenuItem jmiOpen = new JMenuItem("Open");
        JMenuItem jmiSave = new JMenuItem("Save");
        JMenuItem jmiSaveAs = new JMenuItem("Save as...");
        JMenuItem jmiExit = new JMenuItem("Exit");
        jmiNew.setMnemonic('N');
        jmiNew.setToolTipText("Create a new file");
        jmiNew.setIcon(new ImageIcon("new.png"));
        jmiOpen.setMnemonic('O');
        jmiSave.setMnemonic('S');
        jmiSaveAs.setMnemonic('A');
        jmiExit.setMnemonic('E');

        jmiNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("creating a new file");
            }
        });
        jmiOpen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                JFileChooser jfc = new JFileChooser(".");
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Text files", "txt");
                jfc.setFileFilter(filter);
                int retVal = jfc.showOpenDialog(null);

                if(retVal == JFileChooser.APPROVE_OPTION) {
                    //jtxtArea.append(jfc.getSelectedFile().toString());
                    try {
                        Scanner input = new Scanner(jfc.getSelectedFile());

                        while(input.hasNextLine())
                            jtxtArea.append(input.nextLine());

                    }catch (FileNotFoundException e) {
                        System.out.println("file do not exist");
                    }

                }

            }
        });
        jmiSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("creating a new file");
            }
        });
        jmiSaveAs.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                JFileChooser jfc = new JFileChooser(".");
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Text files", "txt");
                jfc.setFileFilter(filter);
                int retVal = jfc.showSaveDialog(null);
                if(retVal == JFileChooser.APPROVE_OPTION) {
                    //jtxtArea.append(jfc.getSelectedFile().toString());
                    try {
                        PrintWriter pw =
                                new PrintWriter(jfc.getSelectedFile());

                        pw.print(jtxtArea.getText());
                        pw.close();

                    }catch (FileNotFoundException e) {
                        System.out.println("file do not exist");
                    }

                }
            }
        });

        jmFile.add(jmiNew);
        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);
        jmFile.add(jmiSaveAs);
        jmFile.addSeparator();
        jmFile.add(jmiExit);


        jmb.add(jmFile);

        window.setJMenuBar(jmb);
        window.add(jpnTA);
        window.add(jtb, BorderLayout.NORTH);



        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 800);
        window.setVisible(true);


    }

}

