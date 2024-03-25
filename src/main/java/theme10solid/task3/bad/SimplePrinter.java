package theme10solid.task3.bad;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SimplePrinter implements MultiFunctionDevice {
    @Override
    public void printData() {
        System.out.println("Печать");
    }

    @Override
    public void scanData() {
        throw new NotImplementedException();
    }

    @Override
    public void sendFax() {
        throw new NotImplementedException();
    }
}
