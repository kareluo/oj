package problems.p690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null) return 0;
        Map<Integer, Employee> es = new HashMap<>();
        for (Employee employee : employees) {
            es.put(employee.id, employee);
        }
        return importance(es, id);
    }

    private int importance(Map<Integer, Employee> es, int id) {
        Employee employee = es.get(id);
        int importance = employee.importance;
        if (employee.subordinates != null) {
            for (Integer i : employee.subordinates) {
                importance += importance(es, i);
            }
        }
        return importance;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}