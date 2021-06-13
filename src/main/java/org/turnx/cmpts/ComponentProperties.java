package org.turnx.cmpts;

import org.turnx.interfaces.ColorConstans;
import org.turnx.interfaces.DimensionDefault;
import org.turnx.utils.PresetBorders;

import javax.swing.*;
import java.awt.*;

public abstract class ComponentProperties extends JComponent implements DimensionDefault, ColorConstans {

    public int border = DEFAULT_BORDER;
    public Color borderColor = new Color(33,33,33);
    public int borderRadius = 20;
    public Color background = DEFAULT_BACGROUND;
    public int padding;
    private int color;
    public boolean isHover = false;
    private Color backgroundHover = DEFAULT_BACGROUND_HOVER;
    public PresetBorders borders = new PresetBorders();

    // width
    // height
    public int width;
    public int height;

    public int getBorderX() {
        return border;
    }

    public void setBorderX(int border) {
        this.border = border;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadiusX(int borderRadius) {
        this.borderRadius = borderRadius;
        int reference = Math.min(this.getWidth(),this.getHeight());
        this.borders.setCornerTopLeft(borderRadius);
        this.borders.setCornerTopRight(borderRadius);
        this.borders.setCornerBottomLeft(borderRadius);
        this.borders.setCornerBottomRight(borderRadius);
    }

    public void setBorderRadiusX(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        this.borders.setCornerTopLeft(topLeft);
        this.borders.setCornerTopRight(topRight);
        this.borders.setCornerBottomLeft(bottomRight);
        this.borders.setCornerBottomRight(bottomLeft);
    }

    public void verifyCorners(int reference){
        this.borders.verifyCorners(reference);
    }

    public Color getBackgroundX() {
        return this.background;
    }

    public void setBackgroundX(Color background) {
        this.background = background;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    public Color getBackgroundHover() {
        return backgroundHover;
    }

    public void setBackgroundHover(Color backgroundHover) {
        this.backgroundHover = backgroundHover;
    }

}
