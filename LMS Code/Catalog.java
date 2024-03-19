package com.company;
import java.util.Arrays;

public class Catalog {
    Books books = new Books();

    public void findBooks(String input){
        String searchFor = input;
        String[][] booksDatabase = books.getBooksDatabase();

        for(int i = 0; i < booksDatabase.length; i++) {
            boolean test = Arrays.asList(booksDatabase[i]).contains(searchFor);
            if (test) {
                System.out.println("Title : " + booksDatabase[i][0]);
                System.out.println("Author : " + booksDatabase[i][1]);
                System.out.println("ISBN : " + booksDatabase[i][2]);
                System.out.println("Genre : " + booksDatabase[i][3]);
                System.out.println("Aisle : " + booksDatabase[i][4]);
                System.out.println("Copies : " + booksDatabase[i][5]);
            }
        }
    }
}

