package ua.khpi.pinecone.lab2;

import java.util.Arrays;
import java.util.Objects;

public class DirectAccessTable {
    private Engine[] engines;

    /**
     * Puts element to the direct access table.
     *
     * @param engine one element of the table
     * @return true if put is correct, false if putting element have a duplicate key.
     */
    public boolean put(Engine engine) {
        if (Objects.isNull(engines)) {
            engines = new Engine[engine.getCode() + 1];
        }
        if (engines.length < engine.getCode() + 1) {
            engines = Arrays.copyOf(engines, engine.getCode() + 1);
        }
        if (Objects.nonNull(engines[engine.getCode()])) {
            return false;
        } else {
            engines[engine.getCode()] = engine;
            return true;
        }
    }

    /**
     * Returns an element with such key from table or null if no such element in table.
     *
     * @param key of element to search
     * @return needed element
     */
    public Engine search(Integer key) {
        if (engines.length < key || Objects.isNull(engines[key])) {
            return null;
        }
        return engines[key];
    }
}
