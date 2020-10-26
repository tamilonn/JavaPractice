package com.javapub.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class ObservableTest {

    public static void main (String args[]) throws Exception {

        System.out.println("Start ObservableTest");
        NewsProducer producer = new NewsProducer();
        FacebookObserver fo = new FacebookObserver();
        producer.addObserver(fo);

        TwitterObserver to = new TwitterObserver();
        producer.addObserver(to);

        producer.feedNews(5);

        System.out.println("End ObservableTest");

    }

    /**
     * Observable class
     */
    static class NewsProducer extends Observable {

        String message = "NewsProducer";
        String[] news = {"Tamil News", "English News", "Spanish News", "French News"};


        /**
         * FeedNews method to notify observers with language of news feed.
         * @param count
         * @throws Exception
         */
        public void feedNews(int count) throws Exception {
            int newsCount = news.length;
            for(int i=0; i<count; i++){
                setMessage(news[new Random().nextInt(newsCount)]);
                setChanged();
                Thread.sleep(1000);
                //notify all observers in the available Observable
                notifyObservers(getMessage());
                System.out.println("----------------------");
            }
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }


    }

    //Observer1
    static class FacebookObserver implements Observer {
        /**
         * This method is called whenever the observed object is changed. An
         * application calls an <tt>Observable</tt> object's
         * <code>notifyObservers</code> method to have all the object's
         * observers notified of the change.
         *
         * @param o   the observable object.
         * @param arg an argument passed to the <code>notifyObservers</code>
         */
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("FacebookObserver update()" + o.toString());
            System.out.println(arg.toString());
        }
    }

    //Observer2
    static class TwitterObserver implements Observer {
        /**
         * This method is called whenever the observed object is changed. An
         * application calls an <tt>Observable</tt> object's
         * <code>notifyObservers</code> method to have all the object's
         * observers notified of the change.
         *
         * @param o   the observable object.
         * @param arg an argument passed to the <code>notifyObservers</code>
         */
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("TwitterObserver update() invoked..." + o.toString());
            System.out.println(arg.toString());
        }
    }


}