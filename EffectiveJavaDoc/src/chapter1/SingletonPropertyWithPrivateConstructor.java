package chapter1;

/**
 * 1.3 Enforce the singleton property with a private constructor or an enum type
 *
 * <p>
 *     A singleton is a class instantiated exactly once. It represents a stateless object or a component which is intrinsically unique.
 *     This class is difficult to test because you cannot mock a class already instantiated.
 * </p>
 * <p>
 *     Main advantage to public field approach is that it gives you the flexibility to change your mind whether the class is a singleton without changing API.
 *     The factory method returns the sole instance, but could be modified to return each instance for every thread.
 *     Can be used as Supplier if factory method used : Elvis::instance.
 * </p>
 * <p>
 *     Field approach is preferable when there is no need for method.
 * </p>
 * <p>
 *     To make the singleton class Serializable, make the fields transient and provide readResolve method. Otherwise,
 *     each time it is deserialized, a new instance will be created.
 * </p>
 * <p>
 *     Another way to implement singleton is to declare a single-element enum. More concise, provides serialization machinery,
 *     it provides full safety against instantiation attacks. - Often the best way
 * </p>
 */
public class SingletonPropertyWithPrivateConstructor {
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();

        EnumElvis elvisEnum = EnumElvis.INSTANCE;
        elvisEnum.leaveTheBuilding();
    }
}
