package services;

public interface UserDAO {

    void create(Client client);

    List<client> readAll();

    Client read(int id);

    boolean update(Client client, int id);

    boolean delete(int id);
}
