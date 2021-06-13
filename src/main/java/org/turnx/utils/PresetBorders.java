package org.turnx.utils;

import org.turnx.cmpts.ComponentProperties;

import java.awt.*;

public class PresetBorders {

    private int cornerBottomLeft = 10;
    private int cornerBottomRight = 10;
    private int cornerTopLeft = 10;
    private int cornerTopRight = 10;

    public int getCornerBottomLeft() {
        return cornerBottomLeft;
    }

    public void verifyCorners(int reference){
        cornerTopLeft = getCornerAllow(cornerTopLeft,reference);
        cornerTopRight = getCornerAllow(cornerTopRight,reference);
        cornerBottomLeft = getCornerAllow(cornerBottomLeft,reference);
        cornerBottomRight = getCornerAllow(cornerBottomRight,reference);
    }

    public void setCornerBottomLeft(int cornerBottomLeft) {
        this.cornerBottomLeft = cornerBottomLeft;
    }

    public int getCornerBottomRight() {
        return cornerBottomRight;
    }

    public void setCornerBottomRight(int cornerBottomRight) {
        this.cornerBottomRight = cornerBottomRight;
    }

    public int getCornerTopLeft() {
        return cornerTopLeft;
    }

    public void setCornerTopLeft(int cornerTopLeft) {
        this.cornerTopLeft = cornerTopLeft;
    }

    public int getCornerTopRight() {
        return cornerTopRight;
    }

    public void setCornerTopRight(int cornerTopRight) {
        this.cornerTopRight = cornerTopRight;
    }

    public void drawRoundRect(Graphics2D g, Color fillColor, Color borderColor, int width, int height, int stroke) {
        width--;
        height--;
        int delta = (int)(stroke/2);
        if (fillColor != null) {
            g.setColor(fillColor);
            if (this.cornerTopLeft > 0) {
                /*g.fillArc(delta, delta,
                        this.cornerTopLeft * 2,
                        this.cornerTopLeft * 2, 90, 90);*/
                paintArc(g,
                        0,
                        0,
                        this.cornerTopLeft * 2,
                        this.cornerTopLeft * 2,
                        90,
                        90,
                        this.cornerTopLeft * 2,
                        Color.RED);
            } else {
                g.fillRect(0, 0,
                        this.cornerTopLeft,
                        this.cornerTopLeft * 2);
            }
            if (this.cornerTopRight > 0) {
                /*g.fillArc(width - this.cornerTopRight * 2-delta,
                        delta,
                        this.cornerTopRight * 2,
                        this.cornerTopRight * 2, 0, 90);*/
                paintArc(g,
                        width - this.cornerTopRight * 2,
                        0,
                        this.cornerTopRight * 2,
                        this.cornerTopRight * 2,
                        0,
                        90,
                        this.cornerTopRight * 2,
                        Color.RED);
            } else {
                g.fillRect(width - this.cornerTopRight,
                        0,
                        this.cornerTopRight,
                        this.cornerTopRight);
            }
            if (this.cornerBottomRight > 0) {
                /*g.fillArc(width - this.cornerBottomRight * 2-delta,
                        height - this.cornerBottomRight * 2-delta,
                        this.cornerBottomRight * 2,
                        this.cornerBottomRight * 2, 270, 90);*/
                paintArc(g,
                        width - this.cornerBottomRight * 2,
                        height - this.cornerBottomRight * 2,
                        this.cornerBottomRight * 2,
                        this.cornerBottomRight * 2,
                        270,
                        90,
                        this.cornerBottomRight * 2,
                        Color.RED);
            } else {
                g.fillRect(width - this.cornerBottomRight,
                        height - this.cornerBottomRight,
                        this.cornerBottomRight,
                        this.cornerBottomRight);
            }
            if (this.cornerBottomLeft > 0) {
                /*g.fillArc(0, height - this.cornerBottomLeft * 2-delta,
                        this.cornerBottomLeft * 2,
                        this.cornerBottomLeft * 2, 180, 90);*/
                paintArc(g,
                        0,
                        height - this.cornerBottomLeft * 2,
                        this.cornerBottomRight * 2,
                        this.cornerBottomRight * 2,
                        180,
                        90,
                        this.cornerBottomRight * 2,
                        Color.RED);
            } else {
                g.fillRect(0, height - this.cornerBottomLeft,
                        this.cornerBottomLeft,
                        this.cornerBottomLeft);
            }

            g.fillRect(this.cornerTopLeft,
                    0,
                    width - this.cornerTopRight - this.cornerTopLeft,
                    this.cornerTopLeft);

            g.fillRect(width - this.cornerTopRight,
                    this.cornerTopRight,
                    this.cornerTopRight,
                    height - this.cornerTopRight - this.cornerBottomRight);

            g.fillRect(this.cornerBottomLeft,
                    height - this.cornerBottomRight,
                    width - this.cornerBottomRight - this.cornerBottomLeft,
                    this.cornerBottomRight);

            g.fillRect(0,
                    this.cornerTopLeft,
                    this.cornerBottomLeft,
                    height - this.cornerTopLeft - this.cornerBottomLeft);

            g.fillRect(this.cornerBottomLeft,
                    this.cornerTopLeft,
                    width - this.cornerBottomLeft - this.cornerTopRight,
                    height - this.cornerTopLeft - this.cornerBottomRight);

        }
        if (borderColor != null && !borderColor.equals(fillColor)) {
            paintBorderRadius((Graphics2D) g, borderColor, width, height, stroke);
        }

    }

