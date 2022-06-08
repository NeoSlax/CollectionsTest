/*
 * Copyright (c) 2022.
 * Третьяков Павел Сергеевич (Tretyakov Pavel)
 */

public interface CarSet {
    boolean add(Car car);

    boolean remove(Car car);

    int size();

    void clear();
}
