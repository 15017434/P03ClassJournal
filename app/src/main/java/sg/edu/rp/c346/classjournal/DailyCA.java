package sg.edu.rp.c346.classjournal;

import java.io.Serializable;

/**
 * Created by 15056158 on 2/5/2017.
 */

public class DailyCA implements Serializable {
    private int week;
    private String dgGrade;


    public DailyCA(int week, String dgGrade){

        this.week = week;
        this.dgGrade = dgGrade;




    }

    public int getWeek() {
        return week;}


    public String getGrade() {
        return dgGrade;}



}
