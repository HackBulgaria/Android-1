package com.example.georgi.sqliteexample;

/**
 * Created by georgi on 12/3/14.
 */
public class FluentApiBuilder {
    public FluentApiBuilder(){

            String string = new FluentApiBuilder().selectFrom("users").where("username").eq("213").build();
    }
    
    public FluentApiBuilder selectFrom(String tableName){
        this.tableName = tableName;
        return this;
    }


}
