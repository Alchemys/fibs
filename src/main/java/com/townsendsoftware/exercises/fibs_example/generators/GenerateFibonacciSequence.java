package com.townsendsoftware.exercises.fibs_example.generators;

import java.util.ArrayList;
import java.util.List;

import com.townsendsoftware.exercises.fibs_example.utils.LogUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenerateFibonacciSequence {
    
    public static List<Long> generateSequence(long seqSeed0, long seqSeed1, long iterations) {
        List<Long> generatedSequence = new ArrayList<Long>();
        if (seqSeed0 >= 0 && seqSeed1 > 0 && iterations > 0) {
            if (seqSeed0 >= seqSeed1 && seqSeed1 != 1 && seqSeed0 !=1) {
                log.error("seqSeed0 must be < seqSeed1 (unless both are 1). Provided: seqSeed0[{}], seqSeed1[{}], iterations[{}]", seqSeed0, seqSeed1, iterations);
            } else {
                log.info("Generating fibonacci sequence using seeds {}, {} for {} iterations", seqSeed0, seqSeed1, iterations);
                generatedSequence.add(seqSeed0);
                generatedSequence.add(seqSeed1);
                for (int seqCount = 2; seqCount < iterations-2; seqCount++) {
                    // This should work since we have already seeded the first two values
                    long toAdd = (generatedSequence.get(seqCount-1).longValue() + generatedSequence.get(seqCount-2).longValue());
                    generatedSequence.add(toAdd);
                } 
            }
        } else {
            log.error("seqSeed0, seqSeed1 and iterations must be positive long values. Provided: seqSeed0[{}], seqSeed1[{}], iterations[{}]", seqSeed0, seqSeed1, iterations);
        }

        return generatedSequence;
    }
}
