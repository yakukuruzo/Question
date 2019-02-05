package com.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.example.MaximumSubArray.*;

/**
 * Created by levin on 3/27/17.
 */
public class MaximumSubArrayTest {
    @Test
    public void testKadanesAlgorythm() throws Exception {
        kadanesAlgorythm(null);
        kadanesAlgorythm(new int[]{});
        kadanesAlgorythm(new int[]{9});
        kadanesAlgorythm(new int[]{-4});
        kadanesAlgorythm(new int[]{-4, -5, -8, -1, -19});
        kadanesAlgorythm(new int[]{4, 5, 1, 6, 7});
        kadanesAlgorythm(new int[]{4, 5, -1, 6, 7});
        kadanesAlgorythm(new int[]{1, -3, 3, 2, -1});
    }

}