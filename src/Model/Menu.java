package Model;

public class Menu {

    private String category;
    private String item;
    private String type;
    private int menuType;

    public Menu (String category, String item, String type, int menuType) {
        this.category = category;
        this.item = item;
        this.type = type;
        this.menuType = menuType;
    }

    public String getCategory() {
        return category;
    }

    public String getItem() {
        return item;
    }

    public String getType() {
        return type;
    }

    public int getMenuType() {
        return menuType;
    }

}
