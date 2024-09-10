import java.util.*;

public class Lab1 {
    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager();

        // 添加3名员工：A、B 和 C
        manager.addEmployee("A", 30);
        manager.addEmployee("B", 25);
        manager.addEmployee("C", 40);

        // 删除员工 B
        manager.deleteEmployee("B");

        // 再添加2名员工：A，D
        manager.addEmployee("A", 30); // 添加一个新的姓名为"A"的员工
        manager.addEmployee("D", 28);

        // 打印所有员工，应该是 A、C、D
        System.out.println("员工列表:");
        manager.printEmployees();
    }
}
class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名: " + name + ", 年龄: " + age;
    }
}
class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    // 添加一个新员工
    public void addEmployee(String name, int age) {
        for (Employee a:employees){
            if (Objects.equals(a.name, name)){//already here
                return;
            }
        }
        employees.add(new Employee(name, age));
    }

    // 删除一个员工，按姓名删除
    public void deleteEmployee(String name) {
        employees.removeIf(employee -> employee.name.equals(name));
    }

    // 按姓名排序并打印所有员工
    public void printEmployees() {
        // 按姓名排序
        employees.sort(Comparator.comparing(employee -> employee.name));
        // 打印员工信息
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
}
