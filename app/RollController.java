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

    DiceValue dv  = new DiceValue(Integer.valueOf(result));
    String comp  = this.getSophisticatedResult(dv); 
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
    //record pattern
    if (obj instanceof String s) {
      logger.info("Operate on String: "+ s.substring(1,2));
    }
    if (obj instanceof Integer i) {
      logger.info("Operate on Integer: "+ i.intValue());
    }
    if (obj instanceof DiceValue Mydv) {
      logger.info("Operate on DiceValue: "+ Mydv.dv);
    }

    logger.info("Computation ... ");
    //pattern matching for switch (since Java 17)
    return switch(obj) {
      case Integer i -> "An integer!";
      case String s -> "A string!";
      case DiceValue mydv -> "A DiceValue!";
      default -> "No idea what is going on here!";
    };
  }

  private record DiceValue(Integer dv) {};

}
