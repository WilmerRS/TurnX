package org.turnx.cmpts;

import org.turnx.utils.PresetBorders;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ComponentX extends ComponentProperties implements MouseListener {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color c;
        if (this.isHover) {
            c = this.getBackgroundHover();
        } else {
            c = this.getBackgroundX();
        }
        this.verifyCorners(Math.min(this.getWidth(), this.getHeight()));
        this.borders.drawRoundRect(graphics, c, this.borderColor, this.getWidth(), this.getHeight(), this.border);
        //drawRoundRect(graphics, c, Color.BLACK, 7);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        this.isHover = !this.isHover;
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        this.isHover = !this.isHover;
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        this.isHover = true;
        this.setCursor(new Cursor(12));
        super.repaint();
        this.isHover = true;
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        this.isHover = false;
        super.repaint();
    }

    /*
    private void drawRoundRect(Graphics g, Color fillColor, Color borderColor, int cornerMask) {
        int radius = this.borderRadius;
        int width = this.getWidth();
        int height = this.getHeight();

        radius += radius % 2; // so we don't have to deal with rounding issues for odd numbers
        width--;
        height--;
        if (radius > width / 2 && radius > height / 2) {
            radius = width / 2;
        }
        if (fillColor != null) {
            g.setColor(fillColor);
            if (this.borders.getCornerTopLeft() > 0) {
                g.fillArc(0, 0,
                        this.borders.getCornerTopLeft() * 2,
                        this.borders.getCornerTopLeft() * 2, 90, 90);
            } else {
                g.fillRect(0, 0,
                        this.borders.getCornerTopLeft(),
                        this.borders.getCornerTopLeft() * 2);
            }
            if (this.borders.getCornerTopRight() > 0) {
                g.fillArc(width - this.borders.getCornerTopRight() * 2,
                        0,
                        this.borders.getCornerTopRight() * 2,
                        this.borders.getCornerTopRight() * 2, 0, 90);
            } else {
                g.fillRect(width - this.borders.getCornerTopRight(),
                        0,
                        this.borders.getCornerTopRight(),
                        this.borders.getCornerTopRight());
            }
            if (this.borders.getCornerBottomRight() > 0) {
                g.fillArc(width - this.borders.getCornerBottomRight() * 2,
                        height - this.borders.getCornerBottomRight() * 2,
                        this.borders.getCornerBottomRight() * 2,
                        this.borders.getCornerBottomRight() * 2, 270, 90);
            } else {
                g.fillRect(width - this.borders.getCornerBottomRight(),
                        height - this.borders.getCornerBottomRight(),
                        this.borders.getCornerBottomRight(),
                        this.borders.getCornerBottomRight());
            }
            if (this.borders.getCornerBottomLeft() > 0) {
                g.fillArc(0, height - this.borders.getCornerBottomLeft() * 2,
                        this.borders.getCornerBottomLeft() * 2,
                        this.borders.getCornerBottomLeft() * 2, 180, 90);
            } else {
                g.fillRect(0, height - this.borders.getCornerBottomLeft(),
                        this.borders.getCornerBottomLeft(),
                        this.borders.getCornerBottomLeft());
            }

            g.fillRect(this.borders.getCornerTopLeft(),
                    0,
                    width - this.borders.getCornerTopRight() - this.borders.getCornerTopLeft(),
                    this.borders.getCornerTopLeft());

            g.fillRect(width - this.borders.getCornerTopRight(),
                    this.borders.getCornerTopRight(),
                    this.borders.getCornerTopRight(),
                    height - this.borders.getCornerTopRight() - this.borders.getCornerBottomRight());

            g.fillRect(this.borders.getCornerBottomLeft(),
                    height - this.borders.getCornerBottomRight(),
                    width - this.borders.getCornerBottomRight() - this.borders.getCornerBottomLeft(),
                    this.borders.getCornerBottomRight());

            g.fillRect(0,
                    this.borders.getCornerTopLeft(),
                    this.borders.getCornerBottomLeft(),
                    height - this.borders.getCornerTopLeft() - this.borders.getCornerBottomLeft());

            g.fillRect(this.borders.getCornerBottomLeft(),
                    this.borders.getCornerTopLeft(),
                    width - this.borders.getCornerBottomLeft() - this.borders.getCornerTopRight(),
                    height - this.borders.getCornerTopLeft() - this.borders.getCornerBottomRight());

        }
        if (borderColor != null && !borderColor.equals(fillColor)) {
            paintBorderRadius((Graphics2D) g, borderColor, width, height, cornerMask);
        }

    }

    private void paintBorderRadius(Graphics2D g, Color borderColor, int width, int height, int cornerMask) {
        width--;
        height--;
        g.setColor(borderColor);
        g.setStroke(new BasicStroke((int) (this.border / 1.1)));

        // XXX: there are problems with this when using semi-transparent colors + borderSize > 1
        // XXX: this could be changed to to use ONE draw action using drawShape with GeneralPath.curveTo()
        // XXX: this then could also be used to FILL the shape (see above)
        if (this.borders.getCornerTopLeft() > 0) {
            g.drawArc(0, 0, this.borders.getCornerTopLeft() * 2, this.borders.getCornerTopLeft() * 2, 90, 90);
        } else {
            g.drawLine(0, 0, this.borders.getCornerTopLeft(), 0);
            g.drawLine(0, 0, 0, this.borders.getCornerTopLeft());
        }
        if (this.borders.getCornerTopRight() > 0) {
            g.drawArc(width - this.borders.getCornerTopRight() * 2, 0,
                    this.borders.getCornerTopRight() * 2,
                    this.borders.getCornerTopRight() * 2,
                    0,
                    90);
        } else {
            g.drawLine(width - this.borders.getCornerTopRight(), 0, width, 0);
            g.drawLine(width, 0, width, this.borders.getCornerTopRight());
        }
        if (this.borders.getCornerBottomRight() > 0) {
            g.drawArc(width - this.borders.getCornerBottomRight() * 2,
                    height - this.borders.getCornerBottomRight() * 2,
                    this.borders.getCornerBottomRight() * 2,
                    this.borders.getCornerBottomRight() * 2, 270, 80);
        } else {
            g.drawLine(width - this.borders.getCornerBottomRight(),
                    height, width, height);
            g.drawLine(width,
                    height - this.borders.getCornerBottomRight(),
                    width, height);
        }
        if (this.borders.getCornerBottomLeft() > 0) {
            g.drawArc(0, height - this.borders.getCornerBottomLeft() * 2,
                    this.borders.getCornerBottomLeft() * 2,
                    this.borders.getCornerBottomLeft() * 2, 180, 90);
        } else {
            g.drawLine(0, height,
                    this.borders.getCornerBottomLeft() * 2, height);
            g.drawLine(0,
                    height - this.borders.getCornerBottomLeft() * 2, 0, height);
        }

        g.setStroke(new BasicStroke(this.border));
        g.drawLine(this.borders.getCornerTopLeft(),
                0,
                width - this.borders.getCornerTopRight(), 0); // top
        g.drawLine(width,
                this.borders.getCornerTopRight(),
                width,
                height - this.borders.getCornerBottomRight()); // right
        g.drawLine(this.borders.getCornerBottomLeft(),
                height,
                width - this.borders.getCornerBottomRight(),
                height); // bottom
        g.drawLine(0,
                this.borders.getCornerTopLeft(),
                0,
                height - this.borders.getCornerBottomLeft()); // left
    }
*/
}
