package com.company;
import java.util.Arrays;

public class Books {
    String[][] booksDatabase = {
            {"Divergent", "Veronica Roth", "9876", "YA", "R", "1"},
            {"Percy Jackson : The Lightning Thief", "Rick Riordan", "4567", "YA", "R", "2"}
    };

    public void addBook(String input) {
        String[] bookInfo = input.split(", ");


        // add bookInfo array to database
        booksDatabase = Arrays.copyOf(booksDatabase, booksDatabase.length + 1);
        booksDatabase[booksDatabase.length-1] = bookInfo;

        // to test the books are all in the database
        /* for(int i = 0; i < booksDatabase.length; i++){
            for(int j = 0; j < booksDatabase[i].length; j++){
                System.out.println(booksDatabase[i][j]);
            }
        }
         */
    }

    public String[][] getBooksDatabase(){
        return booksDatabase;
    }
}

