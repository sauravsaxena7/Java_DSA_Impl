package com.stack.utils;

public class Stack<T> {

    private int top;

    public Stack(int top) {
        this.top = top;
    }

    public T pop(T[] t) throws Exception {
        if(this.top==-1) throw new Exception("Stack is Empty");
        T tops = t[this.top];
        t[this.top--]=null;
        return tops;
    }

    public void push(T[] t, T item, int size ) throws Exception {
        if (this.top>=size) throw new Exception("Stack Over Flow");
        t[++this.top]=item;
    }

    public int getTop(){
        return this.top;
    }
}
