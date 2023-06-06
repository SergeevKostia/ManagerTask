package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void shouldMatchesContainsQuery() {
        Task task = new Task(1);
        SimpleTask simpleTask = new SimpleTask(2, "Задача для домашнего задания");

        String[] subtasks = {"Задача для тестировщика","Тестировать Задача","Отформатировать код"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                100,
                "Задача домашнего задания",
                "Тема Задача",
                "02.06.2023"
        );
        Todos todos = new Todos();

        todos.add(task);
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = { false, true, true, true };
        boolean[] actual = new boolean[4];

        Task[] arrayTask = todos.findAll();

        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Задача");
        }

        Assertions.assertArrayEquals(expected,actual);
    }

}
