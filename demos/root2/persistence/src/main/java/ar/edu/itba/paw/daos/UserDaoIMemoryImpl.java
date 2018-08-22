package ar.edu.itba.paw.daos;


import ar.edu.itba.paw.interfaces.UserDao;
import ar.edu.itba.paw.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserDaoIMemoryImpl implements UserDao {

  private Map<String, User> users = new ConcurrentHashMap<String, User>();

  public UserDaoIMemoryImpl() {
    User user = new User();
    user.setId("1");
    user.setName("Leo");
    user.setPassword("1234");
    users.put("1", user);
    User user2 = new User();
    user2.setId("2");
    user2.setName("Alvaro");
    user2.setPassword("12345");
    users.put("2", user2);
    User user3 = new User();
    user3.setId("3");
    user3.setName("<script>console.alert(\"ROTO\")</script>");
    user3.setPassword("12345");
    users.put("2", user2);
  }

  public User get(String id) {
    return users.get(id);
  }

  public List<User> list() {
    return new ArrayList<User>(this.users.values());
  }

  public User save(User user){
    return this.users.put(user.getId(), user);
  };

}
