package cz.zcu.kiv.relisa.data.simple1;

/**
 * Date: 17.7.17
 *
 * @author Jakub Danek
 */
public class TestClass {

    public String testMethod(Integer parameter) {
        return parameter.toString();
    }

    public Integer testMethod(String parameter) {
        return Integer.valueOf(parameter);
    }
}
