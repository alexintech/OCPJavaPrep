package dao;

import java.util.*;

class Emp {
  int id;
  String name;
  int age;
  String address;
}

interface EmpDAO {
  public int create(Emp e);
  public Emp get(int id);
  public boolean delete(Emp e);
  public boolean update(Emp e);
  public Collection<Emp> getAll();
}

class EmpDAOImpl implements EmpDAO {
  public int create(Emp e) {
    /* connect to datestore, insert data for employee e */
    return 1;
  }
  public Emp get(int id) {
    /* connect to datastore, retrieve and return data for employee-id id */
    return new Emp();
  }
  public boolean delete(Emp e) {
    /* connect to datastore and delete data for employee-id e.id */
    return true;
  }
  public boolean update(Emp e) {
    /* connect to datastore and update employee data */
    return true;
  }
  public Collection<Emp> getAll() {
    /* connect to datastore, retrieve emp data, return as Collection */
    return new ArrayList<Emp>();
  }
}

public class Client {
  public static void main(String[] args) {
    Emp emp = new Emp();
    emp.id = 10; emp.name = "Harry";
    emp.age = 39; emp.address = "UK";

    EmpDAO dao = new EmpDAOImpl();
    dao.create(emp);
    emp.name = "Harry M"; emp.age = 40;
    dao.update(emp);

    Emp emp2 = dao.get(11);
    if (emp != null) dao.delete(emp2);
  }
}

