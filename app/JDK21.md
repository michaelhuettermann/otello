## JDK 21: Modern language features

This entry point covers example Java application features with JDK 21.

As coded in [RollController.java](RollController.java), in our sample demo, the *pattern matching for switch* is blended with the *record pattern* language feature.

### Pattern matching for switch 
The *Pattern Matching for switch* was introduced as preview with JDK 17 and proposed via [JEP 406](https://openjdk.org/jeps/406).
It was refined by following JEPs, e.g. [JEP 441](https://openjdk.org/jeps/441) (JDK 21).

```
  public String getSophisticatedResult(Object obj) {
    ...
    return switch(obj) {
      case Integer i -> "An integer!";
      case String s -> "A string!";
      case DiceValue mydv -> "A DiceValue!";
      default -> "No idea what is going on here!";
    };
  }
```

### Record pattern
The *Record Patterns* relates to the language feature of pattern matching. It extends it to destructive instances of record classes and adds nested patterns, see [JEP 440](https://openjdk.org/jeps/440) (JDK 21). 

```
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
    ...
```
