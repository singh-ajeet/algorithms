package org.ajeet.learnings.algorithms.ds.tree;

public final class Tuple<T1, T2> {
    public final T1 _1;
    public final  T2 _2;

    public Tuple(T1 key, T2 _2) {
        this._1 = key;
        this._2 = _2;
    }

    public static <T1, T2> Tuple<T1, T2> pair(T1 key, T2 data){
        return new Tuple<>(key, data);
    }

    @Override
    public String toString() {
        return "Tuple [" + _1 + "," + _2 + ']';
    }
}
