package otel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class GreetingController {
  private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

  @GetMapping("/greeting")
  public void greeting() {
    logger.info("... pong!");
  }
}
