/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.Node;
import Domain.Tree;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Jeannette
 */
public class Panel extends JPanel {

    private Tree myTree;
    private Node myNode;
    private Graphics2D graphics2D;
    private BufferedImage bufferedImage;
    private int x;
    private int y;

    public Panel(Tree myTree) {
        super();
        this.myTree = myTree;
        this.myNode = this.myTree.root;
    }//constructor

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, 4500, 4500, null);
        paintTree(g, myNode, 910, 20, 110, 15, 0);
    }//paintComponent

    private void paintTree(Graphics g, Node node, int x, int y, int xoff, int yoff, int level) {
        if (node == null) {
            return;
        }
        g.setColor(Color.CYAN);
        if (node.left != null) {
            g.drawLine(x, y, x - xoff + (level * 2) - 40, (y + yoff) + 100);
        }//leftSon
        if (node.right != null) {
            g.drawLine(x, y, x + xoff - (level * 2) + 40, (y + yoff) + 100);
        }//RightSon
        g.fillOval(x - 70, y - 15, 130, 50);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospace", Font.PLAIN, 13));
        String node1 = node.getQuantityPositions();
        node1 = node1.substring(0, node1.length() - 1);
        g.drawString(node.getChain() + " [" + node1 + "]", x - 50, y + 15);
        paintTree(g, node.left, (int) (x - xoff) + 20, (y + yoff) + 100, ((xoff + 20) + level * 2) - 20, yoff + 77, level + 1);
        paintTree(g, node.right, (int) (x + xoff) - 20, (y + yoff) + 100, ((xoff + 20) - level * 2) - 20, yoff + 15, level + 1);

    }//paintTree

}//class
