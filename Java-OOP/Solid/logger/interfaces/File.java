package Solid.logger.interfaces;

import java.io.IOException;

public interface File {

    int getSize();
    boolean write(String text) throws IOException;
    void append(String text);
}
