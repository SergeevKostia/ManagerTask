package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldMatchesNoContainsQuery() {
        SimpleTask simpleTask = new SimpleTask(10, "Задачи для тестировщика");

        String[] subtasks = {"Задачи для домашнего задания","Протестировать задачу","Отформатировать код"};
        Epic epic = new Epic(78, subtasks);

        Meeting meeting = new Meeting(
                25,
                "Задачи тестировщика",
                "Магазин товаров",
                "02.06.2023"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = { false, false, false };
        boolean[] actual = new boolean[3];

        Task[] arrayTask = todos.findAll();

        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Задача");
        }

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldSearchContainsQuery() {
        SimpleTask simpleTask = new SimpleTask(10, "Задача для домашнего задания");

        String[] subtasks = {"Задача для тестировщика","Протестировать задачу","Отформатировать код"};
        Epic epic = new Epic(58, subtasks);

        Meeting meeting = new Meeting(
                36,
                "Задача тестировщика",
                "Магазин игрушек",
                "02.06.2023"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.search("Задача");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNoSearchContainsQuery() {
        SimpleTask simpleTask = new SimpleTask(10, "Задачи для тестировщика");

        String[] subtasks = {"Задачи для домашнего задания","Протестировать задачу","Отформатировать код"};
        Epic epic = new Epic(78, subtasks);

        Meeting meeting = new Meeting(
                25,
                "Задачи тестировщика",
                "Магазин товаров",
                "02.06.2023"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Задача");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testForGetter(){
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(71, subtasks);

        Meeting meeting = new Meeting(
                852,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        int[] expected = { 7, 71, 852 };
        int[] actual = {simpleTask.getId(), epic.getId(), meeting.getId()};
        Assertions.assertArrayEquals(expected, actual);

    }
}