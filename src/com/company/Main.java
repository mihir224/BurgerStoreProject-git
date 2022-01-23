package com.company;

public class Main {
    public static void main(String[] args) {
        Hamburger hamburger=new Hamburger("garlic", "grilled chicken", "'Juicy Chicken'", 180);
        hamburger.setLettuce(true);
        hamburger.setTomato(true);
        System.out.println("Total price: " + hamburger.finalPrice());
        HealthyBurger healthyBurger=new HealthyBurger("roasted chicken", 160, true);
        healthyBurger.setOats("Strawberry", 50);
        healthyBurger.finalPrice();
        DeluxeBurger deluxeBurger=new DeluxeBurger("fried chicken", 200);
        deluxeBurger.setChips("Lays", 20);
        deluxeBurger.setDrink("Coke",40);
        deluxeBurger.finalPrice();

    }
    public static class Hamburger{
        private String bread;
        private String meat;
        private boolean lettuce;
        private boolean tomato;
        private boolean carrot;
        private boolean olives;
        private String name;
        private double price;
        public Hamburger(String bread, String meat, String name, int price){
            this.bread=bread;
            this.meat=meat;
            this.name=name;
            this.price=price;
        }

        public void setLettuce(boolean lettuce) {
            this.lettuce = lettuce;
        }

        public void setTomato(boolean tomato) {
            this.tomato = tomato;
        }

        public void setCarrot(boolean carrot) {
            this.carrot = carrot;
        }

        public void setOlives(boolean olives) {
            this.olives = olives;
        }

        public double finalPrice()
        {
            System.out.println("A customized " + name + " burger with " + bread +" bread type and " + meat + " meat worth "+ price + " rupees added.");

            if(this.tomato)
            {
                price+=0.5;
                System.out.println("tomatoes worth 0.5 rupees added.");
            }
            if(this.lettuce)
            {
                price+=0.5;

                System.out.println("lettuce worth 0.5 rupees added.");
            }
            if(this.carrot)
            {
                price+=0.5;

                System.out.println("carrots worth 0.5 rupees added.");
            }
            if(this.olives)
            {
                price+=0.5;

                System.out.println("olives worth 0.5 rupees added.");
            }
            return price;
        }
    }
    public static class HealthyBurger extends Hamburger {
        private String oatsFlavour;
        private boolean greenTea;
        private double oatPrice;
        public HealthyBurger(String meat, int price, boolean greenTea) {
            super("multigrain", meat,"'VegAF'", price);
            this.greenTea=greenTea;

        }
        public void setOats(String oatsFlavour, double oatPrice)
        {
            this.oatsFlavour=oatsFlavour;
            this.oatPrice=oatPrice;

        }

        @Override
        public double finalPrice() {
            double price=super.finalPrice(); //here the price value returnd from the finalPrice method of the base class is being used
            if(this.oatsFlavour!=null)
            {
                price+=oatPrice;
                System.out.println(oatsFlavour + " oats worth " + oatPrice + " rupees added"  );
            }
            if(this.greenTea)
            {
                price+=30;
                System.out.println("Green tea worth 30 rupees added.");
            }
            System.out.println("Total price: " + price + " rupees");
            return price;


        }

    }
    public static class DeluxeBurger extends Hamburger {
        private String drink;
        private String chips;
        private double drinkPrice;
        private double chipPrice;

        public DeluxeBurger(String meat, int price)
        {
            super("italian",meat,"'this burger don't speak broke'", price);

        }
        public void setDrink(String drink, double drinkPrice)
        {
            this.drink=drink;
            this.drinkPrice=drinkPrice;
        }
        public void setChips(String chips, double chipPrice)
        {
            this.chips=chips;
            this.chipPrice=chipPrice;
        }

        @Override
        public double finalPrice(){
            double price=super.finalPrice();
            if(this.chips!=null)
            {
                price+=this.chipPrice;
                System.out.println(chips + " worth " + chipPrice + " added." );
            }
            if(this.drink!=null)
            {
                price+=this.drinkPrice;
                System.out.println(drink+ " worth " + drinkPrice + " added.");
            }
            System.out.println("Total price: " + price + " rupees");
            return price;
        }
    }
}

