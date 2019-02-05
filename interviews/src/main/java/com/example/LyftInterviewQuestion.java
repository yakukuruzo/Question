package com.example;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

/**
 * Created by levin on 4/12/17.
 */

public class LyftInterviewQuestion {

    public static class LruCache<K, V> implements Cache<K, V> {

        public static class Entry<K, V> {
            public K key;
            public V value;

        public Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private ArrayList<Entry<K, V>> mEntryList;
        private final int mMaxCapacity;

        public LruCache(int capacity) {
            mMaxCapacity = capacity;
            mEntryList = new ArrayList<>(capacity);
        }

        @Override
        public void put(K key, V value) {

            // Handle key == null

            // Find an element
            for (int i = 0; i < mEntryList.size(); i++) {
                Entry<K,V> curr = mEntryList.get(i);
                if (curr.key == key) {
                    curr.value = value;
                    mEntryList.remove(i);
                    mEntryList.add(curr);
                    return;
                }
            }

            if (mEntryList.size() >= mMaxCapacity) {
                mEntryList.remove(0);
            }

            mEntryList.add(new Entry<>(key, value));
        }

        public V get(K key) {
            // Find element
            for (int i = 0; i < mEntryList.size(); i++) {
                Entry<K,V> curr = mEntryList.get(i);
                if (curr.key == key) {
                    mEntryList.remove(i);
                    mEntryList.add(curr);
                    return curr.value;
                }
            }

            return null;
        }
    }

    public interface Cache<K, V> {

        void put(K key, V value);

        V get(K key);
    }

    /*public static class LruCacheTest {

        @Test
        public void basicTest() {
            assertEquals(4, 4);
            assertFalse(false);
            assertTrue(true);
            assertNotNull(new Object());
            assertNull(null);
        }
    }*/


    /*

class Solution {

    public static void main(String[] args) {
        JUnitCore.main(SolutionTest.class.getName());
    }

    /*

    Implement Java stream map method. Keep in mind that stream methods executing only when iterator is called.

     */

    interface MyStream<T> {

        /**
         * The element iterable for this stream
         */
        Iterator<T> iterator();
    }

    public static class StreamImpl<T> implements MyStream<T> {

        private Iterable<T> iterable;

        public StreamImpl(Iterable<T> iterable) {
            this.iterable = iterable;
        }

        @Override
        public Iterator<T> iterator() {

            return iterable.iterator();
        }
    }

    public static class CustomIterator<R, T> implements Iterator<R> {

        private final Iterator<T> mIterator;
        private final Function<T, R> mMapper;

        public CustomIterator(Iterable<T> iterable, Function<T, R> mapper) {
            mIterator = iterable.iterator();
            mMapper = mapper;
        }

        public boolean hasNext() {
            return mIterator.hasNext();
        }

        public R next() {
            return mMapper.apply(mIterator.next());
        }
    }

    public static class MyStreams {

        static <T> MyStream<T> from(Iterable<T> iterable) {
            return new StreamImpl<>(iterable);
        }

        /**
         * Returns a stream consisting of the results of applying the given function to the elements of this stream.
         */
        static <T, R> MyStream<R> map(Iterable<T> iterable, Function<T, R> mapper) {

            return new StreamImpl(new Iterable<R>() {
                @Override
                public Iterator<R> iterator() {
                    return new CustomIterator(iterable, mapper);
                }
            });

        }

        static <T> MyStream<T> filter(Iterable<T> iterable, Predicate<T> predicate) {
            return null;
        }
    }

    public static class SolutionTest {

        public void map_noInteractionsBeforeUse() {
            List<String> arrayList = Arrays.<String>asList("1", "2", "3");

            final boolean[] wasCalled = { false };

            MyStream<Integer> resultStream = MyStreams.map(arrayList, new Function<String, Integer>() {

                @Override
                public Integer apply(String s) {
                    wasCalled[0] = true;
                    return Integer.valueOf(s);
                }
            });

            Assert.assertEquals(wasCalled[0], false);
        }

        public void map_happyPath() {
            List<String> arrayList = Arrays.<String>asList("1", "2", "3");

            MyStream<Integer> resultStream = MyStreams.map(arrayList, new Function<String, Integer>() {

                @Override
                public Integer apply(String s) {
                    return Integer.valueOf(s) + 1;
                }
            });

            Iterator<Integer> resultIterator = resultStream.iterator();

            Assert.assertEquals(resultIterator.hasNext(), true);
            Assert.assertEquals(new Integer(2), resultIterator.next());
            Assert.assertEquals(resultIterator.hasNext(), true);
            Assert.assertEquals(new Integer(3), resultIterator.next());
            Assert.assertEquals(resultIterator.hasNext(), true);
            Assert.assertEquals(new Integer(4), resultIterator.next());
            Assert.assertEquals(resultIterator.hasNext(), false);
        }

        public void filter_happyPath() throws Exception {
            List<String> arrayList = Arrays.<String>asList("", "2", "3");
            MyStream<String> resultStream = MyStreams.filter(arrayList, new Predicate<String>() {

                @Override
                public boolean test(String s) {
                    return s != null && !s.isEmpty();
                }
            });

            Iterator<String> resultIterator = resultStream.iterator();
            Assert.assertEquals(resultIterator.hasNext(), true);
            Assert.assertEquals("2", resultIterator.next());
            Assert.assertEquals(resultIterator.hasNext(), true);
            Assert.assertEquals("3", resultIterator.next());
            Assert.assertEquals(resultIterator.hasNext(), false);

        }
    }
}

/* Hint
    public interface Iterable<T> {
        Iterator<T> iterator();
    }
    public interface Iterator<E> {
        boolean hasNext();
        E next();
    }
*/


