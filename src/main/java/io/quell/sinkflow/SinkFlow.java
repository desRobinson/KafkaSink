package io.quell.sinkflow;

import io.quell.dummy.avro.SourceSinkDummyEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.io.IOException;

@Slf4j
@EnableBinding(Sink.class)
@EnableAutoConfiguration
public class SinkFlow {

    @StreamListener(Sink.INPUT)
    public void save(byte[] message) throws IOException {

        GenericRecord record = buildDeserializerAndRetrieveData(message, SourceSinkDummyEvent.getClassSchema());

        log.info("Sink *^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^* ");
        log.info("Sink *^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^* ");
        log.info("Sink *^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^* ");
        log.info("Sink *^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^* ");
        log.info("Sink --> " + record.get("HelloWorld"));
        log.info("Sink *^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^* ");
        log.info("Sink *^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^* ");
        log.info("Sink *^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^* ");
        log.info("Sink *^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^* ");
    }

    private GenericRecord buildDeserializerAndRetrieveData(byte[] message, Schema schema) throws IOException {
        GenericDatumReader<GenericRecord> reader = new GenericDatumReader<>(schema);
        Decoder e = DecoderFactory.get().binaryDecoder(message, null);

        return reader.read(null, e);
    }
}
