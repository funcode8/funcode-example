package com.funcode.example.chapter11.controller;

import ch.qos.logback.classic.db.DBAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @Author 萌新程序员成长日记
 */
public class MyDBAppender extends DBAppender {

    @Override
    protected void subAppend(ILoggingEvent event, Connection connection, PreparedStatement insertStatement) throws Throwable {
        //绑定参数
        bindArguements(event, insertStatement);

        int updateCount = insertStatement.executeUpdate();
        if (updateCount != 1) {
            addWarn("Failed to insert loggingEvent");
        }
    }

    @Override
    protected String getInsertSQL() {
        return "INSERT INTO table(col1, col2, col3, col4, col5, col6, " +
                "col7, col8, col9) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    private void bindArguements(ILoggingEvent event, PreparedStatement insertStatement) throws SQLException {
        Object[] args = event.getArgumentArray();
        insertStatement.setString(1, event.getLevel().toString());
        insertStatement.setTimestamp(2, new Timestamp(event.getTimeStamp()));
        insertStatement.setString(3,args[0].toString());
        insertStatement.setString(4,args[1].toString());
        insertStatement.setString(5, new String(args[2].toString().getBytes(), StandardCharsets.UTF_8));
        insertStatement.setString(6,args[3].toString());
        insertStatement.setString(7,event.getMessage());
        insertStatement.setString(8,args[4].toString());
        insertStatement.setString(9,args[5].toString());
    }

}

