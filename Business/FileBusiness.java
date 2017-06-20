/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.FileData;
import Domain.Node;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Jeannette 
 */
public class FileBusiness {
     private FileData treeData;

    public FileBusiness(String fileName) {
        this.treeData = new FileData(fileName);
    }//constructor

    public void saveTree(Node aVLNode) throws FileNotFoundException {
        this.treeData.saveTree(aVLNode);
    }//saveTree

    public void saveSubTree(String chain) throws FileNotFoundException {
        this.treeData.saveSubTree(chain);
    }//saveSubTree
}
