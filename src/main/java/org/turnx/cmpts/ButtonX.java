package org.turnx.cmpts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonX extends ComponentX {

    // es necesario que extienda de una clase las propiedades generales
    // asi mismo se necesita que implemente

    public JLabel textX = new JLabel("Button");

    public ButtonX() {
        super.addMouseListener(this);
        super.add(textX);
        this.setBackgroundX(DEFAULT_BACGROUND_BUTTON);
        this.setBackgroundHover(DEFAULT_BACGROUND_BUTTON_HOVER);
        System.out.println(this.textX.getText());
    }

    public void setTextAling(int position) {

    }

    public void getTextAling() {

    }

}
