package otel;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RollController {
  private static final Logger logger = LoggerFactory.getLogger(RollController.class);

  @GetMapping("/rolldice")
  public String index(@RequestParam("player") Optional<String> player) {
    int result = this.getRandomNumber(1, 6);
    if (player.isPresent()) {
      logger.info("{} is rolling the dice: {}", player.get(), result);
    } else {
      logger.info("Anonymous player is rolling the dice: {}", result);
    }

    String comp  = this.getSophisticatedResult(Integer.valueOf(result)); 
    logger.info("Result of computation: " + comp);

    RestTemplate restTemplate = new RestTemplate();
    logger.info("Ping ...");
    restTemplate.getForObject("http://localhost:8080/greeting", GreetingController.class);

    return Integer.toString(result);
  }

  public int getRandomNumber(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  public String getSophisticatedResult(Object obj) {
    logger.info("Computation ... ");
    //pattern matching for switch (since Java 17)
    return switch(obj) {
      case Integer i -> "An integer!";
      case String s -> "A string!";
      default -> "No idea what is going on here!";
    };
  }
}
