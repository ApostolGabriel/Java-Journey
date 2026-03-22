package chapter1;

/**
 * 1.7 Eliminate obsolete object references
 * <p>
 *     Nulling out object references should be an exception rather than a norm.
 * </p>
 * <p>
 *     The Stack class manages its own memory. The garbage collector is not aware of the elements which became obsolete
 *     because it is aware only of the memory allocated for the objects array.
 * </p>
 * <p>
 *     <b>Whenever a class manages its own memory, the programmer should be alert for memory leaks.</b>
 * </p>
 * <p>
 *     Another common source of memory leaks is caches. Use <b>WeakHashMap</b> for caching, useful only if the desired lifetime of cache entries is determined
 *     by external references to the key, not the value. Moreover, the cache entries may become obsolete after a period of time, they could be cleansed by a thread
 *     or by adding new entries - LinkedHashMap.
 * </p>
 * <p>
 *     A third common source of memory leaks is listeners and other callbacks. If you create an API that registers callbacks but don't deregister them explicitly,
 *     you should use WeakHashMap.
 * </p>
 */
public class ObsoleteObjectReferences {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("first");
        stack.push("second");
        Object second = stack.pop();
        System.out.println(second);
    }
}
