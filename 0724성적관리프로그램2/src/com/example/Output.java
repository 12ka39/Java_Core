package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Output {
    private Connection connection;
    private List<StudentVO> list;

    public Output(List<StudentVO> list) {
        this.list = list;
        DBConnection dbconn = new DBConnection();
        this.connection = dbconn.getConnection();

    }

    void output() {
        Statement stmt = null;
        for (StudentVO std : list) {
            try {
                stmt = connection.createStatement();
                String sql = "INSERT INTO Student ";
                sql += "VALUES ('" + std.getHakbun() + "','" + std.getName() + "',";
                sql += std.getKor() + "," + std.getEng() + ",";
                sql += std.getMat() + "," + std.getEdp() + ",";
                sql += std.getTot() + "," + std.getAvg() + ",'" + std.getGrade() + "');";
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        DBClose.dbClose(this.connection, stmt);
        System.out.println("DB Inserted Successfully");
    }
}