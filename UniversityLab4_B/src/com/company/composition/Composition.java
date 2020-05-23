package com.company.composition;

public class Composition {
    private String name;
    private String performer;
    private short length;
    private CompositionStyle style;

    public Composition(String name, String performer, short length, CompositionStyle style) {
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

    public CompositionStyle getStyle() { return style; }
    public void setStyle(CompositionStyle style) { this.style = style; }

    @Override
    public String toString() {
        return name + " by " +
                performer + "; " +
                "Length = " + length/60 + ":" + length%60 +
                ", Style = " + style.toString();
    }
}
