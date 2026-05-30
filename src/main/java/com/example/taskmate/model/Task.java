package com.example.taskmate.model;

import java.sql.Date;

public class Task {

    private int id;
    private String text;
    private Date deadline;

    public Task(){

    }

    public Task(String text, Date deadline){
        this.text = text;
        this.deadline = deadline;
    }

    public Task(int id, String text, Date deadline){
        this.id = id;
        this.text = text;
        this.deadline = deadline;
    }

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public String getText(){return this.text;}
    public void setText(String text){this.text = text;}

    public Date getDeadline(){return this.deadline;}
    public void setDeadline(Date deadline){this.deadline = deadline;}
}

