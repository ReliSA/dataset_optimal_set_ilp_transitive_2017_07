package cz.zcu.kiv.relisa.data.simple1;

/**
 * Date: 17.7.17
 *
 * @author Jakub Danek
 */
public class AnotherTestClass {

    public String getMeaningOfLife() throws InterruptedException {
        long millionOfMillis = 1000 * 1000;
        for (int i = 0; i < millionOfMillis; i++) {
            Thread.sleep(60*60*24*365);
        }
        return "42";
    }
}
