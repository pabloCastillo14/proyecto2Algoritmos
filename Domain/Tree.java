
package Domain;

import Business.FileBusiness;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Pablo Castillo
 */
public class Tree {
    
    
    public Node root;
    private int position;
    public ArrayList<EachWord> eachWord;
    private String chain;
    

    public Tree() {
        
        this.eachWord = new ArrayList<>();
        this.root = null;
        this.position = 0;
        this.chain = "";
        
    }//constructor

    public int getBF(Node x) {
        
        if (x == null) {
            return -1;
        } else {
            return x.balanceFactor;
        }
    }//getBF

    //**************************************Simple rotations*********************************
    public Node leftRotation(Node c) {
        
        Node aux = c.right;
        c.right = aux.left;
        aux.left = c;
        c.balanceFactor = Math.max(getBF(c.left), getBF(c.right)) + 1;
        aux.balanceFactor = Math.max(getBF(aux.left), getBF(aux.right));

        return aux;
    }// leftRotation

    public Node rightRotation(Node c) {
        
        Node aux = c.left;
        c.left = aux.right;
        aux.right = c;

        c.balanceFactor = Math.max(getBF(c.left), getBF(c.right));
        aux.balanceFactor = Math.max(getBF(aux.left), getBF(aux.right));

        return aux;
    }//rightRotation

    //********************************Double rotations**************************************
    public Node leftRightRotation(Node c) {
        
        Node temp;
        c.left = leftRotation(c.left);
        temp = rightRotation(c);

        return temp;

    }// leftRightRotation

    public Node rightLeftRotation(Node c) {
        
        Node temp;
        c.right = rightRotation(c.right);
        temp = leftRotation(c);

        return temp;

    }//right_left_rotation

    //***************************************insertAVL method*****************************************
    public Node insertAVL(Node newNodo, Node tree) {
        Node newParent = tree;

        if (newNodo.getChain().compareTo(tree.getChain()) < 0) {
            if (tree.left == null) {
                tree.left = newNodo;
                tree.left.setQuantityPositions(tree.left.getQuantityPositions() + this.position + "-");
                this.position++;
            } else {
                tree.left = insertAVL(newNodo, tree.left);
                if ((getBF(tree.left) - getBF(tree.right) == 2)) {
                    if (newNodo.getChain().compareTo(tree.left.getChain()) < 0) {
                        newParent = rightRotation(tree);
                    } else {

                        newParent = leftRightRotation(tree);

                    }
                }
            }
        } else if (newNodo.getChain().compareTo(tree.getChain()) > 0) {
            if (tree.right == null) {
                tree.right = newNodo;
                tree.right.setQuantityPositions(tree.right.getQuantityPositions() + this.position + "-");
                this.position++;
            } else {
                tree.right = insertAVL(newNodo, tree.right);

                if ((getBF(tree.left) - getBF(tree.right) == -2)) {
                    if (newNodo.getChain().compareTo(tree.right.getChain()) > 0) {
                        newParent = leftRotation(tree);
                    } else {

                        newParent = rightLeftRotation(tree);

                    }
                }
            }
        } else {
            tree.setQuantityPositions(tree.getQuantityPositions() + this.position + "-");
            this.position++;
        }
        //updata bf
        if ((tree.left == null) && (tree.right != null)) {
            tree.balanceFactor = tree.right.balanceFactor + 1;
        } else if ((tree.right == null) && (tree.left != null)) {
            tree.balanceFactor = tree.left.balanceFactor + 1;
        } else {
            tree.balanceFactor = Math.max(getBF(tree.left), getBF(tree.right)) + 1;
        }

        return newParent;
    }//insertAVL

    public void insert(String c) {
        Node newLNode = new Node(c);
        if (this.root == null) {
            this.root = newLNode;
            this.root.setQuantityPositions(this.root.getQuantityPositions() + this.position + "-");
            this.position++;
        } else {
            this.root = insertAVL(newLNode, root);

        }//else-if
    }//insert

}//class
