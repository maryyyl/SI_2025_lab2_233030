import org.example.SILab2;
import org.junit.jupiter.api.Test;
import org.example.SILab2.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;


import javax.swing.*;

public class SILab2Test {
    private final SILab2 lab2= new SILab2();
    @Test
    public void EveryStatementTest(){
        List<SILab2.Item> allItems= null; //test case1
        RuntimeException ex1=assertThrows(RuntimeException.class,()->lab2.checkCart(allItems,"neverMind"));
        assertTrue(ex1.getMessage().contains("allItems"));
        //test case 2
        List<SILab2.Item> allItems1= new ArrayList<>();
        allItems1.add(new SILab2.Item("someName",1,301,1));
        allItems1.add(new SILab2.Item(null,0,0,0));
        RuntimeException ex2=assertThrows(RuntimeException.class,()->lab2.checkCart(allItems1,"neverMind"));
        assertTrue(ex2.getMessage().contains("Invalid"));
        //test case 3
        List<SILab2.Item> allItems2= new ArrayList<>();
        allItems2.add(new SILab2.Item("someName",1,301,1));
        allItems2.add(new SILab2.Item("someName",0,0,0));
        assertEquals(-30,lab2.checkCart(allItems2,"1234567891234567"));
        //test case 4
        RuntimeException ex5=assertThrows(RuntimeException.class,()->lab2.checkCart(allItems2,"123456789"));//test case 4, card num length =9
        assertTrue(ex5.getMessage().contains("Invalid card number"));
        // test case 5, invalid character
        RuntimeException ex4=assertThrows(RuntimeException.class,()->lab2.checkCart(allItems2,"a123456789123456"));
        assertTrue(ex4.getMessage().contains("Invalid character"));

    }
    @Test
    public void MultipleConditionsTest(){
        List<SILab2.Item> allItems= new ArrayList<>();
        allItems.add(new SILab2.Item("someName",1,299,0)); //- FFF
        allItems.add(new SILab2.Item("someName",1,301,1)); //- TTF (TXX)
        allItems.add(new SILab2.Item("someName",1,299,0.10));// - FTF (FTX)
        allItems.add(new SILab2.Item("someName",11,299,0)); //- FFT
        assertEquals(3767.1,lab2.checkCart(allItems,"1234567891234567"));
    }

}



