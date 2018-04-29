private void ingredientStorebtnActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        /*
        Since DatabaseHandler's methods create the connection and close them in its
        own methods there is no reason to establish another connection.
        */
        //insert ingredients to database
        //need to make ingredient object
        Ingredient i = new Ingredient(ingredientNameField.getText(), Integer.parseInt(caloriesField.getText()), Integer.parseInt(fatField.getText()),
                Integer.parseInt(sodiumField.getText()), groupField.getText(), Integer.parseInt(proteinField.getText()), Integer.parseInt(sugarField.getText()));
        DatabaseHandler.insertIngredient(i);
        
        //clear all fields
        ingredientNameField.setText("");
        caloriesField.setText("");
        fatField.setText("");
        sodiumField.setText("");
        groupField.setText("");
        proteinField.setText("");
        sugarField.setText("");
    }                                                  

    private void storeRecipeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        /*
        Since DatabaseHandler's methods create the connection and close them in its
        own methods there is no reason to establish another connection.
        */
        //insert recipe and instructions
        //need to make recipe object
        Recipe r = new Recipe(addRecipeTextField.getText(), recipeInstructionField.getText(), recipeCategoryField.getText());
        //n should be the number of ingredients chosen by the user.
        int n;
        Ingredient[] ingredients = new Ingredient[n];
        //will need to add the chosen ingredients to the array so that addRecipe can be called.
        DatabaseHandler.addRecipe(r,i);
        
        //clear fields
        addRecipeTextField.setText("");
        recipeInstructionField.setText("");
        recipeCategoryField.setText("");
        
    }  