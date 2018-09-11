package studio.bz_soft.currencyrates.net;

/**
 * Created by Black_Zerg on 27.01.2018.
 */

public class RequestData {

    private String url;
    private String data;
    private String method;
    private String command;

    public RequestData(String url, String data, String method, String command) {
        this.url = url;
        this.data = data;
        this.method = method;
        this.command = command;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
