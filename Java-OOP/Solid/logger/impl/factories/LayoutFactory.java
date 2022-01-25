package Solid.logger.impl.factories;

import Solid.logger.impl.layouts.SimpleLayout;
import Solid.logger.impl.layouts.XmlLayout;
import Solid.logger.interfaces.Factory;
import Solid.logger.interfaces.Layout;

public class LayoutFactory implements Factory<Layout> {


    @Override
    public Layout produce(String input) {
       Layout layout = null;

       if (input.equals("SimpleLayout")) {
           layout = new SimpleLayout();
       } else if (input.equals("XmlLayout")) {
           layout = new XmlLayout();
       }
       return layout;
    }
}
