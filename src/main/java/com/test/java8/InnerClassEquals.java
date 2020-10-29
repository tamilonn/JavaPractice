package com.test.java8;

import java.util.Objects;

public class InnerClassEquals {

    String origin;
    String label;

    public class AnotherClass extends InnerClassEquals {
        String data;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof AnotherClass)) return false;
            AnotherClass that = (AnotherClass) o;
            return (origin.equals(that.origin) && label.equals(that.label) &&
             Objects.equals(getData(), that.getData()));
        }

        @Override
        public int hashCode() {

            return Objects.hash(getData());
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
