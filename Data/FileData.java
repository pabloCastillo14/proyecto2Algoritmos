package Data;

import Domain.Node;
import Domain.EachWord;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author Jeannette 
 */
public class FileData {
    private String path;
    private String chain;

    public FileData(String fileName) {
        this.path = fileName;
        this.chain = "";
    }//constructor

    public void saveTree(Node node) throws FileNotFoundException {
        File file = new File(this.path);
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        PrintStream printStream = new PrintStream(fileOutputStream);
        String temp = node.getQuantityPositions();
        temp = temp.substring(0, temp.length() - 1);
        printStream.println(node.getChain() + "#" + temp);
    }//saveTree

    public void saveSubTree(String chain) throws FileNotFoundException {
        File file = new File(this.path);
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        PrintStream printStream = new PrintStream(fileOutputStream);
        printStream.println(chain);
    }//saveSubTree
    
}//class
