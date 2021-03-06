package com.uhasoft.guard.ds.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uhasoft.guard.context.UserCache;
import com.uhasoft.guard.ds.json.constant.JsonConstant;
import com.uhasoft.guard.ds.json.entity.RoleRight;
import com.uhasoft.guard.ds.json.entity.UserRole;
import com.uhasoft.guard.entity.Right;
import com.uhasoft.guard.entity.Role;
import com.uhasoft.guard.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author Weihua
 * @since 1.0.0
 */
public class JsonReader {

  private static final Logger logger = LoggerFactory.getLogger(JsonReader.class);
  private static final Gson gson = new Gson();

  @PostConstruct
  public void init() throws Exception {
    String userJson = readFile(JsonConstant.USER_JSON);
    List<UserRole> userRoles = gson.fromJson(userJson, new TypeToken<List<UserRole>>() {}.getType());
    String roleJson = readFile(JsonConstant.ROLE_JSON);
    List<RoleRight> roleRights = gson.fromJson(roleJson, new TypeToken<List<RoleRight>>() {}.getType());
    String rightJson = readFile(JsonConstant.RIGHT_JSON);
    List<Right> rights = gson.fromJson(rightJson, new TypeToken<List<Right>>() {}.getType());
    Map<String, Right> rightMap = new HashMap<>();
    rights.forEach(p -> rightMap.put(p.getName(), p));
    Map<String, Role> roleMap = new HashMap<>();
    roleRights.forEach(rp -> {
      Role role = new Role();
      role.setName(rp.getName());
      List<Right> rightList = new ArrayList<>(rp.getRights().size());
      rp.getRights().forEach(p -> rightList.add(rightMap.get(p)));
      role.setRights(rightList);
      roleMap.put(role.getName(), role);
    });
    userRoles.forEach(u -> {
      User user = new User();
      user.setName(u.getName());
      List<Role> roles = new ArrayList<>(u.getRoles().size());
      u.getRoles().forEach(r -> roles.add(roleMap.get(r)));
      user.setRoles(roles);
      UserCache.addUser(u.getName(), user);
    });
  }

  public String readFile(String resource) throws Exception{
    ClassLoader classLoader = getClass().getClassLoader();
    URL url = classLoader.getResource(resource);
    if(url == null){
      logger.error("File not found: {}", resource);
      throw new Exception("File not found:" + resource);
    }
    String path = URLDecoder.decode(url.getFile(), "UTF-8");
    File file = new File(path);
    long length = file.length();
    byte[] content = new byte[(int) length];
    try(FileInputStream inputStream = new FileInputStream(file)) {
      int read = inputStream.read(content);
      logger.info("read result: {}", read);
      return new String(content, StandardCharsets.UTF_8);
    } catch (Exception ex){
      logger.error(ex.getMessage(), ex);
      return null;
    }
  }
}
