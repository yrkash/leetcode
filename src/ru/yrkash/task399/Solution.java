package ru.yrkash.task399;


import ru.yrkash.task133.Node;

import java.util.*;

public class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // Создаем граф, в котором каждая переменная будет ключом, а значением - карта других переменных и их значений
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Заполняем граф
        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());

            // Связь A / B и B / A
            graph.get(A).put(B, val);
            graph.get(B).put(A, 1.0 / val);
        }

        // Массив для хранения результатов запросов
        double[] results = new double[queries.size()];

        // Обрабатываем каждый запрос
        for (int i = 0; i < queries.size(); i++) {
            String C = queries.get(i).get(0);
            String D = queries.get(i).get(1);

            // Проверяем, если обе переменные существуют в графе
            if (!graph.containsKey(C) || !graph.containsKey(D))
                results[i] = -1.0;
            else {
                // Если переменные существуют, пытаемся найти ответ с помощью DFS
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, visited, C, D, 1.0);
            }
        }
        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph,
                       Set<String> visited,
                       String current,
                       String target,
                       double value) {
        // Если текущая переменная равна целевой, возвращаем собранное значение
        if (current.equals(target))
            return value;

        // Помечаем текущую переменную как посещённую
        visited.add(current);

        // Перебираем всех соседей текущей переменной
        for (Map.Entry<String, Double> entry : graph.get(current).entrySet()) {
            String neighbor = entry.getKey();
            double newValue = value * entry.getValue();
            // Если сосед не был посещен, продолжаем DFS
            if (!visited.contains(neighbor)) {
                double result = dfs(graph, visited, neighbor, target, newValue);
                // Если нашли ответ, возвращаем его
                if (result != -1.0)
                    return result;
            }
        }

        // Если не можем найти путь к цели, возвращаем -1.0
        return -1.0;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e")); // e не определено
        queries.add(Arrays.asList("b", "b"));
        queries.add(Arrays.asList("x", "x")); // x не определено

        double[] results = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(results)); // Output: [6.0, 0.5, -1.0, 1.0, -1.0]
    }
}
