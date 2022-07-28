package com.getdream.demo.d20220521;

public class Main {
    public static void main(String[] args) {
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        System.out.println(
                "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)".equals(insert) ? "测试成功" : "测试失败");
    }

    static String buildInsertSql(String table, String[] fields) {
        // TODO:
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(table).append(" (");
        sb.append(String.join(", ", fields));
        sb.append(") VALUES (?, ?, ?)");


        return sb.toString();
    }
}
