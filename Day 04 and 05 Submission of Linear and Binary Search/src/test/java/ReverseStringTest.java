import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stringbuilderproblems.reversestring.ReverseString;

public class ReverseStringTest {
 @Test
    void testReverseString(){
     String input = "Hello, World!";
     String output = "!dlroW ,olleH";
     Assertions.assertEquals(output, ReverseString.reverseString(input));
 }

}
