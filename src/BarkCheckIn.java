/**************************************************************
 * Name        : Bark Check In
 * Author      : Cody Hale
 * Created     : 12/08/2022
 * Course      : 202301 CIS152 13306 - Data Structures
 * Version     : 1.0
 * OS          : Windows 11
 * IDE         : IntelliJ IDEA
 * Complexity  : O(1)
 * Copyright   : This is my own original work based on
 *               specifications issued by our instructor
 * Description : Creates a list and a hashmap - uses a gui to take data and check a dog into the dog daycare, then can get the dog out and remove them from the hashmap/table.
 *               Input:  x variables
 *               Output: string to display x variables
 * Academic Honesty: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or
 * unmodified. I have not given other fellow student(s) access to
 * my program.
 ***************************************************************/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 * The type Bark check in.
 */
public class BarkCheckIn extends JFrame {

    private JPanel mainPanel;
    private JTextField ownerNameTextField;
    private JTextField ownerPhoneTextField;
    private JTextField ownerEmailTextField;
    private JTextField dogNameTextField;
    private JLabel ownerNameLabel;
    private JLabel ownerPhoneLabel;
    private JLabel ownersEmailLabel;
    private JLabel dogsNameLabel;
    private JButton checkOutButton;
    private JButton checkInButton;
    private JLabel requiredLabel;
    private JTable barkCheckedInTable;
    private JPanel tablePanel;

    /**
     * The Id.
     */
    public int ID = 0;




    /**
     * Instantiates a new Bark check in.
     *
     * @param title the title
     */
    public BarkCheckIn(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


        String[] columnNames = {"Id","Owner Name", "Owner Email","Owner Phone", "Dog Name"};
        // creates a new map called dogs
        HashMap<String, String> dogs = new HashMap<>();
        List<Dogs> checkedInDogs = new ArrayList<>();
        List<Dogs> checkedOutDogs = new ArrayList<>();

        checkInButton.addActionListener(new ActionListener() {

            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // add the information about the dog to the hashmap
                // generate a pop-up stating check in was successful with the specific data points - ownerName, ownerEmail, ownerPhone, dogName, ID
                ID = ID + 1;

                String id = String.valueOf(ID);


                // creates a component and initializes it
                Component parent = null;
                // initializes string variables to be used
                String ownerName = "";
                String ownerEmail = "";
                String ownerPhone = "";
                String dogName = "";

                // grabs the text in the JTextFields and assigns to the declared variables
                if (ownerNameTextField.getText().equals("") || ownerEmailTextField.getText().equals("") || ownerPhoneTextField.getText().equals("") || dogNameTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "No entry found, please enter data and try again");
                } else {



                    ownerName = ownerNameTextField.getText();
                    ownerEmail = ownerEmailTextField.getText();
                    ownerPhone = ownerPhoneTextField.getText();
                    dogName = dogNameTextField.getText();
                    //int tempId = ++id;
                    //String dogId = String.valueOf(tempId);
                    // adds the dogName and id to the hashmap
                    dogs.put(dogName, id);

                    DogTableModel dogTableModel = new DogTableModel(checkedInDogs);
                    barkCheckedInTable.setModel(dogTableModel);
                    barkCheckedInTable.setAutoCreateRowSorter(true);
                    checkedInDogs.add(new Dogs(id, ownerName, ownerEmail, ownerPhone, dogName));

                    // clears all data from the text fields for further use
                    ownerNameTextField.setText("");
                    ownerEmailTextField.setText("");
                    ownerPhoneTextField.setText("");
                    dogNameTextField.setText("");

                    // creates a pop-up message to let the user know their information was stored
                    JOptionPane.showMessageDialog(null, "Check in was successful!" + "    Owner=" + ownerName +
                            "    Email=" + ownerEmail + "    Phone=" + ownerPhone + "    Dog=" + dogName);
                    String dogsString = String.valueOf(dogs);
                    JOptionPane.showMessageDialog(null, dogsString);
                }
            }

        });
        checkOutButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                AbstractTableModel table = (AbstractTableModel) barkCheckedInTable.getModel();

                DogTableModel dogTbl = new DogTableModel(checkedOutDogs);
                //find's the dog's name and if there remove from the checked in list, if not display a pop-up stating the dog wasn't found
                //if removed successfully, create a pop-up that stats the dog was removed successfully.
                if (ownerNameTextField.getText().equals("") || ownerEmailTextField.getText().equals("") || ownerPhoneTextField.getText().equals("") || dogNameTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "No entry found, please enter data and try again");
                } else {
                    String checkDogsName = dogNameTextField.getText();
                    if (dogs.containsKey(checkDogsName)) {
                        dogs.remove(checkDogsName);
                        JOptionPane.showMessageDialog(null, "Check out was successful!" + "    Dog=" + checkDogsName);
                        // clears all data from the text fields for further use
                        ownerNameTextField.setText("");
                        ownerEmailTextField.setText("");
                        ownerPhoneTextField.setText("");
                        dogNameTextField.setText("");

                        String dogsString = String.valueOf(dogs);
                        JOptionPane.showMessageDialog(null, dogsString);


                    } else {
                        JOptionPane.showMessageDialog(null, "Your entry was not found. Check the spelling and try again.");
                    }

                }

            }
        });
        barkCheckedInTable.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AbstractTableModel model = (AbstractTableModel) barkCheckedInTable.getModel();
                int selectedRow = barkCheckedInTable.getSelectedRow();
                ownerNameTextField.setText(model.getValueAt(selectedRow, 1).toString());
                ownerEmailTextField.setText(model.getValueAt(selectedRow, 2).toString());
                ownerPhoneTextField.setText(model.getValueAt(selectedRow, 3).toString());
                dogNameTextField.setText(model.getValueAt(selectedRow, 4).toString());
            }
        });
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        JFrame frame = new BarkCheckIn("Bark Check In/Check Out");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


    }

    private static class DogTableModel extends AbstractTableModel{
        private final String[] COLUMNS = {"ID","OWNER NAME", "OWNER EMAIL", "OWNER PHONE", "DOG NAME"};
        private final List<Dogs> dogs;


        private DogTableModel(List<Dogs> dogs){
         this.dogs = dogs;
      }

        @Override
        public int getRowCount(){
            return dogs.size();
        }
        @Override
        public int getColumnCount(){
            return COLUMNS.length;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex){
            return switch (columnIndex){
                case 0 -> dogs.get(rowIndex).getId();
                case 1 -> dogs.get(rowIndex).getOwnerName();
                case 2 -> dogs.get(rowIndex).getOwnerEmail();
                case 3 -> dogs.get(rowIndex).getOwnerPhone();
                case 4 -> dogs.get(rowIndex).getDogName();
                default -> "";
            };
        }
        @Override
        public String getColumnName(int column){
            return COLUMNS[column];
        }


        @Override
        public Class<?> getColumnClass(int columnIndex){
            if (getValueAt(0, columnIndex) != null){
                return getValueAt(0, columnIndex).getClass();
            }
            else{
                return Object.class;
                }
        }
    }
}



