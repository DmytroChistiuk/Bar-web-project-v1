package decorator.decoratorFunctionality;

import decorator.entity.Haircut;
import decorator.ВarbershopDecorator;

public class FadeHaircutDecorator implements ВarbershopDecorator {
    private ВarbershopDecorator вarbershopDecorator;

    public FadeHaircutDecorator(ВarbershopDecorator вarbershopDecorator) {
        this.вarbershopDecorator = вarbershopDecorator;
    }

    @Override
    public void cut(Haircut haircut) {
        System.out.println("~~Fade haircut was made~~");
        if(вarbershopDecorator!=null){
        вarbershopDecorator.cut(haircut);}
        else {
            System.out.println("Thanks for using our barbershop");
        }
    }
}
