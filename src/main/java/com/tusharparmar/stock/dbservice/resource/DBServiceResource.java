package com.tusharparmar.stock.dbservice.resource;

import com.tusharparmar.stock.dbservice.model.Quote;
import com.tusharparmar.stock.dbservice.model.Quotes;
import com.tusharparmar.stock.dbservice.repository.QuoteRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/db")
public class DBServiceResource {

    private QuoteRepository quoteRepository;

    public DBServiceResource(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username)
    {
        return getQuotesByUserName(username);
    }

    @PostMapping("/add")
    public List<String> addQuotes(@RequestBody @NotNull Quotes quotes)
    {
        quotes.getQuotes()
                .stream().map(quote -> new Quote(quotes.getUserName(),quote))
                .forEach(quote -> quoteRepository.save(quote));

        return getQuotesByUserName(quotes.getUserName());
    }

    @DeleteMapping("/delete/{username}")
    public List<String> deleteQuotes(@PathVariable("username") final String username)
    {
        List<Quote> quotes = quoteRepository.findByUserName(username);
        quoteRepository.deleteAll(quotes);
        return getQuotesByUserName(username);
    }

    private List<String> getQuotesByUserName(String username)
    {
        return quoteRepository.findByUserName(username)
                .stream().map(Quote::getQuote).collect(Collectors.toList());
    }
}
