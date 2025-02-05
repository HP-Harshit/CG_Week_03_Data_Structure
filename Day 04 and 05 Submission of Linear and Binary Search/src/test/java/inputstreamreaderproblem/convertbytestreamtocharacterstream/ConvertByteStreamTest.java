package inputstreamreaderproblem.convertbytestreamtocharacterstream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConvertByteStreamTest {
    @Test
    void testWriteOutput(){
        // Specify the path to your file
        String filePath = "sampleByteStream.txt";

        // Byte stream content (hex values)
        byte[] byteData = {
                0x48, 0x65, 0x6c, 0x6c, 0x6f, 0x2c, 0x20, 0x74, 0x68, 0x69, 0x73, 0x20, 0x69, 0x73, 0x20, 0x61,
                0x20, 0x73, 0x61, 0x6d, 0x70, 0x6c, 0x65, 0x20, 0x66, 0x69, 0x6c, 0x65, 0x2e, 0x0a, 0x49, 0x74,
                0x20, 0x63, 0x6f, 0x6e, 0x74, 0x61, 0x69, 0x6e, 0x73, 0x20, 0x6d, 0x75, 0x6c, 0x74, 0x69, 0x70,
                0x6c, 0x65, 0x20, 0x6c, 0x69, 0x6e, 0x65, 0x73, 0x20, 0x6f, 0x66, 0x20, 0x74, 0x65, 0x78, 0x74,
                0x2e, 0x0a, 0x45, 0x61, 0x63, 0x68, 0x20, 0x6c, 0x69, 0x6e, 0x65, 0x20, 0x73, 0x65, 0x72, 0x76,
                0x65, 0x73, 0x20, 0x61, 0x73, 0x20, 0x61, 0x20, 0x73, 0x65, 0x70, 0x61, 0x72, 0x61, 0x74, 0x65,
                0x20, 0x73, 0x74, 0x72, 0x69, 0x6e, 0x67, 0x2e, 0x0a, 0x54, 0x68, 0x69, 0x73, 0x20, 0x66, 0x69,
                0x6c, 0x65, 0x20, 0x69, 0x73, 0x20, 0x75, 0x73, 0x65, 0x64, 0x20, 0x74, 0x6f, 0x20, 0x64, 0x65,
                0x6d, 0x6f, 0x6e, 0x73, 0x74, 0x72, 0x61, 0x74, 0x65, 0x20, 0x72, 0x65, 0x61, 0x64, 0x69, 0x6e,
                0x67, 0x20, 0x66, 0x72, 0x6f, 0x6d, 0x20, 0x61, 0x20, 0x66, 0x69, 0x6c, 0x65, 0x20, 0x75, 0x73,
                0x69, 0x6e, 0x67, 0x20, 0x46, 0x69, 0x6c, 0x65, 0x52, 0x65, 0x61, 0x64, 0x65, 0x72, 0x20, 0x61,
                0x6e, 0x64, 0x20, 0x49, 0x6e, 0x70, 0x75, 0x74, 0x53, 0x74, 0x72, 0x65, 0x61, 0x6d, 0x52, 0x65,
                0x61, 0x64, 0x65, 0x72, 0x2e, 0x0a, 0x48, 0x6f, 0x70, 0x65, 0x20, 0x79, 0x6f, 0x75, 0x20, 0x66,
                0x69, 0x6e, 0x64, 0x20, 0x74, 0x68, 0x69, 0x73, 0x20, 0x65, 0x78, 0x61, 0x6d, 0x70, 0x6c, 0x65,
                0x20, 0x68, 0x65, 0x6c, 0x70, 0x66, 0x75, 0x6c, 0x21
        };

        Assertions.assertEquals(true, ConvertByteStream.writeOutput(filePath, byteData));
    }

    @Test
    void testReadInput(){
        // Specify the path to your file
        String filePath = "sampleByteStream.txt";

        String expectedOutput = "Hello, this is a sample file.\n" +
                "It contains multiple lines of text.\n" +
                "Each line serves as a separate string.\n" +
                "This file is used to demonstrate reading from a file using FileReader and InputStreamReader.\n" +
                "Hope you find this example helpful!\n";

        Assertions.assertEquals(expectedOutput, ConvertByteStream.readInput(filePath));
    }
}
