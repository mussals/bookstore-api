package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Customer;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApiApplication.class, args);
    }

    // Adds a few sample rows at startup so GET requests return data right away.
    @Bean
    CommandLineRunner seedData(BookRepository books, CustomerRepository customers) {
        return args -> {
            books.save(new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227", 14.99, 12));
            books.save(new Book("Dune", "Frank Herbert", "9780441172719", 10.99, 8));
            books.save(new Book("Beloved", "Toni Morrison", "9781400033416", 16.00, 5));

            customers.save(new Customer("Amina", "Hassan", "amina.hassan@example.com", "612-555-0101", "Minneapolis"));
            customers.save(new Customer("Jordan", "Lee", "jordan.lee@example.com", "651-555-0102", "St. Paul"));
        };
    }
}
