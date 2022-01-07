package IntefacesAndAbstraction.carShop;

import java.io.Serializable;

public interface Car extends Serializable {

    public static final int TIRES = 4;

    public String getModel();
    public String getColor();
    public Integer getHorsePower();
    public String countryProduced();


}
