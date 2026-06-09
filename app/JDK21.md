## JDK 21: Modern language features

This entry point covers example Java application features available with JDK 21.

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

Pattern matching for switch allows switch statements to evaluate objects instead of constants or primitive values. This new features results in handy code that is more readable. With JDK 21, there is no need to utilize *instanceof* constructs.

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

Record patterns enable a simple way to extract data from records.
Records were added in JDK 16 (see [JEP 395](https://openjdk.org/jeps/395)). 
In our case, our record looks as follows:

```
private record DiceValue(Integer dv) {};
```

The record is created with the rolled dice _int_. In our code, we easily deconstruct the record's final field by:

```
logger.info("Operate on DiceValue: "+ Mydv.dv);
```

Our example code includes *pattern matching for switch* and *record pattern*. It shows how these new modern language features can be leveraged 
to significantly improve the code.
f
