package sql;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.*;

public class output extends JFrame{
    
    private IndividualAuthor currentEntry;
    private insert personQueries;
    private List< IndividualAuthor > results;
    private int numberOfEntries = 0;
    private int currentEntryIndex;
    
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton addButton;
    private JButton previousButton;
    private JButton nextButton;
    private JButton browseButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JLabel ofLabel;
    private JTextField indexTextField;
    private JTextField maxTextField;
    private JPanel navigatePanel;
    private JPanel queryPanel;
    private JButton findButton;
    private JLabel AuthorID;
    private JTextField AuthorIDField;
    
    public output() {
        super("Authors form");
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        personQueries = new insert();
       
        Box vertical1 = Box.createVerticalBox();
        Box vertical2 = Box.createVerticalBox();
        Box vertical3 = Box.createVerticalBox();
        
        navigatePanel = new JPanel();
        navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));
        
        label1 = new JLabel("Author ID:");
        label2 = new JLabel("First Name:");
        label3 = new JLabel("Last Name:");
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        textField3 = new JTextField(10);
        addButton = new JButton("Add New Entry");
        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");
        browseButton = new JButton("Browse All Entries");
        ofLabel = new JLabel("of");
        indexTextField = new JTextField(3);
        maxTextField = new JTextField(3);
        queryPanel = new JPanel();
        findButton = new JButton("Find");
        AuthorID = new JLabel("Author ID:");
        AuthorIDField = new JTextField(10);
        deleteButton = new JButton("Delete Current Entry");
        updateButton = new JButton("Update Current Entry");
        
        vertical1.add(label1);
        vertical1.add(Box.createVerticalStrut(25));
        vertical1.add(label2);
        vertical1.add(Box.createVerticalStrut(25));
        vertical1.add(label3);
        addComponent(vertical1, 2, 0, 1, 1);
        
        vertical2.add(textField1);
        vertical2.add(Box.createVerticalStrut(25));
        vertical2.add(textField2);
        vertical2.add(Box.createVerticalStrut(25));
        vertical2.add(textField3);
        addComponent(vertical2, 2, 2, 1, 1);
        
        JLabel empty1 = new JLabel("     ");
        JLabel empty2 = new JLabel("     ");
        JLabel empty3 = new JLabel("     ");
        vertical3.add(empty1);
        vertical3.add(Box.createVerticalStrut(25));
        vertical3.add(empty2);
        vertical3.add(Box.createVerticalStrut(25));
        vertical3.add(empty3);
        addComponent(vertical3, 2, 1, 1, 1);
        
        queryPanel.setBorder( BorderFactory.createTitledBorder("Find an entry by Author ID" ) );
        queryPanel.add( Box.createHorizontalStrut( 5 ) );
        queryPanel.add( AuthorID );
        queryPanel.add( Box.createHorizontalStrut( 10 ) );
        queryPanel.add( AuthorIDField );
        queryPanel.add( Box.createHorizontalStrut( 10 ) );
        
        findButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed( ActionEvent evt) {
                        findButtonActionPerformed(evt);
                    }
                }
        );
        
        queryPanel.add(findButton);
        queryPanel.add(Box.createHorizontalStrut(5));
        addComponent(queryPanel, 4, 0, 3, 1);
        
        previousButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        previousButtonActionPerformed(evt);
                    }
                }
        );
        
        navigatePanel.add(previousButton);
        navigatePanel.add(Box.createHorizontalStrut(10));
        
        indexTextField.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        indexTextFieldActionPerformed(evt);
                    }
                }
        );
        
        navigatePanel.add(indexTextField);
        navigatePanel.add(Box.createHorizontalStrut(10));
        
        navigatePanel.add( ofLabel );
        navigatePanel.add(Box.createHorizontalStrut(10));
        
        maxTextField.setEditable(false);
        navigatePanel.add( maxTextField );
        navigatePanel.add( Box.createHorizontalStrut( 10 ) );
        
        nextButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed( ActionEvent evt ) {
                        nextButtonActionPerformed(evt);
                    }
                }
        );
        
        navigatePanel.add(nextButton);
        addComponent(navigatePanel, 0, 0, 3, 1);
        
        addButton.addActionListener (
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                       addButtonActionPerformed(evt);
                    }
                }
        );
        addComponent(addButton, 6, 0, 1, 1);
        
        JLabel empty6 = new JLabel("    ");
        addComponent(empty6, 5, 0, 3, 1);
           
        JLabel empty4 = new JLabel("     ");
        addComponent(empty4, 3, 0, 3, 1);
        
        JLabel empty5 = new JLabel("     ");
        addComponent(empty5, 1, 0, 3, 1);
        
        browseButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        browseButtonActionPerformed(evt);
                    }
                }
        );
        
        JLabel empty7 = new JLabel();
        addComponent(empty7, 6, 1, 1, 1);
        
        addComponent(browseButton, 6, 2, 1, 1);
        
        deleteButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                      deleteButtonActionPerformed(evt);
                    }
                }
        );
        
        JLabel empty8 = new JLabel("    ");
        addComponent(empty8, 7, 0, 3, 1);
        
        addComponent(deleteButton, 8, 0, 1, 1);
        
        updateButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        updateButtonActionPerformed(evt);
                    }
                }
        );
        
        JLabel empty9 = new JLabel();
        addComponent(empty9, 8, 1, 1, 1);
        
        addComponent(updateButton, 8, 2, 1, 1);
    }
    
    private void addComponent(Component component, int row,
            int column, int width, int height) {
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints (component, constraints );
        add( component);
    }
    
    private void addButtonActionPerformed(ActionEvent evt) {
        try {
        int results = personQueries.addPerson(Integer.parseInt( textField1.getText()), textField2.getText(),
                textField3.getText());
        if ( results == 1 )
            JOptionPane.showMessageDialog( this, "Person added!", "Person added", JOptionPane.INFORMATION_MESSAGE );
        else
         {
             JOptionPane.showMessageDialog( this, "Person not added!", "Error", JOptionPane.ERROR_MESSAGE );
        }
            }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Missing input", "Error", JOptionPane.ERROR_MESSAGE);
        }
        browseButtonActionPerformed(evt);
    }
    
    
    private void previousButtonActionPerformed(ActionEvent evt) {
        currentEntryIndex--;
        if ( currentEntryIndex < 0 )
            currentEntryIndex = numberOfEntries - 1;
        indexTextField.setText( "" + ( currentEntryIndex + 1 ) ); 
        indexTextFieldActionPerformed( evt ); 
    }
    
    private void nextButtonActionPerformed(ActionEvent evt) {
        currentEntryIndex++;
        if( currentEntryIndex >= numberOfEntries)
            currentEntryIndex = 0;
        indexTextField.setText("" + (currentEntryIndex + 1));
        indexTextFieldActionPerformed( evt ); 
    }
    
    private void indexTextFieldActionPerformed(ActionEvent evt) {
        currentEntryIndex = ( Integer.parseInt(indexTextField.getText() ) - 1 );
        if ( numberOfEntries != 0 && currentEntryIndex < numberOfEntries ) {
            
            currentEntry = results.get( currentEntryIndex );
            textField1.setText("" + currentEntry.getAuthorID() );
            textField2.setText( currentEntry.getFirstName() );
            textField3.setText( currentEntry.getLastName() );
        } 
    }
    private void browseButtonActionPerformed( ActionEvent evt) {
        try {
            results = personQueries.getAllAuthors();
            numberOfEntries = results.size();
            if (numberOfEntries != 0) {
                currentEntryIndex = 0;
                currentEntry = results.get( currentEntryIndex );
                textField1.setText( "" + currentEntry.getAuthorID() );
                textField2.setText( currentEntry.getFirstName() );
                textField3.setText( currentEntry.getLastName() );
                indexTextField.setText("" + (currentEntryIndex + 1) );
                maxTextField.setText("" + numberOfEntries);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void findButtonActionPerformed(ActionEvent evt) {
        try {
            results = personQueries.getAuthorByAuthorID(AuthorIDField.getText());
            numberOfEntries = results.size();
            if( numberOfEntries != 0) {
                currentEntryIndex = 0;
                currentEntry = results.get(currentEntryIndex);
                textField1.setText("" + currentEntry.getAuthorID());
                textField2.setText(currentEntry.getFirstName());
                textField3.setText(currentEntry.getLastName());
                indexTextField.setText("" + (currentEntryIndex + 1) );
                maxTextField.setText("" + numberOfEntries);
            }
            else {
                JOptionPane.showMessageDialog(this, "No Author by that Author ID", "Author not found", JOptionPane.ERROR_MESSAGE);
            }
        }
            catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e, "Database error", JOptionPane.ERROR_MESSAGE);
                    }
        }
    
    private void deleteButtonActionPerformed(ActionEvent evt) {
        try {
            int results = personQueries.deleteAuthor(Integer.parseInt (textField1.getText()));
            if(results == 1) 
                JOptionPane.showMessageDialog(this, "Author successfully delete", "Successful Delete", JOptionPane.INFORMATION_MESSAGE);
            else {
                JOptionPane.showMessageDialog(this, "AUTHOR NOT DELETED", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,"AUTHOR NOT DELETED" , "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        browseButtonActionPerformed(evt);
    }
    private void updateButtonActionPerformed(ActionEvent evt) {
        int currentAuthorID = 0;
        try {
        String input = JOptionPane.showInputDialog(this, "Input the Author's ID you wish to update");
        currentAuthorID = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            int results = personQueries.updateAuthor(Integer.parseInt(textField1.getText()), textField2.getText(), 
                    textField3.getText(), currentAuthorID);
            if( results == 1)
                JOptionPane.showMessageDialog(this, "AUTHOR SUCCESSFULLY UPDATED", "Successful Update", JOptionPane.INFORMATION_MESSAGE);
            else {
                JOptionPane.showMessageDialog(this, "AUTHOR NOT UPDATED", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static void main(String[] args) {
        output output = new output();
        output.setSize(450, 400);
        output.setLocation(450, 150);
        output.setResizable(false);
        output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        output.setVisible(true);
    }
}
