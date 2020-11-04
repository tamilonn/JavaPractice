package com.test.java8;

import java.lang.instrument.Instrumentation;

/**
 * To test this class.  Need to create a jar with MANIFEST.MF having this agent class.
 * Then have jar created.  Ref: https://www.baeldung.com/java-size-of-object
 */
public class InstrumentationAgent {
    private static volatile Instrumentation globalInstrumentation;

    public static void premain(final String agentArgs, final Instrumentation inst) {
        globalInstrumentation = inst;
    }

    public static long getObjectSize(final Object object) {
        if (globalInstrumentation == null) {
            throw new IllegalStateException("Agent not initialized.");
        }
        return globalInstrumentation.getObjectSize(object);
    }
}
