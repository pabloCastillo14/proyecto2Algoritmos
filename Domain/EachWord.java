/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Jeannette
 */
public class EachWord {

    private String name;
    private int position;

    public EachWord(String name, int position) {
        this.name = name;
        this.position = position;
    }//constructor

    public EachWord() {
        this.name = "";
        this.position = 0;
    }//default

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}//class
