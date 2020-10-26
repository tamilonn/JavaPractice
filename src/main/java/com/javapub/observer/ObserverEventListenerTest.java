package com.javapub.observer;

import javax.swing.event.EventListenerList;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EventListener;

/**
 * This example demonstrates EventListenerList to handle 2 types of EventListener events in
 * single place from the EventManager.
 */
public class ObserverEventListenerTest {

    public static void main (String args[]) throws Exception {

        System.out.println("Start ObserverEventListenerTest");

        //create EventManager
        EventManager eventManager = new EventManager();

        //create and fire event for CustomerBeanProperty
        eventManager.addCustomerBeanProperty(new CustomerBeanProperty());
        eventManager.customerBeanPropertyChanged("Tamilselvan");
        Thread.sleep(1000);
        eventManager.customerBeanPropertyChanged("Tarun");

        System.out.println("--------------------");
        //create and fire event for MyListenerImpl
        eventManager.addMyListener(new MyListenerImpl());
        eventManager.fireMyListenerEvent("Server started");
        Thread.sleep(1000);
        eventManager.fireMyListenerEvent("Server stopped");

        System.out.println("End ObserverEventListenerTest");

    }


    static class EventManager {

        EventListenerList eventListenerList = new EventListenerList();

        //generic register listeners
        private void register(Class c, EventListener listener){
            eventListenerList.add(c, listener);
        }

        //I.Listener type 1
        public void addCustomerBeanProperty(CustomerBeanProperty listener){
            register(listener.getClass(), listener);
        }



        //2. Fire Listener type 1 event
        protected void customerBeanPropertyChanged(String newValue) {
            // Guaranteed to return a non-null array
            Object[] listeners = eventListenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event


            for (int i = listeners.length-2; i>=0; i-=2) {
                if (listeners[i]==CustomerBeanProperty.class) {

                    CustomerBeanProperty tmpListener = (CustomerBeanProperty) listeners[i+1];
                    PropertyChangeEvent event = new PropertyChangeEvent(this, "customerName", tmpListener.getCustomerName(),newValue);
                    tmpListener.setCustomerName(newValue);
                    ((PropertyChangeListener)listeners[i+1]).propertyChange(event);
                }
            }
        }


        //II.Listener type 2
        public void addMyListener(MyListenerImpl listener){
            register(listener.getClass(), listener);
        }



        //2. Fire Listener type 2 event
        protected void fireMyListenerEvent(String newValue) {
            // Guaranteed to return a non-null array
            Object[] listeners = eventListenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event


            for (int i = listeners.length-2; i>=0; i-=2) {
                if (listeners[i]==MyListenerImpl.class) {

                    MyListenerImpl tmpListener = (MyListenerImpl) listeners[i+1];
                    tmpListener.onEvent(newValue);
                }
            }
        }




    }

    static class CustomerBeanProperty implements PropertyChangeListener {

        private String customerName = "";


        /**
         * This method gets called when a bound property is changed.
         *
         * @param evt A PropertyChangeEvent object describing the event source
         *            and the property that has changed.
         */
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            System.out.println("CustomerBeanProperty propertyChange() invoked..");

            System.out.println( "Old value = "+ evt.getOldValue() + " New value = "+ evt.getNewValue());

        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }
    }

    //2nd Event Listener
    static interface MyListener extends EventListener {

        void onEvent(String event);
    }

    static class MyListenerImpl implements MyListener {

        @Override
        public void onEvent(String event) {
            System.out.println("MyListenerImpl::onEvent() called");
            System.out.println("Event is "+ event);
        }
    }





}
