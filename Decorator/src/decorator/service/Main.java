package decorator.service;

import decorator.decoratorFunctionality.FadeHaircutDecorator;
import decorator.decoratorFunctionality.MustacheCutDecorator;
import decorator.decoratorFunctionality.ВeardСutDecorator;

public class Main {

    public static void main(String[] args) {
	Barber barber = new Barber(new FadeHaircutDecorator(new MustacheCutDecorator(new ВeardСutDecorator(null))));
    barber.StartDoingHaircut();
    }
}
