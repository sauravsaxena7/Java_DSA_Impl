package com.java_interview_questions;

interface MarkForToString{
    //does not have any methods and fields
}

class Apple implements MarkForToString{
    String color;
    String sweetnessPercent;

    public Apple(String color, String sweetnessPercent) {
        this.color = color;
        this.sweetnessPercent = sweetnessPercent;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", sweetnessPercent='" + sweetnessPercent + '\'' +
                '}';
    }
}

class Orange{
    String color;
    String sweetnessPercent;

    public Orange(String color, String sweetnessPercent) {
        this.color = color;
        this.sweetnessPercent = sweetnessPercent;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "color='" + color + '\'' +
                ", sweetnessPercent='" + sweetnessPercent + '\'' +
                '}';
    }
}

class AuditService{
    public static void audit(Object o){
        if(o  instanceof MarkForToString ){
            System.out.println("Audited::: "+o);
        }else {
            System.out.println("Not Auditable::: "+o);
        }
    }
}

public class MarkerInterfaceExample {
    public static void main(String[] args){
        Apple a = new Apple("red","20%");
        Orange o = new Orange("orange","35%");

        AuditService.audit(a);
        AuditService.audit(o);
    }
}
