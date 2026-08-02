package com.truetileanimationmovement.core;

/**
 * A contract for objects that can create a copy of themselves.
 * <p>
 * Classes implementing this interface should define how the copy operation is
 * performed, ensuring that the returned object is a separate instance with the
 * same state as the original.
 * <p>
 * This interface does not currently prescribe whether the copy operation should
 * be deep or shallow.
 *
 * @param <T> the type of the object that can be copied
 */
public interface Copyable<T> {
    /**
     * Makes a copy of this instance with identical state.
     *
     * @return a new instance of this object with copied state
     */
    T copy();
}
