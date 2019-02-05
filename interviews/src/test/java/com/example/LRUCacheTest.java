package com.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.LRUInterviewQuestion.*;

/**
 * Created by levin on 4/20/17.
 */
public class LRUCacheTest {

    @Test
    public void testLRUCache() throws Exception {
        LRUCache cache = new LRUCache(5);

        cache.set(9, 0);
        cache.set(5, 2);
        cache.set(3, 7);
        cache.set(1, 34);
        cache.set(90, 56);
        cache.set(34, 25);

        System.out.println(cache.get(9));
        System.out.println(cache.get(3));
    }
}