package io.pfsoftware.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {
    private static final String restApiEndpoint = "https://gturnquist-quoters.cfapps.io/api/random";

    @RequestMapping("/")
    public String index(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject(restApiEndpoint, Quote.class);

        model.addAttribute("message",quote.getValue().getQuote());
        return "index";
    }
}
