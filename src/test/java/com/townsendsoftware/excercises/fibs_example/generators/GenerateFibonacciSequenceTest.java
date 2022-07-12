package com.townsendsoftware.excercises.fibs_example.generators;

import static com.townsendsoftware.exercises.fibs_example.constants.FibsConstants.MAX_ITERATIONS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import com.townsendsoftware.exercises.fibs_example.generators.GenerateFibonacciSequence;

public class GenerateFibonacciSequenceTest {

    @Test
    public void testFullRange() {
        List<Long> results = GenerateFibonacciSequence.generateSequence(0, 1, 50);
        assertTrue(CollectionUtils.isNotEmpty(results));
        assertEquals(50, results.size());
        for (int idx = 2; idx < 50; idx++) {
            long f0 = results.get(idx-1);
            long f1 = results.get(idx-2);
            assertEquals(results.get(idx), new Long(f0 + f1));
        }
    }

    @Test
    public void testOutOfBounds() {
        // seeds can't be equal unless they are one
        List<Long> results = GenerateFibonacciSequence.generateSequence(0, 0, 50);
        assertTrue("Seeds can't be equal unless both are 1", CollectionUtils.isEmpty(results));

        // Validate 1, 1 seeds work
        results = GenerateFibonacciSequence.generateSequence(1, 1, 50);
        assertTrue("Seeds CAN be equal if both are 1", CollectionUtils.isNotEmpty(results));

        // Validate seed1 > seed 0
        results = GenerateFibonacciSequence.generateSequence(1, 0, 50);
        assertTrue("seed0 must be < seed1", CollectionUtils.isEmpty(results));

        // Validate iterations > 1
        results = GenerateFibonacciSequence.generateSequence(0, 1, 0);
        assertTrue("Iterations must be > 0", CollectionUtils.isEmpty(results));

        // Validate iterations <= MAX_ITERATIONS
        results = GenerateFibonacciSequence.generateSequence(0, 1, MAX_ITERATIONS + 1);
        assertTrue("Iterations must be <= MAX_ITERATIONS", CollectionUtils.isEmpty(results));
    }
}