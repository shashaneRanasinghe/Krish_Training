import org.junit.Assert;
import org.junit.Test;

public class MissingNumberTest {

    @Test
    public void MissingNumberTest_HappyPath(){
        String[] inputs = {"6 5 2 3 1","3 8 2 4 5 7","-2 3 -1 0 2"};
        String[] expected = {"The missing number is 4","The missing number is 6","The missing number is 1"};
        for(int i = 0;i < inputs.length;i++){
            String actual = MissingNumber.findMissingNumber(inputs[i]);
            Assert.assertEquals(expected[i],actual);
        }
    }

    @Test
    public void MissingNumberTest_NumAtEnd(){
        String[] inputs = {"6 5 4 3 2","3 4 5 6 7","-2 -1 0 1 2"};
        String[] expected = {"The missing number is 7","The missing number is 8","The missing number is 3"};
        for(int i = 0;i < inputs.length;i++){
            String actual = MissingNumber.findMissingNumber(inputs[i]);
            Assert.assertEquals(expected[i],actual);
        }
    }

    @Test
    public void MissingNumberTest_InvalidSequence(){
        String[] inputs = {"6 d 3","1  2 3","1.0 3 2"};
        for(String input : inputs){
            String expected = "Please enter valid number series";
            String actual = MissingNumber.findMissingNumber(input);
            Assert.assertEquals(expected,actual);
        }
    }

    @Test
    public void MissingNumberTest_MultipleMissingNums(){
        String input = "6 5 4 2";
        String expected = "The missing number is 3";
        String actual = MissingNumber.findMissingNumber(input);
        Assert.assertEquals(expected,actual);
    }
}
