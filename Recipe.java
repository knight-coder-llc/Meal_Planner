/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * author: D Koger
 */
package test;
public class Recipe {
    private int recipeID;
    private String catagory;
    private String instruction;
    private String name;
    //full Constructor
    Recipe(int id, String cat, String instruct, String n){
        recipeID = id;
        catagory = cat;
        instruction = instruct;
        name = n;
    }
    //constructor without id
    Recipe(String cat, String instruct, String n){
        catagory = cat;
        instruction = instruct;
        name = n;
    }
    //null constructor
    Recipe(){
        
    }
    public int getID(){
        return recipeID;
    }
    public String getCategory(){
        return catagory;
    }
    public String getInstruction(){
        return instruction;
    }
    public String getName(){
        return name;
    }
    public void setID(int id){
        recipeID = id;
    }
    public void setCategory(String c){
        catagory = c;
    }
    public void setInstruction(String i){
        instruction = i;
    }
    public void setName(String n){
        name = n;
    }
}