    private void paintBorderRadius(Graphics2D g, Color borderColor, int width, int height, int stroke) {
        //width--;
        //height--;
        g.setColor(borderColor);
        g.setStroke(new BasicStroke(stroke));
        int delta = (int) (stroke / 2);

        // XXX: there are problems with this when using semi-transparent colors + borderSize > 1
        // XXX: this could be changed to to use ONE draw action using drawShape with GeneralPath.curveTo()
        // XXX: this then could also be used to FILL the shape (see above)
        if (this.cornerTopLeft > 0) {
            /*g.drawArc(0+delta, 0+delta,
                    this.cornerTopLeft * 2,
                    this.cornerTopLeft * 2, 90, 90);*/
            paintArc(g,
                    0,
                    0,
                    this.cornerTopLeft * 2,
                    this.cornerTopLeft * 2,
                    90,
                    90,
                    stroke,
                    Color.BLUE);
        } // top left
        if (this.cornerTopRight > 0) {
            /*g.drawArc(width - this.cornerTopRight * 2, 0+delta,
                    this.cornerTopRight * 2-delta,
                    this.cornerTopRight * 2,
                    0,
                    90);*/
            paintArc(g,
                    width - this.cornerTopRight * 2,
                    0,
                    this.cornerTopRight * 2,
                    this.cornerTopRight * 2,
                    0,
                    90,
                    stroke,
                    Color.BLUE);
        } //top right
        if (this.cornerBottomRight > 0) {
            /*g.drawArc(width - this.cornerBottomRight * 2 - delta,
                    height - this.cornerBottomRight * 2 - delta,
                    this.cornerBottomRight * 2,
                    this.cornerBottomRight * 2, 270, 90);*/
            paintArc(g,
                    width - this.cornerBottomRight * 2,
                    height - this.cornerBottomRight * 2,
                    this.cornerBottomRight * 2,
                    this.cornerBottomRight * 2,
                    270,
                    90,
                    stroke,
                    Color.BLUE);
        } // bottom right
        if (this.cornerBottomLeft > 0) {
            /*g.drawArc(0+delta, height - this.cornerBottomLeft * 2 - delta,
                    this.cornerBottomLeft * 2,
                    this.cornerBottomLeft * 2, 180, 90);*/
            paintArc(g,
                    0,
                    height - this.cornerBottomLeft * 2,
                    this.cornerBottomLeft * 2,
                    this.cornerBottomLeft * 2,
                    180,
                    90,
                    stroke,
                    Color.BLUE);
        }

        /*g.drawLine(this.cornerTopLeft,
                0,
                width - this.cornerTopRight, 0);// top*/
        paintLine(g,
                this.cornerTopLeft + delta,
                0,
                width - this.cornerTopRight - delta, 0, stroke, Color.BLUE);
        /*
        g.drawLine(width,
                this.cornerTopRight + delta,
                width,
                height - this.cornerBottomRight - delta); // right
                */
        paintLine(g,
                width-3,
                75,
                width-3,
                height-this.cornerBottomRight, stroke-10, Color.RED);
        g.drawLine(this.cornerBottomLeft,
                height,
                width - this.cornerBottomRight,
                height); // bottom
        g.drawLine(0,
                this.cornerTopLeft,
                0,
                height - this.cornerBottomLeft); // left

        //paintArc(g, 0, 0, radius, radius, 0, 90, stroke, Color.BLUE);
        //paintArc(g, 0, 0, radius, radius, 90, 90, stroke, Color.BLUE);
        //paintArc(g, 0, 0, radius, radius, 180, 90, stroke, Color.BLUE);
        //paintArc(g, 0, 0, radius, radius, 270, 90, stroke, Color.BLUE);

    }

    private void paintArc(Graphics2D g, int x, int y, int width, int height, int start, int length, int stroke, Color color) {
        g.setStroke(new BasicStroke((stroke == 1) ? 1 : 2));
        g.setColor(color);
        //width += width % 2;
        //height += height % 2;

        if (stroke > 1) {
            stroke /= 2;
        }

        int minRadius = Math.min(width, height);
        if (stroke > minRadius) {
            stroke = minRadius;
        }

        int xx = x ;
        int yy = y ;
        int countStroke = 0;
        while (countStroke < stroke) {
            g.drawArc(xx, yy, width - (countStroke * 2), height - (countStroke * 2), start, length);
            countStroke++;
            xx++;
            yy++;
        }
    }

    private void paintLine(Graphics2D g, int xInitial, int yInitial, int xFinal, int yFinal, int stroke, Color color){
        g.setStroke(new BasicStroke((stroke == 1) ? 1 : stroke + stroke%2));
        g.setColor(color);
        g.drawLine(xInitial, yInitial , xFinal, yFinal);
    }

    public int getCornerAllow(int current, int reference){
        if(current > reference/2){
            return reference/2;
        }
        return current;
    }

}
