package com.argo.notificaciones_service.notificaciones.application.dto;

import java.util.Map;

public class mensajesss {


    private Map<String,Object> notification;

    private String priority;

    private Map<String,Object> data;

    private String to;

    public Map<String, Object> getNotification() {
        return notification;
    }

    public void setNotification(Map<String, Object> notification) {
        this.notification = notification;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "mensajesss{" +
                "notification=" + notification +
                ", priority='" + priority + '\'' +
                ", data=" + data +
                ", to='" + to + '\'' +
                '}';
    }
}
