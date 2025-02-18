public class Main {
    public static void main(String[] args) {
        Room hall = new Room("Hall:", "A large hall with stone walls.");
        Room kitchen = new Room("Kitchen:", "A small kitchen with a wooden table.");

        hall.addExit("north", kitchen);
        kitchen.addExit("south", hall);

        Item sword = new Item("Sword", "a sharp blade");
        Item elixir = new Item("Elixir", "a strange drink");
        hall.addItem(sword);
        kitchen.addItem(elixir);


        NPC stranger = new NPC("Stranger", "a wise-looking elder", "A traveler! Beware of the monsters ahead!");
        hall.addNpc(stranger);


        Player adventurer = new Player("Adventurer", "A brave young man.", 100, hall);

        MUDController mudController = new MUDController(adventurer);
        mudController.runGameLoop();
    }
}