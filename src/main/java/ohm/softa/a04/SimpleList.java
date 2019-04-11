package ohm.softa.a04;

import java.util.function.Function;

public interface SimpleList<T> extends Iterable<T> {
	/**
	 * Add a given object to the back of the list.
	 */
	void add(T t);

	/**
	 * @return current size of the list
	 */
	int size();

	/**
	 * Generate a new list using the given filter instance.
	 * @return a new, filtered list
	 */
	default SimpleList<T> filter(SimpleFilter<T> filter) {
		SimpleList<T> result = new SimpleListImpl<>();
		for (T t : this) {
			if (filter.include(t)) {
				result.add(t);
			}
		}
		return result;
	}

	default <R> SimpleList<R> map(Function<T, R> transform) {
		SimpleList<R> result = new SimpleListImpl<>();
		for(T t : this) {
			R r = transform.apply(t);
			result.add(r);
		}
		return result;
	}
}
