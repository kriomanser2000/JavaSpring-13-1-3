package com.example.javasp1313;

public class Quote
{
    private String quote;
    private String author;
    private String category;
    public Quote(String quote, String author, String category)
    {
        this.quote = quote;
        this.author = author;
        this.category = category;
    }
    public String getQuote()
    {
        return quote;
    }
    public void setQuote(String quote)
    {
        this.quote = quote;
    }
    public String getAuthor()
    {
        return author;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public String getCategory()
    {
        return category;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }
}
