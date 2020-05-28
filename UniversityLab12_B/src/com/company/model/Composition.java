package com.company.model;

public class Composition {
    private long ID;
    private String name;
    private String performer;
    private short length;
    private String style;

    public Composition(long id, String name, String performer, short length, String style) {
        this.ID = id;
        this.name = name;
        this.performer = performer;
        this.length = length;
        this.style = style;
    }

    public Composition(String name, String performer, short length, String style) {
        this.name = name;
        this.performer = performer;
        this.length = length;
        this.style = style;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPerformer() { return performer; }
    public void setPerformer(String performer) { this.performer = performer; }

    public short getLength() { return length; }
    public void setLength(short length) { this.length = length; }

    public String getStyle() { return style; }
    public void setStyle(String style) { this.style = style; }

    public long getID() { return ID; }

    @Override
    public String toString() {
        return ID + ". " + name + " by " +
                performer + "; " +
                "Length = " + length/60 + ":" + length%60 +
                ", Style = " + style.toString();
    }
}
