package chapter1;

import java.math.BigInteger;
import java.util.EnumSet;
import java.util.Random;

/**
 * 1.1 Creating factory static methods instead of constructors
 * <p>
 *  Advantages:
 *  <p>
 *      1. the methods have names in contrast to constructors.
 *      Example: BigInteger(int, int, Random) -> BigInteger.probablePrime().
 *      Using constructors with different type parameters can confuse clients of the API.
 * </p>
 * <p>
 *     2. Not required to instantiate the class each time a static factory method is called unlike the constructor.
 *     Similar to Flyweight pattern, greatly improves performance not using duplicate objects, instead using predefined objects, especially if expensive to create.
 *     Classes maintain strict control of their instances - instance-controlled - guarantees that it is singleton or non instantiable.
 * </p>
 * <p>
 *     Flyweight pattern - constant data of an object = intrinsic state.
 *     Other variables on an object which other objects can alter = extrinsic state.
 *     This pattern suggests that extrinsic state of the objects should be moved to other objects.
 *     This state should be passed with methods to the class with constant data.
 *     The object that contains the intrinsic state is called flyweight.
 *     Use this pattern when you need the RAM space occupied by the duplicated objects. In other cases, CPU can be overloaded in cycles used to load context data.
 * <p>
 *     Enum types guarantee that no 2 objects of the enum type are duplicated.
 * <p>
 *     3. Static factories unlike constructors can return a subtype.
 *     The Collections API has a lot of such methods, 45 separate classes with different implementation details were hidden to the client.
 *     This can allow a client to know little about implementation depth and can use each private type as needed from the interface.
 * <p>
 *     4. Class of the returned object can vary from call to call as a function to input parameters.
 * <p>
 *     5. The class of the returned object need not exist when the class containing the method is written.
 *     A service provider framework is a system in which providers implement a service, and the system makes the implementation
 *     available to the clients, decoupling the clients from the implementation.
 * <p>
 * Disadvantages:
 * <p>
 *     1. Classes without public or protected constructors cannot be subclassed
 * </p>
 * <p>
 *     2. Hard for programmers to find - List of method names to indicate static factory methods:
 *     <ul>
 *         <li>from</li>
 *         <li>of</li>
 *         <li>valueOf</li>
 *         <li>instance or getInstance</li>
 *         <li>create or newInstance</li>
 *         <li>getType</li>
 *         <li>newType</li>
 *         <li>type</li>
 *     </ul>
 * </p>
 */
public class StaticFactoryMethods {

    public static void main(String[] args) {
        // value of is an example of static factory method
        boolean primitiveValue = true;
        System.out.println(Boolean.valueOf(primitiveValue)); // never creates an object

        // introduces in Java 4
        System.out.println(BigInteger.probablePrime(32, new Random()));

        // This method returns a private subtype of the enum set class - RegularEnumSet - not disclosed to client
        EnumSet<Personality> personalities = EnumSet.allOf(Personality.class);
        System.out.println(personalities);
    }
}
