package kg.sklad.models;

public class MyError {
    private int statusCode;
    private String messsage;

    public MyError(int statusCode, String messsage) {
        this.statusCode = statusCode;
        this.messsage = messsage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
}
