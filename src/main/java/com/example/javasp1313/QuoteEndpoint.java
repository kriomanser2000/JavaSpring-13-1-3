package com.example.javasp1313;

import com.example.soap.service.model.Quote;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Endpoint
public class QuoteEndpoint
{
    private static final String NAMESPACE_URI = "http://example.com/quotes";
    private static final List<Quote> QUOTES = Arrays.asList(
            new Quote("Education is the most powerful weapon which you can use to change the world.", "Nelson Mandela", "Education"),
            new Quote("The only way to do great work is to love what you do.", "Steve Jobs", "Technology"),
            new Quote("Stay hungry, stay foolish.", "Steve Jobs", "Technology"),
            new Quote("An investment in knowledge pays the best interest.", "Benjamin Franklin", "Education")
    );
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetQuoteRequest")
    @ResponsePayload
    public GetQuoteResponse getQuote(@RequestPayload GetQuoteRequest request)
    {
        String category = request.getCategory();
        List<Quote> filteredQuotes = QUOTES.stream()
                .filter(quote -> quote.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        Random random = new Random();
        Quote randomQuote = filteredQuotes.isEmpty()
                ? new Quote("No quotes found for the given category.", "System", "None")
                : filteredQuotes.get(random.nextInt(filteredQuotes.size()));
        GetQuoteResponse response = new GetQuoteResponse();
        response.setQuote(randomQuote.getQuote());
        response.setAuthor(randomQuote.getAuthor());
        response.setCategory(randomQuote.getCategory());
        return response;
    }
}
