package com.aavdeev.diablo;

public class DiabloClass {
    private String name;
    private String descrption;

    public static final DiabloClass[] listClass = {
            new DiabloClass("Demon Hunter"," достойный класс для одиночной игры, обладает мощной атакой дальнего боя. Есть возможность наносить большой урон боссам и элитникам, не подвергаясь их атаке, а также убивать мелких мобов взрывными ловушками, нужно постоянно быть в движении или прятаться за спинами товарищей."),
            new DiabloClass("Witch Doctor","класс для любителей призывать существ, медленных травящих и деморализующих атак. Неповторимый \"дебаффер\", уменьшающий параметры врагов. Может вызвать стаю огненных летучих мышей или дождь из лягушек. Свою слабую броню он компенсирует вызовом могучего воина, который может одним ударом сразить любого демона и принимать удары от боссов."),
            new DiabloClass("Barbarian","сильный персонаж, всегда готовый к бою, огромная толпа мобов его не испугает, а скорее только раззадорит и придаст силы. На боссах может включать пассивки на броню и тоже смеяться ему в лицо. Хороший соло-персонаж и незаменимый \"танк\" в кооперативе.")
    };

    public DiabloClass(String name, String descrption) {
        this.name = name;
        this.descrption = descrption;
    }

    public String getName() {
        return name;
    }

    public String getDescrption() {
        return descrption;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
