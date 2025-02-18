public class NPC {
    private String name;
    private String description;
    private String dialogue;

    public NPC(String name, String description, String dialogue){
        this.name = name;
        this.description = description;
        this.dialogue = dialogue;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String talk(){
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }
}
