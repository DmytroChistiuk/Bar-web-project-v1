package decorator.decoratorFunctionality;

import decorator.entity.Haircut;
import decorator.ВarbershopDecorator;

public class MustacheCutDecorator implements ВarbershopDecorator {
    private ВarbershopDecorator вarbershopDecorator;

    public MustacheCutDecorator(ВarbershopDecorator вarbershopDecorator) {
        this.вarbershopDecorator = вarbershopDecorator;
    }

    @Override
    public void cut(Haircut haircut) {
        System.out.println("~~Mustache was cut~~");
        if(вarbershopDecorator!=null){
        вarbershopDecorator.cut(haircut);}
        else {
            System.out.println("Thanks for using our barbershop");
        }

    }
}
