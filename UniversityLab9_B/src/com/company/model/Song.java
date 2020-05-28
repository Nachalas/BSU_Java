package com.company.model;

import java.io.Serializable;

public class Song implements Serializable {
    private String name;
    private String performer;
    private short length;
    private SongStyle style;

    public Song(String name, String performer, short length, SongStyle style) {
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

    public SongStyle getStyle() { return style; }
    public void setStyle(SongStyle style) { this.style = style; }

    @Override
    public String toString() {
        return name + " by " +
                performer + "; " +
                "Length = " + length/60 + ":" + length%60 +
                ", Style = " + style.toString();
    }
}
