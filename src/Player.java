import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String description;
    private int health;
    private Room currRoom;
    private List<Item> Inventory;

    public Player(String name, String description, int health, Room startRoom) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.currRoom = startRoom;
        this.Inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }
    public Room getCurrRoom(){
        return currRoom;
    }
    public void setCurrRoom(Room currRoom){
        this.currRoom = currRoom;
    }

    public List<Item> getInventory() {
        return Inventory;
    }
    public void addItem(Item item){
        if(item != null){
            Inventory.add(item);
            System.out.println("Added " + item.getName() + " to inventory.");
        }
    }

    public void removeItem(Item item){
        if(Inventory.contains(item)){
            Inventory.remove(item);
            System.out.println("Removed " + item.getName() + " from inventory.");
        }else{
            System.out.println("Item not found in inventory.");
        }
    }

    public void showInventory(){
        if(Inventory.isEmpty()){
            System.out.println("Your inventory is empty.");
        }else{
            System.out.println("Your inventory contains: ");
            for(Item item: Inventory){
                System.out.println("- " + item.getName() + ":" + item.getDescription());
            }
        }
    }
}
