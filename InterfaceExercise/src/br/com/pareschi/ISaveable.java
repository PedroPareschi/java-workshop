package br.com.pareschi;

import java.util.List;

public interface ISaveable {
    //        1.  ISaveable (interface)
    //
    //    -  It has two methods:
    //
    //        -  write(), takes no arguments and returns a List containing objects of type String.
    //
    //        -  read(), takes a List of type String and doesn't return anything.
    List<String> write();
    void read(List<String> list);
}
