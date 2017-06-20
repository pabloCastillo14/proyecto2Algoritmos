/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Pablo Castillo
 */
public class Node {
     int balanceFactor;
    private String chain;
    private String quantityPositions;
    public Node left;
    public Node right;

    public Node(String chain) {
        this.balanceFactor = 0;
        this.left = null;
        this.right = null;
        this.chain = chain;
        this.quantityPositions = "";
    }//constructor

    /**
     * @return the chain
     */
    public String getChain() {
        return chain;
    }

    /**
     * @param chain the chain to set
     */
    public void setChain(String chain) {
        this.chain = chain;
    }

    /**
     * @return the quantityPositions
     */
    public String getQuantityPositions() {
        return quantityPositions;
    }

    /**
     * @param quantityPositions the quantityPositions to set
     */
    public void setQuantityPositions(String quantityPositions) {
        this.quantityPositions = quantityPositions;
    }
}
