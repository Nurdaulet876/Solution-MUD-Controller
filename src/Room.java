import java.util.*;

public class Room{
    private String name;
    private String description;
    private List<Item> items;
    private List<NPC> npcs;
    private Map<String, Room> exits;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.npcs = new ArrayList<>();
        this.exits = new HashMap<>();
    }

    public void describe(){
        System.out.println("You are in the " + name + " room." + description + ".");
        if(!items.isEmpty()){
            System.out.println("You see: ");
            for(Item item: items){
                System.out.println(item.getName() + " ");
            }
            System.out.println();
        }else{
            System.out.println("There are no items here.");
        }

        if(!npcs.isEmpty()){
            System.out.println("You see NPCs: ");
            for(NPC npc: npcs){
                System.out.println(npc.getName());
            }
        }else{
            System.out.println("There are no NPCs here.");
        }
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

    public List<Item> getItems() {
        return items;
    }

    public List<NPC> getNPCs(){
        return npcs;
    }
    public void addItem(Item item){
        if(item != null){
            items.add(item);
        }
    }
    public void removeItem(Item item){
        items.remove(item);
    }
    public Item getItem(String itemName){
        for(Item item: items){
            if(item.getName().equalsIgnoreCase(itemName)){
                return item;
            }
        }
        return null;
    }

    public void addNpc(NPC npc){
        if(npc != null){
            npcs.add(npc);
            System.out.println(npc.getName() + " added to " + name);
        }
    }

    public void removeNpc(NPC npc){
        npcs.remove(npc);
    }

    public NPC getNpc(String NpcName){
        for(NPC npc: npcs){
            System.out.println("Checking NPCs: " + npc.getName());
            if(npc.getName().equalsIgnoreCase(NpcName)){
                return npc;
            }
        }
        return null;
    }
    public void addExit(String direction, Room room){
        exits.put(direction.toLowerCase(), room);
    }
    public Room getExit(String direction){
        return exits.get(direction.toLowerCase());
    }
    public void showExits(){
        System.out.println("All available exits: " + exits.keySet());
    }
}
