package com.mycompany.newchoise;

/**
 *
 * @author truebondar
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.EventListenerList;

public class MyButtonGroup extends ButtonGroup {
   private ActionListener btnGrpListener = new BtnGrpListener();
   private EventListenerList listenerList = new EventListenerList();

   @Override
   public void add(AbstractButton b) {
      b.addActionListener(btnGrpListener);
      super.add(b);
   }
   
   public void addKeyListener(KeyAdapter ka) {
      listenerList.add(KeyAdapter.class, ka);
   }

   public void addActionListener(ActionListener listener) {
      listenerList.add(ActionListener.class, listener);
   }

   public void removeActionListener(ActionListener listener) {
      listenerList.remove(ActionListener.class, listener);
   }

   protected void fireActionListeners() {
      Object[] listeners = listenerList.getListenerList();
      String actionCommand = "";
      ButtonModel model = getSelection();
      if (model != null) {
         actionCommand = model.getActionCommand();
      }
      ActionEvent ae = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, actionCommand);
      for (int i = listeners.length-2; i>=0; i-=2) {
          if (listeners[i]== ActionListener.class) {
              ((ActionListener)listeners[i+1]).actionPerformed(ae);
          }
      }
   }

   private class BtnGrpListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent ae) {
         fireActionListeners();
      }
   }
}
