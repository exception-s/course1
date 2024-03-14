package Enums;

public enum Items {
    Costum("Чёрный бархатный костюм..."),
    Buns("плюшки"),
    Basket("корзинка");
    private String item;
    Items(String item){
        this.item = item;
    }
    public String getItem(){
        return item;
    }
}
