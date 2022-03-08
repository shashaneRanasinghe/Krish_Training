import org.junit.Assert;
import org.junit.Test;

public class NoOfOccurrencesTest {

    @Test
    public void NoOfOccurrencesTest_HappyPath(){
        String[] inputs = {"aaabccd","aAacBbd","ZzxNmYzhg"};
        String[] expected = {"a - 3\nb - 1\nc - 2\nd - 1\n","a - 3\nb - 2\nc - 1\nd - 1\n",
                "g - 1\nh - 1\nm - 1\nn - 1\nx - 1\ny - 1\nz - 3\n"};
        for(int i = 0;i<inputs.length;i++){
            Assert.assertEquals(expected[i],NoOfOccurences.findOccurences(inputs[i]));
        }
    }

    @Test
    public void NoOfOccurrencesTest_InputValidation(){
        String[] inputs = {"aaabcc1","aA32acBbd","Zzx35NmYzhg"};
        String expected = "Please enter valid sequence of letters";
        for(int i = 0;i<inputs.length;i++){
            Assert.assertEquals(expected,NoOfOccurences.findOccurences(inputs[i]));
        }
    }
}
