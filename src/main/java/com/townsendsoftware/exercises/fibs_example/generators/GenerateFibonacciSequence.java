package com.townsendsoftware.exercises.fibs_example.generators;

import java.util.ArrayList;
import java.util.List;

import com.townsendsoftware.exercises.fibs_example.utils.LogUtils;

public class GenerateFibonacciSequence {
    
    public static List<Long> generateSequence(long seqSeed0, long seqSeed1, long iterations) {
        List<Long> generatedSequence = new ArrayList<Long>();
        if (seqSeed0 >= 0 && seqSeed1 > 0 && iterations > 0) {
            if (seqSeed0 >= seqSeed1 && seqSeed1 != 1 && seqSeed0 !=1) {
                LogUtils.logMessage(String.format("seqSeed0 must be < seqSeed1 (unless both are 1). Provided: seqSeed0[%d], seqSeed1[%d], iterations[%d]", seqSeed0, seqSeed1, iterations));
            } else {
                LogUtils.logMessage(String.format("Generating fibonacci sequence using seeds %d, %d for %d iterations", seqSeed0, seqSeed1, iterations));
                generatedSequence.add(seqSeed0);
                generatedSequence.add(seqSeed1);
                for (int seqCount = 2; seqCount < iterations-2; seqCount++) {
                    // This should work since we have already seeded the first two values
                    long toAdd = (generatedSequence.get(seqCount-1).longValue() + generatedSequence.get(seqCount-2).longValue());
                    generatedSequence.add(toAdd);
                } 
            }
        } else {
            LogUtils.logMessage(String.format("seqSeed0, seqSeed1 and iterations must be positive long values. Provided: seqSeed0[%d], seqSeed1[%d], iterations[%d]", seqSeed0, seqSeed1, iterations));
        }

        return generatedSequence;
    }
}
