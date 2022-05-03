package com.example.spring.models.webservice;

import java.util.Objects;

public class Quote {

    private int id;
    private String body;
    private String author;

    private Quote(){}

    public Quote(int id, String body, String author) {
        this.id = id;
        this.body = body;
        this.author = author;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getBody() {return body;}
    public void setBody(String body) {this.body = body;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return id == quote.id && Objects.equals(body, quote.body) && Objects.equals(author, quote.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, author);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
