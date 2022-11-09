package mini.Tweet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PositiveVisitor implements Visitor {
    @Override
    public void visit(User u) {
        File pos = new File(
                "C:\\Users\\Ivan\\Desktop\\miniTwitter1\\CS356-Mini-Twitter\\src\\mini\\Tweet\\PositiveWords");
        double total = 0;
        double posTot = 0;
        ArrayList<String> words = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(pos);
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PositiveVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Object o : u.getUsers()) {
            User us = (User) o;
            for (String s : us.getTweets()) {
                for (String word : words) {
                    if (s.toLowerCase().contains(word))
                        posTot++;
                }
                total += s.split(" ").length;
            }
        }
        JOptionPane.showMessageDialog(null, "Total positive words: " + posTot / total);
    }

    @Override
    public void visit(UserGroup ug) {

    }

}
