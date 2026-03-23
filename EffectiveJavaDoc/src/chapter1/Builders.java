package chapter1;

/**
 * 1.2 Consider a builder when faced with many constructor parameters.
 * <p>
 *     The telescoping constructor pattern - provide a constructor with only the required parameters, another with a single optional parameter,
 *     a third with two optional parameters, culminating with a constructor with all optional parameters.
 *     Following this pattern, a client would be challenged to memorize the parameters' meaning and to count them => can cause bugs.
 * </p>
 * <p>
 *     Use JavaBeans pattern instead -> allows consistency, mandates mutability.
 *     Call parameterless constructor, call setter methods to set each required parameter, leave optional not used parameters empty.
 *     A disadvantage to this pattern is that it precludes the possibility to make a class immutable.
 * </p>
 * <p>
 *     The builder pattern -> instead of making the desired object, the client calls a constructor with all required parameters and gets a builder object.
 *     Then the client calls setter-like methods on the builder object. After that, calls build (parameterless method) to create the populated object.
 *     The builder is usually a static member class of the class it builds.
 *     To detect invalid parameters check in parameter setter methods and throw invalidArgumentException with proper messages.
 *     This is well suited for class hierarchies. Use a parallel hierarchy of builders.
 *     Should be used when you have enough parameters to make it worthwhile, 4 >.
 * </p>
 * <p>
 *     The builder pattern is a good choice when designing classes whose constructors or static factories would have more than a
 *     handful of parameters.
 * </p>
 */
public class Builders {
    public static void main(String[] args) {
        // this constructor requires parameters that we don't want to set
        // if the number of parameters increasing, it can get out of hand.
        NutritionFacts cocaCola = new NutritionFacts(240, 8, 100, 0, 35, 27);

        // it is easy to create instance, but wordy, and easy to read
        NutritionFactsEnhanced cocaColaEnhanced = new NutritionFactsEnhanced();
        cocaColaEnhanced.setServingSize(240);
        cocaColaEnhanced.setServings(8);
        cocaColaEnhanced.setCalories(100);
        cocaColaEnhanced.setSodium(35);
        cocaColaEnhanced.setCarbohydrate(27);

        // All optional parameters are in one place, easy to write, read, implement.
        NutritionFactsImmutable cocaColaImmutable = new NutritionFactsImmutable.Builder(240, 8).calories(100)
                .sodium(35).carbohydrate(27).build();


        // Pizza example with Builder subtypes
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION).build();
        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();
    }
}
