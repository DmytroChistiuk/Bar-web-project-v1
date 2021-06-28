package decorator.decoratorFunctionality;

import decorator.entity.Haircut;
import decorator.ВarbershopDecorator;

public class ВeardСutDecorator implements ВarbershopDecorator {
    private ВarbershopDecorator вarbershopDecorator;

    public ВeardСutDecorator(ВarbershopDecorator вarbershopDecorator) {
        this.вarbershopDecorator = вarbershopDecorator;
    }

    @Override
    public void cut(Haircut haircut) {
        System.out.println("~~Beard was cut~~");
        if(вarbershopDecorator!=null){
        вarbershopDecorator.cut(haircut);}
        else {
            System.out.println("Thanks for using our barbershop");
        }
    }
}
