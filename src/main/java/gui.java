import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class gui extends JFrame {

    private JButton bChoose1 = new JButton();
    private JTextField jimagepath1 = new JTextField();
    private JLabel lImagePath1 = new JLabel();
    private JButton bChoose2 = new JButton();
    private JTextField jzippath2 = new JTextField();
    private JLabel lZipFilePath1 = new JLabel();
    private JButton bDotheTrick1 = new JButton();
    private JLabel lAbodx1 = new JLabel();

    public gui() {
        // Frame-Initialisierung
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 380;
        int frameHeight = 318;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Tricker - X");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        cp.setBackground(Color.GRAY);

        bChoose1.setBounds(264, 32, 80, 24);
        bChoose1.setText("Choose");
        bChoose1.setMargin(new Insets(2, 2, 2, 2));
        bChoose1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bChoose1_ActionPerformed(evt);
            }
        });
        cp.add(bChoose1);
        jimagepath1.setBounds(8, 32, 232, 24);
        cp.add(jimagepath1);
        lImagePath1.setBounds(8, 8, 95, 24);
        lImagePath1.setText("Image Path:");
        lImagePath1.setFont(new Font("Dialog", Font.BOLD, 16));
        lImagePath1.setForeground(Color.CYAN);
        cp.add(lImagePath1);
        bChoose2.setBounds(264, 120, 80, 24);
        jzippath2.setBounds(8, 120, 232, 24);
        lZipFilePath1.setBounds(8, 96, 103, 24);
        bChoose2.setText("Choose");
        bChoose2.setMargin(new Insets(2, 2, 2, 2));
        bChoose2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bChoose2_ActionPerformed(evt);
            }
        });
        cp.add(bChoose2);
        cp.add(jzippath2);
        lZipFilePath1.setText("Zip File Path:");
        lZipFilePath1.setFont(new Font("Dialog", Font.BOLD, 16));
        lZipFilePath1.setForeground(Color.CYAN);
        cp.add(lZipFilePath1);
        bDotheTrick1.setBounds(128, 192, 104, 24);
        bDotheTrick1.setText("Do the Trick");
        bDotheTrick1.setMargin(new Insets(2, 2, 2, 2));
        bDotheTrick1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bDotheTrick1_ActionPerformed(evt);
            }
        });
        cp.add(bDotheTrick1);
        lAbodx1.setBounds(8, 248, 56, 24);
        lAbodx1.setText("© Abodx");
        lAbodx1.setForeground(new Color(0xC0C0C0));
        cp.add(lAbodx1);
        // Ende Komponenten

        setVisible(true);
    }

    public void bChoose1_ActionPerformed(ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Image File");
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
                "Image files (JPG, PNG, BMP)", "jpg", "jpeg", "png", "bmp");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            jimagepath1.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    public void bChoose2_ActionPerformed(ActionEvent evt) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose ZIP File");
            FileNameExtensionFilter zipFilter = new FileNameExtensionFilter(
                    "ZIP files", "zip");
        fileChooser.setFileFilter(zipFilter);
        fileChooser.setAcceptAllFileFilterUsed(false);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                jzippath2.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
    }

    public void bDotheTrick1_ActionPerformed(ActionEvent evt) {
        String imgPath = jimagepath1.getText();
        String zipPath = jzippath2.getText();

        File imgFile = new File(imgPath);
        String directory = imgFile.getParent();
        String fileName = imgFile.getName();
        String outputFileName = fileName.substring(0, fileName.lastIndexOf('.')) + "-out" + fileName.substring(fileName.lastIndexOf('.'));
        String outputPath = new File(directory, outputFileName).getAbsolutePath();

        try {
            Hider.simpletrick(imgPath, zipPath, outputPath);
            JOptionPane.showMessageDialog(this, "Done successfully ;)", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.err.println("Something went wrong: " + e.getMessage());
        }
    }
}

