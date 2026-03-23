package chapter1;

/**
 * 1.8 Avoid finalizers and cleaners
 * <p>
 *     Finalizers are unpredictable, often dangerous, and generally unnecessary.
 * </p>
 * <p>
 *     Cleaners are less dangerous than finalizers, still unpredictable, slow and generally unnecessary.
 * </p>
 * <p>
 *     Never do anything time critical in a finalizer or cleaner because it can take arbitrarily long time between objects
 *     and the time it is cleaned up.
 * </p>
 * <p>
 *     It is not good practice to close file descriptors in a finalizer because the file descriptor is a limited resource.
 *     If many files are left open as a result of system's tardiness in running finalizers/cleaners, a program may fail because it can no longer open files.
 * </p>
 * <p>
 *     Never depend on finalizers or cleaners to update a persistent state. If you want to release a lock on a shared resource such as a database,
 *     you will bring the distributed system to a grinding halt.
 * </p>
 * <p>
 *     Finalizers have security risks: open class to finalizer attackers. Throwing an exception from a constructor should be
 *     sufficient to prevent an object from coming into existence.
 *     To protect nonfinal classes from finalizers attacks, write a finalize method that does nothing.
 * </p>
 * <p>
 *     Implement AutoCloseable, require its clients to invoke close method on each instance, for objects encapsulate resources that require termination.
 * </p>
 * <p>
 *     The finalizers and cleaners have 2 cases where they are useful. First one is to close an instance later than never.
 *     The second concerns objects with native peers. A native peer is a non-Java object which a normal object delegates with native methods.
 *     The native peer needs to not hold critical resources and performance is acceptable. Native objects are not garbage collected.
 * </p>
 */
public class FinalizersAndCleaners {
    public static void main(String[] args) {
        try (Room room = new Room(7)) {
            System.out.println("Goodbye");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
