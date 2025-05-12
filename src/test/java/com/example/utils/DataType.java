package com.example.utils;

public enum DataType {
    NAME(String.class) {
        @Override
        public Object transform(String text) {
            return text.trim(); // For item names, just trim spaces
        }
        @Override
        @SuppressWarnings("unchecked")
        public <T> T cast(Object value) {
            return (T) value; // Return as String
        }
    },
    PRICE (Double.class) {
        @Override
        public Object transform(String text) {
            return Double.parseDouble(text.replace("$",
                    "").trim()); // Remove $ and parse as Double
        }
        @Override
        @SuppressWarnings("unchecked")
        public <T> T cast(Object value) {
            return (T) value; // Return as Double
        }
    };
// More enums like DATE, RATINGS etc can be added

    private final Class<?> type;

    DataType(Class<?> type) {
        this.type = type;
    }

    public Class<?> getType() {
        return type;
    }

    // Abstract method that will be implemented by each enum constant
    public abstract Object transform(String text);

    public abstract <T> T cast(Object value);
}

