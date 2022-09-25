package Week8To11.ChatClient.only;

public interface UserStatusListener {
    public void online(String login);
    public void offline(String login);
}
