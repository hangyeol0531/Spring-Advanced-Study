package hello.advanced.trace.hellotract;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV1Test {

    @Test
    void begin_end() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception(){
        HelloTraceV1 tract = new HelloTraceV1();
        TraceStatus status = tract.begin("hello");
        tract.exception(status, new IllegalStateException());
    }

}