package decorator.service;

import decorator.entity.Haircut;
import decorator.ВarbershopDecorator;

public class Barber {
    private ВarbershopDecorator вarbershopDecorator;

    public Barber(ВarbershopDecorator вarbershopDecorator) {
        this.вarbershopDecorator = вarbershopDecorator;
    }

    public Haircut StartDoingHaircut(){
        Haircut haircut = new Haircut();
        вarbershopDecorator.cut(haircut);
        return haircut;
    }
}
