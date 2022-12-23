package sockets.server;

public interface IServer
{
    //TODO
    // Modify these methods to update view and call controller methods
    String getUniqueUsername(String username);
    void addUser(String username, UserThread thread);
    void removeUser(String username, UserThread thread);
    void broadcast(String message);
}
