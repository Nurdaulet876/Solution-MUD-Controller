import java.util.Scanner;

public class MUDController {
    private final Player player;
    private boolean running;

    /**
     * Constructs the controller with a reference to the current player.
     */
    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }

    /**
     * Main loop method that repeatedly reads input from the user
     * and dispatches commands until the game ends.
     */
    public void runGameLoop() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the game! Type 'help' to check commands");
        while(running){
            System.out.println("> ");
            String userInput = in.nextLine().trim().toLowerCase();
            handleInput(userInput);
        }
        System.out.println("You left the game. See you later!");
        in.close();
    }

    /**
     * Handle a single command input (e.g. 'look', 'move forward', 'pick up sword').
     */
    public void handleInput(String userInput) {
        if(userInput.isEmpty()){
            return;
        }
        String [] parts = userInput.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = parts.length>1 ? parts[1]: " ";

        switch (command){
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick":
                pickUp(argument);
            case "inventory":
                checkInventory();
                break;
            case "talk":
                talkToNPC(argument);
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                break;
            default:
                System.out.println("This command doesn't exist. You can check all commands by typing 'help'.");
                break;
        }
    }

    /**
     * Look around the current room: describe it and show items/NPCs.
     */
    private void lookAround() {
        Room currRoom = player.getCurrRoom();
        System.out.println("You are in the " + currRoom.getName());
        System.out.println(currRoom.getDescription());

        if (!currRoom.getItems().isEmpty()){
            System.out.println("Items is here: ");
            currRoom.getItems().forEach(item -> System.out.println(item.getName() + " "));
            System.out.println();
        }else{
            System.out.println("There is no items in the room");
        }
    }

    /**
     * Move the player in a given direction (forward, back, left, right).
     */
    private void move(String direction) {
        if(direction.isEmpty()){
            System.out.println("Where do you want to move?");
            return;
        }
        Room nextRoom = player.getCurrRoom().getExit(direction);
        if(nextRoom != null){
            player.setCurrRoom(nextRoom);
            System.out.println("You move " + direction + ".");
            lookAround();
        }else{
            System.out.println("You cannot go that way.");
        }
    }

    /**
     * Pick up an item (e.g. "pick up sword").
     */
    private void pickUp(String arg) {
        if(arg.isEmpty()){
            System.out.println("What do you want to pick up?");
            return;
        }
        Room currRoom = player.getCurrRoom();
        Item item = currRoom.getItem(arg);
        if(item != null){
            player.addItem(item);
            currRoom.removeItem(item);
            System.out.println("You have picked up the " + arg + ".");
        }else{
            System.out.println("No item named '" + arg + "' here.");
        }
    }

    /**
     * Check the player's inventory.
     */
    private void checkInventory() {
        player.showInventory();
    }

    private void talkToNPC(String NpcName){
        Room room = player.getCurrRoom();
        NPC npc = room.getNpc(NpcName);
        if(npc != null){
            System.out.println("You met somebody! " + npc.getName() + " says: " + npc.talk());
        }else{
            System.out.println("No one is here.");
        }
    }

    /**
     * Show help commands
     */
    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("look: Describe the current room.");
        System.out.println("move <direction>: Move in a specified direction.");
        System.out.println("pick <item>: Pick up an item.");
        System.out.println("inventory: List items you are carrying.");
        System.out.println("talk: Talk to NPC.");
        System.out.println("help: Show this help menu.");
        System.out.println("quit or exit: End the game.");
    }
}
