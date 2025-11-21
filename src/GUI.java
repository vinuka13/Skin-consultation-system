import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

public class GUI {

    static JButton sort = new JButton("Sort the List");
    static JButton consultation = new JButton("Add consultation");


    public GUI() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel(null);

        frame.add(panel);
        frame.setTitle("Skincare Consultation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 500);
        frame.setVisible(true);

        panel.setBackground(new Color(0x123456));

        JLabel topicMain = new JLabel("Skincare Consultation Center");
        topicMain.setBounds(150, 5, 300, 40);
        topicMain.setFont(new Font("MV Boli", Font.BOLD, 20));
        topicMain.setForeground(Color.WHITE);
        topicMain.setBackground(Color.black);
        topicMain.setOpaque(true);
        panel.add(topicMain);

        JLabel doctorsTable = new JLabel("List of Registered Doctors");
        doctorsTable.setBounds(50, 60, 300, 40);
        doctorsTable.setFont(new Font("MV Boli", Font.BOLD, 15));
        doctorsTable.setForeground(Color.WHITE);
        panel.add(doctorsTable);

        JTable table = new JTable();
        String[] col = new String[]{"First name", "Surname", "Birthday", "Mobile", "License No.","Specialization"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        TableRowSorter tableRowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(tableRowSorter);
        tableModel.setColumnIdentifiers(col);
        table.setModel(tableModel);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(50, 100, 500, 250);
        panel.add(jScrollPane);
        Object[] data = new Object[6];

        for (int i = 0; i < WestminsterSkinConsultationManager.doctorsList.size(); ++i) {
            data[0] = ((Doctor) WestminsterSkinConsultationManager.doctorsList.get(i)).getName();
            data[1] = ((Doctor) WestminsterSkinConsultationManager.doctorsList.get(i)).getSurname();
            data[2] = ((Doctor) WestminsterSkinConsultationManager.doctorsList.get(i)).getDob();
            data[3] = ((Doctor) WestminsterSkinConsultationManager.doctorsList.get(i)).getMobNo();
            data[4] = ((Doctor) WestminsterSkinConsultationManager.doctorsList.get(i)).getLicenseNo();
            data[5] = ((Doctor) WestminsterSkinConsultationManager.doctorsList.get(i)).getSpecialization();
            tableModel.addRow(data);
        }

        panel.add(consultation);
        consultation.setBounds(420, 370, 130, 30);
        consultation.addActionListener(this::actionPerformed);

        /*panel.add(sort);
        sort.setBounds(440,370,110,30);*/
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == consultation) {
            new ConsultGUI();
        }
    }

}
